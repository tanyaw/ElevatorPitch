package twanwatanakool.elevatorpitches;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuestionDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_display);

        Button nextQuestion = (Button) findViewById(R.id.NextQuestionButton);
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), QuestionDisplay.class);
                startActivityForResult(myIntent, 0);
            }

        });
    }
}
