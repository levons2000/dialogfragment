package com.example.student.lionmarket.activitys;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.student.lionmarket.fragments.MainFragment;
import com.example.student.lionmarket.R;
import com.example.student.lionmarket.adapters.GamesAdapter;
import com.example.student.lionmarket.providers.AllItemDatas;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fragmentManager;
    MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MainFragment.itemsAdd();
        MainFragment.list = AllItemDatas.list;
        fragmentManager = getFragmentManager();
        mainFragment = new MainFragment();
        setFragmentMain();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainFragment.list = AllItemDatas.getBuyItems();
                mainFragment.updateList(new GamesAdapter(MainActivity.this, MainFragment.list));
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setBackgroundResource(R.drawable.side_nav_bar);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mainFragment.gamesAdapter.getFilter().filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mainFragment.gamesAdapter.getFilter().filter(newText);
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_all:
                MainFragment.list = AllItemDatas.list;
                mainFragment.updateList(new GamesAdapter(MainActivity.this, MainFragment.list));
                break;
            case R.id.nav_pc:
                MainFragment.list = AllItemDatas.getItemsByType("PC Game");
                mainFragment.updateList(new GamesAdapter(MainActivity.this, MainFragment.list));
                break;
            case R.id.nav_ps4:
                MainFragment.list = AllItemDatas.getItemsByType("PS4 Game");
                mainFragment.updateList(new GamesAdapter(MainActivity.this, MainFragment.list));
                break;
            case R.id.nav_xbox:
               MainFragment.list = AllItemDatas.getItemsByType("XBox One Game");
                mainFragment.updateList(new GamesAdapter(MainActivity.this, MainFragment.list));
                break;
            case R.id.nav_liked:
                MainFragment.list =  AllItemDatas.getLikedItems();
                mainFragment.updateList(new GamesAdapter(MainActivity.this, MainFragment.list));
                break;
            case R.id.nav_buy:
                MainFragment.list = AllItemDatas.getBuyItems();
                mainFragment.updateList(new GamesAdapter(MainActivity.this, MainFragment.list));
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setFragmentMain(){
        fragmentManager.beginTransaction().replace(R.id.container_content, mainFragment).commit();
    }

}
