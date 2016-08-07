package com.zxm.palmcampus.base;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.zxm.palmcampus.R;
import com.zxm.palmcampus.activity.MainActivity;

public class BasePager {
	public Activity mActivity;
	
	public View mRootView;// 布局对象

	public TextView tvTitle;// 标题对象

	public FrameLayout flContent;// 内容

	public ImageButton btnMenu;// 菜单按钮
	public ImageButton btnPhoto;// 组图切换按钮

	public RelativeLayout relativity;//获取RelativeLayout控件
	
	public BasePager(Activity activity) {
		mActivity = activity;
		initViews();
	}
	/**
	 * 初始化布局
	 */
	public void initViews(){
		mRootView = View.inflate(mActivity, R.layout.base_pager, null);
		relativity = (RelativeLayout) mRootView.findViewById(R.id.base_rel_pager);
		tvTitle = (TextView) mRootView.findViewById(R.id.tv_title);
		flContent = (FrameLayout) mRootView.findViewById(R.id.fl_content);
		btnMenu = (ImageButton) mRootView.findViewById(R.id.btn_menu);
		btnPhoto = (ImageButton) mRootView.findViewById(R.id.btn_photo);
		btnMenu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				toggleSlidingMenu();
			}
		});
	}
	/**
	 * 切换SlidingMenu的状态
	 */
	private void toggleSlidingMenu() {
		MainActivity mainUi = (MainActivity) mActivity;
		SlidingMenu slidingMenu = mainUi.getSlidingMenu();
		slidingMenu.toggle();//切换状态,显示时隐藏,隐藏时显示
		
	}
	/**
	 * 初始化数据
	 */
	public void initData(){
		
	}
	/**
	 * 设置侧边栏开启或关闭
	 * 各个子页面所使用的方法
	 * @param enable
	 */
	public void setSlidingMenuEnable(boolean enable){
		MainActivity mainUi = (MainActivity) mActivity;
		SlidingMenu slidingMenu = mainUi.getSlidingMenu();
		
		if(enable){
			slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		}else{
			slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
		}
		
	}
}
