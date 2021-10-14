package com.example.java_task3.accounts;

import java.util.HashSet;
import java.util.Set;

public class AccountService {
    private static Set<User> _users = new HashSet<User>();

    public static User tryGetUser(String nickname, String password) {
        return _users.stream().filter(x -> x.is(nickname, password)).findFirst().orElse(null);
    }

    public static boolean trySetUser(String nickname, String email, String password) {
        var user = tryGetUser(nickname, password);
        if (user == null) {
            _users.add(new User(nickname, email, password));
            return true;
        }
        return false;
    }

    public static boolean isAuthorized(String nickname) {
        return _users.stream().anyMatch(x -> x.NickName.equals(nickname));
    }
}
