package com.ipads.bookadmin.entity;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable{
    private Integer iid;
    private String name;
    private String note;
    private List<Book> Book;//表示一个类别下有多本书

    public List<Book> getBook() {
        return Book;
    }

    public void setBook(List<Book> book) {
        Book = book;
    }
    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
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
}
