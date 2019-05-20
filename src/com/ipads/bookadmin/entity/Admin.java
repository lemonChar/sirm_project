package com.ipads.bookadmin.entity;

import java.sql.Timestamp;

public class Admin {
    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    private String aid;
    private String password;
    private Timestamp lastdate;
    private Integer flag;
    private Integer status;


    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passoword) {
        this.password = passoword;
    }

    public Timestamp getLastdate() {
        return lastdate;
    }

    public void setLastdate(Timestamp lastdate) {
        this.lastdate = lastdate;
    }
}
