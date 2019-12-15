package uz.com.uzgovmonsys.constants;

public enum InputEditeType {

    PHONE(1),
    SMS(2);


    private int value;

    InputEditeType(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
