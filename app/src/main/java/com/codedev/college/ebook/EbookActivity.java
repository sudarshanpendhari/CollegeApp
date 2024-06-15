package com.codedev.college.ebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.codedev.college.R;
import com.codedev.college.ui.faculty.teacherAdapter;
import com.codedev.college.ui.faculty.teacherData;
import com.codedev.college.ui.gallery.GalleryAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends AppCompatActivity {

    private ArrayList<ebookData> list1,list2,list3,list4,list5,list6;

    private RecyclerView csr,mechr,civilr,aidsr,etcr,asr;
    private LinearLayout csrNoData,mechrNoData,civilrNoData,aidsrNoData,etcrNoData,asrNoData;
    private DatabaseReference reference,dbRef;
    private ebookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);


        csr=findViewById(R.id.csr);
        mechr=findViewById(R.id.mechr);
        civilr=findViewById(R.id.civilr);
        aidsr=findViewById(R.id.aidsr);
        etcr=findViewById(R.id.etcr);
        asr=findViewById(R.id.asr);

        csrNoData=findViewById(R.id.csrNoData);
        mechrNoData=findViewById(R.id.mechrNoData);
        civilrNoData=findViewById(R.id.civilrNoData);
        aidsrNoData=findViewById(R.id.aidsrNoData);
        etcrNoData=findViewById(R.id.etcrNoData);
        asrNoData=findViewById(R.id.asrNoData);

        reference= FirebaseDatabase.getInstance().getReference().child("pdf");

        csdata();
        mechdata();
        civildata();
        aidsdata();
        asdata();
        etcdata();




    }

    private void etcdata() {
        dbRef=reference.child("E&TC");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list6=new ArrayList<>();
                if(!snapshot.exists()){
                    etcrNoData.setVisibility(View.VISIBLE);
                    etcr.setVisibility(View.GONE);
                }else{

                    etcrNoData.setVisibility(View.GONE);
                    etcr.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        ebookData data=snapshot1.getValue(ebookData.class);
                        list6.add(data);
                    }
                    etcr.setHasFixedSize(true);
                    etcr.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                    adapter=new ebookAdapter(EbookActivity.this,list6);
                    etcr.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void asdata() {
        dbRef=reference.child("Applied Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list5=new ArrayList<>();
                if(!snapshot.exists()){
                    asrNoData.setVisibility(View.VISIBLE);
                    asr.setVisibility(View.GONE);
                }else{

                    asrNoData.setVisibility(View.GONE);
                    asr.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        ebookData data=snapshot1.getValue(ebookData.class);
                        list5.add(data);
                    }
                    asr.setHasFixedSize(true);
                    asr.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                    adapter=new ebookAdapter(EbookActivity.this,list5);
                    asr.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void aidsdata() {
        dbRef=reference.child("AI&DS");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4=new ArrayList<>();
                if(!snapshot.exists()){
                    aidsrNoData.setVisibility(View.VISIBLE);
                    aidsr.setVisibility(View.GONE);
                }else{

                    aidsrNoData.setVisibility(View.GONE);
                    aidsr.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        ebookData data=snapshot1.getValue(ebookData.class);
                        list4.add(data);
                    }
                    aidsr.setHasFixedSize(true);
                    aidsr.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                    adapter=new ebookAdapter(EbookActivity.this,list4);
                    aidsr.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void civildata() {
        dbRef=reference.child("Civil");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3=new ArrayList<>();
                if(!snapshot.exists()){
                    civilrNoData.setVisibility(View.VISIBLE);
                    civilr.setVisibility(View.GONE);
                }else{

                    civilrNoData.setVisibility(View.GONE);
                    civilr.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        ebookData data=snapshot1.getValue(ebookData.class);
                        list3.add(data);
                    }
                    civilr.setHasFixedSize(true);
                    civilr.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                    adapter=new ebookAdapter(EbookActivity.this,list3);
                    civilr.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void mechdata() {
        dbRef=reference.child("Mechanical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2=new ArrayList<>();
                if(!snapshot.exists()){
                    mechrNoData.setVisibility(View.VISIBLE);
                    mechr.setVisibility(View.GONE);
                }else{

                    mechrNoData.setVisibility(View.GONE);
                    mechr.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        ebookData data=snapshot1.getValue(ebookData.class);
                        list2.add(data);
                    }
                    mechr.setHasFixedSize(true);
                    mechr.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                    adapter=new ebookAdapter(EbookActivity.this,list2);
                    mechr.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void csdata() {
        dbRef=reference.child("Computer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1=new ArrayList<>();
                if(!snapshot.exists()){
                    csrNoData.setVisibility(View.VISIBLE);
                    csr.setVisibility(View.GONE);
                }else{

                    csrNoData.setVisibility(View.GONE);
                    csr.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        ebookData data=snapshot1.getValue(ebookData.class);
                        list1.add(data);
                    }
                    csr.setHasFixedSize(true);
                    csr.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                    adapter=new ebookAdapter(EbookActivity.this,list1);
                    csr.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private void getdata() {
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                list=new ArrayList<>();
//                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
//                    ebookData data= dataSnapshot.getValue(ebookData.class);
//                    list.add(data);
//                }
//
//                ebookAdapter=new ebookAdapter(EbookActivity.this,list);
//                ebookRecycler.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
//                ebookRecycler.setAdapter(ebookAdapter);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
}