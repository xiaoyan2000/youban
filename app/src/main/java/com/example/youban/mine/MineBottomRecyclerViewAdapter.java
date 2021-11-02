package com.example.youban.mine;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youban.databinding.FragmentMineBottomBinding;
import com.example.youban.placeholder.PlaceholderMineActivity.PlaceholderMin;

import java.util.List;

public class MineBottomRecyclerViewAdapter extends RecyclerView.Adapter<MineBottomRecyclerViewAdapter.ViewHolder> {

    private final List<PlaceholderMin> mValues;
    private MineBottomRecyclerViewAdapter.OnItemClickListener mOnItemClickListener;
    private MineBottomRecyclerViewAdapter.OnItemLongClickListener mOnItemLongClickListener;

    public void setOnItemClickListener(MineBottomRecyclerViewAdapter.OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setOnItemLongClickListener(MineBottomRecyclerViewAdapter.OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }

    public MineBottomRecyclerViewAdapter(List<PlaceholderMin> activities) {
        mValues = activities;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentMineBottomBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //holder.mPheadView.setImageBitmap(mValues.get(position).phead);
        holder.mNameView.setText(mValues.get(position).name);
        holder.mDataView.setText(mValues.get(position).time);
        holder.mContentView.setText(mValues.get(position).content);
        //holder.mAimageView1.setImageBitmap(mValues.get(position).aimage1);
        //holder.mAimageView2.setImageBitmap(mValues.get(position).aimage2);
        //holder.mAimageView3.setImageBitmap(mValues.get(position).aimage3);
        holder.mLocationView.setText(mValues.get(position).location);
        holder.mGoodnView.setText(mValues.get(position).goodnumber);
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
        public final ImageView mPheadView;
        public final TextView mNameView;
        public final TextView mDataView;
        public final TextView mContentView;
        public final ImageView mAimageView1;
        public final ImageView mAimageView2;
        public final ImageView mAimageView3;
        public final TextView mLocationView;
        public final TextView mGoodnView;
        public ViewHolder(FragmentMineBottomBinding binding) {
            super(binding.getRoot());
            mPheadView = binding.imageMinePerson;
            mNameView = binding.mineActivityPname;
            mDataView = binding.mineActivityData;
            mContentView = binding.mineActivityContent;
            mAimageView1 = binding.mineActivityImage1;
            mAimageView2 = binding.mineActivityImage2;
            mAimageView3 = binding.mineActivityImage3;
            mLocationView = binding.mineActivityLocation;
            mGoodnView = binding.mineGoodNumber;
        }
    }
}