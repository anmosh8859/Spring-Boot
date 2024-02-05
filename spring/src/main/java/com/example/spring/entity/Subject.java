package com.example.spring.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class Subject {

    public Subject(String subjectName, int marksObtained) {
        this.subjectName = subjectName;
        this.marksObtained = marksObtained;
    }

    @Field(name="subject_name")
    private String subjectName;
    @Field(name="marks_obtained")
    private int marksObtained;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(int marksObtained) {
        this.marksObtained = marksObtained;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                ", marksObtained=" + marksObtained +
                '}';
    }
}
