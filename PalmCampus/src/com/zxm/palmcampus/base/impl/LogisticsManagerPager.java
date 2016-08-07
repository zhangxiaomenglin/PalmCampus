package com.zxm.palmcampus.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.zxm.palmcampus.base.BasePager;

public class LogisticsManagerPager extends BasePager {

	public LogisticsManagerPager(Activity activity) {
		super(activity);
	}
	@Override
	public void initData() {
		System.out.println("初始化后勤管理数据....");

		tvTitle.setText("后勤管理");
		setSlidingMenuEnable(true);// 打开侧边栏

		TextView text = new TextView(mActivity);
		text.setText("宿舍管理");
		text.setTextColor(Color.RED);
		text.setTextSize(25);
		text.setGravity(Gravity.CENTER);

		// 向FrameLayout中动态添加布局
		flContent.addView(text);
	}

}
