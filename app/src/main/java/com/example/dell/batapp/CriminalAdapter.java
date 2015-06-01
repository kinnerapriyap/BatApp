package com.example.dell.batapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Dell on 1/12/2015.
 */
public class CriminalAdapter extends ArrayAdapter<Criminal> {

    Context context;

    public CriminalAdapter(Context context, int resource, List<Criminal> list) {
        super(context, resource, list);
        this.context= context;
    }

    static class ViewHolder {
        TextView criminalname;
        TextView criminalage;
        TextView criminalgender;
        TextView criminalcrimes;
        TextView criminallocation;
        //ImageView criminalimage;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView==null) {
            LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.detailview, parent, false);

            holder=new ViewHolder();

            holder.criminalname= (TextView)convertView.findViewById(R.id.nametext);
            holder.criminalage= (TextView)convertView.findViewById(R.id.agetext);
            holder.criminalgender= (TextView)convertView.findViewById(R.id.gendertext);
            holder.criminalcrimes= (TextView)convertView.findViewById(R.id.crimestext);
            holder.criminallocation= (TextView)convertView.findViewById(R.id.locationtext);

            //holder.criminalimage= (ImageView)convertView.findViewById(R.id.image);

            convertView.setTag(holder);
        }

        else {
            holder= (ViewHolder) convertView.getTag();
        }

        Criminal criminal= getItem(position);
        holder.criminalname.setText(criminal.getName());
        holder.criminalage.setText(criminal.getAge());
        holder.criminalgender.setText(criminal.getGender());
        holder.criminalcrimes.setText(criminal.getCrimes());
        holder.criminallocation.setText(criminal.getLocation());
        /*byte[] decodedByte = Base64.decode(criminal.getImage(), 0);
        Bitmap b = BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
        holder.criminalimage.setImageBitmap(b);*/

        return convertView;

    }

}
