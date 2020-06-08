package com.lumut.hangga.repo.remote.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemResponse {
    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    @SerializedName("userId")
    @Expose int userId;
    @SerializedName("id")
    @Expose int id;
    @SerializedName("title")
    @Expose String title;
    @SerializedName("completed")
    @Expose boolean completed;
}
