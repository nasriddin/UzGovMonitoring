package uz.safar.open_data.service;


import io.jsonwebtoken.lang.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.safar.open_data.model.*;
import uz.safar.open_data.payload.ApiResponse;
import uz.safar.open_data.payload.RateChar;
import uz.safar.open_data.payload.RateIn;
import uz.safar.open_data.repository.*;
import java.sql.Timestamp;
import java.util.*;

@Service
public class EmployeeService {

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RateRepository rateRepository;

    public List<Region> getAllRegion() {

        return regionRepository.findAll();
    }

    public List<Organization> getOrganization(){
        return organizationRepository.findAll();
    }

    public List<Organization> getAllOrganization(Integer region_id) {

        return organizationRepository.findOrganizationsByRegionId(region_id);

    }



    public List<Department> getAllDepartment(Integer organization_id) {
        return departmentRepository.findDepartmentsByOrganizationId(organization_id);
    }

    public List<Employee> getAllEmployee(Integer department_id) {
        return employeeRepository.findEmployeesByDepartment_Id(department_id);
    }

    public ApiResponse rateEmployee(RateIn rateIn, Integer employee_id, User currentUser) {

        Employee employee = employeeRepository.findById(employee_id).orElseThrow(() -> new UsernameNotFoundException("Employee is not found"));

        Calendar calendar = Calendar.getInstance();

        Optional<Rate> optionalRate = rateRepository.findTopByUserOrderByCreatedAt(currentUser);

        long millis = System.currentTimeMillis() - 24 * 60 * 60 * 1000;
        Date date = new Date(millis);

        if (optionalRate.isPresent()) {
            Rate lastRate = optionalRate.get();
            if (lastRate.getCreatedAt().after(date)) {
                return new ApiResponse("1 kun ichida bitta ishchiga bir hil foydalanuvchidan otziv", false,1);
            }
        }

        rateRepository.save(new Rate(rateIn.getComment(), rateIn.getStatus(), new Timestamp(calendar.getTimeInMillis()), employee, currentUser));
        return new ApiResponse("Rated ",true,0);
    }

    public List<Long>  getRate(){

//        Optional<Rate> optionalRate = rateRepository.findRatesByStatusGreaterThan(2);
//        if (optionalRate.isPresent()){
//            Rate rate = optionalRate.get();
//
//        }
        return rateRepository.find();
    }

}
