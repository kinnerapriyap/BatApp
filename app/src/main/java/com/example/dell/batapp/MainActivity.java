package com.example.dell.batapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button addbtn, viewbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addbtn= (Button)findViewById(R.id.newbutton);
        viewbtn= (Button)findViewById(R.id.viewbutton);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void addnew(View v) {
        Intent intent= new Intent(getApplicationContext(), AddNewActivity.class);
        startActivity(intent);
    }

    public void viewall(View v) {
        Intent intent= new Intent(getApplicationContext(), ViewActivity.class);
        startActivity(intent);
    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       