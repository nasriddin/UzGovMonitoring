package uz.com.uzgovmonsys.madel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Organizaions implements Serializable {

    private String name;
    private int id;
    private RegionsResponse region;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public RegionsResponse getRegion() {
        return region;
    }
}
