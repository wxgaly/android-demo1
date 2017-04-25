package wxgaly.android.testdemo1.model.news;

import java.util.List;

import wxgaly.android.testdemo1.callback.IBaseCallback;
import wxgaly.android.testdemo1.model.IBaseModel;

/**
 * Created by wxgaly on 2017/1/8.
 */

public interface INewsModel extends IBaseModel {

    void getNews(int index, IBaseCallback<List<NewsBean>, String> callback);

}
