package com.zxm.palmcampus.base.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.zxm.palmcampus.R;
import com.zxm.palmcampus.base.BasePager;
import com.zxm.palmcampus.base.home.syllabus.Syllabus;

/**
 * 首页的实现
 * 
 * @author xiaomeng
 *
 */
public class HomePager extends BasePager {
	GridView gridview;
	Intent intent = new Intent();
	private View view;
	private View home_view;
	private ViewGroup group;
	private ViewPager home_ViewPager;
	private ImageView[] imageViews = null;
	private ImageView imageView = null;
	// 小圆点
	private boolean isContinue = true;
	private AtomicInteger what = new AtomicInteger(0);

	public HomePager(Activity activity) {
		super(activity);
	}

	@Override
	public void initData() {
		System.out.println("初始化首页数据....");

		tvTitle.setText("蚌埠学院");// 修改标题
		// tvTitle.setBackgroundResource(R.drawable.ic_biaoti);
		btnMenu.setVisibility(View.GONE);// 隐藏菜单按钮
		setSlidingMenuEnable(false);// 关闭侧边栏
		relativity.setBackgroundResource(R.drawable.ic_biaoti);

		// 初始化界面
		view = initView();
		// 初始化viewpager
		initViewPager();
		// 初始化GridView控件
		initGridView();
		// 向FrameLayout中动态添加布局
		flContent.addView(view);

	}

	private View initView() {
		home_view = View.inflate(mActivity, R.layout.home_main, null);
		home_ViewPager = (ViewPager) home_view.findViewById(R.id.adv_pager);
		group = (ViewGroup) home_view.findViewById(R.id.viewGroup);
		gridview = (GridView) home_view.findViewById(R.id.gridview);
		return home_view;
	}

