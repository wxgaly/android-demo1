package wxgaly.android.testdagger2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import wxgaly.android.testdagger2.api.ApiService;
import wxgaly.android.testdagger2.module.DaggerActivityComponent;
import wxgaly.android.testdagger2.module.User;

public class ScrollingActivity extends AppCompatActivity {

    private static final String TAG = "wxg";
    private static final String BAIDU_URL = "http://www.baidu.com";

    private TextView textview;

    @Inject
    User user;

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        intiView();
        initData();
    }

    private void initData() {
        DaggerActivityComponent.builder().build().inject(this);
        testUser();
        testRetrofit();
    }

    private void testRetrofit() {
        ApiService.GetResponse response = retrofit.create(ApiService.GetResponse.class);
        Flowable<ResponseBody> flowable = response.getHttpResponse(BAIDU_URL);

        //使用rxjava的方式回调
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((responseBody) -> {
                            String string = responseBody.string();
                            Log.d(TAG, "onResponse() called with: string = [" + string + "]");
                            textview.setText(string);
                        },
                        (throwable) -> {
                            Log.e(TAG, "onFailure: " + throwable.getMessage(), throwable);
                        });

        //通常方式调用retrofit异步回调
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
//                try {
//                    String string = response.body().string();
//                    Log.d(TAG, "onResponse() called with: string = [" + string + "]");
//                    textview.setText(string);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
//                Log.e(TAG, "onFailure: " + throwable.getMessage(), throwable);
//            }
//        });

    }

    private void testUser() {
        user.setName("测试Demo");

        Log.d(TAG, "initData() called--- " + user.toString());
    }

    private void intiView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        textview = (TextView) findViewById(R.id.textview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
