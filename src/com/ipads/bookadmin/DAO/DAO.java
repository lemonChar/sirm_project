package com.ipads.bookadmin.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface DAO<K,V> {

    public boolean doCreate(V vo)throws SQLException;

    public boolean doUpdate(V vo)throws SQLException;

    public boolean doRemove(Set<?> ids)throws SQLException;

    public V findById(K id)throws SQLException;

    public List<V> findAll()throws SQLException;

    public List<V> findAllBySplit(String column,String keyWord,Integer currentPage,Integer lineSize)throws SQLException;

    public Integer getAllCount(String column,String keyWord)throws SQLException;


}
