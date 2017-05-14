package wxgaly.android.testdagger2.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import wxgaly.android.testdagger2.ScrollingActivity;

/**
 * Created by wxgaly on 2017/5/14.
 */

@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(ScrollingActivity scrollingActivity);

    Context context();
}
