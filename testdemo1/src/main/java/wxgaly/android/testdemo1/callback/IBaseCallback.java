package wxgaly.android.testdemo1.callback;

/**
 * Created by wxgaly on 2016/12/31.
 */

public interface IBaseCallback<S, F> {

    void onSuccess(S successMsg);

    void onFailure(F failMsg);

}
