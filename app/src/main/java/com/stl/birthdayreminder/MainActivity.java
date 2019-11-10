package com.stl.birthdayreminder;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity
{

    Toolbar toolbar;
    FloatingActionButton f_action_btn;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff) ;
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

//        View header = mNavigationView.getHeaderView(0);




        mFragmentTransaction = mFragmentManager.beginTransaction();

        mFragmentTransaction.replace(R.id.display,new display_birthday()).commit();


        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                if(menuItem.getItemId()==R.id.nav_item_home)
                {

                    mFragmentTransaction = mFragmentManager.beginTransaction();

                    mFragmentTransaction.replace(R.id.display,new display_birthday()).commit();
                }

                if(menuItem.getItemId()==R.id.nav_item_feedback)
                {
                    Intent Email = new Intent(Intent.ACTION_SEND);
                    Email.setType("text/email");
                    Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "17ceuog010@ddu.ac.in" });
                    Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                    Email.putExtra(Intent.EXTRA_TEXT, "Dear ...," + "");
                    startActivity(Intent.createChooser(Email, "Send Feedback:"));
                    return true;
                }
                if(menuItem.getItemId()==R.id.nav_item_rate)
                {

                    Uri marketUri = Uri.parse("market://details?id=" + getPackageName());
                    Intent marketIntent = new Intent(Intent.ACTION_VIEW, marketUri);
                    startActivity(marketIntent);

                }



                return false;
            }

        });

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name,
                R.string.app_name);


        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);

        return super.onCreateOptionsMenu(menu);
    }
}
