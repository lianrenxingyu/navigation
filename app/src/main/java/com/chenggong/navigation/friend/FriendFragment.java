package com.chenggong.navigation.friend;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chenggong.navigation.R;
import com.chenggong.navigation.fragment.BaseFragment;
import com.chenggong.navigation.friend.adapter.FriendRecyclerAdapter;
import com.chenggong.navigation.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenggong on 18-10-8.
 */

public class FriendFragment extends BaseFragment {

    private static final String TAG = "FriendFragment";
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private ImageView topBackgroundImage;

    private LogUtil sLog = LogUtil.getInstance();

    private List<String> strings = null;
    private FriendRecyclerAdapter adapter = null;

    public FriendFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment NewsFragment.
     */
    public static FriendFragment newInstance() {
        return new FriendFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_friend, container, false);
        recyclerView = view.findViewById(R.id.recycler_friend);
        initView();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        adapter = new FriendRecyclerAdapter(getContext(), strings);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initView() {
        strings = new ArrayList<>();
        strings.add("dlajal");
        strings.add("ldjafljfl");
        strings.add("dljfalfj");
        strings.add("dljfalfj");
        strings.add("dljfalfj");
        strings.add("dljfalfj");
        strings.add("dljfalfj");
        strings.add("dljfalfj");
        strings.add("dljfalfj");

    }

}

