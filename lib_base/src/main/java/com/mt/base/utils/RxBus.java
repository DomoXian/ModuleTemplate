package com.mt.base.utils;

import io.reactivex.Flowable;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by xianguo on 12/5/17.
 * RxBus 事件总线
 */

public class RxBus {

    private final FlowableProcessor<Object> mFlowableBus;

    private final Subject<Object> mSubjectBus;


    private RxBus() {
        mFlowableBus = PublishProcessor.create().toSerialized();
        mSubjectBus = PublishSubject.create().toSerialized();
    }

    public static RxBus getInstance() {
        return Holder.sRxBus;
    }

    public void post(Object o){
        mSubjectBus.onNext(o);
    }

    public void postFlowable(Object o){
        mFlowableBus.onNext(o);
    }

    public <T>Flowable<T> toFlowable(Class<T> tClass){
        return mFlowableBus.ofType(tClass);
    }

    public <T>Flowable<T> toObservable(Class<T> tClass){
        return mFlowableBus.ofType(tClass);
    }

    private static class Holder {
        private static final RxBus sRxBus = new RxBus();
    }
}
