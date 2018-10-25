package com.example.edgarreyes.possiblecodetest;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;

import java.util.ArrayList;

public class DvdAdapter extends RecyclerView.Adapter<DvdAdapter.DvdViewHolder>{

    private ArrayList<Dvd> mDvdList;

    public DvdAdapter(ArrayList<Dvd> data){
        mDvdList = data;
    }


    @NonNull
    @Override
    public DvdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View dvdView = inflater.inflate(R.layout.dvd_container,parent, false);
        DvdViewHolder viewHolder = new DvdViewHolder(dvdView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DvdViewHolder holder, int position) {
            Dvd dvd = mDvdList.get(position);
            String title = dvd.getTitle();
            String imageUrl = dvd.getUrl();
            ImageView dvdImageView = holder.mDvdImage;
            holder.mDvdTitle.setText(title);
            Glide.with(dvdImageView).load(imageUrl).into(dvdImageView);

    }

    @Override
    public int getItemCount() {
        return mDvdList.size();
    }

    public class DvdViewHolder extends RecyclerView.ViewHolder{

        public ImageView mDvdImage;
        public TextView mDvdTitle;

        public DvdViewHolder(View itemView) {
            super(itemView);
            mDvdTitle = itemView.findViewById(R.id.container_dvd_title_tv);
            mDvdImage = itemView.findViewById(R.id.container_dvd_image_iv);
        }

    }

}
