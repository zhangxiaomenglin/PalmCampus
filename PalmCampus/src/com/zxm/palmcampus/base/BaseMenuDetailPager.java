package com.zxm.palmcampus.base;

import android.app.Activity;
import android.view.View;

public abstract class BaseMenuDetailPager {
	public Activity mActivity;
	
	public View mRootView;//根布局对象
	
	public BaseMenuDetailPager(Activity activity) {
		mActivity = activity;
		mRootView = initViews();
	}
	/**
	 * 初始化界面
	 * @return
	 */
	public abstract View initViews();
	/**
	 * 初始化数据
	 */
	public void initDate(){
		
	}
	
}
