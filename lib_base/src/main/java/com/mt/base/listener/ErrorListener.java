package com.mt.base.listener;

/**
 * Created by xianguo on 27/4/17.
 * 业务异常
 */

public interface ErrorListener {

    // 业务异常
    void call(String code, String desc);

    // 网络异常
    void netError(Throwable throwable);

}
