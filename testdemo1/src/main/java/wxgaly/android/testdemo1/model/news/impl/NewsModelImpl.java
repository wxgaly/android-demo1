package wxgaly.android.testdemo1.model.news.impl;


import android.content.Context;

import org.reactivestreams.Publisher;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import wxgaly.android.testdemo1.api.news.NewsService;
import wxgaly.android.testdemo1.callback.IBaseCallback;
import wxgaly.android.testdemo1.constant.Constant;
import wxgaly.android.testdemo1.model.bean.ResultBean;
import wxgaly.android.testdemo1.model.news.INewsModel;
import wxgaly.android.testdemo1.model.news.NewsBean;
import wxgaly.android.testdemo1.util.Logger;
import wxgaly.android.testdemo1.util.RetrofitManager;

/**
 * Created by wxgaly on 2017/1/8.
 */

public class NewsModelImpl implements INewsModel {

    private Retrofit mRetrofit;
    private Context mContext;


    public NewsModelImpl(Context context) {
        init();
        this.mContext = context;
    }

    private void init() {

        mRetrofit = RetrofitManager.getInstance().getRetrofit();

    }

    @Override
    public void getNews(int index, final IBaseCallback<List<NewsBean>, String> callback) {

        NewsService service = mRetrofit.create(NewsService.class);



        service.getNews(Constant.NewsType.newsTypeList[index], Constant.AppKey.NEWS_KEY)
                .subscribeOn(Schedulers.io())
                .map(new Function<ResultBean<List<NewsBean>>, List<NewsBean>>() {
                    @Override
                    public List<NewsBean> apply(ResultBean<List<NewsBean>> listResultBean) throws Exception {
                        return listResultBean.result.data;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<NewsBean>>() {

                    @Override
                    public void accept(List<NewsBean> newsBeen) throws Exception {
                        callback.onSuccess(newsBeen);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.onFailure(throwable.getMessage());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        Logger.d("onCompleted");
                    }
                });



    }

    @Override
    public void onDestory() {
        RetrofitManager.getInstance().close();
    }
}
