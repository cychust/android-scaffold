package net.bingyan.common.frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Author   dashmrl
 * Date     28/01/2018
 * Time     20:09
 * Email    xinliugm@gmail.com
 */

public abstract class BaseLazyFragment extends BaseFragment {
    private boolean isVisible = false;
    private boolean isViewInit = false;
    private boolean isDataLoad = false;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initModels(savedInstanceState);
        initViews(savedInstanceState);
        isViewInit = true;
        addLifecycleObservers(savedInstanceState);
        loadData(savedInstanceState);
        isDataLoad = true;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && !isDataLoad) {
            isVisible = true;
            lazyLoad();
        } else {
            isVisible = false;
        }
    }

    private void lazyLoad() {
        if (!isVisible || !isViewInit || isDataLoad) {
            return;
        }
        loadData(null);
        isDataLoad = true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isViewInit = false;
        isDataLoad = false;
    }
}
