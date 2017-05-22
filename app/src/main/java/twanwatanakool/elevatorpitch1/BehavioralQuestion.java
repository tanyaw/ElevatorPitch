package twanwatanakool.elevatorpitch1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import twanwatanakool.elevatorpitch1.Questions.InterviewQuestions;

public class BehavioralQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_display);

        Button nextQuestion = (Button) findViewById(R.id.NextQuestionButton);

        nextQuestion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                updateQuestion();
            }
        });
    }

    public void updateQuestion() {
        final TextView changeQuestion = (TextView) findViewById(R.id.DisplayQuestionText);
        final InterviewQuestions db = new InterviewQuestions(this);
        String q = db.getBehaviorQuestion();

        if(q ==null) {
            changeQuestion.setText("There are currently no questions in the database.");
        } else {
            changeQuestion.setText(q);
        }
    }
}