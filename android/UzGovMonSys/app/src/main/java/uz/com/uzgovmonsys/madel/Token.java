package uz.com.uzgovmonsys.madel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Token implements Serializable {

    @SerializedName("accessToken")
    private String accessToken;
    @SerializedName("tokenType")
    private String tokenType;
    @SerializedName("message")
    private String message;
    @SerializedName("status")
    private int status;

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

}
