package com.example.student.lionmarket.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.student.lionmarket.R;
import com.example.student.lionmarket.activitys.ScrollingActivity;
import com.example.student.lionmarket.models.GameModel;
import com.example.student.lionmarket.providers.AllItemDatas;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.ItemsViewHolder> implements Filterable {

    private List<GameModel> list;
    private Context context;
    private List<GameModel> searchList;

    public GamesAdapter(Context context, List<GameModel> list) {
        this.context = context;
        this.list = list;
        searchList = list;
    }

    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.game_model_style, parent, false);
        return new ItemsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemsViewHolder holder, int position) {
        holder.textName.setText(searchList.get(position).getName());
        holder.textConsole.setText(searchList.get(position).getType());
        holder.textPrise.setText(searchList.get(position).getPrice());
        if (searchList.get(position).isLiked) {
            holder.buttonLike.setImageResource(R.drawable.ic_thumb_up_active_24dp);
        }
        if (searchList.get(position).isInBin) {
            holder.buttonBuy.setImageResource(R.drawable.ic_shopping_cart_active_24dp);
        }
        Picasso.get().load(searchList.get(position).getImgUrl()[0]).into(holder.imageGame);

    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String searchText = String.valueOf(charSequence);
                if (searchText.isEmpty()) {
                    searchList = list;
                } else {
                    List<GameModel> newList = new ArrayList<>();
                    for (int i = 0; i < searchList.size(); i++) {
                        if (searchList.get(i).getName().contains(searchText)) {
                            newList.add(searchList.get(i));
                        }
                    }
                    searchList = newList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = searchList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                searchList = (List<GameModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class ItemsViewHolder extends RecyclerView.ViewHolder {
        TextView textName;
        TextView textConsole;
        TextView textPrise;
        ImageView imageGame;
        ImageButton buttonBuy;
        ImageButton buttonLike;

        ItemsViewHolder(View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.game_name);
            textConsole = itemView.findViewById(R.id.game_console);
            textPrise = itemView.findViewById(R.id.game_price);
            buttonBuy = itemView.findViewById(R.id.buy);
            buttonLike = itemView.findViewById(R.id.like);
            imageGame = itemView.findViewById(R.id.game_image);
            buttonLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!searchList.get(getAdapterPosition()).isLiked) {
                        buttonLike.setImageResource(R.drawable.ic_thumb_up_active_24dp);
                        for (int i = 0; i < AllItemDatas.list.size(); i++) {
                            if (AllItemDatas.list.get(i).getName().equals(searchList.get(getAdapterPosition()).getName())) {
                                AllItemDatas.list.get(i).isLiked = true;
                            }
                        }
                    } else {
                        buttonLike.setImageResource(R.drawable.ic_thumb_up_black_24dp);
                        for (int i = 0; i < AllItemDatas.list.size(); i++) {
                            if (AllItemDatas.list.get(i).getName().equals(searchList.get(getAdapterPosition()).getName())) {
                                AllItemDatas.list.get(i).isLiked = false;
                            }
                        }
                    }
                }
            });
            buttonBuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!searchList.get(getAdapterPosition()).isInBin) {
                        buttonBuy.setImageResource(R.drawable.ic_shopping_cart_active_24dp);
                        for (int i = 0; i < AllItemDatas.list.size(); i++) {
                            if (AllItemDatas.list.get(i).getName().equals(searchList.get(getAdapterPosition()).getName())) {
                                AllItemDatas.list.get(i).isInBin = true;
                            }
                        }
                    } else {
                        buttonBuy.setImageResource(R.drawable.ic_shopping_cart_black_24dp);
                        for (int i = 0; i < AllItemDatas.list.size(); i++) {
                            if (AllItemDatas.list.get(i).getName().equals(searchList.get(getAdapterPosition()).getName())) {
                                AllItemDatas.list.get(i).isInBin = false;
                            }
                        }
                    }
                }

            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (int i = 0; i < AllItemDatas.list.size(); i++) {
                        if (AllItemDatas.list.get(i).getName().equals(list.get(getAdapterPosition()).getName())) {
                            AllItemDatas.position = i;
                        }
                    }
                    Intent intent = new Intent(context, ScrollingActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}
