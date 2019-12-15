package uz.safar.open_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.safar.open_data.model.Organization;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization,Integer> {

//    Optional<Organization> findOrganizationsByRegion(Integer id);

    List<Organization> findOrganizationsByRegionId(Integer region_id);
}
