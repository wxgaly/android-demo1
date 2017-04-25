package wxgaly.android.testdemo1.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import wxgaly.android.testdemo1.R;
import wxgaly.android.testdemo1.constant.Constant;
import wxgaly.android.testdemo1.view.fragment.NewsFragment;

/**
 * Created by wxgaly on 2016/12/28.
 */

public class NewsActivity extends AppCompatActivity {


    private static final int MAX = 4;
    private MaterialViewPager mViewPager;
    //    private ViewPager mViewPager;
    private NewsFragment[] newsFragments = new NewsFragment[Constant.NewsType.newsTypeList.length];
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_news);
        initView();
        initData();
    }

    private void initView() {
        setTitle("");
        mViewPager = (MaterialViewPager) findViewById(R.id.news_viewPager);
    }

    private void initData() {

        toolbar = mViewPager.getToolbar();

        if (toolbar != null) {
            ActionBar supportActionBar = getSupportActionBar();
            setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(navigationClickListener);
        }

        for (int i = 0; i < newsFragments.length; i++) {
            newsFragments[i] = new NewsFragment();
        }

        newsFragments[0].getNews(0);

        ViewPager viewPager = mViewPager.getViewPager();

        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return newsFragments[position];
            }

            @Override
            public int getCount() {
                return newsFragments.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return Constant.NewsType.newsNameList[position];
            }
        });

        viewPager.setOffscreenPageLimit(MAX);
        viewPager.addOnPageChangeListener(onPageChangeListener);

        viewPager.setCurrentItem(0, true);
//
//        //After set an adapter to the mViewPager
        mViewPager.getPagerTitleStrip().setViewPager(viewPager);

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                return HeaderDesign.fromColorAndDrawable(Color.parseColor("#00BCD4"),
                        getResources().getDrawable(R.mipmap.default_avatar));
            }
        });

    }

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            newsFragments[position].getNews(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private View.OnClickListener navigationClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

}
