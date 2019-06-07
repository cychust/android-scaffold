package net.bingyan.common.act;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Author   dashmrl
 * Date     27/01/2018
 * Time     09:35
 * Email    xinliugm@gmail.com
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initTheme(savedInstanceState);
        initialWork(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initModel(savedInstanceState);
        initViews(savedInstanceState);
        addLifecycleObservers(savedInstanceState);
        loadData(savedInstanceState);
    }

    protected void initTheme(Bundle savedInstanceState){}

    protected void initialWork(Bundle savedInstanceState) {}

    protected abstract int getLayoutId();

    protected void initModel(Bundle savedInstanceStace){}

    protected void initViews(Bundle savedInstanceState){}

    protected void addLifecycleObservers(Bundle savedInstanceState){}

    protected void loadData(Bundle savedInstanceState){}


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
