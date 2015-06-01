package com.example.dell.batapp;

import android.annotation.TargetApi;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class ViewActivity extends ActionBarActivity {

    ListView listview;
    ArrayList<Criminal> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        listview= (ListView)findViewById(R.id.criminallist);

        DBHandler db= new DBHandler(getApplicationContext());
        list= db.getCriminal();
        CriminalAdapter adapter= new CriminalAdapter(getApplicationContext(), R.layout.detailview, list);
        listview.setAdapter(adapter);

        AdapterView.OnItemClickListener listener= new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {

                Intent intent= new Intent(getApplicationContext(), OpenActivity.class);
                Criminal criminal= list.get(position);
                intent.putExtra("id", criminal.getId());
                intent.putExtra("name", criminal.getName());
                intent.putExtra("age", criminal.getAge());
                intent.putExtra("gender", criminal.getGender());
                intent.putExtra("crimes", criminal.getCrimes());
                intent.putExtra("location", criminal.getLocation());
                //intent.putExtra("image", criminal.getImage());
                startActivity(intent);

            }

        };
        listview.setOnItemClickListener(listener);

    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view, menu);
        MenuItem searchItem = menu.findItem(R.id.search_item);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchview =
                (SearchView) menu.findItem(R.id.search_item).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        if(item.getItemId()==R.id.search_item) {
            Intent intent= new Intent(getApplicationContext(), SearchActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
