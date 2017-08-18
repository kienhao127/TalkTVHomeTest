package com.example.cpu11341_local.talktvhometest.data;

/**
 * Created by CPU11341-local on 8/18/2017.
 */

public class DocGrid {
    private int imageID;
    private String channelName;
    private int action_type;

    public DocGrid(int imageID, String channelName, int action_type) {
        this.imageID = imageID;
        this.channelName = channelName;
        this.action_type = action_type;
    }

    public int getImageID() {
        return imageID;
    }

    public String getChannelName() {
        return channelName;
    }

    public int getAction_type() {
        return action_type;
    }
}
