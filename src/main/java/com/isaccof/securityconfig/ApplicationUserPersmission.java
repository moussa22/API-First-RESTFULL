package com.isaccof.securityconfig;

public enum ApplicationUserPersmission {

    USERS_READ("users:read"),
    USERS_WRITE("users:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private  final String permission;

    ApplicationUserPersmission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
