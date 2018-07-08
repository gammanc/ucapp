package com.team.ucapp.ui.grades;

public class SubjectGrades {
    private String evaluation;
    private String date_percentage;
    private String grade;

    public SubjectGrades() {
    }

    public SubjectGrades(String evaluation, String date_percentage, String grade) {
        this.evaluation = evaluation;
        this.date_percentage = date_percentage;
        this.grade = grade;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getDate_percentage() {
        return date_percentage;
    }

    public void setDate_percentage(String date_percentage) {
        this.date_percentage = date_percentage;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
