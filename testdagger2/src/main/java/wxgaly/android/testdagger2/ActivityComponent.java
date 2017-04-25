package wxgaly.android.testdagger2;

import dagger.Component;

/**
 * Created by wxgaly on 2017/4/26.
 */

@Component
public interface ActivityComponent {

    void inject(ScrollingActivity activity);

}
