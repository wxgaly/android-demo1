package wxgaly.android.testdemo1.presenter.news.impl;


import android.content.Context;

import java.util.List;

import wxgaly.android.testdemo1.callback.IBaseCallback;
import wxgaly.android.testdemo1.constant.Constant;
import wxgaly.android.testdemo1.model.news.NewsBean;
import wxgaly.android.testdemo1.model.news.impl.NewsModelImpl;
import wxgaly.android.testdemo1.presenter.news.INewsPresenter;
import wxgaly.android.testdemo1.view.news.INewsView;

/**
 * Created by wxgaly on 2017/1/8.
 */

public class NewsPImpl implements INewsPresenter {

    private Context mContext;
    private NewsModelImpl mNewsModel;
    private INewsView mINewsView;

    public NewsPImpl(INewsView newsView) {
        mINewsView = newsView;
        mNewsModel = new NewsModelImpl(mINewsView.getContext());
    }

    @Override
    public void getNews(int index) {
        mINewsView.showProgress();
        mNewsModel.getNews(index, mBaseCallback);
    }

    @Override
    public void onDestroy() {
        mNewsModel.onDestory();
    }


    private IBaseCallback mBaseCallback = new IBaseCallback<List<NewsBean>, String>() {

        @Override
        public void onSuccess(List<NewsBean> news) {
            mINewsView.hideProgress();
            mINewsView.getNewsSuccess(news);
        }

        @Override
        public void onFailure(String failMsg) {
            mINewsView.hideProgress();
            mINewsView.getNewsFailure(new Constant.ErrorDetail(Constant.ErrorCode.ERROR, failMsg));
        }
    };

}
