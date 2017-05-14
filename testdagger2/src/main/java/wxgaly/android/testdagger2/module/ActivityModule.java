package wxgaly.android.testdagger2.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wxgaly on 2017/4/26.
 */

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }

}
