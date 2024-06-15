package com.codedev.college.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codedev.college.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    RecyclerView recycler1,recycler2;
    GalleryAdapter adapter;

    DatabaseReference reference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);

        recycler1=view.findViewById(R.id.recycler1);
        recycler2=view.findViewById(R.id.recycler2);

        reference= FirebaseDatabase.getInstance().getReference().child("gallery");

        getR1Image();

        getR2Image();

        return  view;
    }

    private void getR2Image() {
        reference.child("Infrastructure").addValueEventListener(new ValueEventListener() {

            List<String>imageList=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String data=(String) dataSnapshot.getValue();
                    imageList.add(data);
                }

                adapter=new GalleryAdapter(getContext(),imageList);
                recycler1.setLayoutManager(new GridLayoutManager(getContext(),3));
                recycler1.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getR1Image() {
        reference.child("others").addValueEventListener(new ValueEventListener() {

            List<String>imageList=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String data=(String) dataSnapshot.getValue();
                    imageList.add(data);
                }

                adapter=new GalleryAdapter(getContext(),imageList);
                recycler2.setLayoutManager(new GridLayoutManager(getContext(),3));
                recycler2.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}