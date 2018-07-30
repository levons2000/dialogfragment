package com.example.student.lionmarket.views;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.widget.VideoView;

import com.example.student.lionmarket.R;
import com.example.student.lionmarket.providers.AllItemDatas;

public class VideoDialog extends Dialog {

    public VideoDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.video_dialog_style);
        setVideoUrl(AllItemDatas.getItemByPosition().getVideoLink());

    }

    private void setVideoUrl(String url) {
        VideoView videoView = findViewById(R.id.video_for_dialog);
        videoView.setVideoURI(Uri.parse(url));
        videoView.start();
    }
}
