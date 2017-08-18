package com.example.cpu11341_local.talktvhometest.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cpu11341_local.talktvhometest.R;
import com.example.cpu11341_local.talktvhometest.data.DocGrid;
import com.example.cpu11341_local.talktvhometest.data.DocHorizon;

import java.util.ArrayList;

/**
 * Created by CPU11341-local on 8/18/2017.
 */

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.HorizonRVHolder> {
    private ArrayList<DocHorizon> arrHorList = new ArrayList<DocHorizon>();
    private ArrayList<DocGrid> arrDocGrid = new ArrayList<DocGrid>();
    private static RecyclerView horizontalList;
    private static RecyclerView gridList;

    public HomeRecyclerAdapter(ArrayList<DocHorizon> arrHorList, ArrayList<DocGrid> arrDocGrid){
        this.arrHorList = arrHorList;
        this.arrDocGrid = arrDocGrid;
    }

    @Override
    public HorizonRVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:{
                return new GridRVHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_layout,parent,false));
            }
            default:{
                return new HorizonRVHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.horlist_item_layout,parent,false));
            }
        }
    }

    @Override
    public void onBindViewHolder(HomeRecyclerAdapter.HorizonRVHolder holder, int position) {
        holder.horizontalAdapter.setData(arrHorList);
//        holder.gridRecyclerAdapter.setData(arrDocGrid);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class HorizonRVHolder extends RecyclerView.ViewHolder{
        HorlistRecyclerAdapter horlistRecyclerAdapter;
        private HorlistRecyclerAdapter horizontalAdapter;

        public HorizonRVHolder(View view){
            super(view);
            Context context = itemView.getContext();
            horizontalList = (RecyclerView) itemView.findViewById(R.id.recyclerViewHorList);
            horizontalList.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            horizontalAdapter = new HorlistRecyclerAdapter();
            horizontalList.setAdapter(horizontalAdapter);
        }
    }

    public static class GridRVHolder extends HorizonRVHolder {

        private GridRecyclerAdapter gridRecyclerAdapter;
        public GridRVHolder(View view){
            super(view);
            Context context = itemView.getContext();
            gridList = (RecyclerView) itemView.findViewById(R.id.recyclerViewGrid);
            gridList.setLayoutManager(new GridLayoutManager(context, 2));
            gridRecyclerAdapter = new GridRecyclerAdapter();
            gridList.setAdapter(gridRecyclerAdapter);
        }
    }


}