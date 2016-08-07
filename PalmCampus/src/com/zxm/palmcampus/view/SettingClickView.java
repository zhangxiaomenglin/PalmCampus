package com.zxm.palmcampus.view;

import com.zxm.palmcampus.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
/**
 * 設置中心的自定義组合控件
 * 
 * @author xiaomeng
 *
 */
public class SettingClickView extends RelativeLayout {
	TextView tvTitle;
	TextView tvDesc;
	
	public SettingClickView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView();
	}

	public SettingClickView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	public SettingClickView(Context context) {
		super(context);
		initView();
	}
	/**
	 * 初始化布局
	 */
	private void initView() {
		//将自定义好的布局文件设置给当前的SeetingClickView
		View view = View.inflate(getContext(), R.layout.view_setting_click, this);
		tvTitle = (TextView) findViewById(R.id.tv_title);
		tvDesc = (TextView) findViewById(R.id.tv_desc);
	}
	public void setTitle(String title) {
		tvTitle.setText(title);
		tvTitle.setGravity(Gravity.CENTER);
	}

	public void setDesc(String desc) {
		tvDesc.setText(desc);
		tvDesc.setGravity(Gravity.CENTER);
	}

}
