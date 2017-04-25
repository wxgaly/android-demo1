package wxgaly.android.testdemo1.api.news;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import wxgaly.android.testdemo1.model.news.NewsBean;
import wxgaly.android.testdemo1.model.bean.ResultBean;
import wxgaly.android.testdemo1.constant.Constant;

/**
 * Created by wxgaly on 2016/12/31.
 */

public interface NewsService {

    @GET(Constant.RequestURL.NEWS_BASE_URL + Constant.RequestURL.NEWS_SUFFIX_URL)
    Flowable<ResultBean<List<NewsBean>>> getNews(@Query(Constant.RequestQueryKey.NEWS_TYPE_STR) String type,
                                                 @Query(Constant.RequestQueryKey.KEY_STR) String key);

}
