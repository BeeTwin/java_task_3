package com.example.java_task3.logic.model;

import java.util.Date;

public class FileModel {
    public String Name;
    public String FullPath;
    public long Size;
    public Date Date;
    public boolean IsFile;

    public FileModel(String name, String fullPath, long size, Date date, boolean isFile) {
        Name = name;
        FullPath = fullPath;
        Size = size;
        Date = date;
        IsFile = isFile;
    }
}
