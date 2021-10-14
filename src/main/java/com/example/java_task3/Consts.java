package com.example.java_task3;

public class Consts {
    public static class Urls {
        public static final String MainUrl = "";
        public static final String LoginUrl = "";
        public static final String RegisterUrl = "";

        public static String homeOf(String nickname) {
            return Consts.Urls.MainUrl + "path=" + Consts.Paths.Home + nickname + "&nickname=" + nickname;
        }
    }

    public static class Paths {
        public static final String Home = "C:/Users/";
    }

}
