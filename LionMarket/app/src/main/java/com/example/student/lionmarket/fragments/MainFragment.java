package com.example.student.lionmarket.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.lionmarket.R;
import com.example.student.lionmarket.activitys.MainActivity;
import com.example.student.lionmarket.adapters.GamesAdapter;
import com.example.student.lionmarket.models.GameModel;
import com.example.student.lionmarket.providers.AllItemDatas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends android.app.Fragment {

    public static List<GameModel> list = new ArrayList<>();
    static boolean b = true;
    RecyclerView recyclerView;
    public GamesAdapter gamesAdapter;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        if (b) {
            itemsAdd();
        }
        Collections.shuffle(AllItemDatas.list);
        gamesAdapter = new GamesAdapter(getActivity(), list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView = v.findViewById(R.id.items_recyc);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(gamesAdapter);
        return v;

    }

    public static void itemsAdd() {
        AllItemDatas.list.add(new GameModel(new String[]{"https://orig00.deviantart.net/4edb/f/2013/328/0/5/the_forest_by_pooterman-d6vk4b0.png", "https://orig00.deviantart.net/4edb/f/2013/328/0/5/the_forest_by_pooterman-d6vk4b0.png", "https://orig00.deviantart.net/4edb/f/2013/328/0/5/the_forest_by_pooterman-d6vk4b0.png"}, "The Forest", "10.49", R.string.theforest_desc, "PC Game", "https://steamcdn-a.akamaihd.net/steam/apps/256715589/movie480.webm?t=1525039057","Endnight Games Ltd", 0, "https://endnightgames.com/sites/default/files/styles/large/public/images/games//screenshots/TheForestScreenshot_07_1.jpg?itok=iSLZwORJ"));
        AllItemDatas.list.add(new GameModel(new String[]{"https://orig00.deviantart.net/91d5/f/2012/128/d/2/terraria_by_tchiba69-d4yzkij.png", "https://orig00.deviantart.net/65db/f/2011/235/e/d/terraria___dock_icon_1_by_gavreed-d47n049.png", "http://a3.mzstatic.com/us/r30/Purple5/v4/42/f3/51/42f35178-7d95-a249-d147-f4371bb2d12f/icon350x350.png"}, "Terraria", "6.99", R.string.terraria_desc, "PC Game", "https://steamcdn-a.akamaihd.net/steam/apps/2040428/movie480.webm?t=1447376855", "Re-Logic", 0, "https://forums.terraria.org/index.php?attachments/post-title-banner-png.148002/"));
        AllItemDatas.list.add(new GameModel(new String[]{"https://pbs.twimg.com/profile_images/1017713253676302337/RwcqV6eI_400x400.jpg", "https://pbs.twimg.com/profile_images/1017713253676302337/RwcqV6eI_400x400.jpg", "https://pbs.twimg.com/profile_images/1017713253676302337/RwcqV6eI_400x400.jpg"}, "Earthfall", "29.99", R.string.earthfall_desc, "PS4 Game", "", "Holospark", 0, "https://www.windowscentral.com/sites/wpcentral.com/files/styles/xlarge/public/field/image/2018/04/earthfall-1.jpg?itok=JcUdpn9P"));
        AllItemDatas.list.add(new GameModel(new String[]{"https://orig00.deviantart.net/32e1/f/2016/053/9/5/far_cry_3___icon_by_blagoicons-d9sqfyj.png", "https://orig00.deviantart.net/32e1/f/2016/053/9/5/far_cry_3___icon_by_blagoicons-d9sqfyj.png", "https://orig00.deviantart.net/32e1/f/2016/053/9/5/far_cry_3___icon_by_blagoicons-d9sqfyj.png"}, "Far Cry 3", "10.49", R.string.farcry_desc, "PS4 Game", "https://steamcdn-a.akamaihd.net/steam/apps/2028177/movie480.webm?t=1447357140", "Ubisoft Entertainment", 0, "http://themepack.me/i/c/749x468/media/g/56/far-cry-3-hd-theme-2.jpg"));
        AllItemDatas.list.add(new GameModel(new String[]{"https://orig00.deviantart.net/a935/f/2014/240/d/2/resident_evil_2___icon_circle_by_wesleysouji-d7x38a5.png", "https://orig00.deviantart.net/a935/f/2014/240/d/2/resident_evil_2___icon_circle_by_wesleysouji-d7x38a5.png", "https://orig00.deviantart.net/a935/f/2014/240/d/2/resident_evil_2___icon_circle_by_wesleysouji-d7x38a5.png"}, "Resident Evil 2", "59.99", R.string.residentevil_desc, "XBox One Game", "https://steamcdn-a.akamaihd.net/steam/apps/256719962/movie480.webm?t=1529624730", "CapCom Ltd", 0, "https://images.gamewatcherstatic.com/image/file/3/40/90013/resident-evil-2-hd-remake-fa-fan-unreal-engine.jpg"));
        AllItemDatas.list.add(new GameModel(new String[]{"https://orig00.deviantart.net/1d82/f/2018/160/3/4/battlefield_5_icon_by_troublem4ker-dcdxlii.png", "https://orig00.deviantart.net/1d82/f/2018/160/3/4/battlefield_5_icon_by_troublem4ker-dcdxlii.png", "https://orig00.deviantart.net/1d82/f/2018/160/3/4/battlefield_5_icon_by_troublem4ker-dcdxlii.png"}, "Battlefield 5", "59.99", R.string.battlefield_desc, "XBox One Game", "", "Electronic Arts", 0, "https://cdn.wccftech.com/wp-content/uploads/2018/05/Battlefield-5-Single-Player.jpg"));
        b = false;
    }

    public void updateList(GamesAdapter gamesAdapter){
        recyclerView.setAdapter(gamesAdapter);
    }


}
