package com.example.youban.square;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.youban.R;
import com.example.youban.placeholder.PlaceholderContent;

public class SquareBottom extends Fragment {

    public SquareBottom() {
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        SquareBottomRecyclerViewAdapter mTestAdapter = new SquareBottomRecyclerViewAdapter(PlaceholderContent.ITEMS);
        mTestAdapter.setOnItemClickListener(new SquareBottomRecyclerViewAdapter.OnItemClickListener() {
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), ActivityInfomation.class);
                startActivity(intent);
            }
        });
        mTestAdapter.setOnItemLongClickListener(new SquareBottomRecyclerViewAdapter.OnItemLongClickListener() {
            public void onItemLongClick(View view, int position) {
            }
        });
        View view = inflater.inflate(R.layout.fragment_square_bottom_list, container, false);
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(mTestAdapter);
        return view;
    }
}