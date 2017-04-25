package wxgaly.android.testdemo1.view.news;

import java.util.List;

import wxgaly.android.testdemo1.constant.Constant;
import wxgaly.android.testdemo1.model.news.NewsBean;
import wxgaly.android.testdemo1.view.IBaseView;

/**
 * Created by wxgaly on 2017/1/8.
 */

public interface INewsView extends IBaseView {

    void getNewsSuccess(List<NewsBean> news);

    void getNewsFailure(Constant.ErrorDetail errorDetail);
}
