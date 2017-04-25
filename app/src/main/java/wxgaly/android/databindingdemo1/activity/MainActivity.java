package wxgaly.android.databindingdemo1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import wxgaly.android.databindingdemo1.R;
import wxgaly.android.databindingdemo1.adapter.BaseQuickAdapter;
import wxgaly.android.databindingdemo1.adapter.MainAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private MainAdapter mAdapter;
    private List<String> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mDatas.add("Simple Demo");
        mDatas.add("List Demo");
        mDatas.add("Expression Demo");
        mDatas.add("BothWayBinding Demo");

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new MainAdapter(R.layout.main_recycler_item, mDatas);

        mAdapter.setOnItemClickListener(onItemClickListener);

        mRecyclerView.setAdapter(mAdapter);
    }

    private BaseQuickAdapter.OnItemClickListener onItemClickListener = new BaseQuickAdapter.OnItemClickListener() {
        @Override
        public void OnItemClick(View view, int position) {
            switch (position) {
                case 0:
                    Intent intent = new Intent(MainActivity.this, SimpleActivity.class);
                    startActivity(intent);
                    break;

                case 1:
                    Intent intent2 = new Intent(MainActivity.this, ListActivity.class);
                    startActivity(intent2);
                    break;

                case 2:
                    Intent intent3 = new Intent(MainActivity.this, ExpressionActivity.class);
                    startActivity(intent3);

                case 3:
                    Intent intent4 = new Intent(MainActivity.this, BothWayBindingActivity.class);
                    startActivity(intent4);
                    break;
                default:

                    break;
            }
        }
    };

}
