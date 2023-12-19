package idusw.javaweb.openapia.controller;

import idusw.javaweb.openapia.model.ProjectDTO;
import idusw.javaweb.openapia.util.ConnectionManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet(name="projectController", urlPatterns = { "/project/update", "/project/update-form",
         "/project/list" ,"/project/add", "/project/delete-form",
        "/project/add-form", "/project/login" ,"/project/delete", "/project/detail", "/project/register-form"
        , "/project/register","/project/search"})

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 30, maxRequestSize = 1024 * 1024 * 50)
public class ProjectController extends HttpServlet {
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    ProjectDTO projectDTO = null;
    List<ProjectDTO> projectDTOList = null;
    int cnt = 0;

    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int index = request.getRequestURI().lastIndexOf("/"); // URI에서 마지막 / 위치의 인덱스 값을 반환
        String command = request.getRequestURI().substring(index + 1);
        // HttpSession 유형의 객체가 존재하는 경우 가져오고, 존재하지 않는 경수 생성함, session : 일정 기간 동안 상태 유지
        HttpSession session = request.getSession();

        String sql = null;
        String tableName = "t_prja202012015"; //테이블

        if (command.equals("add")) {
            fileUpload(request, response);
            projectDTO = new ProjectDTO();
            projectDTO.setProjectName(request.getParameter("project-name"));
            projectDTO.setStatus(request.getParameter("status"));
            projectDTO.setProjectDescription(request.getParameter("project-description"));
            projectDTO.setProjectLeader(request.getParameter("project-leader"));
            projectDTO.setProjectImage((String) request.getAttribute("project-image"));

            sql = "insert into " + tableName + "(project_name, project_description ,status, project_leader, project_image) " + "values (?, ?, ?, ?, ?)";

            try (Connection conn = connectionManager.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, projectDTO.getProjectName());
                pstmt.setString(2, projectDTO.getProjectDescription());
                pstmt.setString(3, projectDTO.getStatus());
                pstmt.setString(4, projectDTO.getProjectLeader());
                pstmt.setString(5,projectDTO.getProjectImage());
                cnt = pstmt.executeUpdate();

                if (cnt >= 1) {
                    response.sendRedirect("../project/list");
                } else {
                    request.setAttribute("message", "프로젝트 등록 실패");
                    request.getRequestDispatcher("../errors/fail.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        else if(command.equals("add-form")) {
            request.getRequestDispatcher("../project/add.jsp").forward(request, response);
        }
        else if(command.equals("list")) {
            String orderBy = request.getParameter("orderby");
            String direction = request.getParameter("direction");
            String condition = "";
            if(orderBy!= null && direction != null) condition = " order by "+ orderBy+ " " + direction;
            sql = "select * from " + tableName + condition;
            try (Connection conn = connectionManager.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql);){

                projectDTOList = new ArrayList<>(); //projectDto init
                while(rs.next()) {
                    ProjectDTO project = setRsToDTO(rs);
                    projectDTOList.add(project);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                if(projectDTOList != null){
                    request.setAttribute("dtoList", projectDTOList);
                    request.getRequestDispatcher("../project/list.jsp").forward(request, response);
                } else{
                    request.setAttribute("message", "프로젝트 등록 실패");
                    request.getRequestDispatcher("../errors/fail.jsp").forward(request,response);
                }
            }
        }
        if (command.equals("detail")) {
            projectDTO = new ProjectDTO();
            projectDTO.setPid(Long.valueOf(request.getParameter("pid")));

            sql = "select * from " + tableName + " where pid=" + projectDTO.getPid();

            try (Connection conn = connectionManager.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next()) {
                    projectDTO = setRsToDTO(rs);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                if (projectDTO != null) {
                    request.setAttribute("pDto", projectDTO);
                    request.getRequestDispatcher("../project/detail.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", "프로젝트 상세보기 실패");
                    request.getRequestDispatcher("../errors/fail.jsp").forward(request, response);
                }
            }
        }

        else if(command.equals("update-form")){
            projectDTO = new ProjectDTO();
            projectDTO.setPid(Long.valueOf(request.getParameter("pid")));
            sql = "select *from "+tableName+" where pid=" + projectDTO.getPid();

            try (Connection conn = connectionManager.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)){
                if(rs.next()) {
                    projectDTO = setRsToDTO(rs);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            finally {
                if(projectDTO!= null) {
                    request.setAttribute("pDto", projectDTO);
                    request.getRequestDispatcher("../project/edit.jsp").forward(request, response);                }
                else{
                    request.setAttribute("message", "프로젝트 업데이트 폼 로드 실패");
                    request.getRequestDispatcher("../errors/fail.jsp").forward(request, response);
                }
            }
        }
        else if(command.equals("update")) {
            fileUpload(request, response);
            projectDTO = new ProjectDTO();
            projectDTO.setPid(Long.valueOf(request.getParameter("pid")));
            projectDTO.setProjectName(request.getParameter("project-name"));
            projectDTO.setStatus(request.getParameter("status"));
            projectDTO.setProjectDescription(request.getParameter("project-description"));
            projectDTO.setProjectLeader(request.getParameter("project-leader"));
            projectDTO.setProjectImage((String) request.getAttribute("project-image"));

            sql = "update "+ tableName + " set project_name = ?, project_description = ?, status = ?, project_leader = ?, project_image = ? where pid = ?";
            try (Connection conn = connectionManager.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql);){

                pstmt.setString(1,projectDTO.getProjectName());
                pstmt.setString(2,projectDTO.getProjectDescription());
                pstmt.setString(3,projectDTO.getStatus());
                pstmt.setString(4, projectDTO.getProjectLeader());
                pstmt.setString(5,projectDTO.getProjectImage());
                pstmt.setLong(6, Long.valueOf(request.getParameter("pid")));
                cnt = pstmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                if(cnt>=1){
                    response.sendRedirect("../project/list");
                }
                else{
                    request.setAttribute("message", "프로젝트 업데이트 실패");
                    request.getRequestDispatcher("../errors/fail.jsp").forward(request, response);
                }
            }
        }
        else if (command.equals("delete")) {
            projectDTO = new ProjectDTO();
            projectDTO.setPid(Long.valueOf(request.getParameter("pid")));

            sql = "delete from " + tableName + " where pid = ?";
            try (Connection conn = connectionManager.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql);){
                pstmt.setLong(1, projectDTO.getPid());
                cnt = pstmt.executeUpdate();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }finally {
                if(cnt>=1){
                    response.sendRedirect("../project/list");
                }
                else{
                    request.setAttribute("message", "프로젝트 삭제 실패");
                    request.getRequestDispatcher("../errors.fail.jsp").forward(request, response);
                }
            }
        }
        else if (command.equals("search")) {
            String fieldName = "project_name";
            String by = request.getParameter("by");
            String keyword = request.getParameter("keyword");
            if (by.equals("leader")) {
                fieldName = "project_leader";
            }

            sql = "select * from " + tableName + " where " + fieldName + " like '%" + keyword + "%'";
            try (Connection conn = connectionManager.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                projectDTOList = new ArrayList<>();
                while (rs.next()) {
                    ProjectDTO project = setRsToDTO(rs);
                    projectDTOList.add(project);
                }

                request.setAttribute("dtoList", projectDTOList);
                request.setAttribute("by", by);
                request.setAttribute("keyword", keyword);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                request.getRequestDispatcher("../project/list.jsp").forward(request, response);
            }

        }

    }
    private ProjectDTO setRsToDTO(ResultSet rs) throws SQLException{
        projectDTO = new ProjectDTO();
        projectDTO.setPid(rs.getLong("pid"));
        projectDTO.setProjectName(rs.getString("project_name"));
        projectDTO.setProjectDescription(rs.getString("project_description"));
        projectDTO.setStatus(rs.getString("status"));
        projectDTO.setProjectLeader(rs.getString("project_leader"));

        Timestamp regTimestamp = rs.getDate("reg_timestamp");
        projectDTO.setRegTimestamp(regTimestamp);

        Timestamp revTimestamp = rs.getDate("rev_timestamp");
        projectDTO.setRevTimestamp(revTimestamp);

        projectDTO.setProjectImage(rs.getString("project_image"));

        return projectDTO;
    }
    private static final String SAVE_DIR = "files";
    private String partName = null;
    private String partValue = null;

    public void fileUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + SAVE_DIR;
        System.out.println(appPath);
        File fileSaveDir = new File(savePath);
        if(!fileSaveDir.exists()){
            fileSaveDir.mkdir();
        }
        Collection<Part> parts = request.getParts();
        for (Part part: parts) {
            partName = part.getName();
            if(part.getContentType() != null) {
                partValue = getFileName(part);
                if(partValue!=null && !partValue.isEmpty()) {
                    try {
                        part.write(savePath + File.separator + partValue);
                        System.out.println("success");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            else {
                partValue = request.getParameter(partName);
            }
            request.setAttribute(partName, partValue);
        }
    }
    private String getFileName(Part part){
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items){
            if(s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=")+2, s.length()-1);
            }
        }
        return "";
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
