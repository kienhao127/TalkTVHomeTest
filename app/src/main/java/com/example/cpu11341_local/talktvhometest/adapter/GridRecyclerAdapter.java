package com.example.cpu11341_local.talktvhometest.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cpu11341_local.talktvhometest.R;
import com.example.cpu11341_local.talktvhometest.data.DocGrid;
import com.example.cpu11341_local.talktvhometest.data.DocHorizon;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.ArrayList;

/**
 * Created by CPU11341-local on 8/18/2017.
 */

public class GridRecyclerAdapter extends RecyclerView.Adapter<GridRecyclerAdapter.RecyclerViewHolder> {
    private ArrayList<DocGrid> arrGridItem = new ArrayList<DocGrid>();
    private Context context;

    public GridRecyclerAdapter(Context context){
        this.context = context;
    }

    public GridRecyclerAdapter(Context context, ArrayList<DocGrid> arrHorList){
        this.arrGridItem = arrHorList;
        this.context = context;
    }

    @Override
    public GridRecyclerAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_layout,parent,false);

        GridRecyclerAdapter.RecyclerViewHolder recyclerViewHolder = new GridRecyclerAdapter.RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    public static float pxFromDp(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

    @Override
    public void onBindViewHolder(GridRecyclerAdapter.RecyclerViewHolder holder, int position) {
        final DocGrid docGrid = arrGridItem.get(position);

        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .displayer(new RoundedBitmapDisplayer(10))
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).defaultDisplayImageOptions(displayImageOptions).build();
        ImageLoader.getInstance().init(config);
        ImageLoader.getInstance().displayImage(docGrid.getImageURL(), holder.imageViewThumb);

        holder.textViewChannelName.setText(docGrid.getChannelName());
    }

    @Override
    public int getItemCount() {
        return arrGridItem.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        ImageView imageViewThumb;
        TextView textViewChannelName;
        public RecyclerViewHolder(View view){
            super(view);
            imageViewThumb = (ImageView) view.findViewById(R.id.imageViewThumb);
            textViewChannelName = (TextView) view.findViewById(R.id.textViewChannelName);
        }
    }

    public void setData(ArrayList<DocGrid> data) {
        if (arrGridItem != data) {
            arrGridItem = data;
            notifyDataSetChanged();
        }
    }
}