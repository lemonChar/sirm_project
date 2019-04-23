package com.ipads.bookadmin.factory;

import com.ipads.bookadmin.DAO.BookDAO;
import com.ipads.bookadmin.DAO.impl.BookDAOImpl;

import java.sql.Connection;

public class DAOFactory {
    public static BookDAO getIBooksDAOInstance(Connection conn){
        return new BookDAOImpl(conn);
    }
}
