package com.benginio.flashcard1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private TextView tvFlashcardQuestion;
private TextView tvFlashcardAnswer;
private ImageView addQuestionImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFlashcardAnswer=findViewById(R.id.flashcard_answer_textview);
        tvFlashcardQuestion=findViewById(R.id.flashcard_question_textview);
        tvFlashcardQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvFlashcardQuestion.setVisibility(view.INVISIBLE);
                tvFlashcardAnswer.setVisibility(view.VISIBLE);
                Log.i("Benginio", "entered onCLick method");

                Toast.makeText(MainActivity.this, "I CLICKED THE QUESTION!", Toast.LENGTH_SHORT).show();

            }
        });
        tvFlashcardAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvFlashcardAnswer.setVisibility(view.INVISIBLE);
                tvFlashcardQuestion.setVisibility(view.VISIBLE);
                Log.i("Benginio", "entered onCLick method");

                Toast.makeText(MainActivity.this, "I CLICKED THE ANSWER!", Toast.LENGTH_SHORT).show();
            }
        });
         addQuestionImageView=findViewById(R.id.flashcard_add_question_button);
        addQuestionImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, AddCardActivity.class);
                startActivity(intent);
                startActivityForResult(intent, 100);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            //get data
            if(data != null){//check if there's an Intent
               String questionString= data.getExtras().getString("QUESTION_KEY");
                String answerString= data.getExtras().getString("ANSWER_KEY");
                tvFlashcardQuestion.setText(questionString);
                tvFlashcardAnswer.setText(answerString);
            }
        }
    }
}