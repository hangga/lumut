package com.lumut.hangga.view.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lumut.hangga.R;
import com.lumut.hangga.repo.remote.response.ItemResponse;

import java.util.Objects;

public class ViewItem extends RelativeLayout {
    private Context context;
    private TextView txtLink;
    private TextView txtTitle;
    private TextView txtSnipet;

    public void setItemResponse(ItemResponse itemResponse) {
        this.itemResponse = itemResponse;
        txtLink.setText("User Id :"+String.valueOf(itemResponse.getUserId()));
        txtTitle.setText(itemResponse.getTitle());
        txtSnipet.setText("completed:"+String.valueOf(itemResponse.isCompleted()));
    }

    ItemResponse itemResponse;

    public ViewItem(Context context, ItemResponse itemResponse){
        super(context);
        this.context = context;
        inflate(context);
        setItemResponse(itemResponse);
    }

    void inflate(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Objects.requireNonNull(layoutInflater).inflate(R.layout.layout_item_result, this);
        txtLink = findViewById(R.id.txtLink);
        txtTitle = findViewById(R.id.txtTitle);
        txtSnipet = findViewById(R.id.txtSnipet);
    }
}
