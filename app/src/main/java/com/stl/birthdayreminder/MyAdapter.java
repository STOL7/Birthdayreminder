package com.stl.birthdayreminder;

import android.content.Context;
import android.net.Uri;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{


    //public ArrayList<String> img=null;
    public ArrayList<String> profile;
    public ArrayList<String> name;
    public ArrayList<String> bdate;
    //public ArrayList<String> urls;


    public MyAdapter(ArrayList<String> name, ArrayList<String> bdate, ArrayList<String> profile)
    {
        this.name=name;
        this.bdate=bdate;
        this.profile=profile;




        //this.img=img;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int i)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.birthday_view, parent, false);


        //Log.d("onCreateViewHolder",itemView.toString());


        return new MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder( MyViewHolder myViewHolder, int i)
    {
        //String im=img.get(i);
        final String nm=name.get(i);
        String bd=bdate.get(i);

        String prf=profile.get(i);
        //final String url=urls.get(i);

        final Context context=myViewHolder.prf.getContext();
        //Log.d("Image",profile.get(0));
        int id = context.getResources().getIdentifier(prf, "drawable", context.getPackageName());

        Glide.with(context).load(prf).into(myViewHolder.prf);
        myViewHolder.nm.setText(nm);
        myViewHolder.bd.setText("- "+bd);

        }







    @Override
    public int getItemCount()
    {
        return profile.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView prf;
        TextView nm;
        TextView bd;
        //TextView urls;

        RelativeLayout rlt;
        public MyViewHolder(View itemView)
        {
            super(itemView);

            prf=(ImageView)itemView.findViewById(R.id.profile);
            nm=(TextView)itemView.findViewById(R.id.name);
            bd=(TextView)itemView.findViewById(R.id.bdate);

            //urls=(TextView)itemView.findViewById(R.id.urls);
            rlt=(RelativeLayout)itemView.findViewById(R.id.rlt);

            //Log.d("MyViewHolder",txt.toString());

        }
    }


}
