package com.ipads.bookadmin.factory;

import com.ipads.bookadmin.DAO.*;
import com.ipads.bookadmin.DAO.impl.*;

import java.sql.Connection;

public class DAOFactory {
    public static BookDAO getIBooksDAOInstance(Connection conn){
        return new BookDAOImpl(conn);
    }
    public static AdminDAO getAdminDAOInstance(Connection conn){
        return new AdminDAOImpl(conn);
    }

    public static IMemberDao getIMemberDAOInstance(Connection conn){
        return new MemberDaoImpl(conn);
    }
    public static IItemDAO getIItemDAOInstance(Connection conn){
        return new ItemDAOImpl(conn);
    }
    public static ILenbookDAO getILenbookDAOInstance(Connection conn){return new LenbookDAOimpl(conn);}
}
