package com.team.ucapp.ui.expedient;

public class SubjectExpedient {
    private String subjectLetter;
    private String subject;
    private String grade;

    public String getSubjectLetter() {
        return subjectLetter;
    }

    public SubjectExpedient(String subjectLetter, String subject, String grade) {
        this.subjectLetter = subjectLetter;
        this.subject = subject;
        this.grade = grade;
    }

    public void setSubjectLetter(String subjectLetter) {
        this.subjectLetter = subjectLetter;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
