package com.ipads.bookadmin.servlet;

import com.ipads.bookadmin.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@WebServlet(name = "booksServlet",urlPatterns = "/pages/back/books/BooksServlet/*")
public class BookServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/pages/errors.jsp"; // 定义错误页面
        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        if(status != null){
            if ("insertPro".equals(status)){
                path = this.insertPro(request);
            }else if("insert".equals(status)){
                System.out.println(path);
                path = this.insert(request,response);
            }else if("listSplit".equals(status)){
                path = this.listSplit(request,response);
            }
        }
        request.getRequestDispatcher(path).forward(request,response);
    }

    public String listSplit(HttpServletRequest request, HttpServletResponse response) {
        int currentPage = 1;
        int lineSize = 1;
        try {
            currentPage = Integer.parseInt(request.getParameter("cp"));
        }catch (Exception e){}
        try {
            lineSize = Integer.parseInt(request.getParameter("ls"));
        }catch (Exception e){}
        String keyWord = request.getParameter("kw");
        String column = request.getParameter("col");
        if(keyWord == null){
            keyWord = "";
        }
        if (column == null){
            column = "name";
        }

        try {
            Map<String,Object> map = ServiceFactory.getBookServiceInstance().listBySplit(column,keyWord,currentPage,lineSize);
            request.setAttribute("allBooks",map.get("allBooks"));
            request.setAttribute("allRecorders",map.get("allCounts"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("url","/pages/back/books/BooksServlet/listSplit");
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("lineSize",lineSize);
        return "/pages/back/books/books_list.jsp";
    }

    public  String insert(HttpServletRequest request, HttpServletResponse response) { //TODO
        return null;
    }

    public String insertPro(HttpServletRequest request)  {
        Map<String,Object> map = null;
        try {
            map = ServiceFactory.getBookServiceInstance().findByAdminAndItem();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("allItems",map.get("allItems"));
        request.setAttribute("allAdmins",map.get("allAdmins"));
        return "/pages/back/books/books_insert.jsp";
    }
}
