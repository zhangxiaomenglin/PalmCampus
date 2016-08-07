package com.zxm.palmcampus.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 *  fragment基类
 * @author xiaomeng
 *
 */
public abstract class BaseFragment extends Fragment {
	public Activity mActivity;
	
	//fragment创建
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mActivity = getActivity();
	}
	
	//处理fragmet的布局
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return initViews();
	}
	
	//依附的activity创建完成
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initData();
	}
	// 初始化数据, 可以不实现
	public void initData() {
		
	}

	// 子类必须实现初始化布局的方法
	public abstract View initViews();
	
	
	
}
