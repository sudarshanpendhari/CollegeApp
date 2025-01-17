package com.codedev.college.ebook;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codedev.college.R;

import java.util.ArrayList;
import java.util.List;

public class ebookAdapter extends RecyclerView.Adapter<ebookAdapter.EbookViewHolder> {
    private Context context;
    private ArrayList<ebookData> list;

    public ebookAdapter(Context context, ArrayList<ebookData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.ebook_item_layout,parent,false);

        return new EbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EbookViewHolder holder,final int  position) {
        holder.pdfTitle.setText(list.get(holder.getAdapterPosition()).getPdfTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, list.get(holder.getAdapterPosition()).getPdfTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.ebookDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(holder.getAdapterPosition()).getPdfUrl()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EbookViewHolder extends RecyclerView.ViewHolder {

        private TextView pdfTitle;
        private ImageView ebookDownload;

        public EbookViewHolder(@NonNull View itemView) {
            super(itemView);

            ebookDownload=itemView.findViewById(R.id.ebookDownload);
            pdfTitle=itemView.findViewById(R.id.pdfTitle);

        }
    }
}
