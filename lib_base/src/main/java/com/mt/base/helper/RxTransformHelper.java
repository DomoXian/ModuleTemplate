package com.mt.base.helper;


import android.content.Context;

import com.mt.base.data.BaseResponse;
import com.mt.base.listener.ErrorListener;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xianguo on 6/4/17.
 * rx转化帮助类
 */

@SuppressWarnings("unused")
public class RxTransformHelper {


    /**
     * 通用的线程调度
     */
    public static <T> ObservableTransformer<T, T> applySchedulers() {
        return observable -> observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 获取返回的结果
     *
     * @param listener 异常监听
     */
    public static ObservableTransformer<BaseResponse, BaseResponse> applySchedulersResponse(ErrorListener listener) {
        return upstream -> upstream.compose(applySchedulers())
                .onErrorReturn(errorFunction(listener))
                .filter(filterEmpty())
                .filter(filterFailureResponse(listener));

    }

    /**
     * 获取返回结果 转化了 response.result
     * @param listener 异常监听
     */
    public static <T> ObservableTransformer<BaseResponse<T>, T> applySchedulersResult(ErrorListener listener) {
        return upstream -> upstream.compose(applySchedulers())
                .onErrorReturn(errorFunction(listener))
                .filter(filterEmpty())
                .filter(filterFailureResponse(listener))
                .map(response -> response.result);
    }


    /**
     * rx 抛出异常的统一处理
     *
     * @param listener 异常监听处理
     * @return 返回一个function
     */
    public static <T> Function<Throwable, T> errorFunction(ErrorListener listener) {
        return throwable -> {
            throwable.printStackTrace();
            if (listener != null) {
                listener.netError(throwable);
            }
            return null;
        };
    }

    /**
     * 过滤请求结果为空的
     */
    public static Predicate<BaseResponse> filterEmpty() {
        return baseResponse -> baseResponse != null;
    }

    /**
     * 过滤请求失败的情况
     *
     * @param listener 异常监听
     */
    public static Predicate<BaseResponse> filterFailureResponse(ErrorListener listener) {
        return baseResponse -> {
            if (!baseResponse.status) {
                listener.call(baseResponse.code, baseResponse.desc);
            }
            return baseResponse.status;
        };
    }


    /**
     * 过滤sessionId 失效
     *
     * @param context 上下文
     */
    public static Predicate<BaseResponse> filterSessionId(Context context) {
        return baseResponse -> true;
    }

}
