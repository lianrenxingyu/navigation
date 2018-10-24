package com.chenggong.navigation.msg;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chenggong.navigation.R;
import com.chenggong.navigation.fragment.BaseFragment;
import com.chenggong.navigation.msg.adapter.MsgBrief;
import com.chenggong.navigation.msg.adapter.MsgRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenggong on 18-10-8.
 */

public class MsgFragment extends BaseFragment {

    private static final String TAG = "MsgFragment";

    private List<MsgBrief> msgLists = new ArrayList<>();

    private MsgRecyclerAdapter adapter;
    private RecyclerView recyclerView;

    public MsgFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment NewsFragment.
     */
    public static MsgFragment newInstance() {
        return new MsgFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_msg, container, false);
        recyclerView = view.findViewById(R.id.recycler_msg);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        adapter = new MsgRecyclerAdapter(msgLists);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        initView();
        recyclerView.setAdapter(adapter);
    }

    private void initView() {
        MsgBrief msg = new MsgBrief("imagePath", "Undefined", "这是一个消息,我发送了一个消息给你,请接收,一个新的消息", "7:08", 0);
        for (int i = 0; i < 10; i++) {
            msgLists.add(msg);
        }
    }
}
