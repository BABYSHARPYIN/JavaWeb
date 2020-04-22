package com.rui.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


//保存用户上一次访问的时间
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");

        Cookie[] cookies = req.getCookies();//这里返回数组，说明Cookie可能存在多个
        PrintWriter out = resp.getWriter();
        //判断Cookie是否存在
        if (cookies!=null){
            out.write("你上一次访问的时间是：");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                //获取cookie的名字
                if (cookie.getName().equals("name")){
                    System.out.println(cookie.getValue());
                    out.println(cookie.getValue());
                }
            }
        }else{
            out.println("这是您第一次访问本站");
        }
        Cookie cookie = new Cookie("name", "尹锐");
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
