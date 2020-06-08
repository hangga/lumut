package com.lumut.hangga.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        initDatafromIntent(getIntent());
    }

    void initDatafromIntent(Intent myIntent){
        int id = myIntent.getIntExtra("id", 0);
        int userid = myIntent.getIntExtra("userid", 0);
        String title = myIntent.getStringExtra("title");
        boolean completed = myIntent.getBooleanExtra("completed", false);
        txtLink.setText("Id : "+ String.valueOf(id)+ ", User Id : "+String.valueOf(userid));
        txtTitle.setText(title);
        txtSnipet.setText("completed : "+String.valueOf(completed));
    }

    void initViews(){
        txtLink = findViewById(R.id.txtLink);
        txtTitle = findViewById(R.id.txtTitle);
        txtSnipet = findViewById(R.id.txtSnipet);
    }
}
