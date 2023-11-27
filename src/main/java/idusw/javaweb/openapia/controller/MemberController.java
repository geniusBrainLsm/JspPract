package idusw.javaweb.openapia.controller;

import idusw.javaweb.openapia.model.MemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.reflect.Member;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Controller : 요청의 흐름을 제어하는 역할을 수행
// 데이터 처리 기본 연산 : C.R.U.D (create, read, update, delete)
// HTTP Method (Rest API 관련이 높음) : post, get, (update, delete) - jsp에서는 지원에 문제가 있음
@WebServlet(name="memberController", urlPatterns = {"/members/post", "/members/list", "/members/update",
        "/members/get", "/members/get-list" ,"/members/login-form",
        "/members/login" ,"/members/delete", "/members/logout", "/members/post-form", "/members/get-one"})
public class MemberController extends HttpServlet {
    List<MemberDTO> memberDTOList = new ArrayList<>(); // instance variable

    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // http://localhost:8088/a202312345/members/post
        int index = request.getRequestURI().lastIndexOf("/"); // URI에서 마지막 / 위치의 인덱스 값을 반환
        String command = request.getRequestURI().substring(index + 1);
        //session
        HttpSession session = request.getSession();

        getConnection(); //getConnection() : 정의한 db연결 method
        if(command.equals("post")) { // == vs. equals()
            MemberDTO member = new MemberDTO();
            member.setFullName(request.getParameter("full-name"));
            member.setEmail(request.getParameter("email"));
            member.setZipcode(request.getParameter("zipcode"));
            String pw1 = request.getParameter("pw1");
            String pw2 = request.getParameter("pw2");
            if (pw1.equals(pw2))
                member.setPw(pw1);
            else
                System.out.println("암호 불일치로 작업 중단");
            try {
                stmt = conn.createStatement(); //문장 객체 반환. (sql 질의 처리)
                int cnt = stmt.executeUpdate("insert into t_m202012015(fullname, email, zipcode, pw)  values ('" +
                        member.getFullName() + "', '" +
                        member.getEmail() + "', '" +
                        member.getZipcode() + "', '" +
                        member.getPw() + "')");
                // cnt 가 0이면 질의 실패
                if(cnt != 0){ //성공
                    request.setAttribute("dto", member);
                    //session.setAttribute("dto",member);
                    request.getRequestDispatcher("/members/success.jsp").forward(request,response);
                }
                else{

                    request.getRequestDispatcher("/errors/fail.jsp").forward(request,response);
                    //forward는 request객체를 다음 request에도 유지한다는
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
//        TODO: 회원 가입 성공 메시지와 이동 버튼을 가진 view 호출

//            memberDTOList.add(member);
//            // 매개변수로 전달 - 문자열만 또는 속성(attribute) 전달 - 모든 객체
//            request.setAttribute("dtoList", memberDTOList);
//
//            request.getRequestDispatcher("../members/list.jsp").forward(request, response);
            response.sendRedirect("/members/get-list"); //회원가입하면 get-list로 리다이렉트
        }
        else if(command.equals("get-list")) {
            memberDTOList = new ArrayList<>(); //memberDTOㅣist 초기화
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
        else if (command.equals("login-form")) {
            MemberDTO m = null;
            try {
                stmt = conn.createStatement(); //문장 객체 반환. (sql 질의 처리)
                //select 구문의 경우 row 또는 rows를 반환 >>resultSet
                String query = "select * from t_m202012015 " +
                        "where email ='" + request.getParameter("email")+
                        "' and pw = '" + request.getParameter("pw1")+"'";
                System.out.println(query);
                rs = stmt.executeQuery(query);
                // cnt 가 0이면 질의 실패
                if(rs.next()) {
                    m = new MemberDTO();
                    m.setMid(rs.getLong("mid"));
                    m.setFullName(rs.getString("fullname"));
                    m.setEmail(rs.getString("email"));
                    m.setPw(rs.getString("pw"));
                    memberDTOList.add(m);
                }
                if(m != null){
                    session.setAttribute("dto",m); //scope는 PRSA(page request session application scope 순서)
                    //request.setAttribute("dto",m);
                    request.getRequestDispatcher("../main/index.jsp").forward(request,response);
                }
                else{
                    request.setAttribute("message", "이메일 혹은 비밀번호가 일치하지 않습니다.");
                    request.getRequestDispatcher("/errors/fail.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


//            request.setAttribute("dto", m);
//            request.getRequestDispatcher("../main/index.jsp");
        }
        else if (command.equals("get-one")) {
            MemberDTO member = null;
            try {
                /* stmt = conn.createStatement(); //문장 객체 반환. (sql 질의 처리)
                //select 구문의 경우 row 또는 rows를 반환 >>resultSet
                String query = "select * from t_m202012015 " +
                        "where mid =" + Long.valueOf(request.getParameter("mid"));

                System.out.println(query);*/
                pstmt = conn.prepareStatement("select * from t_m202012015 where mid = ?");
                //여기 ? 는 placeholder임.
                pstmt.setLong(1, Long.valueOf(request.getParameter("mid")));
                rs = pstmt.executeQuery();
                // cnt 가 0이면 질의 실패
                if(rs.next()) {
                    member = new MemberDTO();
                    member.setMid(rs.getLong("mid"));
                    member.setFullName(rs.getString("fullname"));
                    member.setEmail(rs.getString("email"));
                    member.setPw(rs.getString("pw"));
                    member.setZipcode(rs.getString("zipcode"));

                }
                if(member != null){
                    session.setAttribute("dto",member); //scope는 PRSA(page request session application scope 순서)
                    //request.setAttribute("dto",m);
                    request.getRequestDispatcher("../members/detail.jsp").forward(request,response);
                }
                else{
                    //request.setAttribute("message", "이메일 혹은 비밀번호가 일치하지 않습니다.");
                    request.getRequestDispatcher("/errors/fail.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else if (command.equals("update")) {
            MemberDTO member = new MemberDTO();
            member.setMid(Long.valueOf(request.getParameter("mid")));
            member.setFullName(request.getParameter("full-name"));
            member.setEmail(request.getParameter("email"));
            member.setPw(request.getParameter("pw"));
            member.setZipcode(request.getParameter("zipcode"));
            int cnt = 0;
            try {
                /* stmt = conn.createStatement(); //문장 객체 반환. (sql 질의 처리)
                //select 구문의 경우 row 또는 rows를 반환 >>resultSet
                String query = "select * from t_m202012015 " +
                        "where mid =" + Long.valueOf(request.getParameter("mid"));

                System.out.println(query);*/
                pstmt = conn.prepareStatement("update t_m202012015 set fullname = ?, pw = ?, zipcode = ? where mid = ?");
                //여기 ? 는 placeholder임.
                pstmt.setString(1,member.getFullName());
                pstmt.setString(2,member.getPw());
                pstmt.setString(3,member.getZipcode());
                pstmt.setLong(4, member.getMid());
                cnt = pstmt.executeUpdate();
                // cnt 가 0이면 질의 실패
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                if(cnt > 0){
                    request.getRequestDispatcher("../members/get-one?mid=" + member.getMid()).forward(request, response);
                } else{
                    request.getRequestDispatcher("../members/errors.fail.jsp").forward(request, response);
                }
            }

        }
        else if (command.equals("delete")) {
            MemberDTO member = new MemberDTO();
            member.setMid(Long.valueOf(request.getParameter("mid")));
            int cnt = 0;
            try {
                pstmt = conn.prepareStatement("delete from t_m202012015 where mid = ?");
                pstmt.setLong(1, member.getMid());
                cnt = pstmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                if(cnt > 0){
                    request.getRequestDispatcher("../members/deleted.jsp").forward(request, response);
                    session.invalidate();
                } else{
                    request.getRequestDispatcher("../members/errors.fail.jsp").forward(request, response);
                }
            }
        }
        else if (command.equals("logout")) {
            session.invalidate();
            response.sendRedirect("../main/index.jsp"); //request 객체 전달이 필요없는 경우(감사합니다.. 이런거 못띄운다)
            //request.getRequestDispatcher("../main/index.jsp").forward(request, response);
         }
    }
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
        String jdbcUrl = "jdbc:mysql://localhost:3306/db_202012015?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
        String dbUser = "root";
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
}
