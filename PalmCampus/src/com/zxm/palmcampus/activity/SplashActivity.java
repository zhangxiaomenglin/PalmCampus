package com.zxm.palmcampus.activity;

import com.zxm.palmcampus.R;
import com.zxm.palmcampus.R.layout;
import com.zxm.palmcampus.utils.PrefUtils;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;



public class SplashActivity extends Activity {
	protected static final int CODE_UPDATE_DIALOG = 0;
    protected static final int CODE_URL_ERROR = 1;
    protected static final int CODE_NET_ERROR = 2;
    protected static final int CODE_JSON_ERROR = 3;
    protected static final int CODE_ENTER_HOME = 4;// 进入主页面

    RelativeLayout rlRoot;
    private ImageView img_splash;
    SharedPreferences mPref;// 获得checkbox状态
    
    private Handler mHand = new Handler() {
        public void handleMessage(Message msg) {
            // 判断之前有没有显示过新手引导
            boolean userGuide = PrefUtils.getBoolean(SplashActivity.this,
                    "is_user_guide_showed", false);
            switch (msg.what) {
                case CODE_UPDATE_DIALOG:
     //               showUpdateDailog();
                    break;
                case CODE_URL_ERROR:
                    Toast.makeText(SplashActivity.this, "url错误", Toast.LENGTH_SHORT)
                            .show();
                    enterHome(userGuide);
                    break;
                case CODE_NET_ERROR:
                    Toast.makeText(SplashActivity.this, "网络错误", Toast.LENGTH_SHORT)
                            .show();
                    enterHome(userGuide);
                    break;
                case CODE_JSON_ERROR:
                    Toast.makeText(SplashActivity.this, "数据解析错误",
                            Toast.LENGTH_SHORT).show();
                    enterHome(userGuide);
                    break;
                case CODE_ENTER_HOME:
                    enterHome(userGuide);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        rlRoot = (RelativeLayout) findViewById(R.id.rl_root);
        img_splash = (ImageView) findViewById(R.id.img_splash);

        mPref = getSharedPreferences("config", MODE_PRIVATE);
        // 判断是否需要自动更新
        boolean autoUpdate = mPref.getBoolean("auto_update", true);
        if (autoUpdate) {
            //checkVersion();
        } else {
            // 延时2秒钟后发送的消息
            mHand.sendEmptyMessageDelayed(CODE_ENTER_HOME, 2000);
        }

        startAnim();
        // LibUtils.doSomething();
        // rlRoot.setBackgroundResource(R.drawable.newscenter_press);
    }

    
    /**
     * 开启动画
     */
    private void startAnim() {
        // 动画集合
        AnimationSet set = new AnimationSet(false);
        // 旋转动画
        RotateAnimation rotate = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        rotate.setDuration(3000);// 动画时间
        rotate.setFillAfter(true);// 保持动画状态
        // 缩放动画
        ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        scale.setDuration(3000);// 动画时间
        scale.setFillAfter(true);// 保持动画状态
        // 渐变动画
        AlphaAnimation alpha = new AlphaAnimation(0, 1);
        alpha.setDuration(3000);// 动画时间
        alpha.setFillAfter(true);// 保持动画状态
        set.addAnimation(rotate);
        set.addAnimation(scale);
        set.addAnimation(alpha);
        // 设置动画监听
        set.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
            // 动画执行结束
            @Override
            public void onAnimationEnd(Animation animation) {
                jumpNextPage();
            }
        });

        img_splash.startAnimation(set);

    }
    /**
     * 跳转下一个页面
     */
    private void jumpNextPage() {
        // 判断之前有没有显示过新手引导
        boolean userGuide = PrefUtils.getBoolean(this, "is_user_guide_showed",
                false);
        enterHome(userGuide);
    }
    /**
     * 跳到主界面
     *
     * @param userGuide
     */
    private void enterHome(boolean userGuide) {
        if (!userGuide) {
            // 跳转到新手引导页
            startActivity(new Intent(SplashActivity.this, GuideActivity.class));
        } else {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        }

        finish();
    };

}
