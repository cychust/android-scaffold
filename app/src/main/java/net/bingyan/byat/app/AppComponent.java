package net.bingyan.byat.app;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Author   dashmrl
 * Date     29/01/2018
 * Time     09:11
 * Email    xinliugm@gmail.com
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBindingsModule.class,
        AppModule.class})
public interface AppComponent extends AndroidInjector<App>{
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App>{
        @BindsInstance
       abstract AppComponent.Builder bind(App app);
    }
}
