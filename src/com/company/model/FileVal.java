package com.company.model;

public class FileVal {
    private String filename;
    private long length;


    public  FileVal(String filename , long length){
        this.filename = filename;
        this.length = length;
    }
    public String getFilename(){
        return this.filename;
    }

    public void setFilename(String filename){
        this.filename = filename;
    }

    public long getLength(){
        return this.length;
    }

    public void setLength(long length){
        this.length = length;
    }
}
