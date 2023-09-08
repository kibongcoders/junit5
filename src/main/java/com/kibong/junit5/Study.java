package com.kibong.junit5;

public class Study {

    StudyStatus studyStatus = StudyStatus.DRAFT;
    public Study() {
    }

    public StudyStatus getStatus(){
        return studyStatus;
    }
}
