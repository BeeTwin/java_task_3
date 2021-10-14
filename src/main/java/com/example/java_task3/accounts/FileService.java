package com.example.java_task3.accounts;

import com.example.java_task3.Consts;

import java.io.File;
import java.io.IOException;

public class FileService {
    public static void createDirectoryFor(String nickname) throws IOException {
        var file = new File(Consts.Paths.Home + nickname);
        file.mkdir();
    }
}
