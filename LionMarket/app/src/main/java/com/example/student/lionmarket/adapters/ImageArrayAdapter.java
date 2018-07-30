package com.example.student.lionmarket.adapters;

import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.student.lionmarket.R;
import com.example.student.lionmarket.activitys.ScrollingActivity;
import com.example.student.lionmarket.fragments.PagerDialogFragment;
import com.squareup.picasso.Picasso;

public class ImageArrayAdapter extends RecyclerView.Adapter<ImageArrayAdapter.MyViewHolder> {
    private Context context;
    private String[] array;

    public ImageArrayAdapter(Context context, String[] array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.img_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(array[position]).into(holder.itemImage);
    }

    @Override
    public int getItemCount() {
        return array.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.image_item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PagerDialogFragment pagerDialogFragment = new PagerDialogFragment(context, getAdapterPosition());
                    pagerDialogFragment.show(((ScrollingActivity) context).getFragmentManager(), "My Dialog");
                }
            });

        }
    }
}
