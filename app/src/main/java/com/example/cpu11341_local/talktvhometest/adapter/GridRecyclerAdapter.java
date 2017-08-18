package com.example.cpu11341_local.talktvhometest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cpu11341_local.talktvhometest.R;
import com.example.cpu11341_local.talktvhometest.data.DocGrid;
import com.example.cpu11341_local.talktvhometest.data.DocHorizon;

import java.util.ArrayList;

/**
 * Created by CPU11341-local on 8/18/2017.
 */

public class GridRecyclerAdapter extends RecyclerView.Adapter<GridRecyclerAdapter.RecyclerViewHolder> {
    private ArrayList<DocGrid> arrGridItem = new ArrayList<DocGrid>();

    public GridRecyclerAdapter(){
    }

    public GridRecyclerAdapter(ArrayList<DocGrid> arrHorList){
        this.arrGridItem = arrHorList;
    }

    @Override
    public GridRecyclerAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_layout,parent,false);

        GridRecyclerAdapter.RecyclerViewHolder recyclerViewHolder = new GridRecyclerAdapter.RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(GridRecyclerAdapter.RecyclerViewHolder holder, int position) {
        final DocGrid docGrid = arrGridItem.get(position);
        holder.imageViewThumb.setImageResource(docGrid.getImageID());
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