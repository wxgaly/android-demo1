package wxgaly.android.testdagger2.module;

import javax.inject.Inject;

/**
 * Created by wxgaly on 2017/4/21.
 */

public class User {

    private String name;

    @Inject
    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
