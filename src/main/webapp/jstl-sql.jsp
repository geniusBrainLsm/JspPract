<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title> c:sql </title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<sql:setDataSource driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/db_a202012015"
                   user="u_a202012015"
                   password="1234" />

<sql:query var="users" startRow="0" >
    select * from t_m202012015;
<%--    <sql:param value="" />--%>
</sql:query>

<c:forEach var="row" items="${users.rows}">
    ${row.mid} - ${row.fullname} :: ${row.email} :: ${row.pw}<br>
</c:forEach>
</body>
</html>

