package com.example.quizbuzz;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomViewHolder extends RecyclerView.ViewHolder {

  TextView idd , question;
  RadioButton option1 ,option2,option3,option4;
  RadioGroup radioGroup;
  public static List<Integer> selectedPositions = new ArrayList<>();

  public CustomViewHolder(@NonNull View itemView) {
    super(itemView);


      radioGroup = itemView.findViewById(R.id.radioGroup);
      idd = itemView.findViewById(R.id.id);
      question = itemView.findViewById(R.id.question);
      option1 = itemView.findViewById(R.id.option1);
      option2 = itemView.findViewById(R.id.option2);
      option3 = itemView.findViewById(R.id.option3);
      option4 = itemView.findViewById(R.id.option4);

      radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
        if (checkedId != -1) {
          int position = getAdapterPosition();
          if (!selectedPositions.contains(position)) {
            selectedPositions.add(position);
          }
        } else {
          int position = getAdapterPosition();
          selectedPositions.remove(Integer.valueOf(position));
        }
      });
  }
}
