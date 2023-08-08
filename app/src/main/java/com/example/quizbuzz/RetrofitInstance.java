package com.example.quizbuzz;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static RetrofitInstance instance;
    ApiInterFace apiInterFace;
    RetrofitInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://opentdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterFace=retrofit.create(ApiInterFace.class);
    }
    public ApiInterFace getApiInterFace() {
        return apiInterFace;
    }
    public static RetrofitInstance getInstance(){
        if (instance==null){
            instance = new RetrofitInstance();
        }
        return instance;
    }
}
