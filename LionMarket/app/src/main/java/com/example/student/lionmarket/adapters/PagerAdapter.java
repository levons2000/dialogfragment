package com.example.student.lionmarket.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.student.lionmarket.R;
import com.example.student.lionmarket.providers.AllItemDatas;
import com.squareup.picasso.Picasso;

public class PagerAdapter extends android.support.v4.view.PagerAdapter {

    private String[] array = AllItemDatas.getItemByPosition().getImgUrl();
    private Context context;

    public PagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return array.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_pager_item, container, false);
        ImageView imageView = view.findViewById(R.id.pager_item_image);
        Picasso.get().load(array[position]).into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
