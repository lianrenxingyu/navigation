package com.chenggong.navigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.chenggong.navigation.utils.LogUtil;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RelativeLayout mMessageView;
    private RelativeLayout mFriendView;
    private RelativeLayout mFreeView;
    private RelativeLayout mMeetView;
    private RelativeLayout[] mNavigationViews = new RelativeLayout[4];//用于存放四个导航按钮的数组


    private LogUtil mLog = LogUtil.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化界面
     */
    private void initView() {
        mMessageView = findViewById(R.id.navigation_msg);
        mFriendView = findViewById(R.id.navigation_friend);
        mFreeView = findViewById(R.id.navigation_free);
        mMeetView = findViewById(R.id.navigation_meet);
        mNavigationViews[0] = mMessageView;
        mNavigationViews[1] = mFriendView;
        mNavigationViews[2] = mFreeView;
        mNavigationViews[3] = mMeetView;
        mMessageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLog.d(TAG, "message");
                setNavigationSelected(mMessageView);

            }
        });
        mFriendView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNavigationSelected(mFriendView);

            }
        });
        mFreeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNavigationSelected(mFreeView);

            }
        });
        mMeetView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNavigationSelected(mMeetView);
            }
        });
    }

    /**
     * 设置某个底部导航按钮变为被选中状态
     * @param view 被选中的底部导航按钮
     */
    private void setNavigationSelected(View view) {
        for (View imageView : mNavigationViews){
            imageView.setSelected(false);
        }
            view.setSelected(true);
    }
}
