package com.codedev.college;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.codedev.college.ebook.EbookActivity;
import com.codedev.college.vid.videoActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        navController= Navigation.findNavController(this,R.id.frame_layout);

        navigationView=findViewById(R.id.navigation_view);
        drawerLayout=findViewById(R.id.drawerLayout);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.Start,R.string.close);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);

        NavigationUI.setupWithNavController(bottomNavigationView,navController);




        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_developer:
                startActivity(new Intent(MainActivity.this,DeveloperActivity.class));
                break;

            case R.id.navigation_video:
                startActivity(new Intent(MainActivity.this, videoActivity.class));
                break;

            case R.id.navigation_share:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Your body here";
                String shareSub = "Your subject here";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                break;

            case R.id.navigation_website:
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.snjb.org/engineering/"));
                startActivity(intent);
                break;

            case R.id.navigation_ebook:
                startActivity(new Intent(MainActivity.this, EbookActivity.class));
                break;



            case R.id.navigation_rate:
                Toast.makeText(this, "Rate", Toast.LENGTH_SHORT).show();
                break;




        }
        return true;
    }
}