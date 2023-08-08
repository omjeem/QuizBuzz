package com.example.quizbuzz.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class QuizApiResponse implements Serializable {
    @SerializedName("response_code")
    int response_code ;
    @SerializedName("results")
    List<Quiz> results;

    public QuizApiResponse(int response_code, List<Quiz> quizzes) {
        this.response_code = response_code;
        this.results = quizzes;
    }

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public List<Quiz> getResults() {
        return results;
    }

    public void setResults(List<Quiz> results) {
        this.results = results;
    }
}
