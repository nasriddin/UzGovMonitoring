package uz.com.uzgovmonsys.constants;

public class Constants {

    //    public static final String BASE_URL = "https://api.new.mediabox.uz";
    public static final String BASE_URL = "http://192.168.0.102:7878/api";

    public static final String DATABASE_NAME = "bkm_db";
    public static final String SHARED_PREFERENCES = "UzGovMonSys_Sharedpreferense";
    public static final String EMPTY_STRING = "";
    public static final String TOKENS = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTc2MzkwNDY2LCJleHAiOjE1NzY5OTUyNjZ9.ei9VLp_ffUw5R8cfdA3u4barnMC_qQUviwZtXvh2edOPMOekto7_NbDN17JOBpiMiXbrv6Vd7D_QDhZyK16vSA";
    public static final String ISLOGIN = "login";
    public static final String TOKEN = "token";


    public static final String COUNTRY_CODE = "+998";
    public static final String PHONE_NUMBER_REGEX = "(90|91|93|94|97|99|95|98|77)\\d{7}$";
    //public static final String PHONE_NUMBER_REGEX = "\\d{9}$";
    public static final String PHONE_NUMBER_REGEX_FULL = "^(\\+" + COUNTRY_CODE + ")" + PHONE_NUMBER_REGEX;
    public static final byte CONNECT_TIMEOUT = 120;
    public static final byte WRITE_TIMEOUT = 120;
    public static final byte READ_TIMEOUT = 120;
}
