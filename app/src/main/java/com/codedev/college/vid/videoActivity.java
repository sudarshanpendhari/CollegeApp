package com.codedev.college.vid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.codedev.college.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class videoActivity extends AppCompatActivity {
    private DatabaseReference reference,dbRef;
    private vidAdapter adapter;
    private RecyclerView vidrv;
    private ArrayList<vidData> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        vidrv=findViewById(R.id.vidrv);
        reference= FirebaseDatabase.getInstance().getReference().child("video");




        getData();


//        getLifecycle().addObserver(youTubePlayerView);


    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list=new ArrayList<>();
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    vidData data=snapshot1.getValue(vidData.class);
                    list.add(data);
                }

                adapter =new vidAdapter(videoActivity.this,list);
                adapter.notifyDataSetChanged();
                vidrv.setLayoutManager(new LinearLayoutManager(videoActivity.this));

                vidrv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(videoActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}