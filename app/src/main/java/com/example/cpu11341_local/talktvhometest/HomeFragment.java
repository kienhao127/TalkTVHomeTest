package com.example.cpu11341_local.talktvhometest;

/**
 * Created by CPU11341-local on 8/17/2017.
 */
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bannerview.Banner;
import com.example.bannerview.BannerView;
import com.example.cpu11341_local.talktvhometest.adapter.DocGridRecyclerAdapter;
import com.example.cpu11341_local.talktvhometest.adapter.DocHorlistRecyclerAdapter;
import com.example.cpu11341_local.talktvhometest.adapter.HomeRecyclerAdapter;
import com.example.cpu11341_local.talktvhometest.data.DocGrid;
import com.example.cpu11341_local.talktvhometest.data.DocGridWithTitle;
import com.example.cpu11341_local.talktvhometest.data.DocHorizon;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    int tabID = 0;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<DocHorizon> arrHorList;
    ArrayList<DocGrid> arrDocGrid;
    ArrayList<DocGridWithTitle> arrDocGridWithTitle;
    ArrayList<Banner> arrBannerItems = new ArrayList<>();
    Parcelable state;

    public static HomeFragment newInstance(int someInt) {
        HomeFragment myFragment = new HomeFragment();

        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        myFragment.setArguments(args);

        return myFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabID = getArguments().getInt("someInt");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        String ImgURL = "http://i.imgur.com/XMhtBg0.png";
        arrHorList = new ArrayList<>();
        arrHorList.add(new DocHorizon(ImgURL, 1, "LOL"));
        arrHorList.add(new DocHorizon(ImgURL, 1, "88"));
        arrHorList.add(new DocHorizon(ImgURL, 1, "CFM"));
        arrHorList.add(new DocHorizon(ImgURL, 1, "99"));
        arrHorList.add(new DocHorizon(ImgURL, 1, "Liên Quân"));
        arrHorList.add(new DocHorizon(ImgURL, 1, "69"));
        arrHorList.add(new DocHorizon(ImgURL, 1, "Khác"));

        arrDocGrid = new ArrayList<>();
        arrDocGrid.add(new DocGrid(ImgURL, "TalkTV 47", 1));
        arrDocGrid.add(new DocGrid(ImgURL, "TalkTV 48", 1));
        arrDocGrid.add(new DocGrid(ImgURL, "TalkTV 49", 1));
        arrDocGrid.add(new DocGrid(ImgURL, "TalkTV 50", 1));
        arrDocGrid.add(new DocGrid(ImgURL, "TalkTV 51", 1));
        arrDocGrid.add(new DocGrid(ImgURL, "TalkTV 52", 1));

        arrDocGridWithTitle = new ArrayList<>();
        arrDocGridWithTitle.add(new DocGridWithTitle("Nổi bật", arrDocGrid));
        arrDocGridWithTitle.add(new DocGridWithTitle("Liên Quân", arrDocGrid));
        arrDocGridWithTitle.add(new DocGridWithTitle("Liên Minh Huyền thoại", arrDocGrid));

        arrBannerItems.add(new Banner(R.drawable.banner1, 69));
        arrBannerItems.add(new Banner(R.drawable.banner2, "www.google.com"));
        arrBannerItems.add(new Banner(R.drawable.banner3, 96));
        arrBannerItems.add(new Banner(R.drawable.banner4, "www.facebook.com"));

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewHome);
        if (tabID == 0){
            adapter = new HomeRecyclerAdapter(tabID, arrBannerItems, arrHorList, arrDocGridWithTitle);
        } else {
            adapter = new HomeRecyclerAdapter(tabID, arrHorList, arrDocGridWithTitle);
        }

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (state != null) {
            layoutManager.onRestoreInstanceState(state);
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        state = layoutManager.onSaveInstanceState();

    }
}