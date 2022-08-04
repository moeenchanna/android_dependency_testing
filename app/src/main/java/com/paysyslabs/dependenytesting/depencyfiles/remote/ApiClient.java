package com.paysyslabs.dependenytesting.depencyfiles.remote;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String UAT_BASE_URL = "https://abltpsp.paysyslabs.com/api/v1/";
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit == null) {

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(40, TimeUnit.SECONDS)
                    .readTimeout(40,TimeUnit.SECONDS).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(UAT_BASE_URL).client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
