package com.example.themichalkozak.finalquiz;

import android.graphics.drawable.Drawable;

/**
 * Created by themichalkozak on 04/03/2018.
 */

public class Question {

    private Drawable image;
    private String [] question;
    private int correctAnserw;

    public Question(Drawable image, String[] question, int correctAnserw) {
        this.image = image;
        this.question = question;
        this.correctAnserw = correctAnserw;
    }

    public Drawable getImage() {
        return image;
    }

    public String[] getQuestion() {
        return question;
    }

    public int getCorrectAnserw() {
        return correctAnserw;
    }
}
