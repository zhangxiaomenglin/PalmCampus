package com.zxm.palmcampus.fragment;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zxm.palmcampus.R;
import com.zxm.palmcampus.base.BasePager;
import com.zxm.palmcampus.base.impl.HomePager;
import com.zxm.palmcampus.base.impl.LogisticsManagerPager;
import com.zxm.palmcampus.base.impl.NewsCenterPager;
import com.zxm.palmcampus.base.impl.SettingPager;
import com.zxm.palmcampus.base.impl.SmartServicePager;

public class ContentFragment extends BaseFragment {
	@ViewInject(R.id.rg_group)
	private RadioGroup rgGroup;

	@ViewInject(R.id.vp_content)
	private ViewPager mViewPager;

	// 存放五个界面的集合
	private ArrayList<BasePager> mPagerList;

	@Override
	public View initViews() {
		View view = View.inflate(mActivity, R.layout.fragment_content, null);
		ViewUtils.inject(this, view);
		return view;
	}

	// 初始化数据, 可以不实现
	public void initData() {
		rgGroup.check(R.id.rb_home);

		// 初始化5个页面的入口--集合
		mPagerList = new ArrayList<BasePager>();

		// 添加界面
		mPagerList.add(new HomePager(mActivity));
		mPagerList.add(new NewsCenterPager(mActivity));
		mPagerList.add(new SmartServicePager(mActivity));
		mPagerList.add(new LogisticsManagerPager(mActivity));
		mPagerList.add(new SettingPager(mActivity));
		
		// 加载页面 new ContentAdapter（）
		mViewPager.setAdapter(new ContentAdapter());
		// 监听RadioGroup的选择事件
		rgGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_home:
					// mViewPager.setCurrentItem(0);// 设置当前页面
					mViewPager.setCurrentItem(0, false);// 去掉切换页面的动画
					break;
				case R.id.rb_news:
					mViewPager.setCurrentItem(1, false);// 设置当前页面
					break;
				case R.id.rb_smart:
					mViewPager.setCurrentItem(2, false);// 设置当前页面
					break;
//				case R.id.rb_gov:
//					mViewPager.setCurrentItem(3, false);// 设置当前页面
//					break;
				case R.id.rb_setting:
					mViewPager.setCurrentItem(4, false);// 设置当前页面
					break;

				default:
					break;
				}
			}
		});
		// 只加载当前的页面
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				mPagerList.get(arg0).initData();// 获取当前被选中的页面, 初始化该页面数据
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
		mPagerList.get(0).initData();// 初始化首页数据

	}

	class ContentAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return mPagerList.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// 从BasePager重新拿到对象
			BasePager pager = mPagerList.get(position);
			container.addView(pager.mRootView);
			// pager.initData();// 初始化数据.... 不要放在此处初始化数据, 否则会预加载下一个页面
			return pager.mRootView;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}
	/**
	 * 获取新闻中心页面
	 * 
	 * @return
	 */
	public NewsCenterPager getNewsCenterPager() {
		return (NewsCenterPager) mPagerList.get(1);
	}

}
