package net.bingyan.common.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author   dashmrl
 * Date     29/01/2018
 * Time     08:53
 * Email    xinliugm@gmail.com
 */

public class RetrofitFactory {
    private static Retrofit.Builder builder = null;

    public static Retrofit.Builder create() {
        if (builder == null) {
            builder = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .validateEagerly(false);
        }
        return builder;
    }

    public static <S> S createService(Class<S> service, String baseUrl) {
        return create().baseUrl(baseUrl).build().create(service);
    }
}
