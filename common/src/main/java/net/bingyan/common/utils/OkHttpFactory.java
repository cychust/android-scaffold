package net.bingyan.common.utils;

import net.bingyan.common.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Author   dashmrl
 * Date     29/01/2018
 * Time     08:53
 * Email    xinliugm@gmail.com
 */

public class OkHttpFactory {
    private static OkHttpClient.Builder builder = null;

    public static OkHttpClient.Builder create() {
        if (builder == null) {
            builder = new OkHttpClient.Builder();
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(loggingInterceptor);
            }
        }
        return builder;
    }
}
