package com.example.cpu11341_local.talktvhometest.data;

/**
 * Created by CPU11341-local on 8/18/2017.
 */

public class DocHorizon {
    private String imgLink;
    private int action_type;
    private String title;

    public DocHorizon(String imgLink, int action_type, String title) {
        this.imgLink = imgLink;
        this.action_type = action_type;
        this.title = title;
    }

    public String getImgLink() {
        return imgLink;
    }

    public int getAction_type() {
        return action_type;
    }

    public String getTitle() {
        return title;
    }
}
