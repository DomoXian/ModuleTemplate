package com.mt.base.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import com.mt.base.R;
import com.mt.base.listener.AsyncLoadListener;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by xianguo on 6/4/17.
 * 异步调用的activity 基类
 */
@SuppressWarnings("unused")
public abstract class BaseAsyncActivity extends BaseActivity implements AsyncLoadListener {

    protected CompositeDisposable mDisposables = new CompositeDisposable();

    protected ViewGroup mParentView;
    protected ViewStub mEmptyViewContainer;
    protected ViewStub mErrorViewContainer;
    protected ViewStub mLoadingViewContainer;

    protected View mEmptyView;
    protected View mErrorView;
    protected View mLoadingView;
    protected View mContentView;
    protected Dialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity_async);
        bindViews();
        afterCreate(savedInstanceState);
    }

    protected void afterCreate(@Nullable Bundle savedInstanceState) {

    }

    private void bindViews() {
        mParentView = $(R.id.view_container);
        mEmptyViewContainer = $(R.id.view_empty);
        mErrorViewContainer = $(R.id.view_error);
        mLoadingViewContainer = $(R.id.view_loading);
        mContentView = $$(getContentViewId());
        mParentView.addView(mContentView);

    }

    protected void setEmptyViewContainer(@LayoutRes int id) {
        mEmptyViewContainer.setLayoutResource(id);
    }

    protected void setErrorViewContainer(@LayoutRes int id) {
        mErrorViewContainer.setLayoutResource(id);
    }

    protected void setLoadingViewContainer(@LayoutRes int id) {
        mLoadingViewContainer.setLayoutResource(id);
    }

    @Override
    public void showProgressView() {

        hideAllViews();
        if (mLoadingView == null) {
            mLoadingView = mLoadingViewContainer.inflate();
        }
        mLoadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showContentView() {
        hideAllViews();
        mContentView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showEmptyView() {
        hideAllViews();
        if (mEmptyView == null) {
            mEmptyView = mEmptyViewContainer.inflate();
        }
        mEmptyView.setVisibility(View.VISIBLE);

    }

    @Override
    public void showNetErrorView() {
        hideAllViews();
        if (mErrorView == null) {
            mErrorView = mErrorViewContainer.inflate();
        }
        mErrorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgressDialog() {
        mDialog = new LoadingDialog(this);
        mDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

    protected abstract int getContentViewId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDisposables != null) {
            mDisposables.clear();
        }
    }

    /**
     * 隐藏所有的页面
     */
    protected void hideAllViews() {
        if (mErrorView != null) {
            mErrorView.setVisibility(View.GONE);
        }
        if (mEmptyView != null) {
            mEmptyView.setVisibility(View.GONE);
        }
        if (mContentView != null) {
            mContentView.setVisibility(View.GONE);
        }
        if (mLoadingView != null) {
            mLoadingView.setVisibility(View.GONE);
        }
    }


}
