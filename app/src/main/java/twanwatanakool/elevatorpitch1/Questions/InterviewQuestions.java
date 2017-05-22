package twanwatanakool.elevatorpitch1.Questions;

/**
 * Created by twanwatanakool on 5/13/17.
 */

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Random;

public class InterviewQuestions {
    private ArrayList<String> techQuestionList = new ArrayList<>();
    private ArrayList<String> behaviorQuestionList = new ArrayList<>();
    private ArrayList<String> techAnswerList = new ArrayList<>();
    private ArrayList<String> behaviorAnswerList = new ArrayList<>();
    private Context context;

    public InterviewQuestions(Context myContext) {
        this.context = myContext;
        setTechQuestions();
        setBehaviorQuestions();

        initTechAnswers();
        initBehaviorAnswers();
    }

    public void initTechAnswers() {
        for(int i=0; i < this.getTechSize(); i++) {
            techAnswerList.add(null);
        }
    }

    public void initBehaviorAnswers() {
        for(int i=0; i < this.getBehaviorSize(); i++) {
            behaviorAnswerList.add(null);
        }
    }

    public void setBehaviorQuestions() {
        BufferedReader in = null;
        try {
            AssetManager assetManager = context.getAssets();
            InputStream is =  assetManager.open("behaviorQuestions.txt");
            Reader reader = new InputStreamReader(is);
            in = new BufferedReader(reader);

            String line;
            while((line = in.readLine()) != null) {
                behaviorQuestionList.add(line);
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
    }

    public void setTechQuestions() {
        BufferedReader in = null;
        try {
            AssetManager assetManager = context.getAssets();
            InputStream is =  assetManager.open("techQuestions.txt");
            Reader reader = new InputStreamReader(is);
            in = new BufferedReader(reader);

            String line;
            while((line = in.readLine()) != null) {
                techQuestionList.add(line);
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
    }

    public String getTechQuestion(int randIndex) {
        if(techQuestionList.isEmpty()) {
            return null;
        } else {
            return techQuestionList.get(randIndex);
        }
    }

    public String getBehaviorQuestion() {
        if(behaviorQuestionList.isEmpty()) {
            return null;
        } else {
            Random rand = new Random();
            int randIndex = rand.nextInt((behaviorQuestionList.size()-1));
            return behaviorQuestionList.get(randIndex);
        }
    }

    public int getTechSize() {
        return techQuestionList.size();
    }

    public int getBehaviorSize() {
        return behaviorQuestionList.size();
    }

    public String getTechAnswer(int index) {
        if(techAnswerList.isEmpty()) {
            return null;
        } else {
            return techAnswerList.get(index);
        }
    }

    public String getBehaveAnswer(int index) {
        if(behaviorAnswerList.isEmpty()) {
            return null;
        } else {
            return behaviorAnswerList.get(index);
        }
    }

    public void setTechAnswer(int index, String s) {
        techAnswerList.set(index, s);
        Log.d("TANYA", "Storing: " + s);
    }

    public void setBehaveAnswer(int index, String s) { behaviorAnswerList.set(index, s); }
}
