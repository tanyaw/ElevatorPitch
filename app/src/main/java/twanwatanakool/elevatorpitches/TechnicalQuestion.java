package twanwatanakool.elevatorpitches;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import twanwatanakool.elevatorpitches.Questions.InterviewQuestions;

public class TechnicalQuestion extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_display);
        //Log.d("TANYA", "DO I EVEN LAUCNH WTF"); - this prints

        Button nextQuestion = (Button) findViewById(R.id.NextQuestionButton);

        nextQuestion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                updateQuestion();
            }
        });
    }

    public void updateQuestion() {
        Log.d("TANYA", "Enter updateQuestion()");
        final TextView changeQuestion = (TextView) findViewById(R.id.DisplayQuestionText);
        //final InterviewQuestions db = new InterviewQuestions();
        Log.d("TANYA", "Can I change Question");
        final InterviewQuestions db2 = new InterviewQuestions(this);
        Log.d("TANYA", "Can I mkae database");
        //String q = db.getTechQuestion();
        Log.d("TANYA", "Before get tech Qs");
        String q = db2.getTechQuestion2();
        Log.d("TANYA", "After get tech Qs");

        if(q == null) {
            changeQuestion.setText("There are currently no questions in the database.");
        } else {
            Log.d("TANYA", "Before set tech Qs");
            changeQuestion.setText(q);
            Log.d("TANYA", "AFTER set tech Qs");
        }
    }
}
