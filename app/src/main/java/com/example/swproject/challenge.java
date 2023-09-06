package com.example.swproject;

public class challenge {
    private int c_id;
    private String c_type;
    private String c_detail;
    private int c_point;
    private String difficulty;
    private String deadline;

    public challenge(){}

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_type() {
        return c_type;
    }

    public void setC_type(String c_type) {
        this.c_type = c_type;
    }

    public String getC_detail() {
        return c_detail;
    }

    public void setC_detail(String c_detail) {
        this.c_detail = c_detail;
    }

    public int getC_point() {
        return c_point;
    }

    public void setC_point(int c_point) {
        this.c_point = c_point;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}