package com.lumut.hangga.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.lumut.hangga.R;

public class DetailActivity extends AppCompatActivity {

    private TextView txtLink;
    private TextView txtTitle;
    private TextView txtSnipet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initViews();
    }

    void initViews(){
        txtLink = findViewById(R.id.txtLink);
        txtTitle = findViewById(R.id.txtTitle);
        txtSnipet = findViewById(R.id.txtSnipet);
    }
}
