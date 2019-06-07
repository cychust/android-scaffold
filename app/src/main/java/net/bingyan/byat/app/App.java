package net.bingyan.byat.app;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Author   dashmrl
 * Date     28/01/2018
 * Time     23:57
 * Email    xinliugm@gmail.com
 */

public class App extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().bind(this).create(this);
    }
}
