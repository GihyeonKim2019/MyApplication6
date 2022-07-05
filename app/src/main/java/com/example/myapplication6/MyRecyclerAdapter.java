package com.example.myapplication6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> implements OnPersonItemClickListener{

    private ArrayList<RecyclerData> mFriendList;
    OnPersonItemClickListener listener;





    @NonNull
    @Override
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.ViewHolder holder, int position) {
        holder.onBind(mFriendList.get(position));
        holder.itemView.setTag(position);
    }

    public void setFriendList(ArrayList<RecyclerData> list){
        this.mFriendList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mFriendList.size();
    }

    public void setOnItemClickListener(OnPersonItemClickListener listener) {
        this.listener = listener;
    }

    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder,view,position);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profile;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int pos = getBindingAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, v, pos);
                    }


                }
            });

            profile = (ImageView) itemView.findViewById(R.id.item_image);

        }

        void onBind(RecyclerData item){
            profile.setImageResource(item.getResId());

        }

    }

}