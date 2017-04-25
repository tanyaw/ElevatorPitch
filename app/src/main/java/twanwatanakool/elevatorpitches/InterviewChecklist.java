package twanwatanakool.elevatorpitches;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class InterviewChecklist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_checklist);

        Button toInterviewTips = (Button) findViewById(R.id.GoToTipsButton);
        toInterviewTips.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), InterviewTips.class);
                startActivityForResult(myIntent, 0);
            }

        });
    }
}
