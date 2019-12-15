package uz.safar.open_data.repository;

import io.jsonwebtoken.lang.Objects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.safar.open_data.model.Rate;
import uz.safar.open_data.model.User;
import uz.safar.open_data.payload.RateChar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface RateRepository extends JpaRepository<Rate,Integer> {

    Optional<Rate> findTopByUserOrderByCreatedAt(User currentUser);

    Optional<Rate> findRatesByStatusGreaterThan(int status);



//    @Query("SELECT r.employee,count(r.status) FROM Rate r WHERE r.status>=3 group by r.employee")
    @Query("select rt.employee,(select count(r.status) from Rate r where r.status >2 and r.employee=rt.employee) from Rate rt")
    List<Long> find();


}
