package com.ipads.bookadmin.service.impl;


import com.ipads.bookadmin.Connection.DatabaseConnection;
import com.ipads.bookadmin.entity.Member;
import com.ipads.bookadmin.factory.DAOFactory;
import com.ipads.bookadmin.service.IMemberService;

public class MemberServiceImpl implements IMemberService {
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean insert(Member vo) throws Exception {
        try{
            if(DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).findById(vo.getMid()) == null)
            return DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).doCreate(vo);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return false;
    }
}
