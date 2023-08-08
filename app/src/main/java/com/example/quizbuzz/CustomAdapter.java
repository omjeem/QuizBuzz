package com.example.quizbuzz;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizbuzz.Models.Quiz;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Context context;
    private List<Quiz> quizzes;


    public CustomAdapter(Context context, List<Quiz> quizzes) {
        this.context = context;
        this.quizzes = quizzes;

    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_question_desc,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
      holder.idd.setText(String.valueOf(position+1)+".");
      holder.question.setText(quizzes.get(position).getQuestion());
      holder.option1.setText(quizzes.get(position).getIncorrect_answers().get(0));
      holder.option2.setText(quizzes.get(position).getIncorrect_answers().get(1));
      holder.option3.setText(quizzes.get(position).getIncorrect_answers().get(2));
      holder.option4.setText(quizzes.get(position).getIncorrect_answers().get(3));



//
//        String op1 =  holder.option1.getText().toString();
//        if(op1.equals(quizzes.get(position).getCorrect_answer()))
//            holder.option1.setTextColor(Color.parseColor("#90EE90"));
//
//        String op2 =  holder.option2.getText().toString();
//        if(op2.equals(quizzes.get(position).getCorrect_answer()))
//            holder.option2.setTextColor(Color.parseColor("#90EE90"));
//        String op3 =  holder.option3.getText().toString();
//        if(op3.equals(quizzes.get(position).getCorrect_answer()))
//            holder.option3.setTextColor(Color.parseColor("#90EE90"));
//        String op4 =  holder.option4.getText().toString();
//        if(op4.equals(quizzes.get(position).getCorrect_answer()))
//            holder.option4.setTextColor(Color.parseColor("#90EE90"));





    }

    @Override
    public int getItemCount() {
        return quizzes.size();
    }
}
