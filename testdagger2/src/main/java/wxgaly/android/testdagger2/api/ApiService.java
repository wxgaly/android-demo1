package wxgaly.android.testdagger2.api;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by wxgaly on 2017/4/27.
 */

public interface ApiService {

    interface GetResponse {

        @GET
        Flowable<ResponseBody> getHttpResponse(@Url String url);
    }

}
