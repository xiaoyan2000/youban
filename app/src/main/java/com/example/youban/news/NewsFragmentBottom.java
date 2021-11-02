package com.example.youban.news;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.youban.R;
import com.example.youban.placeholder.PlaceholderPerson;

public class NewsFragmentBottom extends Fragment {

    public NewsFragmentBottom() {
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_news_bottom_list, container, false);
            Context context = view.getContext();
        NewsRecyclerViewAdapter mTestAdapter = new NewsRecyclerViewAdapter(PlaceholderPerson.PERS);
        mTestAdapter.setOnItemClickListener(new NewsRecyclerViewAdapter.OnItemClickListener() {
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), CommunityActivity.class);
                startActivity(intent);
            }
        });
        mTestAdapter.setOnItemLongClickListener(new NewsRecyclerViewAdapter.OnItemLongClickListener() {
            public void onItemLongClick(View view, int position) {
            }
        });
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(mTestAdapter);
        return (View)recyclerView;
    }
}