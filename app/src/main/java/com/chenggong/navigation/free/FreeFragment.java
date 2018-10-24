package com.chenggong.navigation.free;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chenggong.navigation.R;
import com.chenggong.navigation.fragment.BaseFragment;

/**
 * Created by chenggong on 18-10-8.
 */

public class FreeFragment extends BaseFragment {
    public FreeFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment NewsFragment.
     */
    public static FreeFragment newInstance() {
        return new FreeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_free,container,false);
        return view;
    }
}
