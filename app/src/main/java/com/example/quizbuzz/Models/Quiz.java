package com.example.quizbuzz.Models;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;

import androidx.core.text.HtmlCompat;

import java.io.Serializable;
import java.util.List;

public class Quiz implements Serializable {
    String category = "";
    String type ="";
    String difficulty="";
    String question="";
    String correct_answer="";
    List<String> incorrect_answers;

    public Quiz(String category, String type, String difficulty, String question, String correct_answer, List<String> incorrect_answers) {
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correct_answer = correct_answer;
        this.incorrect_answers = incorrect_answers;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        Spanned decodedQuestion;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            decodedQuestion = Html.fromHtml(question, HtmlCompat.FROM_HTML_MODE_LEGACY);
        else
            decodedQuestion = HtmlCompat.fromHtml(question,HtmlCompat.FROM_HTML_MODE_LEGACY);

        return decodedQuestion.toString();
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public List<String> getIncorrect_answers() {
        return incorrect_answers;
    }

    public void setIncorrect_answers(List<String> incorrect_answers) {
        this.incorrect_answers = incorrect_answers;
    }
}
