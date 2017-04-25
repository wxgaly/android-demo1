package wxgaly.android.databindingdemo1.bean;


import android.databinding.ObservableField;

/**
 * Created by wxgaly on 2016/12/15.
 */

public class FormModel {

    public ObservableField<String> mUsername = new ObservableField<>();
    public ObservableField<String> mPassword = new ObservableField<>();

    public FormModel(String username, String password) {
        mUsername.set(username);
        mPassword.set(password);
    }
}
