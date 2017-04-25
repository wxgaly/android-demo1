package wxgaly.android.databindingdemo1.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import wxgaly.android.databindingdemo1.R;
import wxgaly.android.databindingdemo1.bean.FormModel;
import wxgaly.android.databindingdemo1.databinding.ActivityBothWayBinding;

/**
 * Created by wxgaly on 2016/12/15.
 */

public class BothWayBindingActivity extends AppCompatActivity {

    ActivityBothWayBinding mBinding;
    FormModel model = new FormModel("wxgaly", "wxgaly199425");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_both_way);
        mBinding.setModel(model);

    }
}
