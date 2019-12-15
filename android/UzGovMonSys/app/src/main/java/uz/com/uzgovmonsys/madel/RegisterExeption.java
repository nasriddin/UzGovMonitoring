package uz.com.uzgovmonsys.madel;

public class RegisterExeption extends Throwable {

String message;
String success;

    @Override
    public String getMessage() {
        return message;
    }

    public String getSuccess() {
        return success;
    }
}
