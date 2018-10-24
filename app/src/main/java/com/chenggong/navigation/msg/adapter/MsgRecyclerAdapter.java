package com.chenggong.navigation.msg.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chenggong.navigation.R;
import com.chenggong.navigation.utils.LogUtil;

import java.util.List;

/**
 * Created by chenggong on 18-10-13.
 */

public class MsgRecyclerAdapter extends RecyclerView.Adapter<MsgRecyclerAdapter.ViewHolder> {

    private static final String TAG = "MsgRecyclerAdapter";
    private LogUtil sLog = LogUtil.getInstance();

    List<MsgBrief> msgList;

    public MsgRecyclerAdapter(List<MsgBrief> list) {
        msgList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        sLog.d(TAG, "onCreateViewHolder in");
        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_msg, parent, false);
                return new ViewHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MsgBrief msg = msgList.get(position);
        holder.headImage.setImageResource(R.mipmap.iv_navigation_message_selected);
        holder.name.setText(msg.getName());
        holder.brief.setText(msg.getBrief());
        holder.time.setText(msg.getTime());
    }

    @Override
    public int getItemCount() {
        return msgList != null ? msgList.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return msgList.get(position).getType();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView headImage;
        private TextView name;
        private TextView brief;
        private TextView time;

        public ViewHolder(View itemView) {
            super(itemView);
            headImage = itemView.findViewById(R.id.head_image);
            name = itemView.findViewById(R.id.name);
            brief = itemView.findViewById(R.id.msg_brief);
            time = itemView.findViewById(R.id.msg_time);
        }
    }
}
