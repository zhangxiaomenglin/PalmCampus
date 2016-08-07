package com.zxm.palmcampus.base.impl.setting;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.zxm.palmcampus.R;

public class SettingVersionActivity extends Activity {
	// 服务器返回信息
		private String mVersionName;// 版本名
		private int mVersionCode;// 版本号
		private String mDesc;// 版本描述
		private String mDownloadUrl;// 连接地址
		private TextView tvProgress;// 下载进度展示

		private TextView tvVersionCode;// 版本号
		private Button btnDownLoad;
		private TextView showMsg;// 提示是否有更新
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_version);

		tvVersionCode = (TextView) findViewById(R.id.tv_versioncode);
		btnDownLoad = (Button) findViewById(R.id.btn_download);
		tvProgress = (TextView) findViewById(R.id.tv_progress);
		showMsg = (TextView) findViewById(R.id.tv_de_up);

//		tvVersionCode.setText("" + getVersionCode());

//		checkVersion();
	}
}
