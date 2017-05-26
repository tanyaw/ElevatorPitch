package twanwatanakool.elevatorpitch1.Questions;

/**
 * Created by twanwatanakool on 5/13/17.
 */

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.Collections;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InterviewQuestions {
    private ArrayList<QAObject> techData = new ArrayList<>();
    private ArrayList<QAObject> behaviorData = new ArrayList<>();

    private Context context;

    public InterviewQuestions(Context myContext) {
        this.context = myContext;
        setQuestions(techData, "techQuestions.txt");
        setQuestions(behaviorData, "behaviorQuestions.txt");
    }

    public void setQuestions(ArrayList<QAObject> list, String fileName) {
        BufferedReader in = null;
        try {
            AssetManager assetManager = context.getAssets();
            InputStream is =  assetManager.open(fileName);
            Reader reader = new InputStreamReader(is);
            in = new BufferedReader(reader);

            String line;
            while((line = in.readLine()) != null) {
                QAObject qa = new QAObject();
                qa.setQuestion(line);
                list.add(qa);
            }
        } catch (IOException e) {
            Log.d("Error", "This file does not exist");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e){
                    Log.e("Error", "Cannot close file reader");
                }
            }
        }
        Collections.shuffle(list);
    }

    public String getTechQuestion(int i) {
        return techData.get(i).getQuestion();
    }

    public String getBehaviorQuestion(int i) {
        return behaviorData.get(i).getQuestion();
    }

    public String getTechAnswer(int i) { return techData.get(i).getAnswer(); }

    public String getBehaviorAnswer(int i) { return behaviorData.get(i).getAnswer(); }

    public void setTechAnswer2(int index, String s) {
        techData.get(index).setAnswer(s);
        Log.d("TANYA", "Storing: " + s);
    }

    public void setBehaveAnswer2(int index, String s) {
        behaviorData.get(index).setAnswer(s);
        Log.d("TANYA", "Storing: " + s);
    }

    public int getTechSize() { return techData.size(); }

    public int getBehaviorSize() {
        return behaviorData.size();
    }
}
