package com.morning.framework.common.dto;

/**
 * @author MorningJs
 * @date 2024/6/13 16:51
 * @desc
 */
public class ThreadLocalUser {

    private static final ThreadLocal<String> USER = new ThreadLocal<>();

    public static void setUser(String user) {
        USER.set(user);
    }

    public static String getUser() {
        return USER.get();
    }

    public static void clear() {
        USER.remove();
    }

}