package uz.com.uzgovmonsys.madel;

import java.io.Serializable;

public class RegionsResponse implements Serializable {

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
