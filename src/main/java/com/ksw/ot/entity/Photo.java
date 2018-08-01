package com.ksw.ot.entity;

/**
 * @author KwokSiuWang
 * @date 2018/8/1
 */

public class Photo {
    public Photo() {

    }

    public Photo(String fileName) {
        setUrl("https://www.kwoksiuwang.com/ot/" + fileName);
    }

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
