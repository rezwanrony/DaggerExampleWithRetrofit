package com.friendroid.daggerexamplewithretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.project.dajver.dagger2testexample.api.model.imp.FetchedDataPresenterImpl;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gleb on 8/18/17.
 */

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";

    @BindView(R.id.text)
    TextView text;

    @Inject
    FetchedDataPresenterImpl fetchedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ButterKnife.bind(this);
        App.component().inject(this);

        int position = getIntent().getIntExtra(EXTRA_POSITION, 0);
        text.setText("Name: " + fetchedData.getGitHubData(position).getName() +
                "\nDescription: " + fetchedData.getGitHubData(position).getDescription());
    }
}
