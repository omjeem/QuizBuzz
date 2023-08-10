package com.example.quizbuzz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.quizbuzz.Models.Quiz;
import com.example.quizbuzz.Models.QuizApiResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    CustomAdapter adapter;
    Button button;
    List<Quiz> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       button = findViewById(R.id.submit);



        ApiInterFace apiInterFace = RetrofitInstance.getInstance().getApiInterFace();
        Call<QuizApiResponse> call = apiInterFace.getQuizApiResponse(3,9,"easy","multiple");
        try{
            call.enqueue(new Callback<QuizApiResponse>() {
                @Override
                public void onResponse(Call<QuizApiResponse> call, Response<QuizApiResponse> response) {
                    QuizApiResponse quizApiResponse = response.body();
                     list = quizApiResponse.getResults();
                    for(int i=0;i<list.size();i++){
                        list.get(i).getIncorrect_answers().add(list.get(i).getCorrect_answer());
                        Collections.shuffle(list.get(i).getIncorrect_answers());
                    }
                    showQuizz(list);
                }
                @Override
                public void onFailure(Call<QuizApiResponse> call, Throwable t) {
                    Log.e("api","onFailure " + t.getLocalizedMessage());
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               List<Integer> list1 = CustomViewHolder.selectedPositions;
               for(int position : list1){
                   Log.w("TAG",list1.toString());
                   CustomViewHolder holder = (CustomViewHolder) recyclerView.findViewHolderForAdapterPosition(position);
                   Log.w("Position", String.valueOf(position));
                   if(holder.option1.getText().toString().equals(list.get(position).getCorrect_answer()))
                       holder.option1.setTextColor(Color.parseColor("#90EE90"));
                   if(holder.option2.getText().toString().equals(list.get(position).getCorrect_answer()))
                       holder.option2.setTextColor(Color.parseColor("#90EE90"));
                   if(holder.option3.getText().toString().equals(list.get(position).getCorrect_answer()))
                       holder.option3.setTextColor(Color.parseColor("#90EE90"));
                   if(holder.option4.getText().toString().equals(list.get(position).getCorrect_answer()))
                       holder.option4.setTextColor(Color.parseColor("#90EE90"));


                  if(holder.option1.isChecked()){
                      if(!holder.option1.getText().toString().equals(list.get(position).getCorrect_answer()))
                          holder.option1.setTextColor(Color.parseColor("#ffcccb"));
                  }
                  else if(holder.option2.isChecked()){
                      if(!holder.option2.getText().toString().equals(list.get(position).getCorrect_answer()))
                          holder.option2.setTextColor(Color.parseColor("#ffcccb"));
                  }
                  else if(holder.option3.isChecked()){
                      if(!holder.option3.getText().toString().equals(list.get(position).getCorrect_answer()))
                          holder.option3.setTextColor(Color.parseColor("#ffcccb"));

                  }
                  else if(holder.option4.isChecked()){
                      if(!holder.option4.getText().toString().equals(list.get(position).getCorrect_answer()))
                          holder.option4.setTextColor(Color.parseColor("#ffcccb"));
                  }
//                   Intent intent = new Intent(MainActivity.this,MainActivity.class);
//
//                  startActivity(intent);
//                  finish();


               }

            }
        });





    }
    private void showQuizz(List<Quiz> list) {
        recyclerView = findViewById(R.id.recyclerView );
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this ,1));
        adapter = new CustomAdapter(this,list);
        recyclerView.setAdapter(adapter);
    }
}



