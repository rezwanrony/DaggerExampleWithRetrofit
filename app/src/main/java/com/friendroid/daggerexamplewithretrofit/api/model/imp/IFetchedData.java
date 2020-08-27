package com.friendroid.daggerexamplewithretrofit.api.model.imp;

import com.friendroid.daggerexamplewithretrofit.api.model.GitHubItemModel;
import com.friendroid.daggerexamplewithretrofit.api.model.GitHubModel;

import java.util.List;

/**
 * Created by gleb on 8/18/17.
 */

public interface IFetchedData {

    void setGitHubData(GitHubModel data);
    List<GitHubItemModel> getAllData();
    GitHubItemModel getGitHubData(int position);
}
