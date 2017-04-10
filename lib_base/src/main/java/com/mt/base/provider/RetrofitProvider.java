package com.mt.base.provider;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xianguo on 10/4/17.
 * retrofit 提供者
 */
@SuppressWarnings("unused")
public class RetrofitProvider {

    private static Retrofit mRetrofit;

    /**
     * 获取默认的retrofit
     *
     * @return retrofit
     */
    public static Retrofit DefaultRetrofit() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl("test.com")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(ClientProvider.getClient())
                    .build();
        }
        return mRetrofit;
    }

    /**
     * 获取指定hostName 和 client的retrofit
     *
     * @param hostName 主机域名
     * @param client   客户端
     * @return retrofit
     */
    public static Retrofit specifyRetrofit(String hostName, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(hostName)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }


}
