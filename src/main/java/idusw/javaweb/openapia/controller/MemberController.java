package idusw.javaweb.openapia.controller;

import idusw.javaweb.openapia.model.MemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Controller : 요청의 흐름을 제어하는 역할을 수행
// 데이터 처리 기본 연산 : C.R.U.D (create, read, update, delete)
// HTTP Method (Rest API 관련이 높음) : post, get, (update, delete) - jsp에서는 지원에 문제가 있음
@WebServlet(name="memberController", urlPatterns = {"/members/post", "/members/list", "/members/update",
        "/members/get", "/members/get-list" ,"/members/login-form",
        "/members/login" ,"/members/delete", "/members/logout", "/members/post-form"})
public class MemberController extends HttpServlet {
    List<MemberDTO> memberDTOList = new ArrayList<>(); // instance variable
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private void getConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/db_a202012015?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
        String dbUser = "u_a202012015";
        String dbPass = "1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver를 메모리에 적재
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } try {
            conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);  //dbms 연결

            /*
            rs = stmt.executeQuery("select * from member");
            System.out.println("Connection Success - " + jdbcUrl);
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.println(rs.getString(2));
            }
             */

        } catch(SQLException e) {
            System.out.println("Connection Fail - ");
        } finally {

//            if (rs != null) try { rs.close(); } catch (Exception e) {}
//            if (pstmt != null) try {pstmt.close(); } catch (Exception e) {}
//            if (stmt != null) try {stmt.close(); } catch (Exception e) {}
//            if (conn != null) try {conn.close(); } catch (Exception e) {}

        }
    }
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // http://localhost:8088/a202312345/members/post
        int index = request.getRequestURI().lastIndexOf("/"); // URI에서 마지막 / 위치의 인덱스 값을 반환
        String command = request.getRequestURI().substring(index + 1);
        getConnection(); //getConnection() : 정의한 db연결 method
        if(command.equals("post")) { // == vs. equals()
            MemberDTO member = new MemberDTO();
            member.setFullName(request.getParameter("full-name"));
            member.setEmail(request.getParameter("email"));
            String pw1 = request.getParameter("pw1");
            String pw2 = request.getParameter("pw2");
            if (pw1.equals(pw2))
                member.setPw(pw1);
            else
                System.out.println("암호 불일치로 작업 중단");
            try {
                stmt = conn.createStatement(); //문장 객체 반환. (sql 질의 처리)
                int cnt = stmt.executeUpdate("insert into t_mb202012015(fullname, email, pw)  values ('" +
                        member.getFullName() + "', '" +
                        member.getEmail() + "', '" +
                        member.getPw() + "')");
                // cnt 가 0이면 질의 실패

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

//            memberDTOList.add(member);
//            // 매개변수로 전달 - 문자열만 또는 속성(attribute) 전달 - 모든 객체
//            request.setAttribute("dtoList", memberDTOList);
//
//            request.getRequestDispatcher("../members/list.jsp").forward(request, response);
            response.sendRedirect("/members/get-list"); //회원가입하면 get-list로 리다이렉트
        }
        else if(command.equals("get-list")) {
            try {
                stmt = conn.createStatement(); //문장 객체 반환. (sql 질의 처리)
                //select 구문의 경우 row 또는 rows를 반환 >>resultSet
                rs = stmt.executeQuery("select * from t_m202012015");
                // cnt 가 0이면 질의 실패
                while(rs.next()) {
                    MemberDTO m = new MemberDTO();
                    m.setMid(rs.getLong(1));
                    m.setFullName(rs.getString("fullName"));
                    m.setEmail(rs.getString("email"));
                    m.setPw(rs.getString("pw"));
                    memberDTOList.add(m);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // Database로 부터 정보를 가져와서 속성으로 저장 후 전달

            request.setAttribute("dtoList", memberDTOList);

            request.getRequestDispatcher("../members/list.jsp").forward(request, response);
        }
        else if(command.equals("post-form")) {
            request.getRequestDispatcher("../members/register.jsp").forward(request, response);
        }
    }
}
