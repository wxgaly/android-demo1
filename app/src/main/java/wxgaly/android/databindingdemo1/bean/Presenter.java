package wxgaly.android.databindingdemo1.bean;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by wxgaly on 2016/12/11.
 */

public class Presenter {

    public User mUser;
    private Context mContext;

    public Presenter(User mUser) {
        this.mUser = mUser;
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (mUser != null) {
            mUser.username.set(s.toString());
            mUser.password.set(s.toString());
            mUser.isStudent.set(!mUser.isStudent.get());
        }
    }

    public void onCustomTextChanged(User user) {
        Toast.makeText(mContext, user.toString(), Toast.LENGTH_SHORT).show();
    }


}
