package com.stl.birthdayreminder;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity
{

    Toolbar toolbar;
    FloatingActionButton f_action_btn;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();


        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        f_action_btn = (FloatingActionButton)findViewById(R.id.fab);

        f_action_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Hiii my first button",Snackbar.LENGTH_LONG)
                        .setAction("Action",null).show();
                Intent itn=new Intent(MainActivity.this,AddBirthDate.class);
                startActivity(itn);



            }
        });

        //FrameLayout cl=(FrameLayout)(findViewById(R.id.display));
        //cl.removeAllViews();
        mFragmentTransaction = mFragmentManager.beginTransaction();

        mFragmentTransaction.replace(R.id.display,new display_birthday()).commit();

    }


}
