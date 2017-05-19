package twanwatanakool.elevatorpitches;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.util.Log;

import java.util.Map;

public class InterviewChecklist extends AppCompatActivity {
    private String PREF_NAME = "checkPref";
    private CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7;
    private String compName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_checklist);

        //Get compName for unique IDs
        Bundle extras = getIntent().getExtras();
        compName = extras.getString("compName");

        if(compName == null){
            Log.d("TANYA","compName is null");
        }

        Log.d("TANYA", "compName: " + compName);

        //Set xml status text
        updateStatus();

        //Initialize and Auto-populate Checkboxes
        initCheckboxes();
        retrieveFromPreference2();

        Button toInterviewTips = (Button) findViewById(R.id.GoToTipsButton);
        toInterviewTips.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), InterviewTips.class);
                startActivityForResult(myIntent, 0);

                saveCheckBoxStates2();
            }
        });
    }

    @Override
    public void onBackPressed() {
        saveCheckBoxStates2();
        super.onBackPressed();
    }

    // HELPER METHOD - Creates CheckBox objects
    public void initCheckboxes() {
        cb1 = (CheckBox) findViewById(R.id.ApplyCheckBox);
        cb2 = (CheckBox) findViewById(R.id.SetUpCheckBox);
        cb3 = (CheckBox) findViewById(R.id.ResearchCheckBox);
        cb4 = (CheckBox) findViewById(R.id.StudyCheckBox);
        cb5 = (CheckBox) findViewById(R.id.InterviewCheckBox);
        cb6 = (CheckBox) findViewById(R.id.FollowUpCheckBox);
        cb7 = (CheckBox) findViewById(R.id.ThanksCheckBox);
    }

    // HELPER METHOD - sends checked state to SharedPreferences
    public void saveCheckBoxStates() {
        saveToPreferences("cb1", cb1.isChecked());
        saveToPreferences("cb2", cb2.isChecked());
        saveToPreferences("cb3", cb3.isChecked());
        saveToPreferences("cb4", cb4.isChecked());
        saveToPreferences("cb5", cb5.isChecked());
        saveToPreferences("cb6", cb6.isChecked());
        saveToPreferences("cb7", cb7.isChecked());

        updateStatus();
    }

    public void saveCheckBoxStates2() {
        saveToPreferences(compName+"cb1", cb1.isChecked());
        saveToPreferences(compName+"cb2", cb2.isChecked());
        saveToPreferences(compName+"cb3", cb3.isChecked());
        saveToPreferences(compName+"cb4", cb4.isChecked());
        saveToPreferences(compName+"cb5", cb5.isChecked());
        saveToPreferences(compName+"cb6", cb6.isChecked());
        saveToPreferences(compName+"cb7", cb7.isChecked());

        updateStatus2();
    }

    // HELPER METHOD - Store userInput to SharedPreferences File
    public void saveToPreferences(String s, boolean b) {
        SharedPreferences.Editor editor = getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        editor.putString(s, ""+b);
        editor.commit();
    }

    // HELPER METHOD -  Update StatusText in XML
    public void updateStatus() {
        int update = 0;
        SharedPreferences prefs = this.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        Map<String, ?> keys = prefs.getAll();

        for(Map.Entry<String, ?> entry : keys.entrySet()) {
            if(entry.getValue().equals("true")) {
                update++;
            }
        }

        final TextView status = (TextView) findViewById(R.id.StatusText);
        if(update == 7) {
            status.setText("COMPLETED.");
        } else {
            status.setText(status.getText());
        }
    }

    public void updateStatus2() {
        int update = 0;
        SharedPreferences prefs = this.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        Map<String, ?> keys = prefs.getAll();

        for(Map.Entry<String, ?> entry : keys.entrySet()) {
            if(entry.getKey().contains(compName) && entry.getValue().equals("true")) {
                update++;
            }
        }

        final TextView status = (TextView) findViewById(R.id.StatusText);
        if(update == 7) {
            status.setText("COMPLETED");
        } else {
            status.setText(status.getText());
        }
    }

    // HELPER METHOD - Autopopulate data from SharedPreferences File to activity
    public void retrieveFromPreference() {
        SharedPreferences prefs = this.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        Map<String, ?> keys = prefs.getAll();

        for(Map.Entry<String, ?> entry : keys.entrySet()) {
            String key = entry.getKey();

            if(entry.getValue().equals("true")) {
                switch (key) {
                    case "cb1":
                        cb1.setChecked(true);
                        break;
                    case "cb2":
                        cb2.setChecked(true);
                        break;
                    case "cb3":
                        cb3.setChecked(true);
                        break;
                    case "cb4":
                        cb4.setChecked(true);
                        break;
                    case "cb5":
                        cb5.setChecked(true);
                        break;
                    case "cb6":
                        cb6.setChecked(true);
                        break;
                    case "cb7":
                        cb7.setChecked(true);
                        break;
                }
            }

            else if(entry.getValue().equals("false")) {
                switch (key) {
                    case "cb1":
                        cb1.setChecked(false);
                        break;
                    case "cb2":
                        cb2.setChecked(false);
                        break;
                    case "cb3":
                        cb3.setChecked(false);
                        break;
                    case "cb4":
                        cb4.setChecked(false);
                        break;
                    case "cb5":
                        cb5.setChecked(false);
                        break;
                    case "cb6":
                        cb6.setChecked(false);
                        break;
                    case "cb7":
                        cb7.setChecked(false);
                        break;
                }
            }
        }
    }

    // HELPER METHOD - Auto-populate data from SharedPreferences to activity
    public void retrieveFromPreference2() {
        SharedPreferences prefs = this.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        Map<String, ?> keys = prefs.getAll();

        for (Map.Entry<String, ?> entry : keys.entrySet()) {
            String key = entry.getKey();

            if (key.contains(compName)) {
                if (key.contains("cb1")) {
                    if (entry.getValue().equals("true")) {
                        cb1.setChecked(true);
                    }

                    if (entry.getValue().equals("false")) {
                        cb1.setChecked(false);
                    }
                }

                if (key.contains("cb2")) {
                    if (entry.getValue().equals("true")) {
                        cb2.setChecked(true);
                    }

                    if (entry.getValue().equals("false")) {
                        cb2.setChecked(false);
                    }
                }

                if (key.contains("cb3")) {
                    if (entry.getValue().equals("true")) {
                        cb3.setChecked(true);
                    }

                    if (entry.getValue().equals("false")) {
                        cb3.setChecked(false);
                    }
                }

                if (key.contains("cb4")) {
                    if (entry.getValue().equals("true")) {
                        cb4.setChecked(true);
                    }

                    if (entry.getValue().equals("false")) {
                        cb4.setChecked(false);
                    }
                }

                if (key.contains("cb5")) {
                    if (entry.getValue().equals("true")) {
                        cb5.setChecked(true);
                    }

                    if (entry.getValue().equals("false")) {
                        cb5.setChecked(false);
                    }
                }

                if (key.contains("cb6")) {
                    if (entry.getValue().equals("true")) {
                        cb6.setChecked(true);
                    }

                    if (entry.getValue().equals("false")) {
                        cb6.setChecked(false);
                    }
                }

                if (key.contains("cb7")) {
                    if (entry.getValue().equals("true")) {
                        cb7.setChecked(true);
                    }

                    if (entry.getValue().equals("false")) {
                        cb7.setChecked(false);
                    }
                }
            }
        }
    }

    // HELPER METHOD - Clear all values stored in SharedPreferences File
    public void clearPref() {
        SharedPreferences.Editor editor = this.getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        editor.clear();
        editor.commit();
    }
}