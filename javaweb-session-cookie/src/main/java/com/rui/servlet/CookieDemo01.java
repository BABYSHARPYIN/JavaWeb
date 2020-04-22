package com.rui.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


//保存用户上一次访问的时间
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //Cookie,服务器端从客户端获取
        Cookie[] cookies = req.getCookies();//这里返回数组，说明Cookie可能存在多个
        //判断Cookie是否存在
        if (cookies!=null){
            out.write("你上一次访问的时间是：");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                //获取cookie的名字
                if (cookie.getName().equals("lastLoginTime")){
                    //获取cookie中的值
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toLocaleString());
                }
            }
        }else{
            out.println("这是您第一次访问本站");
        }
        //服务器给客户端响应一个Cookie
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");
        //cookie有效期为一天
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
