package wxgaly.android.testdagger2.module;

import android.app.Activity;

import dagger.Component;

/**
 * Created by wxgaly on 2017/4/26.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity activity();

}
