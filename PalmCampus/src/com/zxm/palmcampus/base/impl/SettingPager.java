package com.zxm.palmcampus.base.impl;

import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.zxm.palmcampus.R;
import com.zxm.palmcampus.base.BasePager;
import com.zxm.palmcampus.base.impl.setting.SettingHomeActivity;
import com.zxm.palmcampus.base.impl.setting.SettingLoginActivity;
import com.zxm.palmcampus.base.impl.setting.SettingNotify;
import com.zxm.palmcampus.base.impl.setting.SettingVersionActivity;
import com.zxm.palmcampus.view.SettingClickView;

public class SettingPager extends BasePager {
	private View view;
	
	private TextView btnlogin;// 登录按钮
	
	private SettingClickView scvnotify;// 系统通知
	private SettingClickView scvversion;// 系统版本
	private SettingClickView scvsetting;// 设置
	public SettingPager(Activity activity) {
		super(activity);
	}
	@Override
	public void initData() {
		System.out.println("初始化设置数据....");

		tvTitle.setText("设置");
		btnMenu.setVisibility(View.GONE);// 隐藏菜单按钮
		setSlidingMenuEnable(false);// 打开侧边栏
		//初始化界面
		view = initView();
		//系统通知
		initNotify();
		//版本信息
		initVersion();
		//设置选项
		initSetting();
		//登录界面
		initLogin();
		
		// 向FrameLayout中动态添加布局
		flContent.addView(view);
	}
	
	private View initView(){
		View view = View.inflate(mActivity, R.layout.activity_setting, null);
		return view;
	}
	/**
	 * 系统通知
	 */
	private void initNotify() {
		scvnotify = (SettingClickView) view.findViewById(R.id.scv_notify);
		scvnotify.setTitle("系统通知");
		scvnotify.setDesc("等待消息");
		scvnotify.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
		scvnotify.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showNotifyDailog();
			}
		});
	}
	/**
	 * 系统通知提示
	 */
	private void showNotifyDailog() {
		// 跳转通知
		Intent intent = new Intent();
		intent.setClass(mActivity, SettingNotify.class);
		// intent.putExtra("url", mNewsList.get(position).url);
		mActivity.startActivity(intent);
	}
	/**
	 * 版本
	 */
	private void initVersion() {
		scvversion = (SettingClickView) view.findViewById(R.id.scv_version);
		scvversion.setTitle("版本");
		scvversion.setDesc("版本信息");
		scvversion.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showVersion();
			}
		});
	}
	/**
	 * 版本信息
	 */
	private void showVersion() {
		// AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
		// builder.setIcon(R.drawable.ic_launcher).setTitle("版本")
		// .setMessage("当前版本是：" + getVersionName())
		// .setPositiveButton("确定", null).show();
		// 跳转版本信息
		Intent intent = new Intent();
		intent.setClass(mActivity, SettingVersionActivity.class);
		// intent.putExtra("url", mNewsList.get(position).url);
		mActivity.startActivity(intent);
	}
	/**
	 * 设置
	 */
	private void initSetting() {
		scvsetting = (SettingClickView) view.findViewById(R.id.scv_setting);
		scvsetting.setTitle("设置");
		scvsetting.setDesc("设置");
		scvsetting.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showSetting();
			}

		});
	}
	/**
	 * 设置
	 */
	private void showSetting() {
		// 跳转设置主界面
		Intent intent = new Intent();
		intent.setClass(mActivity, SettingHomeActivity.class);
		mActivity.startActivity(intent);
	}
	
	/**
	 * 登录按钮
	 */
	private void initLogin() {
		btnlogin = (TextView) view.findViewById(R.id.tv_login);
		btnlogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showLogin();

			}
		});
	}
	/**
	 * 登录业务处理
	 */
	private void showLogin() {
		// 跳转设置登录面
		Intent intent = new Intent();
		intent.setClass(mActivity, SettingLoginActivity.class);
		// intent.putExtra("url", mNewsList.get(position).url);
		mActivity.startActivity(intent);
	}
}
