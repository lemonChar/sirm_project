package com.ipads.bookadmin.service.impl;



import com.ipads.bookadmin.Connection.DatabaseConnection;
import com.ipads.bookadmin.entity.Item;
import com.ipads.bookadmin.factory.DAOFactory;
import com.ipads.bookadmin.service.IItemService;

import java.util.List;

public class ItemServiceImpl implements IItemService {
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean insert(Item vo) throws Exception {
        try {
            return DAOFactory.getIItemDAOInstance(this.dbc.getConn()).doCreate(vo);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }


    }

    @Override
    public List<Item> list() throws Exception {
        try {
            return DAOFactory.getIItemDAOInstance(this.dbc.getConn()).findAll();
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }

    }
}
