package uz.com.uzgovmonsys.madel;

import android.os.Bundle;

public class UserRegister {

    private String name;
    private String phoneNumber;
    private String password;

    public UserRegister(String name, String phoneNumber, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
