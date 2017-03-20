package com.example.material_design.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.material_design.R;
import com.example.material_design.activity.ImagesActivity;
import com.example.material_design.javabean.Images;

import java.util.List;

/**
 * Created by user on 2017/2/27.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private List<Images> mImagesList;
    private Context mContext;
    public ImageAdapter(List<Images> imagesList) {
        mImagesList = imagesList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView mCardView;
        private TextView mName;
        private ImageView mIamge;

        public ViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView) itemView;
            mName = (TextView) itemView.findViewById(R.id.name);
            mIamge = (ImageView) itemView.findViewById(R.id.Iv_images);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext == null){
             mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Images images = mImagesList.get(position);
                Intent intent = new Intent(mContext,ImagesActivity.class);
                intent.putExtra(ImagesActivity.IMAGE_NAME,images.getName());
                intent.putExtra(ImagesActivity.IMAGE_ID,images.getImageId());
                mContext.startActivity(intent);
            }
        });
        return  holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Images images = mImagesList.get(position);
        holder.mName.setText(images.getName());
        Glide.with(mContext).load(images.getImageId()).into(holder.mIamge);
    }

    @Override
    public int getItemCount() {
        return mImagesList.size();
    }
}
