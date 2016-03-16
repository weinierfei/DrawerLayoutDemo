package com.example.drawerlayouttest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.View;
import android.view.Window;

import com.nineoldandroids.view.ViewHelper;


public class MainActivity extends FragmentActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerLayout);
        initEvents();

    }


    private void initEvents() {
        mDrawerLayout.setDrawerListener(new DrawerListener() {
            @Override
            public void onDrawerStateChanged(int newState) {
            }

            //当产生抽屉滑动时
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //获取mDrawerLayout中的第一个子布局，也就是布局中的Relativelayt
                //获取抽屉的view
                View mContent = mDrawerLayout.getChildAt(0);
                View mMenu = drawerView;
                float scale = 1 - slideOffset;
                float rightScale = 0.8f + scale * 0.2f;

                if (drawerView.getTag().equals("LEFT")) {

                    float leftScale = 1 - 0.3f * scale;

                    //设置左边菜单滑动后的占据屏幕大小
                    ViewHelper.setScaleX(mMenu, leftScale);
                    ViewHelper.setScaleY(mMenu, leftScale);
                    //设置菜单透明度
                    ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));

                    //设置内容界面水平和垂直方向偏转量
                    //在滑动时内容界面的宽度为 屏幕宽度减去菜单界面所占宽度
                    ViewHelper.setTranslationX(mContent, mMenu.getMeasuredWidth() * (1 - scale));
                    //设置内容界面操作无效（比如有button就会点击无效）
                    mContent.invalidate();
                    //设置右边菜单滑动后的占据屏幕大小
                    ViewHelper.setScaleX(mContent, rightScale);
                    ViewHelper.setScaleY(mContent, rightScale);
                }
            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }

            @Override
            public void onDrawerClosed(View drawerView) {
            }
        });
    }


}
