package uz.safar.open_data.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.safar.open_data.model.*;
import uz.safar.open_data.payload.ApiResponse;
import uz.safar.open_data.payload.RateIn;
import uz.safar.open_data.security.CurrentUser;
import uz.safar.open_data.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {


    @Autowired
    EmployeeService regService;


    @GetMapping("/regions")
    public List<Region> getAllRegion(){

        return regService.getAllRegion();
    }

    @GetMapping("/regions/{region_id}")
    public List<Organization> getAllOrganization(@PathVariable Integer region_id){

        return regService.getAllOrganization(region_id);
    }

    @GetMapping("/regions/organizations/{organization_id}")
    public List<Department> getAllDepartment(@PathVariable Integer organization_id){

        return regService.getAllDepartment(organization_id);
    }

    @GetMapping("/regions/organizations/departments/{department_id}")
    public List<Employee> getAllDEmployee(@PathVariable Integer department_id){

        return regService.getAllEmployee(department_id);
    }

    @PostMapping("/rate/{employee_id}")
    public ApiResponse rateEmployee(@Valid @RequestBody RateIn ratein, @PathVariable Integer employee_id, @CurrentUser User currentUser){
        return regService.rateEmployee(ratein,employee_id,currentUser);
    }


}
