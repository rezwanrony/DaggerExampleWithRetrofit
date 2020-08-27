package com.friendroid.daggerexamplewithretrofit.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gleb on 8/16/17.
 */

public class GitHubModel {
    @SerializedName("items")
    @Expose
    private List<GitHubItemModel> items = new ArrayList<>();

    public List<GitHubItemModel> getItems() {
        return items;
    }

    public void setItems(List<GitHubItemModel> items) {
        this.items = items;
    }
}
