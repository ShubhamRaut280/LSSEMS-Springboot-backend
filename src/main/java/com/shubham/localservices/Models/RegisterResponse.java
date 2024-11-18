package com.shubham.localservices.Models;

public class RegisterResponse {
    boolean status;
    Long userid;
    String msg;

    public RegisterResponse(boolean status, Long userid, String msg) {
        this.status = status;
        this.userid = userid;
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
