package com.ipads.bookadmin.service.impl;


import com.ipads.bookadmin.Connection.DatabaseConnection;
import com.ipads.bookadmin.entity.Lenbook;
import com.ipads.bookadmin.factory.DAOFactory;
import com.ipads.bookadmin.service.ILenbookService;

import java.util.HashMap;
import java.util.Map;

public class LenbookServiceImpl implements ILenbookService {
    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public boolean insert(Lenbook vo) throws Exception {
        try {
            return DAOFactory.getILenbookDAOInstance(this.dbc.getConn()).doCreate(vo);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }


    }

    @Override
    public Map<String, Object> listByMemberAndBooks() throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            map.put("allBooks",DAOFactory.getILenbookDAOInstance(this.dbc.getConn()).findAll());
            map.put("allMembers",DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).findAll());
            return map;

        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }
}

