package com.lumut.hangga.view.custom;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lumut.hangga.R;
import com.lumut.hangga.repo.remote.response.ItemResponse;
import com.lumut.hangga.view.DetailActivity;

import java.util.Objects;

public class ViewItem extends RelativeLayout {
    ItemResponse itemResponse;
    private Context context;
    private TextView txtLink;
    private TextView txtTitle;
    private TextView txtSnipet;

    public ViewItem(final Context context, final ItemResponse itemResponse) {
        super(context);
        this.context = context;
        inflate(context);
        setItemResponse(itemResponse);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(context, DetailActivity.class);
                myIntent.putExtra("id", itemResponse.getId());
                myIntent.putExtra("userid", itemResponse.getUserId());
                myIntent.putExtra("title", itemResponse.getTitle());
                myIntent.putExtra("completed", itemResponse.isCompleted());
                context.startActivity(myIntent);
            }
        });
    }

    public void setItemResponse(ItemResponse itemResponse) {
        this.itemResponse = itemResponse;
        txtLink.setText("Id :"+ itemResponse.getId() +", User Id : " + itemResponse.getUserId());
        txtTitle.setText(itemResponse.getTitle());
        txtSnipet.setText("completed : " + String.valueOf(itemResponse.isCompleted()));
    }

    void inflate(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Objects.requireNonNull(layoutInflater).inflate(R.layout.layout_item_result, this);
        txtLink = findViewById(R.id.txtLink);
        txtTitle = findViewById(R.id.txtTitle);
        txtSnipet = findViewById(R.id.txtSnipet);
    }
}
