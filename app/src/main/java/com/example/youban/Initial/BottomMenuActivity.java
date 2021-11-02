package com.example.youban.Initial;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.youban.R;
import com.example.youban.mine.MineFragment;
import com.example.youban.news.NewsFragment;
import com.example.youban.square.SquareFragment;

public class BottomMenuActivity extends FragmentActivity {
    private SquareFragment square;
    private NewsFragment news;
    private MineFragment mine;
    private int currentId = R.id.tv_main;//当前选择的id，默认是主页
    private TextView text_square,text_news,text_mine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_menu);
        text_square=findViewById(R.id.tv_main);
        text_news=findViewById(R.id.tv_message);
        text_mine=findViewById(R.id.tv_mine);
        text_square.setSelected(true);
        text_news.setSelected(false);
        text_mine.setSelected(false);
        //默认加载首页
        square = new SquareFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container,square).commit();
        text_square.setOnClickListener(tabClickListenner);
        text_news.setOnClickListener(tabClickListenner);
        text_mine.setOnClickListener(tabClickListenner);
    }
    private View.OnClickListener tabClickListenner = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(v.getId() != currentId){
                changeSelect(v.getId());//改变图标文字颜色的选中
                changeFragment(v.getId());//改变fragment事务
                currentId = v.getId();//修改选中的id
            }
        }
    };
    //改变fragment事务
    private void changeFragment(int res_id){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();//开启一个fragment事务
        hideFragments(transaction);//隐藏所有fragment
        switch (res_id){
            case R.id.tv_main:
                if(square==null){
                    //如果为空先添加，否则直接显示
                    square = new SquareFragment();
                    transaction.add(R.id.main_container,square);
                }
                else {
                    transaction.show(square);
                }
                break;
            case R.id.tv_message:
                if(news==null){
                    //如果为空先添加，否则直接显示
                    news = new NewsFragment();
                    transaction.add(R.id.main_container,news);
                }
                else {
                    transaction.show(news);
                }
                break;
            case R.id.tv_mine:
                if(mine==null){
                    //如果为空先添加，否则直接显示
                    mine = new MineFragment();
                    transaction.add(R.id.main_container,mine);

                }
                else {
                    transaction.show(mine);
                }
                break;
        }
        transaction.commit();
    }
    //隐藏所有fragment
    private void hideFragments(FragmentTransaction transaction){
        if(square !=null) transaction.hide(square);
        if(news !=null) transaction.hide(news);
        if(mine !=null) transaction.hide(mine);
    }
    //改变图标文字颜色的选中
    private void changeSelect(int res_id){
         text_square.setSelected(false);
        text_news.setSelected(false);
        text_mine.setSelected(false);
        switch (res_id){
            case R.id.tv_main:
                text_square.setSelected(true);
                break;
            case R.id.tv_message:
                text_news.setSelected(true);
                break;
            case R.id.tv_mine:
                text_mine.setSelected(true);
                break;
        }
    }
}
