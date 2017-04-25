package wxgaly.android.testdemo1.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wxgaly on 2016/12/28.
 */

public class ResultBean<T> {

    public String reason;

    public Result<T> result;

    @SerializedName("error_code")
    public int errorCode;

}
