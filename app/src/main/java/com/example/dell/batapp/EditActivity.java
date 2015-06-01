package com.example.dell.batapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class EditActivity extends ActionBarActivity {

    EditText namee, agee, gendere, crimese, locatione;
    /*ImageView imagee;*/
    String name, age, gender, crimes, location, position;
    //String image;
    Button savebtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        namee = (EditText)findViewById(R.id.editname);
        agee = (EditText)findViewById(R.id.editage);
        gendere = (EditText)findViewById(R.id.editgender);
        crimese = (EditText)findViewById(R.id.editcrimes);
        locatione = (EditText)findViewById(R.id.editlocation);
        //imagee = (ImageView)findViewById(R.id.editimage);
        savebtn = (Button)findViewById(R.id.savebutton);

        Intent intent= getIntent();
        position= intent.getExtras().getString("id");
        name = intent.getExtras().getString("name");
        age = intent.getExtras().getString("age");
        gender = intent.getExtras().getString("gender");
        crimes = intent.getExtras().getString("crimes");
        location = intent.getExtras().getString("location");
        //image = intent.getExtras().getString("image");

        namee.setText(name);
        agee.setText(age);
        gendere.setText(gender);
        crimese.setText(crimes);
        locatione.setText(location);
        /*byte[] decodedByte = Base64.decode(image, 0);
        Bitmap b = BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
        imagee.setImageBitmap(b);*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void save(View v) {
        String name = namee.getText().toString();
        String age = agee.getText().toString();
        String gender = gendere.getText().toString();
        String crimes = crimese.getText().toString();
        String location = locatione.getText().toString();

        /*byte[] decodedByte = Base64.decode(image, 0);
        Bitmap b = BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] by = baos.toByteArray();
        String temp = Base64.encodeToString(by, Base64.DEFAULT);
        String image = temp;*/
        if(name.equals("")||age.equals("")||gender.equals("")||crimes.equals("")||location.equals("")) {
            Toast.makeText(getApplicationContext(), "Enter all fields before saving", Toast.LENGTH_SHORT).show();
        }
        else {
            DBHandler db= new DBHandler(getApplicationContext());
            Criminal criminal= new Criminal(name, age, gender, crimes, location);
            db.updatecriminal(criminal, Integer.parseInt(position));
            Toast.makeText(getApplicationContext(), "Criminal Data updated", Toast.LENGTH_SHORT).show();
        }
        Intent intent= new Intent(getApplicationContext(), ViewActivity.class);
        startActivity(intent);
    }
}
