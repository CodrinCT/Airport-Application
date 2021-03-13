package com.example.AirportApp.Security;

public enum ApplicationUserPermissions {
//    STUDENT_READ("student:read"),
//    STUDENT_WRITE("student:write"),
//    COURSE_WRITE("course:write"),
//    COURSE_READ("course:read");

    ADMIN_PERMISSION("admin:permission"),
    LOGGEDUSER_PERMISSION("loggeduser:permission");
    private final String permission;


    ApplicationUserPermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }
}
