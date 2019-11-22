package com.heyflyer.heyflyersdk.rest_api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
  public static final String BASE_URL = "http://ec2-52-58-123-201.eu-central-1.compute.amazonaws.com:6900/";

    private static Retrofit retrofit = null;
    private static ApiInterface apiInterface = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().
                    retryOnConnectionFailure(true).
                    connectTimeout(30L, TimeUnit.SECONDS).
                    readTimeout(30L, TimeUnit.SECONDS).
                    addInterceptor(interceptor).
                    build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static ApiInterface getApiInterface() {
        if (apiInterface == null) {
            apiInterface = getClient().create(ApiInterface.class);
        }
        return apiInterface;
    }

}
