package com.ksw.ot.entity;

import java.util.Map;

/**
 * @author KwokSiuWang
 * @date 2018/7/31
 */

public class User {
    private long id;
    private String name;
    private Integer age;
//    private Map<Integer, LatLon> latlons;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

//    public Map<Integer, LatLon> getLatlons() {
//        return latlons;
//    }
//
//    public void setLatlons(Map<Integer, LatLon> latlons) {
//        this.latlons = latlons;
//    }
}
