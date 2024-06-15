package com.codedev.college.vid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.codedev.college.R;

import java.util.ArrayList;
import java.util.List;

public class vidAdapter extends RecyclerView.Adapter<vidAdapter.videoViewHolder> {

    private Context context;
    private ArrayList<vidData> list;

    public vidAdapter(Context context, ArrayList<vidData> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public videoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.video_layout,parent,false);

        return new videoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(videoViewHolder holder, int position) {
        vidData item = list.get(position);
//        holder.vidTitle.setText(item.getVidTitle());


        holder.youTubePlayerView.loadUrl(item.getVidId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class videoViewHolder extends RecyclerView.ViewHolder{
         WebView youTubePlayerView;
//         TextView vidTitle;


        public videoViewHolder( View itemView) {
            super(itemView);
            youTubePlayerView=(WebView) itemView.findViewById(R.id.videoView);
//            vidTitle=itemView.findViewById(R.id.textVid);
            youTubePlayerView.getSettings().setJavaScriptEnabled(true);


            youTubePlayerView.setWebViewClient(new WebViewClient());


        }

    }

}
