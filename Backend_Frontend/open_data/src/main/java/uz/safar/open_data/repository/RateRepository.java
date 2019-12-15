package uz.safar.open_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.safar.open_data.model.Rate;
import uz.safar.open_data.model.User;

import java.util.Optional;

public interface RateRepository extends JpaRepository<Rate,Integer> {

    Optional<Rate> findTopByUserOrderByCreatedAt(User currentUser);
}
