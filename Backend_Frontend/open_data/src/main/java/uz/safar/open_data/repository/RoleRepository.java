package uz.safar.open_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.safar.open_data.model.Role;
import uz.safar.open_data.model.enums.RoleName;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    List<Role> findAllByName(RoleName s);
}
