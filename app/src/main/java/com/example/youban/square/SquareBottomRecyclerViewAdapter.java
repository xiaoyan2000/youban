package com.example.youban.square;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youban.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.youban.databinding.FragmentSquareBottomBinding;

import java.util.List;

public class SquareBottomRecyclerViewAdapter extends RecyclerView.Adapter<SquareBottomRecyclerViewAdapter.ViewHolder> {

    private final List<PlaceholderItem> mValues;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }
    public SquareBottomRecyclerViewAdapter(List<PlaceholderItem> items) {
        mValues = items;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentSquareBottomBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //holder.mImageView.setImageBitmap(mValues.get(position).bitmap);
        holder.mNameView.setText(mValues.get(position).name);
        holder.mTimeView.setText(mValues.get(position).time);
        holder.mAddressView.setText(mValues.get(position).address);
        holder.mNumPeople.setText(mValues.get(position).num_people);
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
        public final TextView mTimeView;
        public final TextView mAddressView;
        public final TextView mNumPeople;

        public ViewHolder(FragmentSquareBottomBinding binding) {
            super(binding.getRoot());
            mImageView = binding.imageSquarePerson;
            mNameView = binding.squareActivetyName;
            mTimeView = binding.squareActivetyTime;
            mAddressView = binding.squareactivetyAdress;
            mNumPeople = binding.squareActivetyNumbePersonr;
        }
    }
}