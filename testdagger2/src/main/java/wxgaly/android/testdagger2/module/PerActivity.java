package wxgaly.android.testdagger2.module;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by wxgaly on 2017/5/14.
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
