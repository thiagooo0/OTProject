package com.ksw.ot.entity;

import java.util.ArrayList;

/**
 * @author KwokSiuWang
 * @date 2018/8/1
 */

public class PhotoList {
    private ArrayList<Photo> photos = new ArrayList<>();

    public void add(Photo photo) {
        photos.add(photo);
    }

    public ArrayList<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<Photo> photos) {
        this.photos = photos;
    }
}
