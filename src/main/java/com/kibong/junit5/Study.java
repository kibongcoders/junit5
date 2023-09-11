package com.kibong.junit5;

public class Study {

    StudyStatus studyStatus = StudyStatus.DRAFT;
    int limit;
    public Study(int limit) {
        this.limit = limit;
    }

    public Study() {

    }

    public StudyStatus getStudyStatus() {
        return studyStatus;
    }

    public void setStudyStatus(StudyStatus studyStatus) {
        this.studyStatus = studyStatus;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit > 11) throw new IllegalArgumentException("스터디의 제한은 10입니다.");
        this.limit = limit;
    }

    public StudyStatus getStatus(){
        return studyStatus;
    }
}
