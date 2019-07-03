package com.example.firstandroidcode;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>
{

    private List<ItemBean> mItemBeans;

    public ItemAdapter(List<ItemBean> list)
    {
        mItemBeans = list;
    }

    public void setmItemBeans(List<ItemBean> mItemBeans)
    {
        this.mItemBeans = mItemBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        ItemBean itemBean = mItemBeans.get(position);
        holder.mTextView.setText(itemBean.getmText());
        holder.mImageView.setImageResource(itemBean.getmResId());
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mItemBeans.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView mImageView;
        private TextView mTextView;

        public ViewHolder(View view)
        {
            super(view);
            mImageView = view.findViewById(R.id.id_img);
            mTextView = view.findViewById(R.id.id_text);
        }
    }
}
