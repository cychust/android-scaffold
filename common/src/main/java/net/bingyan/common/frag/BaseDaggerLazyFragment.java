package net.bingyan.common.frag;

import android.content.Context;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Author   dashmrl
 * Date     28/01/2018
 * Time     20:22
 * Email    xinliugm@gmail.com
 */

public abstract class BaseDaggerLazyFragment extends BaseLazyFragment implements HasSupportFragmentInjector{
    @Inject
    protected DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void beforeOnAttach(Context context) {
        AndroidSupportInjection.inject(this);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return this.dispatchingAndroidInjector;
    }
}
