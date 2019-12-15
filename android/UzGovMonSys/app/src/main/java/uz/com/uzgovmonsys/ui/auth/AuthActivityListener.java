package uz.com.uzgovmonsys.ui.auth;

import uz.com.uzgovmonsys.madel.Login;
import uz.com.uzgovmonsys.madel.UserRegister;

public interface AuthActivityListener {


    void register(UserRegister userRegister);

    void login(Login login);

    void createAuth();
}
