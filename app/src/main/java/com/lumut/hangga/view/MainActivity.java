package com.lumut.hangga.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lumut.hangga.R;
import com.lumut.hangga.repo.remote.response.ItemResponse;
import com.lumut.hangga.view.custom.ViewItem;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    LinearLayout mainContainer;
    ProgressBar mainProgress;
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mainPresenter = new MainPresenter(this, MainActivity.this);
        mainPresenter.getData();
    }

    void initView(){
        mainContainer = findViewById(R.id.mainContainer);
        mainProgress = findViewById(R.id.mainProgress);
    }

    @Override
    public void showResult(List<ItemResponse> items) {
        mainContainer.removeAllViews();
        for (int i = 0; i < items.size(); i++){
            mainContainer.addView(new ViewItem(MainActivity.this, items.get(i)));
        }
    }

    @Override
    public void onEmpty() {

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress(boolean isShow) {
        if (isShow){
            mainProgress.setVisibility(View.VISIBLE);
        } else {
            mainProgress.setVisibility(View.GONE);
        }
    }
}
