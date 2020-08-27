package com.friendroid.daggerexamplewithretrofit.api.model.imp;


import com.friendroid.daggerexamplewithretrofit.api.model.GitHubItemModel;
import com.friendroid.daggerexamplewithretrofit.api.model.GitHubModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by gleb on 8/18/17.
 */

public class FetchedDataPresenterImpl implements IFetchedData {

    private GitHubModel gitHubModel;

    @Inject
    public FetchedDataPresenterImpl() { }

    @Override
    public void setGitHubData(GitHubModel data) {
        this.gitHubModel = data;
    }

    @Override
    public List<GitHubItemModel> getAllData() {
        return gitHubModel.getItems();
    }

    @Override
    public GitHubItemModel getGitHubData(int position) {
        return gitHubModel.getItems().get(position);
    }
}
