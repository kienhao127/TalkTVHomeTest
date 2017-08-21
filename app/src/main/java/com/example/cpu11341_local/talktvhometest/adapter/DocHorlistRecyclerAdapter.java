package com.example.cpu11341_local.talktvhometest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cpu11341_local.talktvhometest.R;
import com.example.cpu11341_local.talktvhometest.data.DocHorizon;

import java.util.ArrayList;

/**
 * Created by CPU11341-local on 8/18/2017.
 */

public class DocHorlistRecyclerAdapter extends RecyclerView.Adapter<DocHorlistRecyclerAdapter.RecyclerViewHolder> {
    private ArrayList<DocHorizon> arrHorList = new ArrayList<DocHorizon>();

    public DocHorlistRecyclerAdapter(){
    }

    public DocHorlistRecyclerAdapter(ArrayList<DocHorizon> arrHorList){
        this.arrHorList = arrHorList;
    }

    @Override
    public DocHorlistRecyclerAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horlist_item_layout, parent,false);

        DocHorlistRecyclerAdapter.RecyclerViewHolder recyclerViewHolder = new DocHorlistRecyclerAdapter.RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(DocHorlistRecyclerAdapter.RecyclerViewHolder holder, int position) {
        final DocHorizon docHorizon = arrHorList.get(position);
        holder.imageViewIcon.setImageResource(docHorizon.getImgID());
        holder.textViewTitle.setText(docHorizon.getTitle());
    }

    @Override
    public int getItemCount() {
        return arrHorList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        ImageView imageViewIcon;
        TextView textViewTitle;
        public RecyclerViewHolder(View view){
            super(view);
            imageViewIcon = (ImageView) view.findViewById(R.id.imageView);
            textViewTitle = (TextView) view.findViewById(R.id.textView);
        }
    }

    public void setData(ArrayList<DocHorizon> data) {
        if (arrHorList != data) {
            arrHorList = data;
            notifyDataSetChanged();
        }
    }
}