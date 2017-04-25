package wxgaly.android.testdemo1.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wxgaly on 2016/12/31.
 */

public class RetrofitManager {

    private static final String BASE_URL = "http://www.baidu.com/";
    private static final int TIEM_OUT = 10;

    private Retrofit mRetrofit;
    private OkHttpClient mOkhttpClient;

    private boolean isLog = true;

    private static RetrofitManager mRetrofitManager;

    private RetrofitManager() {

        if (isLog) {
            initLogRetrofit();
        } else {
            initRetrofit();
        }

    }

    public static RetrofitManager getInstance() {

        if (mRetrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (mRetrofitManager == null) {
                    mRetrofitManager = new RetrofitManager();
                }
            }
        }

        return mRetrofitManager;
    }

    private void initRetrofit() {

        mRetrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    private void initLogRetrofit() {

        mOkhttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(TIEM_OUT, TimeUnit.SECONDS)
                .build();

        mRetrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(mOkhttpClient).build();

    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public void close(){

        if(mRetrofit != null){
            mRetrofit = null;
        }

        if(mRetrofitManager != null){
            mRetrofitManager = null;
        }
    }

}
