package com.codedev.college.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.codedev.college.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class ImageSlider extends SliderViewAdapter<ImageSlider.Myholder> {
    HomeFragment context;
    ArrayList<Integer> arrayList;
    LayoutInflater layoutInflater;

    public ImageSlider(HomeFragment context, ArrayList<Integer> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater=LayoutInflater.from(context.getContext());

    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent) {
        View view=layoutInflater.inflate(R.layout.slider_item,parent,false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(Myholder viewHolder, int position) {
        viewHolder.imageView.setImageResource(arrayList.get(position));
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    public class Myholder extends SliderViewAdapter.ViewHolder {
        ImageView imageView;
        public Myholder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_view);
        }
    }
}
