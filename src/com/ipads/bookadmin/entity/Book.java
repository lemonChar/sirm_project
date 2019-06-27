package com.ipads.bookadmin.entity;

import java.io.Serializable;

public class Book implements Serializable {
    private Integer Bid;
    private String name;
    private String note;
    private Integer status;


    public Integer getBid() {
        return Bid;
    }

    public void setBid(Integer bid) {
        Bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setBid(int bid) {
        this.Bid = bid;
    }


}
