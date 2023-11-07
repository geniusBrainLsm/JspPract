<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ page import="idusw.javaweb.openapia.model.MemberDTO" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!-- JSP 주석,  --%>
<!--
아래는 스크립틀릿(scriptlet) : 스크립팅 요소중 java 문법을 활용하여 처리하고 싶은 경우 사용
JSP 기본 객체 - out, request, response, application ...
JSP 기본 객체 out vs System.out 과는 다른 객체
-->
<%
    ArrayList<MemberDTO> memberList = (ArrayList<MemberDTO>) request.getAttribute("list");
    for(MemberDTO m : memberList)
        out.print(m.getEmail() + " : " + m.getLastName() + m.getFirstName() + "님 가입 환영합니다. <br/>");
%>
</body>
</html>
