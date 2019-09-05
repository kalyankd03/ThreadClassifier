package com.company.model;

public class FileRange {
    String filename;
    Long startOffSet;
    Long endOffSet;

    public String getFilename(){
        return  this.filename;
    }

    public  void setFilename(String filename){
        this.filename = filename;
    }

    public  Long getStartOffSet(){
        return this.startOffSet;
    }

    public void setStartOffSet(Long startOffSet){
        this.startOffSet = startOffSet;
    }

    public Long getEndOffSet(){
        return this.endOffSet;
    }

    public void setEndOffSet(Long endOffSet){
        this.endOffSet = endOffSet;
    }

    @Override
    public  String toString(){
        return filename + ":" + startOffSet + " - " + endOffSet;
    }
}
