package net.bingyan.common.mvp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.CallSuper;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Author   dashmrl
 * Date     28/01/2018
 * Time     19:39
 * Email    xinliugm@gmail.com
 */

public abstract class BasePresenter<V extends BaseView> extends ViewModel implements LifecycleObserver {
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private WeakReference<V> view;

    public void takeView(V t) {
        if (view != null) {
            view.clear();
        }
        view = new WeakReference<V>(t);
        if (view instanceof LifecycleOwner) {
            observeLifecycle((LifecycleOwner) view);
        }
    }

    public V retrieveView() {
        if (view == null || view.get() == null) {
            return null;
        }
        return view.get();
    }

    public void dropView() {
        view.clear();
    }

    public void observeLifecycle(LifecycleOwner lifecycleOwner) {
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    protected void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected void onCreate() {

    }

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onStart() {

    }

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected void onResume() {

    }

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected void onPause() {

    }

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void onStop() {

    }

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void onDestroy() {
        dropView();
    }
}
