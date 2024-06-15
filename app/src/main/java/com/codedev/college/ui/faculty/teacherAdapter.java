package com.codedev.college.ui.faculty;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import com.codedev.college.R;


import java.util.List;

public class teacherAdapter extends RecyclerView.Adapter<teacherAdapter.teacherViewAdapter> {
    private  List<teacherData> list;
    private Context context;


    public teacherAdapter(List<teacherData> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public teacherViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faculty_item_layout, parent, false);
        return new teacherViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull teacherViewAdapter holder, int position) {
        teacherData item = list.get(position);
        holder.name.setText(item.getName());
        holder.email.setText(item.getEmail());
        holder.post.setText(item.getPost());
        holder.blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(item.getBlog()));
                context.startActivity(i);

            }
        });
        try {
            Glide.with(context).load(item.getImage()).placeholder(R.drawable.ic_developer).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class teacherViewAdapter extends RecyclerView.ViewHolder {
        private TextView name, email, post,blog;

        private ImageView imageView;

        public teacherViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.teacherName);
            email = itemView.findViewById(R.id.teacherEmail);
            post = itemView.findViewById(R.id.teacherPost);
            imageView = itemView.findViewById(R.id.teacherImage);
            blog=itemView.findViewById(R.id.vBlog);


        }
    }
}
