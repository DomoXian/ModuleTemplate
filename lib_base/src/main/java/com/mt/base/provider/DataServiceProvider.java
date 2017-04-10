package com.mt.base.provider;


import java.util.HashMap;

/**
 * Created by xianguo on 10/4/17.
 * 提供数据服务
 */
@SuppressWarnings("unused")
public class DataServiceProvider {

    private static DataServiceProvider sDataServiceProvider;

    private HashMap<String, Object> mMap = new HashMap<>();

    private DataServiceProvider() {
    }

    public static DataServiceProvider getInstance() {
        if (sDataServiceProvider == null) {
            synchronized (DataServiceProvider.class) {
                if (sDataServiceProvider == null) {
                    sDataServiceProvider = new DataServiceProvider();
                }
            }
        }
        return sDataServiceProvider;
    }

    @SuppressWarnings("unchecked")
    public <T> T provider(Class<T> tClass) {
        if (mMap.containsKey(tClass.getName())) {
            return (T) mMap.get(tClass.getName());
        } else {
            T t = RetrofitProvider.DefaultRetrofit().create(tClass);
            mMap.put(tClass.getName(), t);
            return t;
        }
    }

}
