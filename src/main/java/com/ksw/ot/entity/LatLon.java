package com.ksw.ot.entity;

/**
 * @author KwokSiuWang
 * @date 2018/7/31
 */

public class LatLon {
    private String id;
    private float lat;
    private float lon;

    public LatLon() {

    }

    public LatLon(String id, float lat, float lon) {
        setId(id);
        setLat(lat);
        setLon(lon);
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
