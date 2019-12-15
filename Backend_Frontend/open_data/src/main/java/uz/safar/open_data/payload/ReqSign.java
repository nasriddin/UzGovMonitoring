package uz.safar.open_data.payload;


import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class ReqSign {

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String password;
}
