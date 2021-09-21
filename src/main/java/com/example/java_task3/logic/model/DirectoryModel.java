package com.example.java_task3.logic.model;

import java.util.List;

public class DirectoryModel {
    public String ParentPath;
    public String FullPath;
    public List<FileModel> Children;

    public DirectoryModel(String parentPath, String fullPath, List<FileModel> children) {
        ParentPath = parentPath;
        FullPath = fullPath;
        Children = children;
    }
}
