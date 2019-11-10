package com.stl.birthdayreminder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class display_birthday extends Fragment
{
    int i=0;

    DatabaseReference databaseReference;


    private Toolbar toolbar;

    private RecyclerView recyclerview;
    private RecyclerView.Adapter adapter;

    private RecyclerView.LayoutManager layoutmanager;


    private ArrayList<String> profile = new ArrayList<String>();
    private ArrayList<String> name = new ArrayList<String>();
    private ArrayList<String> bdate = new ArrayList<String>();

    MyAdapter adapt;



    Intent intent;
    FloatingActionButton f_action_btn;

    Context con;
    public display_birthday()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        con=getActivity();


        /*databaseReference=FirebaseDatabase.getInstance().getReference().child("User");
        databaseReference.keepSynced(true);*/

        layoutmanager=new LinearLayoutManager(con);



        return inflater.inflate(R.layout.recyclerview, container, false);




    }



    public void onStart()
    {
        super.onStart();
       // firebaseAdapter.startListening();
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerview = (RecyclerView) getView().findViewById(R.id.recycler_view);

        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(layoutmanager);


        f_action_btn = (FloatingActionButton)getView().findViewById(R.id.fab);

        f_action_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view,"Hiii my first button",Snackbar.LENGTH_LONG)
                        //.setAction("Action",null).show();

                Intent myIntent = new Intent(getActivity(), AddBirthDate.class);
                getActivity().startActivity(myIntent);



            }
        });





        /*Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("User");

        FirebaseRecyclerOptions<User> options =
                new FirebaseRecyclerOptions.Builder<User>()
                        .setQuery(databaseReference,User.class).build();

        firebaseAdapter = new FirebaseRecyclerAdapter<User, MyViewHolder>(options) {


            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.birthday_view,viewGroup,false);

                return new MyViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull User model)
            {
                holder.nm.setText(model.getName());
                holder.bd.setText(model.getbDate());
                Picasso.with(getContext()).load(model.getProfile()).into(holder.prf);
            }
        };*/

        DatabaseHelper db = new DatabaseHelper(con);
        db.createDataBase();
        db.openDataBase();
        db.getBirthday();

        name=db.name;
        bdate=db.b_date;
        profile=db.image;
        adapt=new MyAdapter(name,profile,bdate);
        recyclerview=(RecyclerView)getView().findViewById(R.id.recycler_view);
        recyclerview.setLayoutManager(layoutmanager);
        recyclerview.setHasFixedSize(true);

        recyclerview.setAdapter(adapt);






    }

    }










