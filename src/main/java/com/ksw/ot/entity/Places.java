package com.ksw.ot.entity;

import java.util.ArrayList;

/**
 * @author KwokSiuWang
 * @date 2018/8/1
 */

public class Places {
    private ArrayList<LatLon> latLons = new ArrayList<>();

    public void add(LatLon latLon) {
        latLons.add(latLon);
    }

    public ArrayList<LatLon> getLatLons() {
        return latLons;
    }

    public void setLatLons(ArrayList<LatLon> latLons) {
        this.latLons = latLons;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Places :");
        for (LatLon latLon : latLons) {
            stringBuilder.append("\n id : " + latLon.getId() + " ;latlon : " + latLon.getLatitude() + "|" + latLon.getLongitude());
        }
        return stringBuilder.toString();
    }
}
