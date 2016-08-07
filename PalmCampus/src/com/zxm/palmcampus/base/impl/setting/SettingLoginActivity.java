package com.zxm.palmcampus.base.impl.setting;

import com.zxm.palmcampus.R;
import com.zxm.palmcampus.activity.GuideActivity;
import com.zxm.palmcampus.activity.SplashActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SettingLoginActivity extends Activity implements OnClickListener{
	
	private Button btn_register;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		btn_register = (Button) findViewById(R.id.btn_register);
		btn_register.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_register:
			// 跳转到新手引导页
            startActivity(new Intent(this, SettingRegisterActivity.class));
			break;

		default:
			break;
		}
	}
	
}
