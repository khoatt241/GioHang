package khoatt.ttk.tonthatkhoa.appgiohang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;

public class MainActivity extends AppCompatActivity {

    ImageSwitcher imageSwitcher;
    Integer[] mangbanner = {R.drawable.banner1, R.drawable.banner2, R.drawable.banner3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSwitcher = findViewById(R.id.imageswitcher);
        Animation out= AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        Animation in= AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);
    }
}
