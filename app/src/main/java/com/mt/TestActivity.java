package com.mt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.mt.base.view.BaseAsyncActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xianguo on 6/4/17.
 */

public class TestActivity extends BaseAsyncActivity {

    private Button mBtn;
    private Button error;
    private Button empty;
    private Button loadingDialog;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_test;
    }

    @Override
    protected void afterCreate(@Nullable Bundle savedInstanceState) {
        super.afterCreate(savedInstanceState);
        mBtn = $(R.id.btn);
        error = $(R.id.error);
        empty = $(R.id.empty);
        loadingDialog = $(R.id.loading);
        mBtn.setOnClickListener(v -> loadData());
        error.setOnClickListener(v -> error());
        empty.setOnClickListener(v -> empty());
        loadingDialog.setOnClickListener(v -> loading());
        loadData();
    }

    private void loading() {
        showProgressDialog();
        Disposable disposable = Flowable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> hideProgressDialog());
        mDisposables.add(disposable);
    }

    private void empty() {
        showProgressView();
        Disposable disposable = Flowable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> showEmptyView());
        mDisposables.add(disposable);
    }

    private void error() {
        showProgressView();
        Disposable disposable = Flowable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> showNetErrorView());
        mDisposables.add(disposable);
    }


    private void loadData() {
        showProgressView();
        Disposable disposable = Flowable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> showContentView());
        mDisposables.add(disposable);
    }

}
