package com.ipads.bookadmin.service.impl;

import com.ipads.bookadmin.Connection.DatabaseConnection;
import com.ipads.bookadmin.entity.Admin;
import com.ipads.bookadmin.factory.DAOFactory;
import com.ipads.bookadmin.service.AdminService;

public class AdminServiceImpl implements AdminService {
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean login(Admin vo) throws Exception {
        try{
            //如果登录成功
            if (DAOFactory.getAdminDAOInstance(this.dbc.getConn()).findLogin(vo)) {
                return DAOFactory.getAdminDAOInstance(this.dbc.getConn()).doUpdateByLastDate(vo.getAid());
            }
            return false;

        }
        catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }

    }

    @Override
    public boolean updateByLastDate(String aid) throws Exception {
        return false;
    }
}
