package wxgaly.android.testdagger2.module;

import javax.inject.Singleton;

import dagger.Component;
import wxgaly.android.testdagger2.ScrollingActivity;
import wxgaly.android.testdagger2.module.ActivityMoudle;

/**
 * Created by wxgaly on 2017/4/26.
 */

@Singleton
@Component(modules = ActivityMoudle.class)
public interface ActivityComponent {

    void inject(ScrollingActivity activity);

}
