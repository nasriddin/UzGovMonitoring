package uz.safar.open_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.safar.open_data.model.Employee;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    List<Employee> findEmployeesByDepartment_Id(Integer department_id);

}
