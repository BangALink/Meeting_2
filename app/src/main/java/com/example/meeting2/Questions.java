package com.example.meeting2;

public class Questions {
    private int resId;
    private boolean answer;

    public Questions(int textId, boolean theanswer){
        resId = textId;
        answer = theanswer;
    }

    public int getResId(){
        return resId;
    }

    public void setResId(int textId){
        resId = textId;
    }

    public boolean getAnswer(){
        return answer;
    }

    public void setAnswer(boolean theAnswer){
        answer = theAnswer;
    }
}
