package wxgaly.android.databindingdemo1.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import wxgaly.android.databindingdemo1.R;
import wxgaly.android.databindingdemo1.bean.Presenter;
import wxgaly.android.databindingdemo1.bean.User;
import wxgaly.android.databindingdemo1.databinding.ActivitySimpleDbBinding;

/**
 * Created by wxgaly on 2016/12/11.
 */

public class SimpleActivity extends AppCompatActivity {
    ActivitySimpleDbBinding activitySimpleDbBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySimpleDbBinding = DataBindingUtil.setContentView(SimpleActivity.this, R.layout.activity_simple_db);
        init();

    }

    private void init() {
        User user = new User("wxgaly", "wxgaly199425");
        user.isStudent.set(true);
        activitySimpleDbBinding.setUser(user);
        Presenter presenter = new Presenter(user);
        presenter.setContext(getApplicationContext());
        activitySimpleDbBinding.setPresenter(presenter);
    }

}
