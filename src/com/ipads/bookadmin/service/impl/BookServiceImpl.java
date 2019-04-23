package com.ipads.bookadmin.service.impl;

import com.ipads.bookadmin.Connection.DatabaseConnection;
import com.ipads.bookadmin.entity.Book;
import com.ipads.bookadmin.factory.DAOFactory;
import com.ipads.bookadmin.service.BookService;

import java.util.HashMap;
import java.util.Map;

public class BookServiceImpl implements BookService {

    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public boolean insert(Book vo) throws Exception {
        try {
            return DAOFactory.getIBooksDAOInstance(this.dbc.getConn()).doCreate(vo);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public Map<String, Object> findByAdminAndItem() throws Exception {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("allAdmins", null);
            map.put("allItems", null);
            return map;
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();

        }
    }

    @Override
    public Map<String, Object> listBySplit(String column, String keyWord, int currentPage, int lineSize) throws Exception {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("allBooks", DAOFactory.getIBooksDAOInstance(this.dbc.getConn()).findAllBySplit(column, keyWord, currentPage, lineSize));
            map.put("allCounts", DAOFactory.getIBooksDAOInstance(this.dbc.getConn()).getAllCount(column, keyWord));
            return map;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }
}

