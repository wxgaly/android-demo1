package wxgaly.android.databindingdemo1.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import wxgaly.android.databindingdemo1.R;
import wxgaly.android.databindingdemo1.bean.User;
import wxgaly.android.databindingdemo1.databinding.ActivityExpressionBinding;

/**
 * http://b.hiphotos.baidu.com/image/pic/item/d009b3de9c82d15825ffd75c840a19d8bd3e42da.jpg
 * http://a.hiphotos.baidu.com/image/pic/item/f9dcd100baa1cd11daf25f19bc12c8fcc3ce2d46.jpg
 * Created by wxgaly on 2016/12/15.
 */

public class ExpressionActivity extends AppCompatActivity {

    ActivityExpressionBinding mBinding;
    User user = new User("wxgaly", "wxgaly",
            "http://b.hiphotos.baidu.com/image/pic/item/d009b3de9c82d15825ffd75c840a19d8bd3e42da.jpg");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        init();

    }

    private void init() {

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_expression);
        mBinding.setUser(user);
    }
}
