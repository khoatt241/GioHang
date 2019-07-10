package khoatt.ttk.tonthatkhoa.appgiohang;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    ImageSwitcher imageSwitcher;
    Integer[] mangbanner = {R.drawable.banner1, R.drawable.banner2, R.drawable.banner3};
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
        initbanner();

    }

    private void initview() {
        imageSwitcher = findViewById(R.id.imageswitcher);
    }

    private void initbanner() {
        Animation out= AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        Animation in= AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);


        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageSwitcher.LayoutParams params= new ImageSwitcher.LayoutParams(
                        ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
                myView.setLayoutParams(params);
                return myView;
            }
        });

//        final Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (i >= mangbanner.length){
//                    i = 0;
//                }
//                imageSwitcher.setImageResource(mangbanner[i]);
//                i++;
//                handler.postDelayed(this,1000);
//            }
//        },1000);

        CountDownTimer countDownTimer = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (i >= mangbanner.length) {
                    i = 0;
                }
                imageSwitcher.setImageResource(mangbanner[i]);
                i++;
            }

            @Override
            public void onFinish() {
                this.start();
            }
        };
        countDownTimer.start();
    }
}
