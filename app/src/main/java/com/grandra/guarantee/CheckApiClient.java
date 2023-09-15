package com.grandra.guarantee;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CheckApiClient {
    private static final String BASE_URL = "http://apis.data.go.kr/";

    public static CheckApiService getApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(CheckApiService.class);
    }
}
