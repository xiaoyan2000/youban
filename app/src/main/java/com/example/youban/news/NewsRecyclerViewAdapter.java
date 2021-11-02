package com.example.youban.news;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youban.databinding.FragmentNewsBottomBinding;
import com.example.youban.placeholder.PlaceholderPerson;

import java.util.List;


public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder> {

    private final List<PlaceholderPerson.PlaceholderPer> mValues;
    private NewsRecyclerViewAdapter.OnItemClickListener mOnItemClickListener;
    private NewsRecyclerViewAdapter.OnItemLongClickListener mOnItemLongClickListener;

    public void setOnItemClickListener(NewsRecyclerViewAdapter.OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setOnItemLongClickListener(NewsRecyclerViewAdapter.OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }
    public NewsRecyclerViewAdapter(List<PlaceholderPerson.PlaceholderPer> pers) {
        mValues = pers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentNewsBottomBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //holder.mImageView.setImageBitmap(mValues.get(position).bitmap);
        holder.mNameView.setText(mValues.get(position).name);
        holder.mInfView.setText(mValues.get(position).information);
        holder.mTimeView.setText(mValues.get(position).time);
        if(mOnItemClickListener != null){
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition(); // 1
                    mOnItemClickListener.onItemClick(holder.itemView,position); // 2
                }
            });
        }
        if(mOnItemLongClickListener != null){
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemLongClickListener.onItemLongClick(holder.itemView,position);
                    //返回true 表示消耗了事件 事件不会继续传递
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView mImageView;
        public final TextView mNameView;
        public final TextView mInfView;
        public final TextView mTimeView;
        public ViewHolder(FragmentNewsBottomBinding binding) {
            super(binding.getRoot());
            mImageView=binding.newsBottomImage;
            mNameView=binding.newsBottomName;
            mInfView=binding.newsBottomInf;
            mTimeView=binding.newsBottomTime;
        }
    }
}