package com.mt.base.listener;

/**
 * Created by xianguo on 6/4/17.
 * 异步加载监听
 */

public interface AsyncLoadListener {
    /**
     * 加载中
     */
    void showProgressView();

    /**
     * 加载成功
     */
    void showContentView();

    /**
     * 空页面
     */
    void showEmptyView();

    /**
     * 网络异常页面
     */
    void showNetErrorView();

    /**
     * 显示加载窗口
     */
    void showProgressDialog();

    /**
     * 隐藏加载窗口
     */
    void hideProgressDialog();

}
