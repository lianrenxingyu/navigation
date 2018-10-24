package com.chenggong.navigation.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.chenggong.navigation.R;
import com.chenggong.navigation.fragment.BaseFragment;
import com.chenggong.navigation.free.FreeFragment;
import com.chenggong.navigation.friend.FriendFragment;
import com.chenggong.navigation.meet.MeetFragment;
import com.chenggong.navigation.msg.MsgFragment;
import com.chenggong.navigation.utils.LogUtil;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    private RelativeLayout mMsgView;
    private RelativeLayout mFriendView;
    private RelativeLayout mFreeView;
    private RelativeLayout mMeetView;
    private RelativeLayout[] mNavigationViews = new RelativeLayout[4];//用于存放四个导航按钮的数组

    MsgFragment mMsgFragment;
    FriendFragment mFriendFragment;
    FreeFragment mFreeFragment;
    MeetFragment mMeetFragment;

    private FrameLayout mFrameLayout;// 主界面中展示fragment的frameLayout

    private LogUtil mLog = LogUtil.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getToolbar().setOverflowIcon(getResources().getDrawable(R.drawable.ic_add));
        initView();
        switchToMsg();
    }

    /**
     * 初始化界面
     * 一些赋值操作,按键初始化操作
     */
    private void initView() {
        mMsgView = findViewById(R.id.navigation_msg);
        mFriendView = findViewById(R.id.navigation_friend);
        mFreeView = findViewById(R.id.navigation_free);
        mMeetView = findViewById(R.id.navigation_meet);
        mNavigationViews[0] = mMsgView;
        mNavigationViews[1] = mFriendView;
        mNavigationViews[2] = mFreeView;
        mNavigationViews[3] = mMeetView;

        mFrameLayout = findViewById(R.id.main_container);

        mMsgFragment = MsgFragment.newInstance();
        mFriendFragment = FriendFragment.newInstance();
        mFreeFragment = FreeFragment.newInstance();
        mMeetFragment = MeetFragment.newInstance();

        mMsgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchToMsg();
            }
        });
        mFriendView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchToFriend();
            }
        });
        mFreeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchToFree();
            }
        });
        mMeetView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchToMeet();
            }
        });
    }

    /**
     * 设置某个底部导航按钮变为被选中状态
     *
     * @param view 被选中的底部导航按钮
     */
    private void setNavigationSelected(View view) {
        for (View imageView : mNavigationViews) {
            imageView.setSelected(false);
        }
        view.setSelected(true);
    }

    private void switchFragment(BaseFragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_container, fragment);
        transaction.commit();
    }

    private void switchToMsg() {
        if (mMsgView.isSelected()){
            return;
        }
        switchFragment(mMsgFragment);
        setNavigationSelected(mMsgView);
        mLog.d(TAG, "switch to message fragment");
    }

    private void switchToFriend() {
        if (mFriendView.isSelected()){
            return;
        }
        switchFragment(mFriendFragment);
        setNavigationSelected(mFriendView);
        mLog.d(TAG, "switch to friend fragment");
    }

    private void switchToFree() {
        if (mFreeView.isSelected()){
            return;
        }
        switchFragment(mFreeFragment);
        setNavigationSelected(mFreeView);
        mLog.d(TAG, "switch to free fragment");

    }

    private void switchToMeet() {
        if (mMeetView.isSelected()){
            return;
        }
        switchFragment(mMeetFragment);
        setNavigationSelected(mMeetView);
        mLog.d(TAG, "switch to meet fragment");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_friend:
                break;
            case R.id.create_group_chat:
                break;
            case R.id.scan_code:
                break;
        }
        return true;
    }
}



















