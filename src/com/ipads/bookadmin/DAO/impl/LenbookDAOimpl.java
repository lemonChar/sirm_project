package com.ipads.bookadmin.DAO.impl;

import com.ipads.bookadmin.DAO.ILenbookDAO;
import com.ipads.bookadmin.entity.Lenbook;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;


public class LenbookDAOimpl extends AbstractDAOImpl implements ILenbookDAO {
    public LenbookDAOimpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Lenbook vo) throws SQLException {
        URL url = null;
        try {
            url = new URL(baseUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection httpConn = null;
        try {
            httpConn = (HttpURLConnection)url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.fromObject(vo);
        System.out.println(jsonObject.toString()); // debug statement

        //httpConn.setRequestProperty("Content-type","application/x-javascript->json");
        httpConn.setRequestProperty("Content-type","application/json");
        httpConn.setRequestProperty("Content-length", String.valueOf(jsonObject.toString().length()));
        httpConn.setDoOutput(true);     //需要输出
        httpConn.setDoInput(true);      //需要输入
        httpConn.setUseCaches(false);   //不允许缓存
        try {
            httpConn.setRequestMethod("POST");      //设置POST方式连接
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(httpConn.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            dos.writeBytes(jsonObject.toString());
            //dos.write(jsonObject.toString().getBytes());
            dos.flush();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int resultCode = 0;
        StringBuffer sb = new StringBuffer();
        try {
            resultCode = httpConn.getResponseCode();
            System.out.println(resultCode);

            if (HttpURLConnection.HTTP_OK == resultCode) {

                String readLine = new String();
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
                while ((readLine = responseReader.readLine()) != null) {
                    sb.append(readLine).append("\n");
                }
                responseReader.close();
                System.out.println(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (sb.toString().matches("true"))
            return true;

        return false;
    }

    @Override
    public boolean doUpdate(Lenbook vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Lenbook findById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Lenbook> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Lenbook> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }
}
