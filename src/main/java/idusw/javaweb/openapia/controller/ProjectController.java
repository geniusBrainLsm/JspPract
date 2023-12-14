package idusw.javaweb.openapia.controller;

import idusw.javaweb.openapia.model.ProjectDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="projectController", urlPatterns = { "/project/update",
         "/project/list" ,"/project/add",
        "/project/add-form", "/project/login" ,"/project/delete", "/project/detail", "/project/register-form"
        , "/project/register"})
public class ProjectController extends HttpServlet {
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    List<ProjectDTO> projectDTOList = null;

    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = request.getRequestURI().lastIndexOf("/"); // URI에서 마지막 / 위치의 인덱스 값을 반환
        String command = request.getRequestURI().substring(index + 1);
        // HttpSession 유형의 객체가 존재하는 경우 가져오고, 존재하지 않는 경수 생성함, session : 일정 기간 동안 상태 유지
        HttpSession session = request.getSession();
        getConnection();

        if(command.equals("add")) { // == vs. equals()
            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setProjectName(request.getParameter("project-name"));
            projectDTO.setStatus(request.getParameter("status"));
            projectDTO.setProjectDescription(request.getParameter("project-description"));
//            projectDTO.setClientCompany(request.getParameter("client-company"));
            projectDTO.setProjectLeader(request.getParameter("project-leader"));
//            projectDTO.setEstimatedBudget(request.getParameter("estimated-budget"));
            try {
                stmt = conn.createStatement(); //문장 객체 반환. (sql 질의 처리)
                int cnt = stmt.executeUpdate("insert into t_prja202012015(project_name, project_description ,status, project_leader)  values ('" +
                        projectDTO.getProjectName() + "', '" +
                        projectDTO.getProjectDescription() + "', '" +
                        projectDTO.getStatus() + "', '" +
                        projectDTO.getProjectLeader() + "', '" +
                        "')");
                // cnt 가 0이면 질의 실패
                if(cnt != 0){ //성공
                    request.setAttribute("pDto", projectDTO);
                    //session.setAttribute("dto",member);
                    request.getRequestDispatcher("/project/list.jsp").forward(request,response);
                }
                else{
                    request.setAttribute("message", "프로젝트 실패");
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
            response.sendRedirect("/project/list"); //회원가입하면 get-list로 리다이렉트
        }
        else if(command.equals("add-form")) {
            request.getRequestDispatcher("../project/add.jsp").forward(request, response);
        }
        else if(command.equals("list")) {
            projectDTOList = new ArrayList<>(); //projectDto init
            try {
                stmt = conn.createStatement(); //문장 객체 반환. (sql 질의 처리)
                //select 구문의 경우 row 또는 rows를 반환 >>resultSet
                rs = stmt.executeQuery("select * from t_m202012015");
                // cnt 가 0이면 질의 실패
                while(rs.next()) {
                    ProjectDTO projectDTO = new ProjectDTO();
                    projectDTO.setPid(rs.getLong("pid"));
                    projectDTO.setProjectName(rs.getString("project_name"));
                    projectDTO.setProjectDescription(rs.getString("project_description"));
                    projectDTO.setProjectLeader(rs.getString("project_leader"));
                    projectDTO.setStatus(rs.getString("status"));
                    projectDTOList.add(projectDTO);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // Database로 부터 정보를 가져와서 속성으로 저장 후 전달

            request.setAttribute("dtoList", projectDTOList);

            request.getRequestDispatcher("../project/list.jsp").forward(request, response);
        }
        else if(command.equals("detail")) {
            ProjectDTO projectDTO = null;
            String pid = request.getParameter("pid");
            projectDTOList = new ArrayList<>(); //projectDto init
            try {
                stmt = conn.createStatement(); //문장 객체 반환. (sql 질의 처리)
                //select 구문의 경우 row 또는 rows를 반환 >>resultSet
                rs = stmt.executeQuery("select * from t_m202012015 where pid=" + pid);
                // cnt 가 0이면 질의 실패
                if(rs.next()) {
                    //ProjectDTO projectDTO = new ProjectDTO();
                    projectDTO.setPid(rs.getLong("pid"));
                    projectDTO.setProjectName(rs.getString("project_name"));
                    projectDTO.setProjectDescription(rs.getString("project_description"));
                    projectDTO.setStatus(rs.getString("status"));
                    projectDTO.setProjectLeader(rs.getString("project_leader"));
                    projectDTOList.add(projectDTO);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // Database로 부터 정보를 가져와서 속성으로 저장 후 전달

            request.setAttribute("pDto", projectDTO);

            request.getRequestDispatcher("../project/detail.jsp").forward(request, response);
        }
        else if(command.equals("update-form")){
            ProjectDTO projectDTO = null;
            String pid = request.getParameter("pid");
            projectDTOList = new ArrayList<>(); //projectDto init
            try {
                stmt = conn.createStatement(); //문장 객체 반환. (sql 질의 처리)
                //select 구문의 경우 row 또는 rows를 반환 >>resultSet
                rs = stmt.executeQuery("select * from t_m202012015 where pid=" + pid);
                // cnt 가 0이면 질의 실패
                if(rs.next()) {
                    //ProjectDTO projectDTO = new ProjectDTO();
                    projectDTO.setPid(rs.getLong("pid"));
                    projectDTO.setProjectName(rs.getString("project_name"));
                    projectDTO.setProjectDescription(rs.getString("project_description"));
                    projectDTO.setStatus(rs.getString("status"));
                    projectDTO.setProjectLeader(rs.getString("project_leader"));
                    projectDTOList.add(projectDTO);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            request.setAttribute("Pdto", projectDTO);
            request.getRequestDispatcher("../project/edit.jsp");
        }
        else if(command.equals("update")) {
            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setProjectName(request.getParameter("project-name"));
            projectDTO.setStatus(request.getParameter("status"));
            projectDTO.setProjectDescription(request.getParameter("project-description"));
//            projectDTO.setClientCompany(request.getParameter("client-company"));
            projectDTO.setProjectLeader(request.getParameter("project-leader"));
//            projectDTO.setEstimatedBudget(request.getParameter("estimated-budget"));
            try {
                pstmt = conn.prepareStatement("update t_prja202012015 set project_name = ?, " +
                        "project_description = ?, status = ?, project_leader where pid = ?");
                //여기 ? 는 placeholder임.
                pstmt.setString(1,projectDTO.getProjectName());
                pstmt.setString(2,projectDTO.getProjectDescription());
                pstmt.setString(3,projectDTO.getStatus());
                pstmt.setString(4, projectDTO.getProjectLeader());
                pstmt.setLong(5, Long.valueOf(request.getParameter("pid")));
                int cnt = pstmt.executeUpdate();
                // cnt 가 0이면 질의 실패
                if(cnt != 0){ //성공
                    request.setAttribute("pDto", projectDTO);
                    //session.setAttribute("dto",member);
                    request.getRequestDispatcher("/project/list.jsp").forward(request,response);
                }
                else{
                    request.setAttribute("message", "프로젝트 실패");
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
            response.sendRedirect("/project/list"); //회원가입하면 get-list로 리다이렉트
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
//    private Connection conn = null;
//    private Statement stmt = null;
//    private PreparedStatement pstmt = null;
//    private ResultSet rs = null;
    private void getConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/db202012015?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
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
    private ProjectDTO setRsToDTO(ResultSet rs) throws SQLException{
        projectDTO = new ProjectDTO();
        projectDTO = setPid(rs.getLong("pid"));
        pr
    }
}
