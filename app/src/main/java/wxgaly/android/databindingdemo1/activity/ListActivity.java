package wxgaly.android.databindingdemo1.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import wxgaly.android.databindingdemo1.R;
import wxgaly.android.databindingdemo1.adapter.ListAdapter;
import wxgaly.android.databindingdemo1.bean.User;
import wxgaly.android.databindingdemo1.databinding.ActivityListDbBinding;

/**
 * Created by wxgaly on 2016/12/13.
 */

public class ListActivity extends AppCompatActivity {

    ActivityListDbBinding activityListDbBinding;
    private ListAdapter adapter;

    public class Presenter {
        public void onClickAddItem(View view) {
            adapter.add(new User("www", "dfgrgvds", false));
        }

        public void onClickRemoveItem(View view) {
            adapter.remove();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        activityListDbBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_db);

        activityListDbBinding.setPresenter(new Presenter());

        activityListDbBinding.listRecyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {

        adapter = new ListAdapter();

        activityListDbBinding.listRecyclerview.setAdapter(adapter);

        adapter.setOnItemClickListener(new ListAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, User user) {
                Toast.makeText(getApplicationContext(), user.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        List<User> users = new ArrayList<>();
        users.add(new User("wxgaly1", "dsdswdsda", false));
        users.add(new User("wxgaly2", "ewqeqwqew", true));
        users.add(new User("wxgaly3", "grtvbjf", true));
        users.add(new User("wxgaly4", "bmvbmnb,c", false));

        adapter.addAll(users);

    }


}
