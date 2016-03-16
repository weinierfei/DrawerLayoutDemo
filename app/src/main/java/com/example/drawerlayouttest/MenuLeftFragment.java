package com.example.drawerlayouttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuLeftFragment extends Fragment {

    @Bind(R.id.first)
    RelativeLayout first;
    @Bind(R.id.second)
    RelativeLayout second;
    @Bind(R.id.third)
    RelativeLayout third;
    @Bind(R.id.ll_four)
    RelativeLayout llFour;
    @Bind(R.id.ll_five)
    RelativeLayout llFive;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_menu, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.first, R.id.second, R.id.third, R.id.ll_four, R.id.ll_five})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.first:
                Toast.makeText(getActivity(), "第一个", Toast.LENGTH_SHORT).show();
                break;
            case R.id.second:
                Toast.makeText(getActivity(), "第二个", Toast.LENGTH_SHORT).show();
                break;
            case R.id.third:
                Toast.makeText(getActivity(), "第三个", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_four:
                Toast.makeText(getActivity(), "第四个", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_five:
                Toast.makeText(getActivity(), "第五个", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
