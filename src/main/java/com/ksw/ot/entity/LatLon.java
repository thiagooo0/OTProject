package com.ksw.ot.entity;

/**
 * @author KwokSiuWang
 * @date 2018/7/31
 */

public class LatLon {
    private int id;
    private float lat;
    private float lon;

    public LatLon(int id, float lat, float lon) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
