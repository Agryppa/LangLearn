package com.example.langlearn;

class TestQ {
    private String question;
    private String a;
    private String b;
    private String c;
    private String d;
    private int right;

    public TestQ(String question, String a, String b, String c, String d, int right) {
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.right = right;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }

    public int getRight() {
        return right;
    }

    public String getQuestion() {
        return question;
    }
}
