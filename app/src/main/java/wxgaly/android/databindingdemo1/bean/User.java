package wxgaly.android.databindingdemo1.bean;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

/**
 * Created by wxgaly on 2016/12/11.
 */

public class User {

    public ObservableField<String> username = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();
    public ObservableField<String> avatar = new ObservableField<>();
    public ObservableBoolean isStudent = new ObservableBoolean();

    public User(String username, String password) {
        this.username.set(username);
        this.password.set(password);
        this.isStudent.set(false);

    }

    public User(String username, String password, boolean isStudent) {
        this.username.set(username);
        this.password.set(password);
        this.isStudent.set(isStudent);

    }

    public User(String username, String password, String avatar) {
        this.username.set(username);
        this.password.set(password);
        this.isStudent.set(false);
        this.avatar.set(avatar);
    }

    @Override
    public String toString() {
        return "User{" +
                "username=" + username.get() +
                ", password=" + password.get() +
                ", isStudent=" + isStudent.get() +
                '}';
    }
}
