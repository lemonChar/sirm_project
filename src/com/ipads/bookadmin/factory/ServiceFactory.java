package com.ipads.bookadmin.factory;

import com.ipads.bookadmin.service.BookService;
import com.ipads.bookadmin.service.impl.BookServiceImpl;

public class ServiceFactory {
    public static BookService getBookServiceInstance(){
        return new BookServiceImpl();
    }
}
