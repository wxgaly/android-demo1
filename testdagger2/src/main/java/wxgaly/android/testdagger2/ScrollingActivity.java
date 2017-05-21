package wxgaly.android.testdagger2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import wxgaly.android.testdagger2.api.ApiService;
import wxgaly.android.testdagger2.module.ApplicationModule;
import wxgaly.android.testdagger2.module.DaggerApplicationComponent;
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
        DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(getApplication()))
                .build()
                .inject(this);
        testUser();
        testRetrofit();
    }

    private void testRetrofit() {
        ApiService.GetResponse response = retrofit.create(ApiService.GetResponse.class);
        Flowable<ResponseBody> flowable = response.getHttpResponse(BAIDU_URL);

        /*
        参数可以是零个或多个
        参数类型可指定，可省略（根据表达式上下文推断）
        参数包含在圆括号中，用逗号分隔
        表达式主体可以是零条或多条语句,包含在花括号中
        表达式主体只有一条语句时,花括号可省略
        表达式主体有一条以上语句时，表达式的返回类型与代码块的返回类型一致
        表达式只有一条语句时，表达式的返回类型与该语句的返回类型一致
         */

        //使用rxjava的方式回调
        flowable.subscribeOn(Schedulers.io())
                .map(responseBody -> {
                    return responseBody.string(); //当只有一个参数时,可省略圆括号；
                })
                .flatMap(string -> Flowable.just(string))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((String string) -> {//需要声明类型时，需要加圆括号指定参数类型；
                            Log.d(TAG, "onResponse() called with: string = [" + string + "]");
                            textview.setText(string);
                        },
                        throwable -> Log.e(TAG, "onFailure: " + throwable.getMessage(), throwable)
                                                //当执行体中只有一句话时可以省略花括号。
                );

        //通常方式调用retrofit异步回调
        //另外lambda表达式只能实现只有一个抽象方法的接口，
        //当有多个接口时就不能使用lambda

        /*
        那究竟什么样的接口是函数式接口呢？
        函数式接口是只有一个抽象方法的接口。用作表示lambda表达式的类型。
         */

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
        fab.setOnClickListener((view) -> {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
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
