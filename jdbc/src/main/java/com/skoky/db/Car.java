package com.skoky.db;

/**
 * Created by ladislav.skokan on 19.12.2014.
 */
public class Car {

    private Long[] myHash;
    private String id;
    private String made;


    public Car() {
    }

    public Car(String id, String made) {
        this.id = id;
        this.made=made;
    }

    public String getId() {
        return id;
    }

    public String getMade() {
        return made;
    }
}
