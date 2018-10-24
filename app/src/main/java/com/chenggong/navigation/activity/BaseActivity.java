package com.chenggong.navigation.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.chenggong.navigation.R;
import com.chenggong.navigation.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenggong on 18-10-2.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";
    private LogUtil sLog = LogUtil.getInstance();
    private List<Activity> activities = new ArrayList<>();

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activities.add(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initToolbar();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activities.remove(this);
    }

    protected void finishAllActivities() {
        for (Activity activity : activities) {
            activity.finish();
        }
        activities.clear();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    /************************ toolbar method begin **************************/

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);//不显示默认的title
            sLog.d(TAG, "set toolbar success");
        }
    }

    protected Toolbar getToolbar() {
        return toolbar;
    }

    /**
     *  set the toolbar in mainactivity gone
     */
    protected void setToolbarGone(){
        if (toolbar == null)return;
        toolbar.setVisibility(View.GONE);
    }

    protected void setToolbarVisible(){
        if (toolbar == null || toolbar.getVisibility() == View.VISIBLE) return;
        toolbar.setVisibility(View.VISIBLE);

    }
    /**
     * set toolbar title
     *
     * @param title
     */
    protected void setTitle(String title) {
        if (toolbar != null) {
            sLog.d(TAG, "toolbar is null ,set toolbar title fail");
            return;
        }
        TextView toolbat_title = toolbar.findViewById(R.id.toolbar_title);
        toolbat_title.setText(title);
    }

    /************************ toolbar method end **************************/
}
