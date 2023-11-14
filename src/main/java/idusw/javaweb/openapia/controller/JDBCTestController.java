package idusw.javaweb.openapia.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="JDBCTestController", urlPatterns = "/jdbc/test")
public class JDBCTestController extends HttpServlet {
    protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jdbc/test :" + req.getParameter("input"));
        //application context/jdbc/test?input=<내용>
        req.setAttribute("input", req.getParameter("input"));
        req.getRequestDispatcher("../examples/blank.jsp").forward(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //HttpServlet의 doGet메서드 호출
        process(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        process(req,resp);
    }
}
