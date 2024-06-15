package com.codedev.college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DeveloperActivity extends AppCompatActivity {
    private ImageView linkedin,github;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        linkedin=findViewById(R.id.linkedin);
        github=findViewById(R.id.github);

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/sudarshan-pendhari-2aa19222a/?trk=public_profile_browsemap&originalSubdomain=in"));
                startActivity(intent);
            }
        });

        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/sudarshanpendhari"));
                startActivity(intent);

            }
        });
    }
}