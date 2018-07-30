package com.example.student.lionmarket.activitys;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.student.lionmarket.R;
import com.example.student.lionmarket.adapters.ImageArrayAdapter;
import com.example.student.lionmarket.models.GameModel;
import com.example.student.lionmarket.providers.AllItemDatas;
import com.example.student.lionmarket.views.VideoDialog;
import com.squareup.picasso.Picasso;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        GameModel gameModel = AllItemDatas.getItemByPosition();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!AllItemDatas.getItemByPosition().isInBin) {
                    AllItemDatas.getItemByPosition().isInBin = true;
                } else {
                    AllItemDatas.getItemByPosition().isInBin = false;
                }
            }
        });

        ImageView imageView = findViewById(R.id.info_image);
        Picasso.get().load(gameModel.getImgUrl()[0]).into(imageView);

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setRating(gameModel.getRaiting());
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                AllItemDatas.list.get(AllItemDatas.position).setRaiting(v);
            }
        });

        setImageForVideo(AllItemDatas.list.get(AllItemDatas.position).getImageForVideo());
        setAllText(gameModel);
        setRecycler();

    }

    private void setImageForVideo(String url) {
        ImageView imageView = findViewById(R.id.video_image);
        Picasso.get().load(url).into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VideoDialog videoDialog = new VideoDialog(ScrollingActivity.this);
                videoDialog.show();
            }
        });
    }

    private void setRecycler() {
        RecyclerView recyclerView = findViewById(R.id.img_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(new ImageArrayAdapter(this, AllItemDatas.list.get(AllItemDatas.position).getImgUrl()));
    }

    private void setAllText(GameModel gameModel) {
        TextView textName = findViewById(R.id.info_name);
        TextView textType = findViewById(R.id.info_type);
        TextView textPrice = findViewById(R.id.info_price);
        TextView textCreator = findViewById(R.id.info_creator);
        textName.setText(gameModel.getName());
        textType.setText(gameModel.getType());
        textPrice.setText(gameModel.getPrice());
        textCreator.setText(gameModel.getCreator());
        TextView textDesc = findViewById(R.id.desc);
        textDesc.setText(AllItemDatas.list.get(AllItemDatas.position).getDesc());
    }

}
