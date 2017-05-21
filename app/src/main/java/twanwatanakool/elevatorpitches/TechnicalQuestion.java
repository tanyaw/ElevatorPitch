package twanwatanakool.elevatorpitches;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import twanwatanakool.elevatorpitches.Questions.InterviewQuestions;

public class TechnicalQuestion extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_display);

        Button nextQuestion = (Button) findViewById(R.id.NextQuestionButton);
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {updateQuestion();
            }
        });


//        Button showAnswer = (Button) findViewById(R.id.DisplayAnswerText);
//        showAnswer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final TextView displayAnswer = (TextView) findViewById(R.id.DisplayAnswerText);
//                final InterviewQuestions db = new InterviewQuestions(this);
//                String a = db.getBehaveAnswer();
//
//                if(a == null) {
//                    //EDIT TEXT BUTTON appear
//                } else {
//                    displayAnswer.setText(a);
//                }
//            }
//        });
    }

    public void updateQuestion() {
        final TextView changeQuestion = (TextView) findViewById(R.id.DisplayQuestionText);
        final InterviewQuestions db = new InterviewQuestions(this);
        String q = db.getTechQuestion();

        if(q == null) {
            changeQuestion.setText("There are currently no questions in the database.");
        } else {
            changeQuestion.setText(q);
        }
    }
}
