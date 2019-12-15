package uz.safar.open_data.payload;


import lombok.Data;

@Data

public class ReqSignUp {

    private String phoneNumber;
    private String name;
    private String password;
}
