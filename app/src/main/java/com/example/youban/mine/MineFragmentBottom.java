package com.example.youban.mine;

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
import com.example.youban.placeholder.PlaceholderMineActivity;
public class MineFragmentBottom extends Fragment {

    public MineFragmentBottom() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine_list, container, false);
            Context context = view.getContext();
        MineBottomRecyclerViewAdapter mTestAdapter = new MineBottomRecyclerViewAdapter(PlaceholderMineActivity.ACTS);
        mTestAdapter.setOnItemClickListener(new MineBottomRecyclerViewAdapter.OnItemClickListener() {
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(),ActivityEditInf.class);
                startActivity(intent);
            }
        });
        mTestAdapter.setOnItemLongClickListener(new MineBottomRecyclerViewAdapter.OnItemLongClickListener() {
            public void onItemLongClick(View view, int position) {
            }
        });
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(mTestAdapter);
        return view;
    }
}