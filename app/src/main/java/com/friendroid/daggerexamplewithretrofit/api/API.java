package com.friendroid.daggerexamplewithretrofit.api;

import com.friendroid.daggerexamplewithretrofit.api.model.GitHubModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by gleb on 8/16/17.
 */

public interface API {

    @GET("search/repositories")
    Call<GitHubModel> getSearchedRepos(@Query("q") String q,
                                       @Query("page") int page,
                                       @Query("per_page") int perPage);
}
