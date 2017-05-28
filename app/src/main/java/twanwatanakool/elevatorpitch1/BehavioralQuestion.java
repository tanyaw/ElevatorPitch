package twanwatanakool.elevatorpitch1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import twanwatanakool.elevatorpitch1.Questions.InterviewQuestions;

public class BehavioralQuestion extends AppCompatActivity {
    private InterviewQuestions db;
    private int bKey = 0;   //index for arraylist

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_display);

        db = new InterviewQuestions(this);
        updateQuestion();

        Button nextQuestion = (Button) findViewById(R.id.NextQuestionButton);
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                updateQuestion();
            }
        });
    }

    public void updateQuestion() {
        final TextView changeQuestion = (TextView) findViewById(R.id.DisplayQuestionText);
        String q;

        //Logic to randomly select question
        if(bKey >= db.getBehaviorSize()) {
            bKey = 0;
            q = db.getBehaviorQuestion(bKey);
        } else {
            q = db.getBehaviorQuestion(bKey);
        }
        bKey++;

        //Display Question in TextView
        if(q == null) {
            changeQuestion.setText("There are currently no questions in the database.");
        } else {
            changeQuestion.setText(q);
        }
    }
}