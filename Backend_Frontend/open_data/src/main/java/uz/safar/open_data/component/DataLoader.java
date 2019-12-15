package uz.safar.open_data.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.safar.open_data.model.User;
import uz.safar.open_data.model.enums.RoleName;
import uz.safar.open_data.repository.RoleRepository;
import uz.safar.open_data.repository.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Value("${spring.datasource.initialization-mode}")
    private String initialMode;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")) {
            userRepository.save(new User(
                    "superAdmin",
                    passwordEncoder.encode("root123"),
                    "77777",
                    roleRepository.findAll()));

            userRepository.save(new User(
                    "admin",
                    passwordEncoder.encode("admin1"),
                    "+998999999999",
                    roleRepository.findAllByName(RoleName.ROLE_ADMIN)));

            userRepository.save(new User(
                    "moderator",
                    passwordEncoder.encode("moder123"),
                    "321654",
                    roleRepository.findAllByName(RoleName.ROLE_MODERATOR)));

            userRepository.save(new User(
                    "user",
                    passwordEncoder.encode("123"),
                    "3232",
                    roleRepository.findAllByName(RoleName.ROLE_USER)));

        }
    }
}
