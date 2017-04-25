package wxgaly.android.testdemo1.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import java.util.ArrayList;
import java.util.List;

import wxgaly.android.testdemo1.R;
import wxgaly.android.testdemo1.adapter.news.NewsAdapter;
import wxgaly.android.testdemo1.constant.Constant;
import wxgaly.android.testdemo1.model.news.NewsBean;
import wxgaly.android.testdemo1.presenter.news.impl.NewsPImpl;
import wxgaly.android.testdemo1.util.ToastUtils;
import wxgaly.android.testdemo1.view.activity.WebActivity;
import wxgaly.android.testdemo1.view.news.INewsView;

/**
 * Created by wxgaly on 2017/1/10.
 */

public class NewsFragment extends Fragment implements INewsView {

    private View mView;
    private RecyclerView mRecyclerView;
    private NewsAdapter mAdapter;
    private NewsPImpl mNewsPreImpl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_news, container, false);
        initView();
        initData();

        return mView;
    }


    private void initView() {
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.news_recyclerview);
        mAdapter = new NewsAdapter(R.layout.news_item_three_pic, new ArrayList<NewsBean>());

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());

        mAdapter.setOnItemClickListener(mOnItemClickListener);

    }

    private void initData() {
        mNewsPreImpl = new NewsPImpl(NewsFragment.this);
    }

    public void getNews(int index){
        if(mNewsPreImpl == null){
            initData();
        }
        mNewsPreImpl.getNews(index);
    }

    private NewsAdapter.OnItemClickListener mOnItemClickListener = new NewsAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, NewsBean data) {
            Intent intent = new Intent(getActivity(), WebActivity.class);
            intent.putExtra(Constant.IntentKey.URL, data.url);
            startActivity(intent);
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mNewsPreImpl != null){
            mNewsPreImpl = null;
        }

    }

    @Override
    public void getNewsSuccess(List<NewsBean> news) {
        mAdapter.setNewData(news);
    }

    @Override
    public void getNewsFailure(Constant.ErrorDetail errorDetail) {
        ToastUtils.showShort(getActivity(), errorDetail.errorDetail);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public Context getContext() {
        return getActivity();
    }
}
