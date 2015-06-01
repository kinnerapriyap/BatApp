package com.example.dell.batapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class OpenActivity extends ActionBarActivity {

    TextView name1, age1, gender1, crimes1, location1;
    //ImageView image1;
    String name, age, gender, crimes, location, position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);

        name1 = (TextView)findViewById(R.id.textviewname);
        age1 = (TextView)findViewById(R.id.textviewage);
        gender1 = (TextView)findViewById(R.id.textviewgender);
        crimes1 = (TextView)findViewById(R.id.textviewcrimes);
        location1 = (TextView)findViewById(R.id.textviewlocation);
        //image1 = (ImageView)findViewById(R.id.imageview);


        Intent intent= getIntent();
        position= intent.getExtras().getString("id");
        name = intent.getExtras().getString("name");
        age = intent.getExtras().getString("age");
        gender = intent.getExtras().getString("gender");
        crimes = intent.getExtras().getString("crimes");
        location = intent.getExtras().getString("location");
        //image = intent.getExtras().getString("image");


        name1.setText(name);
        age1.setText(age);
        gender1.setText(gender);
        crimes1.setText(crimes);
        location1.setText(location);
         /*byte[] decodedByte = Base64.decode(image, 0);
        Bitmap b = BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
        image1.setImageBitmap(b);*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        /*getMenuInflater().inflate(R.menu.menu_open, menu);
        return true;*/

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_open, menu);

        // Configure the search info and add any event listeners*/


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(item.getItemId()==R.id.exit_item) {
            Intent intent= new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.edit_item) {
            edit();
        }
        if(item.getItemId()==R.id.delete_item) {
            delete();
        }
        if(item.getItemId()==R.id.call_item) {
            Intent callIntent= new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + 303));
            startActivity(callIntent);
        }


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void edit() {
        Intent intent= new Intent(getApplicationContext(), EditActivity.class);
        intent.putExtra("id", position);
        intent.putExtra("name", name);
        intent.putExtra("age", age);
        intent.putExtra("gender", gender);
        intent.putExtra("crimes", crimes);
        intent.putExtra("location", location);
        //intent.putExtra("image", image);
        startActivity(intent);
    }

    public void delete() {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);

        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                DBHandler db= new DBHandler(getApplicationContext());
                db.deletecriminal(Integer.parseInt(position));
                Toast.makeText(getApplicationContext(), "Criminal Data deleted", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(getApplicationContext(), ViewActivity.class);
                startActivity(intent);
            }
        };

        DialogInterface.OnClickListener listener1= new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {

            }
        };

        builder.setMessage("Do you want to delete the criminal cuz you found him?").setCancelable(false).setPositiveButton("Yes, I found him!", listener).setNegativeButton("Nope, no luck yet.", listener1);
        AlertDialog alert= builder.create();
        alert.setTitle("Delete");
        alert.show();
    }

}
