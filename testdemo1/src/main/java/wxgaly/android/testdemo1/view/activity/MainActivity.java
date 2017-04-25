package wxgaly.android.testdemo1.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import wxgaly.android.testdemo1.R;
import wxgaly.android.testdemo1.adapter.BaseQuickAdapter;
import wxgaly.android.testdemo1.adapter.DividerItemDecoration;
import wxgaly.android.testdemo1.adapter.main.MainAdapter;
import wxgaly.android.testdemo1.constant.Constant;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private MainAdapter mAdapter;
    private List<String> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.main_recyclerview);

        mData = Arrays.asList(getResources().getStringArray(R.array.main_item_name));

        mAdapter = new MainAdapter(R.layout.main_recycler_item, mData);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,
                DividerItemDecoration.HORIZONTAL_LIST));

//        mAdapter.setOnItemClickListener(onItemClickListener);

        mAdapter.setOnItemClickListener((view, position) -> {
            Intent intent = new Intent();

            switch(position){
                case Constant.ActivityConstant.ACTIVITY_TYPE_NEWS :

                    intent.setClass(MainActivity.this, NewsActivity.class);

                    break;

                case Constant.ActivityConstant.ACTIVITY_TYPE_WEATHER_FORECAST :

                    break;

                default :

                    break;
            }

            startActivity(intent);
        });

    }

//    private BaseQuickAdapter.OnItemClickListener onItemClickListener = new BaseQuickAdapter.OnItemClickListener() {
//        @Override
//        public void onItemClick(View view, int position) {
//
//
//        }
//    };

}
