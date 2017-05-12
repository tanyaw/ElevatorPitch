package twanwatanakool.elevatorpitches;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class IndividualCompany extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_company);

        Button toChecklistScreen = (Button) findViewById(R.id.InterviewChecklist);
        toChecklistScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), InterviewChecklist.class);
                startActivityForResult(myIntent, 0);
            }

        });

        Button toTechQ = (Button) findViewById(R.id.TechQuestions);
        toTechQ.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), QuestionDisplay.class);
                startActivityForResult(myIntent, 0);
            }

        });

        Button toBehaviorQ = (Button) findViewById(R.id.BehavioralQuestions);
        toBehaviorQ.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), QuestionDisplay.class);
                startActivityForResult(myIntent, 0);
            }

        });

        Button toInterviewTips = (Button) findViewById(R.id.InterviewTips);
        toInterviewTips.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), InterviewTips.class);
                startActivityForResult(myIntent, 0);
            }

        });

        ImageButton interviewIcon = (ImageButton) findViewById(R.id.button_InterviewIcon);
        interviewIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), QuestionDisplay.class);
                startActivityForResult(myIntent, 0);
            }

        });

        ImageButton interviewIcon2 = (ImageButton) findViewById(R.id.button_InterviewIcon2);
        interviewIcon2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), QuestionDisplay.class);
                startActivityForResult(myIntent, 0);
            }

        });

        ImageButton interviewIcon3 = (ImageButton) findViewById(R.id.button_InterviewIcon);
        interviewIcon3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), QuestionDisplay.class);
                startActivityForResult(myIntent, 0);
            }

        });

        ImageButton interviewIcon4 = (ImageButton) findViewById(R.id.button_InterviewIcon2);
        interviewIcon4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), QuestionDisplay.class);
                startActivityForResult(myIntent, 0);
            }

        });
    }

}
