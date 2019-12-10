package com.sandu.quizz4games.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sandu.quizz4games.QuestionsEn;
import com.sandu.quizz4games.R;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private Button ans1_btn;
    private Button ans2_btn;
    private Button ans3_btn;
    private Button ans4_btn;
    private TextView question, score, question_no, textTimer;
    private QuestionsEn questions = new QuestionsEn();

    private String answer;
    private int questionsLength = questions.questions.length;
    private int uScore;
    private int uQuestionsAnswered ;

    ProgressBar progressBar;

    Random r;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

//        // Full Screen
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        //.....//
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        r = new Random();

        ans1_btn = findViewById(R.id.ans1_btn_game);
        ans2_btn = findViewById(R.id.ans2_btn_game);
        ans3_btn = findViewById(R.id.ans3_btn_game);
        ans4_btn = findViewById(R.id.ans4_btn_game);

        question = findViewById(R.id.q_area_game);

        score = findViewById(R.id.score_gameActivity);

        question_no = findViewById(R.id.q_number_game);



        // update question randomizer
        updateQuestion(r.nextInt(questionsLength));
        //...//

        //Timer
       // timer();

        //Button Functions

        ans1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ans1_btn.getText() == answer){
                    correctAnswer();
                    ans1_btn.setBackgroundResource(R.drawable.answer_btn_correct);
                    disableButtons();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            resetButtons();
                            updateQuestion(r.nextInt(questionsLength));
                        }
                    }, 1000);
                    gameOver();

                }else
                    ans1_btn.setBackgroundResource(R.drawable.answer_btn_wrong);
                disableButtons();
                showCorrectAnswer();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        resetButtons();
                        updateQuestion(r.nextInt(questionsLength));
                    }
                }, 1000);
                wrongAnswer();
                gameOver();




            }
        });

        ans2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ans2_btn.getText() == answer){
                    correctAnswer();

                    ans2_btn.setBackgroundResource(R.drawable.answer_btn_correct);
                    disableButtons();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            resetButtons();
                            updateQuestion(r.nextInt(questionsLength));
                        }
                    }, 1000);
                    gameOver();

                }else
                    ans2_btn.setBackgroundResource(R.drawable.answer_btn_wrong);
                disableButtons();
                showCorrectAnswer();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        resetButtons();
                        updateQuestion(r.nextInt(questionsLength));
                    }
                }, 1000);
                wrongAnswer();
                gameOver();


            }

        });
        ans3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ans3_btn.getText() == answer){
                    correctAnswer();
                    ans3_btn.setBackgroundResource(R.drawable.answer_btn_correct);
                    disableButtons();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            resetButtons();
                            updateQuestion(r.nextInt(questionsLength));
                        }
                    }, 1000);
                    gameOver();


                }else
                    ans3_btn.setBackgroundResource(R.drawable.answer_btn_wrong);
                disableButtons();
                showCorrectAnswer();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        resetButtons();
                        updateQuestion(r.nextInt(questionsLength));
                    }
                }, 1000);
                wrongAnswer();
                gameOver();


            }
        });
        ans4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ans4_btn.getText() == answer){
                    correctAnswer();
                    ans4_btn.setBackgroundResource(R.drawable.answer_btn_correct);
                    disableButtons();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            resetButtons();
                            updateQuestion(r.nextInt(questionsLength));
                        }
                    }, 1000);
                    gameOver();


                }else
                    ans4_btn.setBackgroundResource(R.drawable.answer_btn_wrong);
                disableButtons();
                showCorrectAnswer();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        resetButtons();
                        updateQuestion(r.nextInt(questionsLength));
                    }
                }, 1000);
                wrongAnswer();
                gameOver();


            }
        });


    }

    private void resetButtons() {
        ans1_btn.setBackgroundResource(R.drawable.answer_btn);
        ans2_btn.setBackgroundResource(R.drawable.answer_btn);
        ans3_btn.setBackgroundResource(R.drawable.answer_btn);
        ans4_btn.setBackgroundResource(R.drawable.answer_btn);
        ans1_btn.setEnabled(true);
        ans2_btn.setEnabled(true);
        ans3_btn.setEnabled(true);
        ans4_btn.setEnabled(true);


    }

    // Update Question Function
    private void updateQuestion(int num){

        question.setText(questions.getQuestions(num));
        ans1_btn.setText(questions.getChoice1(num));
        ans2_btn.setText(questions.getChoice2(num));
        ans3_btn.setText(questions.getChoice3(num));
        ans4_btn.setText(questions.getChoice4(num));


        answer = questions.getCorrectAnswer(num);

    }
    //Other Functions
    private void wrongAnswer(){
        uScore -= 5;
        uQuestionsAnswered ++;

        if (uScore < 0){
            uScore = 0;
            score.setText("0");
        }
        question_no.setText(uQuestionsAnswered+"/10");
        score.setText(String.valueOf(uScore));

    }

    private void correctAnswer(){
        uScore +=15;
        score.setText(String.valueOf(uScore));

//        uQuestionsAnswered += 0;
        question_no.setText(uQuestionsAnswered+"/10");
    }

    private void gameOver(){
        if (uQuestionsAnswered>10){
            startActivity(new Intent(GameActivity.this, HomeScreen.class));
        }
    }

    private void showCorrectAnswer(){
        if (ans1_btn.getText() == answer){
            ans1_btn.setBackgroundResource(R.drawable.answer_btn_correct);
        }else if (ans2_btn.getText() == answer){
            ans2_btn.setBackgroundResource(R.drawable.answer_btn_correct);
        }else if (ans3_btn.getText() == answer){
            ans3_btn.setBackgroundResource(R.drawable.answer_btn_correct);
        }else if (ans4_btn.getText() == answer){
            ans4_btn.setBackgroundResource(R.drawable.answer_btn_correct);
        }
    }
    //...//
    private void disableButtons(){
        ans1_btn.setEnabled(false);
        ans2_btn.setEnabled(false);
        ans3_btn.setEnabled(false);
        ans4_btn.setEnabled(false);
    }



    public void timer(){
        textTimer = findViewById(R.id.textTimer);

        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {


                textTimer.setText(String.valueOf(millisUntilFinished / 1000));
                progressBar.setProgress(-10);
            }

            public void onFinish() {

            }
        }.start();
    }
}
