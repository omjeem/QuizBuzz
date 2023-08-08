package com.example.quizbuzz;

import com.example.quizbuzz.Models.QuizApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterFace {
    @GET("api.php")
     Call<QuizApiResponse> getQuizApiResponse(
            @Query("amount") int amount,
            @Query("category") int category,
            @Query("difficulty") String difficulty,
            @Query("type") String type
    );
}


