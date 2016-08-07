package com.zxm.palmcampus.base.menudetail;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.zxm.palmcampus.base.BaseMenuDetailPager;

public class PhotoMenuDetailPager extends BaseMenuDetailPager {

	private ImageButton btnPhoto;
	public PhotoMenuDetailPager(Activity activity, ImageButton btnPhoto2) {
		super(activity);
		
		this.btnPhoto = btnPhoto2;
		btnPhoto.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
///				changeDisplay();
			}
		});
		
	}

	@Override
	public View initViews() {
		return null;
	}

}
