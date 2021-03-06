package com.example.administrator.chabaike.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.chabaike.R;

/**
 * Created by Administrator on 2016/6/22.
 */
public class WelcomeActivity extends Activity{
    private ViewPager viewpager;

    private WelcomeAdapter adapter;

    private LinearLayout ll_container;
    private int[] imagesource = new int[]{R.drawable.slide1,R.drawable.slide2,R.drawable.slide3};

    private int pre_index= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        findViewById(R.id.welcome_vp);
        viewpager= (ViewPager) findViewById(R.id.welcome_vp);
        initView();
        viewpager.setAdapter(adapter= new WelcomeAdapter());
        viewpager.addOnPageChangeListener(adapter);
    }
    private ImageView[] imageViews = new ImageView[imagesource.length];

    private void initView(){
        ll_container = (LinearLayout) findViewById(R.id.welcome_ll);
        View view =null;

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(10, 10);
        ViewGroup.LayoutParams lvp =new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        lp.leftMargin=10;
        ImageView iv =null;
        for (int i =0;i<imagesource.length;i++){

            iv = new ImageView(this);
            iv.setLayoutParams(lvp);
            imageViews[i]=iv;
            imageViews[i].setImageResource(imagesource[i]);

            if (i==imagesource.length-1){
                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(WelcomeActivity.this,HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }


            view = new View(this);

            if (i==0){
                view.setBackgroundResource(R.drawable.page_now);
            }else {
                view.setBackgroundResource(R.drawable.page);
            }

            view.setLayoutParams(lp);

            ll_container.addView(view);



        }



    }

    @Override
    protected void onResume() {
        super.onResume();
        //Pref_Utils.putBoolean(this, ConstantKey.PRE_KEY_FRIST_OPEN, false);
    }

    class WelcomeAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener{

        @Override
        public int getCount() {
            return imagesource.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViews[position]);
            return imageViews[position];
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);

        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            ll_container.getChildAt(position).setBackgroundResource(R.drawable.page_now);
            ll_container.getChildAt(pre_index).setBackgroundResource(R.drawable.page);
            pre_index =position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
