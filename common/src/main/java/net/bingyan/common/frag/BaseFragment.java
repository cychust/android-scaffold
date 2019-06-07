package net.bingyan.common.frag;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author   dashmrl
 * Date     28/01/2018
 * Time     20:00
 * Email    xinliugm@gmail.com
 */

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(),container,false);
    }

    protected abstract int getLayoutId();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initModels(savedInstanceState);
        initViews(savedInstanceState);
        addLifecycleObservers(savedInstanceState);
        loadData(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        beforeOnAttach(context);

        super.onAttach(context);
    }

    protected void beforeOnAttach(Context context) {

    }

    protected void initModels(@Nullable Bundle savedInstanceState) {

    }

    protected void initViews(@Nullable Bundle savedInstanceState) {

    }

    protected void addLifecycleObservers(@Nullable Bundle savedInstanceState) {

    }

    protected void loadData(@Nullable Bundle savedInstanceState) {

    }
}
