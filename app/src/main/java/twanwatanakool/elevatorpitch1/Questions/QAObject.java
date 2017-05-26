package twanwatanakool.elevatorpitch1.Questions;

import android.util.Log;

/**
 * Created by twanwatanakool on 5/25/17.
 */

public class QAObject {
    private String question;
    private String answer;

    public QAObject() {
        question = null;
        answer = null;
    }

    public void setQuestion(String s) {
        this.question = s;
        Log.d("TANYA", "Storing: " + s);
    }

    public void setAnswer(String s) {
        this.answer = s;
        Log.d("TANYA", "Storing: " + s);
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
