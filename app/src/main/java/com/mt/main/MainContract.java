package com.mt.main;

import android.content.Context;

import com.mt.base.listener.AsyncLoadListener;

import io.reactivex.disposables.Disposable;

/**
 * Created by xianguo on 24/4/17.
 * 页面
 */

public interface MainContract {
    interface View extends AsyncLoadListener{
        Context getContext();

        void  addDisposable(Disposable disposable);
    }

    interface Present {
        void loadData(Context context);
    }
}
