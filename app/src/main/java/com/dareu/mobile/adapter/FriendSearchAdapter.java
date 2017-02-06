package com.dareu.mobile.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dareu.mobile.R;
import com.dareu.mobile.net.AsyncTaskListener;
import com.dareu.mobile.net.account.LoadProfileImageTask;
import com.dareu.web.dto.response.entity.FriendSearchDescription;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

/**
 * Created by jose.rubalcaba on 01/30/2017.
 */

public class FriendSearchAdapter extends RecyclerView.Adapter<FriendSearchAdapter.FriendSearchViewHolder> {

    private List<FriendSearchDescription> list;
    private RecyclerViewOnItemClickListener<FriendSearchDescription> listener;

    public FriendSearchAdapter(List<FriendSearchDescription> list, RecyclerViewOnItemClickListener<FriendSearchDescription> listener){
        this.list = list;
        this.listener = listener;
    }

    @Override
    public FriendSearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_item, parent, false);
        FriendSearchViewHolder vh = new FriendSearchViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final FriendSearchViewHolder holder, final int position) {
        holder.nameView.setText(list.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClickListener(position, list.get(position));
            }
        });
        LoadProfileImageTask task = new LoadProfileImageTask(holder.imageView.getContext(), list.get(position).getId(), new AsyncTaskListener<Bitmap>() {
            @Override
            public void onTaskResponse(Bitmap response) {
                if(response != null)
                    holder.imageView.setImageBitmap(response);
            }

            @Override
            public void onError(String errorMessage) {

            }
        });
        task.execute();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class FriendSearchViewHolder extends RecyclerView.ViewHolder{

        CircularImageView imageView;
        TextView nameView;

        FriendSearchViewHolder(View view){
            super(view);
            this.imageView = (CircularImageView)view.findViewById(R.id.friendItemImage);
            this.nameView = (TextView)view.findViewById(R.id.friendItemName);
        }
    }
}