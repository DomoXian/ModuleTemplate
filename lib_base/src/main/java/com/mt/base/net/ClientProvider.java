package com.mt.base.net;

import com.mt.base.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;

/**
 * Created by xianguo on 10/4/17.
 * 提供client
 */

public class ClientProvider {

    private static final int TIMEOUT = 20_000;

    private static OkHttpClient SINGLETON;

    private ClientProvider() {
    }

    public static OkHttpClient getClient() {
        if (SINGLETON == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            SINGLETON = new OkHttpClient
                    .Builder()
                    //日志打印拦截工具
                    .addInterceptor(httpLoggingInterceptor)
                    //超时设置
                    .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                    .readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                    .writeTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                    .build();
            SINGLETON.dispatcher().setMaxRequestsPerHost(20);
        }
        return SINGLETON;
    }

    /**
     * 提供证书教养
     */
    @SuppressWarnings("unused")
    public static CertificatePinner getCertificate() {
        // 证书绑定
        CertificatePinner certificatePinner;
        if (BuildConfig.DEBUG) {
            certificatePinner = CertificatePinner.DEFAULT;
        } else {
            certificatePinner = new CertificatePinner.Builder()
                    .build();
        }
        return certificatePinner;
    }
}
