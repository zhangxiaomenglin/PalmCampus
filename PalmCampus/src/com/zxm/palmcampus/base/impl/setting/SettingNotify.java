package com.zxm.palmcampus.base.impl.setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.zxm.palmcampus.R;

public class SettingNotify extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.setting_notify);
	}
}
