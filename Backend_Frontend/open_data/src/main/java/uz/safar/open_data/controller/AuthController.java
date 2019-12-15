package uz.safar.open_data.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import uz.safar.open_data.payload.ApiResponse;
import uz.safar.open_data.payload.JwtResponse;
import uz.safar.open_data.payload.ReqSign;
import uz.safar.open_data.payload.ReqSignUp;
import uz.safar.open_data.service.AuthService;
import uz.safar.open_data.service.JwtTokenProvider;
import javax.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    AuthService authService;


    @PostMapping("/login")
    public HttpEntity<?> login(@Valid @RequestBody ReqSign reqSign){
        return getApiToken(reqSign.getPhoneNumber(),reqSign.getPassword());
    }

    @PostMapping("/register")
    public HttpEntity<?> register(@Valid @RequestBody ReqSignUp reqSignUp){
        ApiResponse apiResponse = authService.register(reqSignUp);
        if (apiResponse.isSuccess()){
            return getApiToken(reqSignUp.getPhoneNumber(),reqSignUp.getPassword());
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse);
        }
    }

    private HttpEntity<?> getApiToken(String phoneNumber, String password){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(phoneNumber,password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }


}
