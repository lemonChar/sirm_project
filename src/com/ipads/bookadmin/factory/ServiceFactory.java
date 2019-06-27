package com.ipads.bookadmin.factory;

import com.ipads.bookadmin.service.*;
import com.ipads.bookadmin.service.impl.*;

public class ServiceFactory {
    public static BookService getBookServiceInstance(){
        return new BookServiceImpl();
    }
    public static AdminService getIAdminServiceInstance() {
        return new AdminServiceImpl();
    }


    public static IMemberService getIMemberServiceInstance(){return new MemberServiceImpl();}
    public static IItemService getIItemServiceInstance(){return new ItemServiceImpl(); }

    public static ILenbookService getILenbooksServiceInstance(){return new LenbookServiceImpl();}
}
