package uz.safar.open_data.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.safar.open_data.model.User;
import uz.safar.open_data.model.enums.RoleName;
import uz.safar.open_data.payload.ApiResponse;
import uz.safar.open_data.payload.ReqSignUp;
import uz.safar.open_data.repository.RoleRepository;
import uz.safar.open_data.repository.UserRepository;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        return userRepository.findByPhoneNumber(phoneNumber).orElseThrow(()-> new UsernameNotFoundException("Phone number is not found"));
    }


    public UserDetails loadUserById(Integer id){
        return userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("Id is not found"));
    }

    public ApiResponse register(ReqSignUp reqSignUp){
        Optional<User> optionalUser = userRepository.findByPhoneNumber(reqSignUp.getPhoneNumber());

        if (optionalUser.isPresent()) {
            return new ApiResponse("Bunday telefon nomer oldin registratsiya qilingan",false,1);
        }else {
            userRepository.save(
                    new User(
                            reqSignUp.getName(),
                            passwordEncoder.encode(reqSignUp.getPassword()),
                            reqSignUp.getPhoneNumber(),
                            roleRepository.findAllByName(RoleName.ROLE_USER)));
            return new ApiResponse("Muvvafiqiyatli o'tildi",true,0);
        }
    }
}
