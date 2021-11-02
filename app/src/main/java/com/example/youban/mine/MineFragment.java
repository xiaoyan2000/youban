package com.example.youban.mine;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.youban.R;


public class MineFragment extends Fragment {
    private ImageView imageView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_mine, null);
        imageView=v.findViewById(R.id.mine_main);
        imageView.setOnClickListener(tabClickListenner);
        return v;
    }

    private View.OnClickListener tabClickListenner = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.mine_main:
                    Intent intent = new Intent(getActivity(),ActivityMineMainInf.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}