package uz.safar.open_data.payload;


import lombok.Data;

@Data
public class JwtResponse {


    private String accessToken;
    private String tokenType = "Bearer";
    private int status;

    public JwtResponse(String accessToken,int status){
        this.accessToken = accessToken;
        this.status = status;
    }
}
