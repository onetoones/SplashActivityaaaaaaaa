package chenshuai.bwie.com.splashactivity.view;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import chenshuai.bwie.com.splashactivity.R;

public class MainActivity extends AppCompatActivity {
    int aa = 0;
    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(mIv, "alpha", 0f, 1f);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mIv, "scaleX", 2f, 1f);
        ObjectAnimator rotationX = ObjectAnimator.ofFloat(mIv, "rotation", 0f, 360f);
        ObjectAnimator translationX = ObjectAnimator.ofFloat(mIv, "translationY", 0f, 240f);
        //动画集
        AnimatorSet animatorSet = new AnimatorSet();
        //设置动画的时间
        animatorSet.setDuration(3000);
        //组合使用
        animatorSet.playTogether(alpha, scaleX, rotationX, translationX);
        //动画开始
        animatorSet.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    aa++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (aa>=2){
                        Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
                        startActivity(intent);
                        break;
                    }
                }
            }
        }).start();
/*        Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
        startActivity(intent);*/
    }


}
