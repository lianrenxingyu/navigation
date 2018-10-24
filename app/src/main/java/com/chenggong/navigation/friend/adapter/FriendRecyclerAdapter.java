package com.chenggong.navigation.friend.adapter;

import android.app.FragmentTransaction;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.chenggong.navigation.R;
import com.chenggong.navigation.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenggong on 18-10-21.
 * <p>
 * 朋友圈的adapter
 * 考虑包含的数据类型
 * 1.文字+表情,符号
 * 2.图片和gif
 * 3.音乐
 * 4.个人录音
 * 5.视频
 * 6.链接
 * 7.上面数据类型的混合
 * <p>
 * 必须包含的功能部分
 * 1.点赞,评论
 * 2.日期
 * <p>
 * <p>
 * 考虑的功能部分
 * 1.朋友圈消息好友随机可见
 * 2.朋友圈消息的截屏控制,截屏虚化
 * 3.地点
 */

public class FriendRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "FriendRecyclerAdapter";
    private Context context;
    private List<String> dataList = new ArrayList<>();

    private LogUtil sLog = LogUtil.getInstance();

    public FriendRecyclerAdapter() {
    }

    public FriendRecyclerAdapter(Context context, List<String> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        viewType = 0;//todo 测试text情况,暂时设置为0
        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend_text_news, parent, false);
                holder = new BaseViewHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }


    class BaseViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private String news;//消息
        private ImageView headImage;//头像
        private TextView name;//用户名
        private TextView newsTime;//消息发送时间
        private FrameLayout container;//各种朋友圈消息的内容容器
        private ImageView comment;//打开评论的按钮

        public BaseViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            news = "这是一条朋友圈,哈哈哈,我也不知道写些什么,凑个字数吧,不知道多少字数了";
            headImage = itemView.findViewById(R.id.head_image);
            name = itemView.findViewById(R.id.name);
            newsTime = itemView.findViewById(R.id.news_time);
            container = itemView.findViewById(R.id.news_content_container);
            comment = itemView.findViewById(R.id.comment);

        }
    }


}
