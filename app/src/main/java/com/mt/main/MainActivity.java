package com.mt.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mt.R;
import com.mt.base.ui.BaseAsyncActivity;



import io.reactivex.disposables.Disposable;

/**
 * Created by xianguo on 24/4/17.
 * 主页
 */

public class MainActivity extends BaseAsyncActivity implements MainContract.View {

    private MainPresent mPresent;

    @Override
    protected void afterCreate(@Nullable Bundle savedInstanceState) {
        super.afterCreate(savedInstanceState);
        mPresent = new MainPresent(this);
        reloadData();
    }

    public void reloadData() {
        mPresent.loadData(this);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void addDisposable(Disposable disposable) {
        mDisposables.add(disposable);
    }



}
