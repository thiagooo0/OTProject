package com.ksw.ot.entity;

/**
 * @author KwokSiuWang
 * @date 2018/7/31
 */

public class LatLon {
    private int id;
    private float latitude;
    private float longitude;
    private String name;
    private Callout callout;

    public LatLon() {

    }

    public LatLon(int id, float latitude, float longitude, String name) {
        setId(id);
        setLatitude(latitude);
        setLongitude(longitude);
        setName(name);
        setCallout(new Callout(name));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Callout getCallout() {
        return callout;
    }

    public void setCallout(Callout callout) {
        this.callout = callout;
    }
}
