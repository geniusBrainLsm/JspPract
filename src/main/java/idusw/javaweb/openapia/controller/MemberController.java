package idusw.javaweb.openapia.controller;

import idusw.javaweb.openapia.model.MemberDTO;
import idusw.javaweb.openapia.model.ProjectDTO;
import idusw.javaweb.openapia.util.ConnectionManager;
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
@WebServlet(name="memberController", urlPatterns = {"/members/post", "/members/update",
        "/members/get", "/members/list" ,
        "/members/login-form", "/members/login" ,"/members/delete", "/members/logout", "/members/post-form", "/members/detail", "/members/register-form"
, "/members/register"})
public class MemberController extends HttpServlet {
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    int cnt = 0;
    String sql = null;
    String tableName = "t_m202012015";
    List<MemberDTO> memberDTOList = new ArrayList<>(); // instance variable
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int index = request.getRequestURI().lastIndexOf("/"); // URI에서 마지막 / 위치의 인덱스 값을 반환
        String command = request.getRequestURI().substring(index + 1);
        //session
        HttpSession session = request.getSession();


        if(command.equals("register")) {
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

            String sql = "insert into "+tableName+"(full_name, email, zipcode, pw) values (?, ?, ?, ?)";
            try(Connection conn = connectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, member.getFullName());
                pstmt.setString(2, member.getEmail());
                pstmt.setString(3, member.getZipcode());
                pstmt.setString(4, member.getPw());
                cnt = pstmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            finally{
                if(cnt >= 1){ //성공
                    request.setAttribute("dto", member);
                    request.getRequestDispatcher("/members/success.jsp").forward(request,response);
                } else{
                    request.setAttribute("message", "회원 등록 실패");
                    request.getRequestDispatcher("../errors/fail.jsp").forward(request,response);
                }
            }
        }
        else if(command.equals("register-form")) {
            request.getRequestDispatcher("../members/register.jsp").forward(request, response);
        }
        else if(command.equals("list")) {
            memberDTOList = new ArrayList<>(); //memberDTOList 초기화
            String sql = "select * from " + tableName;
            try(Connection conn = connectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                rs = pstmt.executeQuery();
                while(rs.next()) {
                    MemberDTO m = setRsToDTO(rs);
                    memberDTOList.add(m);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            finally{
                if(memberDTOList != null){ //회원 목록이 있을 경우
                    request.setAttribute("dtoList", memberDTOList);
                    request.getRequestDispatcher("../members/list.jsp").forward(request,response);
                } else{
                    request.setAttribute("message", "회원 목록이 없습니다.");
                    request.getRequestDispatcher("../errors/fail.jsp").forward(request,response);
                }
            }
        }

        else if (command.equals("login")) {
            MemberDTO m = null;
            String sql = "select * from "+tableName+" where email = ? and pw = ?";
            try (Connection conn = connectionManager.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, request.getParameter("email"));
                pstmt.setString(2, request.getParameter("pw1"));
                rs = pstmt.executeQuery();
                if(rs.next()) {
                    m = setRsToDTO(rs);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if(m != null){
                session.setAttribute("dto",m); //scope는 PRSA(page request session application scope 순서)
                request.getRequestDispatcher("../main/index.jsp").forward(request,response);
            }
            else{
                request.setAttribute("message", "이메일 혹은 비밀번호가 일치하지 않습니다.");
                request.getRequestDispatcher("/errors/fail.jsp").forward(request, response);
            }
        }

        else if (command.equals("login-form")) {
            request.getRequestDispatcher("../members/login.jsp").forward(request, response);
        }
        else if (command.equals("detail")) {
            MemberDTO member = null;
            String sql = "select * from "+tableName+" where mid = ?";
            try (Connection conn = connectionManager.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setLong(1, Long.valueOf(request.getParameter("mid")));
                rs = pstmt.executeQuery();
                if(rs.next()) {
                    member = setRsToDTO(rs);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if(member != null){
                session.setAttribute("dto",member); //scope는 PRSA(page request session application scope 순서)
                request.getRequestDispatcher("../members/detail.jsp").forward(request,response);
            }
            else{
                request.getRequestDispatcher("/errors/fail.jsp").forward(request, response);
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
            String sql = "update "+tableName+" set full_name = ?, pw = ?, zipcode = ? where mid = ?";
            try (Connection conn = connectionManager.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, member.getFullName());
                pstmt.setString(2, member.getPw());
                pstmt.setString(3, member.getZipcode());
                pstmt.setLong(4, member.getMid());
                cnt = pstmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if(cnt > 0){
                request.getRequestDispatcher("../members/detail?mid=" + member.getMid()).forward(request, response);
            } else{
                request.getRequestDispatcher("../members/fail.jsp").forward(request, response);
            }
        }

        else if (command.equals("delete")) {
            MemberDTO member = new MemberDTO();
            member.setMid(Long.valueOf(request.getParameter("mid")));
            int cnt = 0;
            String sql = "delete from "+tableName+" where mid = ?";
            try (Connection conn = connectionManager.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
    private MemberDTO setRsToDTO(ResultSet rs) throws SQLException{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMid(rs.getLong("mid"));
        memberDTO.setEmail(rs.getString("email"));
        memberDTO.setZipcode(rs.getString("zipcode"));
        memberDTO.setPw(rs.getString("pw"));
        memberDTO.setFullName(rs.getString("full_name"));
        return memberDTO;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

}
