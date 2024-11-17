package com.shubham.localservices.Models;

public class AuthResponse {
    boolean status ;
    int role = -1;
    String msg;

    public AuthResponse(boolean status, int role, String msg) {
        this.status = status;
        this.role = role;
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}