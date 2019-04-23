package com.ipads.bookadmin.DAO.impl;

import com.ipads.bookadmin.DAO.BookDAO;
import com.ipads.bookadmin.entity.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BookDAOImpl extends AbstractDAOImpl implements BookDAO {

    public BookDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Book vo) throws SQLException {
        String sql = "INSERT INTO books(iid,aid,name,credate,status,note)VALUES(?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(3,vo.getName());
        super.pstmt.setInt(5,vo.getStatus());
        super.pstmt.setString(6,vo.getNote());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Book vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Book findById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Book> findAll() throws SQLException {
        List<Book> all = new ArrayList<Book>();
        String sql ="SELECT bid,iid,aid,name,credate,status,note FROM books";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            Book vo = new Book();
            vo.setBid(rs.getInt(1));
            vo.setName(rs.getString(4));
            vo.setStatus(rs.getInt(6));
            vo.setNote(rs.getString(7));
            all.add(vo);
        }
        return all;
    }

    @Override
    public List<Book> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        String sql = "SELECT COUNT(*) FROM books WHERE "+column +" LIKE ?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%"+keyWord+"%");
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }
}
