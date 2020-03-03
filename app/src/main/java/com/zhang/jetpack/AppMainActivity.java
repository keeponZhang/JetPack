package com.zhang.jetpack;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class AppMainActivity extends AppCompatActivity {

    private NavController mNavController;
    private Intent mIntent;

    public NavController getNavController() {
        return mNavController;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        mNavController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, mNavController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, mNavController);

        mIntent = getIntent();
        mIntent.setData(Uri.parse("http://www.keepon.com"));
        //这样可以直接跳转
        // mNavController.handleDeepLink(mIntent);
    }

    public void jump() {
        // NavController navController =
        //         Navigation.findNavController(this, R.id.nav_host_fragment);
        // int nextAction = R.id.action_id;
        // int desId = R.id.navigation_dashboard;
        // mNavController.navigate(nextAction);
        mNavController.handleDeepLink(mIntent);

    }


}
