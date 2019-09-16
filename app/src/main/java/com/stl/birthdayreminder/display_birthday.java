package com.stl.birthdayreminder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;



public class display_birthday extends Fragment
{
    int i=0;

    DatabaseReference databaseReference;

    BirthdayBoy birthdayBoy;
    private Toolbar toolbar;

    private RecyclerView recyclerview;
    private RecyclerView.Adapter adapter;

    private RecyclerView.LayoutManager layoutmanager;
    MyAdapter myAdapter;

    private ArrayList<String> profile = new ArrayList<String>();
    private ArrayList<String> name = new ArrayList<String>();
    private ArrayList<String> bdate = new ArrayList<String>();




    Intent intent;

    Context con;
    public display_birthday()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        con=getActivity();
        //Toast.makeText(getContext(),"Entered",Toast.LENGTH_LONG).show();
        birthdayBoy = new BirthdayBoy();
        databaseReference=FirebaseDatabase.getInstance().getReference("User");

        layoutmanager=new LinearLayoutManager(con);



        return inflater.inflate(R.layout.recyclerview, container, false);




    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        //recyclerview=(RecyclerView)getView().findViewById(R.id.recycler_view);
        //recyclerview.removeAllViewsInLayout();




        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {

                    //Toast.makeText(getContext(),"Entered in firebase",Toast.LENGTH_LONG).show();

                    birthdayBoy = ds.getValue(BirthdayBoy.class);

                    profile.add(birthdayBoy.profile);
                    name.add(birthdayBoy.name);

                    bdate.add(birthdayBoy.bDate);
                    //Log.d(name.get(i),bdate.get(i));
                   // i++;
                }

                //Log.d("After adding",bdate.toString());

                myAdapter=new MyAdapter(name,bdate,profile);



                recyclerview.setLayoutManager(layoutmanager);

                recyclerview.setHasFixedSize(true);

                recyclerview.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




        }

    }









