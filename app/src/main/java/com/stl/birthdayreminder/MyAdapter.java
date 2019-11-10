package com.stl.birthdayreminder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{


    //public ArrayList<String> img=null;
    public ArrayList<String> names;
    public ArrayList<String> emails;
    public ArrayList<String> images;

    public ArrayList<String> contacts;
    public ArrayList<String> b_dates;


    public MyAdapter(ArrayList<String> names, ArrayList<String> images, ArrayList<String> b_dates)
    {
        this.names=names;
       // this.emails=emails;
        this.images=images;
        this.b_dates=b_dates;
        Log.d("MyAdapter",b_dates.toString());


        //this.img=img;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int i)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.birthday_view, parent, false);

        Log.d("onCreateViewHolder",itemView.toString());


        return new MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder( MyViewHolder myViewHolder, int i)
    {
        //String im=img.get(i);
        final String nm=names.get(i);
//        String em=emails.get(i);

        String img=images.get(i);
        final String bd=b_dates.get(i);

        final Context context=myViewHolder.img.getContext();
        Log.d("Image",img);
        //int id = context.getResources().getIdentifier(img, "drawable", context.getPackageName());

        String imageDataBytes = img.substring(img.indexOf(",")+1);

        InputStream stream = new ByteArrayInputStream(Base64.decode(imageDataBytes.getBytes(), Base64.DEFAULT));

        Bitmap bitmap = BitmapFactory.decodeStream(stream);

        myViewHolder.img.setImageBitmap(bitmap);
        //startAppAd= new StartAppAd(context);
        myViewHolder.bdate.setText(bd);
        myViewHolder.names.setText(nm);
        //myViewHolder.email.setText(em);






    }

    @Override
    public int getItemCount()
    {
        return names.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        //TextView email;
        TextView names;
        TextView bdate;

        RelativeLayout rlt;
        public MyViewHolder(View itemView)
        {
            super(itemView);

            img=(ImageView)itemView.findViewById(R.id.profile);
           // email=(TextView)itemView.findViewById(R.id.em);
            bdate=(TextView)itemView.findViewById(R.id.bdate);
            names=(TextView)itemView.findViewById(R.id.name);
            //rlt=(RelativeLayout)itemView.findViewById(R.id.rlt);
            Log.d("MyViewHolder",bdate.toString());

        }
    }


}
