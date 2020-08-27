package com.friendroid.daggerexamplewithretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.project.dajver.dagger2testexample.adapter.RecycleListAdapter;
import com.project.dajver.dagger2testexample.api.RestClient;
import com.project.dajver.dagger2testexample.api.model.GitHubModel;
import com.project.dajver.dagger2testexample.api.model.imp.FetchedDataPresenterImpl;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.project.dajver.dagger2testexample.SecondActivity.EXTRA_POSITION;

public class MainActivity extends AppCompatActivity implements Callback<GitHubModel>,
        RecycleListAdapter.OnItemClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    RecycleListAdapter recycleListAdapter;
    @Inject
    RestClient restClient;
    @Inject
    FetchedDataPresenterImpl fetchedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        App.component().inject(this);

        recycleViewSetup(recyclerView);

        restClient.getService().getSearchedRepos("retrofit", 0, 100).enqueue(this);
    }

    public void recycleViewSetup(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onResponse(Call<GitHubModel> call, Response<GitHubModel> response) {
        GitHubModel githubModel = response.body() != null ? response.body() : new GitHubModel();
        fetchedData.setGitHubData(githubModel);

        recycleListAdapter.addAll(fetchedData.getAllData());
        recycleListAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(recycleListAdapter);
    }

    @Override
    public void onFailure(Call<GitHubModel> call, Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(EXTRA_POSITION, position);
        startActivity(intent);
    }
}
