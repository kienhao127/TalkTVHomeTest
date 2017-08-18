package com.example.cpu11341_local.talktvhometest.data;

/**
 * Created by CPU11341-local on 8/18/2017.
 */

public class DocHorizon {
    private int imgID;
    private int action_type;
    private String title;

    public DocHorizon(int imgID, int action_type, String title) {
        this.imgID = imgID;
        this.action_type = action_type;
        this.title = title;
    }

    public int getImgID() {
        return imgID;
    }

    public int getAction_type() {
        return action_type;
    }

    public String getTitle() {
        return title;
    }
}
