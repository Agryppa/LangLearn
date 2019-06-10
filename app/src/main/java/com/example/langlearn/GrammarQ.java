package com.example.langlearn;

public class GrammarQ {
    private String question;
    private String[] posAnswers;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getPosAnswers() {
        return posAnswers;
    }

    public void setPosAnswers(String[] posAnswers) {
        this.posAnswers = posAnswers;
    }

    public GrammarQ(String question, String[] posAnswers) {
        this.question = question;
        this.posAnswers = posAnswers;
    }

    public GrammarQ(String question) {
        this.question = question;
    }
}
