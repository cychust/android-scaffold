package net.bingyan.common.act;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Author   dashmrl
 * Date     27/01/2018
 * Time     09:49
 * Email    xinliugm@gmail.com
 */

public abstract class DaggerBaseActivity extends BaseActivity implements HasSupportFragmentInjector {
    @Inject
    protected DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void initialWork(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
