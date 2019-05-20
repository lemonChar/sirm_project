package com.ipads.bookadmin.factory;

import com.ipads.bookadmin.DAO.AdminDAO;
import com.ipads.bookadmin.DAO.BookDAO;
import com.ipads.bookadmin.DAO.impl.AdminDAOImpl;
import com.ipads.bookadmin.DAO.impl.BookDAOImpl;

import java.sql.Connection;

public class DAOFactory {
    public static BookDAO getIBooksDAOInstance(Connection conn){
        return new BookDAOImpl(conn);
    }
    public static AdminDAO getAdminDAOInstance(Connection conn){
        return new AdminDAOImpl(conn);
    }
}
