package com.rui.servlet;


import com.rui.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


//保存用户上一次访问的时间
public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //得到Session
        HttpSession session = req.getSession();
        //给Session中存入信息
        session.setAttribute("name", new Person("尹锐", 21));
        //获取Session的id
        String id = session.getId();
        //判断是不是新的Session
        if (session.isNew()) {
            resp.getWriter().write("session创建成功，SessionID为" + id);
        } else {
            resp.getWriter().write("session已经存在了，SessionID为" + id);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
