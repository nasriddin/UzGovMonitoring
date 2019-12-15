package uz.safar.open_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.safar.open_data.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByPhoneNumber(String phoneNumber);

    Optional<User> findById(Integer id);
}
