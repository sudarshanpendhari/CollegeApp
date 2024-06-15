package com.codedev.college.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.codedev.college.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class facultyFragment extends Fragment {
    private RecyclerView cs,mech,civil,aids,etc,as;
    private LinearLayout csNoData,mechNoData,civilNoData,aidsNoData,etcNoData,asNoData;
    private List<teacherData> list1,list2,list3,list4,list5,list6;
    private DatabaseReference reference,dbRef;
    private teacherAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_faculty, container, false);


        cs=view.findViewById(R.id.cs);
        mech=view.findViewById(R.id.mech);
        civil=view.findViewById(R.id.civil);
        aids=view.findViewById(R.id.aids);
        etc=view.findViewById(R.id.etc);
        as=view.findViewById(R.id.as);

        csNoData=view.findViewById(R.id.csNoData);
        mechNoData=view.findViewById(R.id.mechNoData);
        civilNoData=view.findViewById(R.id.civilNoData);
        aidsNoData=view.findViewById(R.id.aidsNoData);
        etcNoData=view.findViewById(R.id.etcNoData);
        asNoData=view.findViewById(R.id.asNoData);

        reference= FirebaseDatabase.getInstance().getReference().child("teacher");

        cs();
        mech();
        civil();
        aids();
        etc();
        as();

        return view;
    }

    private void cs() {
        dbRef=reference.child("Computer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1=new ArrayList<>();
                if(!snapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    cs.setVisibility(View.GONE);
                }else{

                    csNoData.setVisibility(View.GONE);
                    cs.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        teacherData data=snapshot1.getValue(teacherData.class);
                        list1.add(data);
                    }
                    cs.setHasFixedSize(true);
                    cs.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new teacherAdapter(list1,getContext());
                    cs.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mech() {
        dbRef=reference.child("Mechanical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2=new ArrayList<>();
                if(!snapshot.exists()){
                    mechNoData.setVisibility(View.VISIBLE);
                    mech.setVisibility(View.GONE);
                }else{
                    mechNoData.setVisibility(View.GONE);
                    mech.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        teacherData data=snapshot1.getValue(teacherData.class);
                        list2.add(data);
                    }
                    mech.setHasFixedSize(true);
                    mech.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new teacherAdapter(list2,getContext());
                    mech.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void civil() {
        dbRef=reference.child("Civil");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3=new ArrayList<>();
                if(!snapshot.exists()){
                    civilNoData.setVisibility(View.VISIBLE);
                    civil.setVisibility(View.GONE);
                }else{

                    civilNoData.setVisibility(View.GONE);
                    civil.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        teacherData data=snapshot1.getValue(teacherData.class);
                        list3.add(data);
                    }
                    civil.setHasFixedSize(true);
                    civil.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new teacherAdapter(list3,getContext());
                    civil.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void etc() {
        dbRef=reference.child("E&TC");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list5=new ArrayList<>();
                if(!snapshot.exists()){
                    etcNoData.setVisibility(View.VISIBLE);
                    etc.setVisibility(View.GONE);
                }else{

                    etcNoData.setVisibility(View.GONE);
                    etc.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        teacherData data=snapshot1.getValue(teacherData.class);
                        list5.add(data);
                    }
                    etc.setHasFixedSize(true);
                    etc.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new teacherAdapter(list5,getContext());
                    etc.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void as() {
        dbRef=reference.child("Applied Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list6=new ArrayList<>();
                if(!snapshot.exists()){
                    asNoData.setVisibility(View.VISIBLE);
                    as.setVisibility(View.GONE);
                }else{

                    asNoData.setVisibility(View.GONE);
                    as.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        teacherData data=snapshot1.getValue(teacherData.class);
                        list6.add(data);
                    }
                    as.setHasFixedSize(true);
                    as.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new teacherAdapter(list6,getContext());
                    as.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void aids() {
        dbRef=reference.child("AI&DS");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4=new ArrayList<>();
                if(!snapshot.exists()){
                    aidsNoData.setVisibility(View.VISIBLE);
                    aids.setVisibility(View.GONE);
                }else{

                    aidsNoData.setVisibility(View.GONE);
                    aids.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        teacherData data=snapshot1.getValue(teacherData.class);
                        list4.add(data);
                    }
                    aids.setHasFixedSize(true);
                    aids.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new teacherAdapter(list4,getContext());
                    aids.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}