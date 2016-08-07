package com.zxm.palmcampus.base.home.syllabus;

import java.util.ArrayList;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.zxm.palmcampus.R;
import com.zxm.palmcampus.base.home.syllabus.adapter.MyFragmentPagerAdapter;
import com.zxm.palmcampus.base.home.syllabus.fragment.Fragment1;
import com.zxm.palmcampus.base.home.syllabus.fragment.Fragment2;
import com.zxm.palmcampus.base.home.syllabus.fragment.Fragment3;

/**
 * 首页--课程表
 * 
 * @author xiaomeng
 *
 */
public class Syllabus extends FragmentActivity {
	private static final String TAG = "SyllabusActivity";
	private TextView tvProgramme, tvWeekend, tvplan;// 日程，周末，计划
	private ViewPager mPager;
	private ArrayList<Fragment> fragmentsList;

	private int currIndex = 0;
	private ImageView ivBottomLine;
	private int bottomLineWidth;

	private int offset = 0;
	private int position_one;
	private int position_two;
	private int position_three;

	private Resources resources;// 获取系统内的资源

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.home_syllabus);
		resources = getResources();
		InitWidth();
		InitTextView();
		InitViewPager();

	}

	/**
	 * 初始化显示的小条目
	 */
	private void InitTextView() {
		tvProgramme = (TextView) findViewById(R.id.tvProgramme);
		tvWeekend = (TextView) findViewById(R.id.tvWeekend);
		tvplan = (TextView) findViewById(R.id.tvplan);
		
		//三个页面的点击事件
		tvProgramme.setOnClickListener(new MyOnClickListener(0));
		tvWeekend.setOnClickListener(new MyOnClickListener(1));
		tvplan.setOnClickListener(new MyOnClickListener(2));
	}

	/**
	 * 用ViewPager初始化每个分页面
	 * 
	 */
	private void InitViewPager() {
		mPager = (ViewPager) findViewById(R.id.vPager);
		fragmentsList = new ArrayList<Fragment>();

		Fragment1 fmpro = new Fragment1();
		Fragment2 fmweekend = new Fragment2();
		Fragment3 fmplan = new Fragment3();

		fragmentsList.add(fmpro);
		fragmentsList.add(fmweekend);
		fragmentsList.add(fmplan);

		mPager.setAdapter(new MyFragmentPagerAdapter(
				getSupportFragmentManager(), fragmentsList));
		mPager.setCurrentItem(0);
		mPager.setOnPageChangeListener(new MyOnPageChangeListener());

	}

	private void InitWidth() {
		ivBottomLine = (ImageView) findViewById(R.id.iv_bottom_line);
		bottomLineWidth = ivBottomLine.getLayoutParams().width;
		Log.d(TAG, "cursor imageview width=" + bottomLineWidth);
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenW = dm.widthPixels;
		offset = (int) ((screenW / 3 - bottomLineWidth) / 2);
		Log.i("MainActivity", "screenW=" + screenW);
		Log.i("MainActivity", "offset=" + offset);
		// 分配三个导航栏的宽度
		position_one = (int) (screenW / 3);
		position_two = position_one * 2;
		position_three = position_one * 3;

	}

	public class MyOnClickListener implements OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			mPager.setCurrentItem(index);
		}
	}

	/**
	 * viewPager点击事件
	 */
	public class MyOnPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageSelected(int arg0) {
			Animation animation = null;
			switch (arg0) {
			case 0:
				if (currIndex == 1) {
					animation = new TranslateAnimation(position_one, 0, 0, 0);
					tvProgramme.setTextColor(resources
							.getColor(R.color.lightwhite));
				} else if (currIndex == 2) {
					animation = new TranslateAnimation(position_two, 0, 0, 0);
					tvWeekend.setTextColor(resources
							.getColor(R.color.lightwhite));
				}
				tvplan.setTextColor(resources.getColor(R.color.white));
				break;
			case 1:
				if (currIndex == 0) {
					animation = new TranslateAnimation(0, position_one, 0, 0);
					tvplan.setTextColor(resources.getColor(R.color.lightwhite));
				} else if (currIndex == 2) {
					animation = new TranslateAnimation(position_two,
							position_one, 0, 0);
					tvWeekend.setTextColor(resources
							.getColor(R.color.lightwhite));
				}
				tvProgramme.setTextColor(resources.getColor(R.color.white));
				break;
			case 2:
				if (currIndex == 0) {
					animation = new TranslateAnimation(0, position_two, 0, 0);
					tvplan.setTextColor(resources.getColor(R.color.lightwhite));
				} else if (currIndex == 1) {
					animation = new TranslateAnimation(position_one,
							position_two, 0, 0);
					tvProgramme.setTextColor(resources
							.getColor(R.color.lightwhite));
				}
				tvWeekend.setTextColor(resources.getColor(R.color.white));
				break;
			}
			currIndex = arg0;
			// 设置放动画效果
			animation.setFillAfter(true);
			animation.setDuration(300);
			ivBottomLine.startAnimation(animation);
		}

	}

}
