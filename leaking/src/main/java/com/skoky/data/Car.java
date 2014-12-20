package com.skoky.data;

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
        this.myHash = new Long[1024];
        System.out.println("Hash allocated:"+myHash.length);
    }

    public String getId() {
        return id;
    }

    public String getMade() {
        return made;
    }
}