	private void initViewPager() {
		List<View> advPics = new ArrayList<View>();

		ImageView img1 = new ImageView(mActivity);
		img1.setBackgroundResource(R.drawable.ic_doors);
		advPics.add(img1);

		ImageView img2 = new ImageView(mActivity);
		img2.setBackgroundResource(R.drawable.ic_building);
		advPics.add(img2);

		ImageView img3 = new ImageView(mActivity);
		img3.setBackgroundResource(R.drawable.ic_library);
		advPics.add(img3);

		ImageView img4 = new ImageView(mActivity);
		img4.setBackgroundResource(R.drawable.ic_lake);
		advPics.add(img4);

		imageViews = new ImageView[advPics.size()];

		for (int i = 0; i < advPics.size(); i++) {
			imageView = new ImageView(mActivity);
			imageView.setLayoutParams(new LayoutParams(20, 20));
			imageView.setPadding(5, 5, 5, 5);
			imageViews[i] = imageView;
			if (i == 0) {
				imageViews[i]
						.setBackgroundResource(R.drawable.banner_dian_focus);
			} else {
				imageViews[i]
						.setBackgroundResource(R.drawable.banner_dian_blur);
			}
			group.addView(imageViews[i]);
		}
		// 为viewPager设置Adapter
		home_ViewPager.setAdapter(new HomeAdapter(advPics));
		// 设置viewpager的监听事件
		home_ViewPager.setOnPageChangeListener(new GuidePageChangeListener());
		// 设置触摸事件 当触摸是停止滑动
		home_ViewPager.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
				case MotionEvent.ACTION_MOVE:
					isContinue = false;
					break;
				case MotionEvent.ACTION_UP:
					isContinue = true;
					break;
				default:
					isContinue = true;
					break;
				}
				return false;
			}
		});
		// 定义线程 viewpager自动滑动
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					if (isContinue) {
						viewHandler.sendEmptyMessage(what.get());
						whatOption();
					}
				}
			}
		}).start();

	}

	/**
	 * 睡眠2分钟 模拟线程阻塞
	 */
	private void whatOption() {
		what.incrementAndGet();
		if (what.get() > imageViews.length - 1) {
			what.getAndAdd(-4);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * viewpager的Handler 发送消息自动滑动
	 */
	private final Handler viewHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			home_ViewPager.setCurrentItem(msg.what);
			super.handleMessage(msg);
		};
	};

	/**
	 * ViewPager的Adapter
	 */
	private final class HomeAdapter extends PagerAdapter {
		private List<View> views = null;

		public HomeAdapter(List<View> views) {
			this.views = views;
		}

		@Override
		public int getCount() {
			return views.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(View container, int position) {
			((ViewGroup) container).addView(views.get(position), 0);
			return views.get(position);
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager) container).removeView(views.get(position));
		}
	}

	/**
	 * viewpager 小圆点监听事件
	 */
	private final class GuidePageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageSelected(int arg0) {
			what.getAndSet(arg0);
			for (int i = 0; i < imageViews.length; i++) {
				imageViews[arg0]
						.setBackgroundResource(R.drawable.banner_dian_focus);
				if (arg0 != i) {
					imageViews[i]
							.setBackgroundResource(R.drawable.banner_dian_blur);
				}
			}
		}
	}

	/**
	 * 初始化GridView方法
	 * 
	 */
	private void initGridView() {
		// 生成动态数组，并且转入数据
		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
		// --------------------------------------------------------------
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ItemImage", R.drawable.button_1);
		map.put("ItemText", "课表");
		lstImageItem.add(map);

		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("ItemImage", R.drawable.button_2);// 添加图像资源的ID
		map1.put("ItemText", "新闻");// 按序号做ItemText
		lstImageItem.add(map1);

		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("ItemImage", R.drawable.button_3);// 添加图像资源的ID
		map2.put("ItemText", "学校概况");// 按序号做ItemText
		lstImageItem.add(map2);

		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map3.put("ItemImage", R.drawable.button_4);// 添加图像资源的ID
		map3.put("ItemText", "黄页");// 按序号做ItemText
		lstImageItem.add(map3);

		HashMap<String, Object> map4 = new HashMap<String, Object>();
		map4.put("ItemImage", R.drawable.button_5);// 添加图像资源的ID
		map4.put("ItemText", "考生问答");// 按序号做ItemText
		lstImageItem.add(map4);

		HashMap<String, Object> map5 = new HashMap<String, Object>();
		map5.put("ItemImage", R.drawable.button_6);// 添加图像资源的ID
		map5.put("ItemText", "校园风采");// 按序号做ItemText
		lstImageItem.add(map5);

		HashMap<String, Object> map6 = new HashMap<String, Object>();
		map6.put("ItemImage", R.drawable.button_7);// 添加图像资源的ID
		map6.put("ItemText", "招生专栏");// 按序号做ItemText
		lstImageItem.add(map6);

		HashMap<String, Object> map7 = new HashMap<String, Object>();
		map7.put("ItemImage", R.drawable.button_8);// 添加图像资源的ID
		map7.put("ItemText", "班车");// 按序号做ItemText
		lstImageItem.add(map7);

		HashMap<String, Object> map8 = new HashMap<String, Object>();
		map8.put("ItemImage", R.drawable.button_9);// 添加图像资源的ID
		map8.put("ItemText", "校历");// 按序号做ItemText
		lstImageItem.add(map8);

		// -----------------------------------------------------------------------------
		SimpleAdapter saImageItems = new SimpleAdapter(mActivity,// 没什么解释(activity对象)
				lstImageItem, // 数据来源
				R.layout.night_item,// night_item的XML实现
				// 动态数组与ImageItem对应的子项
				new String[] { "ItemImage", "ItemText" },
				// ImageItem的XML文件里面的一个ImageView,两个TextView ID
				new int[] { R.id.ItemImage, R.id.ItemText });
		// 添加并显示
		gridview.setAdapter(saImageItems);
		// 添加消息处理
		gridview.setOnItemClickListener(new ItemClickListener());

	}

	// 当AdapterView被单击（触摸屏或者键盘），则返回的Item单击事件
	class ItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// 在本例中arg2=arg3
			HashMap<String, Object> item = (HashMap<String, Object>) arg0
					.getItemAtPosition(arg2);
			// 显示所选Item的ItemText
			// setTitle((String) item.get("ItemText"));
			// Toast.makeText(Main.this, "第" + (arg2+1) + "项被点击",
			// Toast.LENGTH_SHORT).show();

			switch (arg2) {
			case 0:
				intent.setClass(mActivity, Syllabus.class);
				mActivity.startActivity(intent);
				break;// 课表

			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:
				Toast.makeText(mActivity, "等待开发中...", Toast.LENGTH_SHORT)
						.show();
				break;// 招生专栏
			case 7:
				Toast.makeText(mActivity, "等待开发中...", Toast.LENGTH_SHORT)
						.show();
				break;// 班车
			case 8:
				Toast.makeText(mActivity, "等待开发中...", Toast.LENGTH_SHORT)
						.show();
				break;// 校历
			default:
				break;
			}
		}
	}

}
