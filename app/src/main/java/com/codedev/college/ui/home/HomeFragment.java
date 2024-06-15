package com.codedev.college.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codedev.college.R;
import com.codedev.college.WebActivity;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private SliderView sliderView;
    private String urlll;
    ArrayList<Integer> arrayList = new ArrayList<>();
    private ImageView map;
    private TextView t1,t2,t3,t4,t5,t6;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderView = view.findViewById(R.id.slider);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.FILL);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

        map=view.findViewById(R.id.map);
        t1=view.findViewById(R.id.compText);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                urlll="http://www.snjb.org/engineering/Computer_engineering/computer_engineering_profile";

                Intent intent=new Intent(view.getContext(),WebActivity.class);
                intent.putExtra("url",urlll);
                startActivity(intent);


            }
        });
        t2=view.findViewById(R.id.mechText);
        t3=view.findViewById(R.id.civilText);
        t4=view.findViewById(R.id.aidsText);
        t5=view.findViewById(R.id.etcText);
        t6=view.findViewById(R.id.asText);

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                urlll="http://www.snjb.org/engineering/Mechanical_engineering/mechanical_engineering_profile";

                Intent intent=new Intent(view.getContext(),WebActivity.class);
                intent.putExtra("url",urlll);
                startActivity(intent);


            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                urlll="http://www.snjb.org/engineering/Civil_engineering/civil_engineering_profile";

                Intent intent=new Intent(view.getContext(),WebActivity.class);
                intent.putExtra("url",urlll);
                startActivity(intent);


            }
        });

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                urlll="http://www.snjb.org/engineering/Artificial_intelligence/aids_profile";

                Intent intent=new Intent(view.getContext(),WebActivity.class);
                intent.putExtra("url",urlll);
                startActivity(intent);


            }
        });

        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                urlll="http://www.snjb.org/engineering/Electronics_telecommunication/electronics_telecommunication_engineering_profile";

                Intent intent=new Intent(view.getContext(),WebActivity.class);
                intent.putExtra("url",urlll);
                startActivity(intent);


            }
        });

        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                urlll="http://www.snjb.org/engineering/Applied_science/engineering_applied_science_profile";

                Intent intent=new Intent(view.getContext(),WebActivity.class);
                intent.putExtra("url",urlll);
                startActivity(intent);


            }
        });


        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });

        arrayList.add(R.drawable.snjb0);
        arrayList.add(R.drawable.snjb1);
        arrayList.add(R.drawable.snjb2);
        arrayList.add(R.drawable.snjb3);
        arrayList.add(R.drawable.snjb4);
        arrayList.add(R.drawable.snjb5);
        arrayList.add(R.drawable.snjb6);

        ImageSlider imageSlider = new ImageSlider(HomeFragment.this, arrayList);
        sliderView.setSliderAdapter(imageSlider);
        sliderView.startAutoCycle();


        return view;
    }

    private void openMap() {
        Uri uri=Uri.parse("geo:0, 0?q=SNJB's College of Engineering");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);


    }

}