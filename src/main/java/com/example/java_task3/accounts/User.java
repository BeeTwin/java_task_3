package com.example.java_task3.accounts;

public class User {
    public final String NickName;
    public final String Email;
    private final String _password;

    public User(String nickname, String email, String password) {
        NickName = nickname;
        Email = email;
        _password = password;
    }

    public boolean is(String nickName, String password) {
        return NickName.equals(nickName) && _password.equals(password);
    }
}
