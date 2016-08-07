package com.zxm.palmcampus.base;

import com.zxm.palmcampus.R;
import com.zxm.palmcampus.domain.NewsData.NewsTabData;
import com.zxm.palmcampus.global.GlobalContants;

import android.app.Activity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;

public class TabDetailPager extends BaseMenuDetailPager implements OnPageChangeListener{

	NewsTabData mTabData;
	
	private String mUrl;
	
	
	public TabDetailPager(Activity activity, NewsTabData newsTabData) {
		super(activity);
		mTabData = newsTabData;
		mUrl = GlobalContants.SERVER_URL + mTabData.url;
		System.out.println("运行到TabDetailPager");
	}

	@Override
	public View initViews() {
		View view = View.inflate(mActivity, R.layout.tab_detail_pager, null);
		
		
		
		return view;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
	}

	@Override
	public void onPageSelected(int arg0) {
		
	}

}
