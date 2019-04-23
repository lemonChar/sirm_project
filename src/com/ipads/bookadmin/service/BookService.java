package com.ipads.bookadmin.service;

import com.ipads.bookadmin.entity.Book;

import java.util.Map;

public interface BookService {
    /**
     * 增加图书详情
     * @param vo 表示要执行数据增加的对象
     * @return 成功返回true，失败返回false
     * @throws Exception
     */
    public boolean  insert(Book vo) throws Exception;

    /**
     * 此方法表示执行查询Admin表和item表中的全部数据
     * @return
     * @throws Exception
     */
    public Map<String,Object> findByAdminAndItem() throws Exception;

    /**
     * 定义分页接口类
     * @param column
     * @param keyWord
     * @param currentPage
     * @param lineSize
     * @return
     * @throws Exception
     */
    public Map<String,Object> listBySplit(String column,String keyWord,int currentPage,int lineSize) throws Exception;
}
