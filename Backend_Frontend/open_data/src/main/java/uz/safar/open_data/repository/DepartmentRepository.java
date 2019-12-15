package uz.safar.open_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.safar.open_data.model.Department;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {

    List<Department> findDepartmentsByOrganizationId(Integer organization_id);
}
