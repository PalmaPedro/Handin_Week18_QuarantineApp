package com.pedropalma.handin_week18_quarentineapp;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Covid19Api {
    @GET("summary")
    Call<List<Post>> getPosts();
}