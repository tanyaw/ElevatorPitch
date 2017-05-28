package twanwatanakool.elevatorpitch1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import twanwatanakool.elevatorpitch1.Questions.InterviewQuestions;

//TODO 1. Implement Answer functionality by writing to file by using firebase or backendless

public class TechnicalQuestion extends AppCompatActivity {
    private InterviewQuestions db;
    private int tKey = 0;    //index for arraylist

    EditText et1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_display);

        db = new InterviewQuestions(this);
        updateQuestion();

        //Make EditText/TextView temp disappear
//        et1 = (EditText)findViewById(R.id.et1);
//        et1.setVisibility(View.GONE);
//        t1 = (TextView) findViewById(R.id.DisplayAnswerText);
//        t1.setVisibility(View.GONE);

        Button nextQuestion = (Button) findViewById(R.id.NextQuestionButton);
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) { updateQuestion(); }
        });

//        Button tapHereButton = (Button) findViewById(R.id.DisplayAnswerButton);
//        tapHereButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showAnswer(v);
//
//                //Clear text in edit text widget
//                et1.setText(null);
//            }
//        });
        Log.d("TANYA", "now waht???");
    }

//    @Override
//    public boolean dispatchKeyEvent(KeyEvent e) {
//        //On Down + Enter, save answer to database
//        if (e.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
//            if(e.getAction() == KeyEvent.ACTION_DOWN) {
//                et1 = (EditText) findViewById(R.id.et1);
//                userInput = et1.getText().toString();
//
//                if (userInput != null && userInput.length() > 0) {
//                    final InterviewQuestions db = new InterviewQuestions(this);
//                    db.setTechAnswer(techKey, userInput);
//
//                    //Clear text in edit text widget
//                    et1.setText(null);
//                } else {
//                    Toast.makeText(TechnicalQuestion.this, "Please enter your answer!", Toast.LENGTH_SHORT).show();
//                }
//            }
//            return true;
//        }
//        return super.dispatchKeyEvent(e);
//    }

//    public void showAnswer(View v) {
//        String answer = db.getTechAnswer(tKey);
//
//        //Make TapHereText Button Disappear
//        final Button tapHereButton = (Button) findViewById(R.id.DisplayAnswerButton);
//        tapHereButton.setVisibility(View.GONE);
//
//        //If no answer, set visibility of edit answer
//        if(answer == null) {
//            et1.setVisibility(View.VISIBLE);
//        }
//        //If answer, set answer
//        else {
//            t1.setVisibility(View.VISIBLE);
//            t1.setText(answer);
//        }
//    }

    public void updateQuestion() {
        final TextView changeQuestion = (TextView) findViewById(R.id.DisplayQuestionText);
        String q;

        //Logic to randomly select question
        if(tKey >= db.getTechSize()) {
            tKey = 0;
            q = db.getTechQuestion(tKey);
        } else {
            q = db.getTechQuestion(tKey);
        }
        tKey++;

        //Display Question in TextView
        if(q == null) {
            changeQuestion.setText("There are currently no questions in the database.");
        } else {
            changeQuestion.setText(q);
        }

        //Reset question screen state
//        et1 = (EditText)findViewById(R.id.et1);
//        et1.setVisibility(View.GONE);
//
//        t1 = (TextView) findViewById(R.id.DisplayAnswerText);
//        t1.setVisibility(View.GONE);
//
//        final Button tapHere = (Button) findViewById(R.id.DisplayAnswerButton);
//        tapHere.setVisibility(View.VISIBLE);
    }
}
