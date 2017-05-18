package com.mt.main;

import android.content.Context;

import com.mt.base.data.PageRequest;
import com.mt.base.helper.RxTransformHelper;
import com.mt.base.listener.ErrorListener;
import com.mt.data.DataLoader;

import io.reactivex.disposables.Disposable;

/**
 * Created by xianguo on 24/4/17.
 * 代理类实现
 */

public class MainPresent implements MainContract.Present {

    private MainContract.View mView;

    public MainPresent(MainContract.View view) {
        mView = view;
    }

    @Override
    public void loadData(Context context) {
        mView.showProgressView();
        Disposable disposable = DataLoader.getInstance()
                .getPicList(new PageRequest())
                .compose(RxTransformHelper.applySchedulersResult(new ErrorListener() {
                    @Override
                    public void call(String code, String desc) {

                    }

                    @Override
                    public void netError(Throwable throwable) {
                        mView.showNetErrorView();
                    }
                }))
                .filter(tnGouPics -> {
                    if (tnGouPics == null || tnGouPics.size() == 0) {
                        mView.showEmptyView();
                        return false;
                    } else {
                        mView.showContentView();
                        return true;
                    }
                })
                .subscribe(tnGouPics -> {

                });
        mView.addDisposable(disposable);
    }
}
