package com.example.cpu11341_local.talktvhometest;

/**
 * Created by CPU11341-local on 8/17/2017.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cpu11341_local.talktvhometest.adapter.HomeRecyclerAdapter;
import com.example.cpu11341_local.talktvhometest.data.DocGrid;
import com.example.cpu11341_local.talktvhometest.data.DocHorizon;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    int tabID = 0;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<DocHorizon> arrHorList;
    ArrayList<DocGrid> arrDocGrid;
    public static HomeFragment newInstance(int someInt) {
        HomeFragment myFragment = new HomeFragment();

        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        myFragment.setArguments(args);

        return myFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);

        arrHorList = new ArrayList<DocHorizon>();
        arrHorList.add(new DocHorizon(R.drawable.horlist_item_logo, 1, "LOL"));
        arrHorList.add(new DocHorizon(R.drawable.horlist_item_logo, 1, "88"));
        arrHorList.add(new DocHorizon(R.drawable.horlist_item_logo, 1, "CFM"));
        arrHorList.add(new DocHorizon(R.drawable.horlist_item_logo, 1, "99"));
        arrHorList.add(new DocHorizon(R.drawable.horlist_item_logo, 1, "Liên Quân"));
        arrHorList.add(new DocHorizon(R.drawable.horlist_item_logo, 1, "69"));
        arrHorList.add(new DocHorizon(R.drawable.horlist_item_logo, 1, "Khác"));

        arrDocGrid = new ArrayList<>();
        arrDocGrid.add(new DocGrid(R.drawable.grid_item, "TalkTV 47", 1));
        arrDocGrid.add(new DocGrid(R.drawable.grid_item, "TalkTV 48", 1));
        arrDocGrid.add(new DocGrid(R.drawable.grid_item, "TalkTV 49", 1));
        arrDocGrid.add(new DocGrid(R.drawable.grid_item, "TalkTV 50", 1));
        arrDocGrid.add(new DocGrid(R.drawable.grid_item, "TalkTV 51", 1));
        arrDocGrid.add(new DocGrid(R.drawable.grid_item, "TalkTV 52", 1));

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewHome);
        adapter = new HomeRecyclerAdapter(arrHorList, arrDocGrid);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
