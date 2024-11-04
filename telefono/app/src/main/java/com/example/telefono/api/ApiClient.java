package com.example.telefono.api;

import android.annotation.SuppressLint;

import java.lang.ref.Cleaner;

import retrofit2.Retrofit;

public class ApiClient {
    private static final String BASE_URL = "https://apicontactos.jmacboy.com/";
    private static Retrofit retrofit;

    @SuppressLint("NewApi")
    public static Retrofit getClient() {
        if (retrofit == null) {
            Cleaner GsonConverterFactory = null;
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofit;
    }
}
