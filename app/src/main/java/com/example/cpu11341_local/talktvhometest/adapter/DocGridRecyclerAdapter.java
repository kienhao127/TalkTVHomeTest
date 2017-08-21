package com.example.cpu11341_local.talktvhometest.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cpu11341_local.talktvhometest.R;
import com.example.cpu11341_local.talktvhometest.data.DocGridWithTitle;

import java.util.ArrayList;

/**
 * Created by CPU11341-local on 8/18/2017.
 */

public class DocGridRecyclerAdapter extends RecyclerView.Adapter<DocGridRecyclerAdapter.RVHolder> {
    private static ArrayList<DocGridWithTitle> arrDocGrid = new ArrayList<DocGridWithTitle>();
    private static RecyclerView gridList;

    public DocGridRecyclerAdapter(ArrayList<DocGridWithTitle> arrDocGrid){
        this.arrDocGrid = arrDocGrid;
    }

    public DocGridRecyclerAdapter() {

    }

    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RVHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_grid_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(DocGridRecyclerAdapter.RVHolder holder, int position) {
        holder.gridRecyclerAdapter.setData(arrDocGrid.get(position).getarrDocGrid());
        holder.textView.setText(arrDocGrid.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return arrDocGrid.size();
    }

    public static class RVHolder extends RecyclerView.ViewHolder{
//        private HorlistRecyclerAdapter horizontalAdapter;
        private GridRecyclerAdapter gridRecyclerAdapter;
        private TextView textView;
        public RVHolder(View view){
            super(view);
            Context context = itemView.getContext();

            textView = (TextView) itemView.findViewById(R.id.textViewTitle);
            gridList = (RecyclerView) itemView.findViewById(R.id.recyclerViewGrid);
            gridList.setLayoutManager(new GridLayoutManager(context, 2));
            gridRecyclerAdapter = new GridRecyclerAdapter();
            gridList.setAdapter(gridRecyclerAdapter);
        }
    }

    public void setData(ArrayList<DocGridWithTitle> data) {
        if (arrDocGrid != data) {
            arrDocGrid = data;
            notifyDataSetChanged();
        }
    }
}