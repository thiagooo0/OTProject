package com.ksw.ot.entity;

/**
 * @author KwokSiuWang
 * @date 2018/8/8
 */

class Callout {
    private String content;
    private String display = "ALWAYS";

    public Callout() {

    }

    public Callout(String content) {
        setContent(content);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
