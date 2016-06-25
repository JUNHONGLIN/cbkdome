package com.example.administrator.chabaike.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.administrator.chabaike.R;

/**
 * Created by Administrator on 2016/6/22.
 */
public class HomeActivity extends FragmentActivity {

    private TabLayout mTabs;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void initView(){
        mTabs= (TabLayout) findViewById(R.id.home_class);
        viewPager= (ViewPager) findViewById(R.id.home_vp);

        viewPager.setAdapter(new ConrentAdapter(getSupportFragmentManager()));
        mTabs.setupWithViewPager(viewPager);
    }

    public class ConrentAdapter extends FragmentPagerAdapter{

        public ConrentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 0;
        }
    }
}
