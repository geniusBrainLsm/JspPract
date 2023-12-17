<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>LSM | Projects</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
  <!-- navbar -->
  <%@ include file="../main/navbar.jsp"%>>
  <!-- /.navbar -->
  <!-- main-sidebar Container -->
  <%@ include file="../main/main-sidebar.jsp"%>>
  <!-- /.main-sidebar Container -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Projects</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Projects</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card">
        <div class="card-header">
          <h3 class="card-title">Projects</h3>

          <div class="card-tools">
            <div class = "input-group input-group-sm">
              <form action="../project/search" method="get">
                <div class="input-group-append">
                  <select name="by" id ="inputStatus" class="form-control custom-select">
                    <c:choose>
                      <c:when test="${by == 'leader'}">
                        <option>name</option>
                        <option selected>leader</option>
                      </c:when>
                      <c:otherwise>
                        <option selected>name</option>
                        <option>leader</option>
                      </c:otherwise>
                    </c:choose>

                  </select>
                  <input type="text" name="keyword" value="${keyword}" class="form-control float-right" placeholder="Project Name">
                  <button type="submit" class="btn btn-default">
                    <i class="fas fa-search"></i>
                  </button>
                </div>

              </form>
            </div>
          </div>
        </div>
        <div class="card-body p-0">
          <table class="table table-striped projects">
            <thead>
            <tr>
              <th style="width: 1%">
                Project ID
              </th>
              <th style="width: 20%">
                Project Name
                <a href="../project/list?orderby=project_name&direction=asc"><i class="fas fa-arrow-up"></i></a>
                <a href="../project/list?orderby=project_name&direction=desc"><i class="fas fa-arrow-down"></i></a>
              </th>
              <th style="width: 30%">
                Team Leader
              </th>
              <th>
                Project Progress
              </th>
              <th style="width: 8%" class="text-center">
                Status
              </th>
              <th style="width: 20%">
              </th>
            </tr>
            </thead>
            <tbody>
            <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
            <c:forEach var="dto" items="${requestScope.dtoList}">
            <tr>
              <td>
                ${dto.pid}
              </td>
              <td>
                <a>
                  ${dto.projectName}
                </a>
                <br/>
                <small>
                  Created ${dto.regTimestamp}
                </small>
              </td>
              <td>
                <ul class="list-inline">
                  <li class="list-inline-item">
                    <img alt="Avatar" class="table-avatar" src="../dist/img/avatar.png">
                  </li>
                  ${dto.projectLeader}
                </ul>
              </td>
              <td class="project_progress">
                <div class="progress progress-sm">
                  <div class="progress-bar bg-green" role="progressbar" aria-valuenow="57" aria-valuemin="0" aria-valuemax="100" style="width: 57%">
                  </div>
                </div>
                <small>
                    ${dto.revTimestamp}
                </small>
              </td>
              <td class="project-state">
                <span class="badge badge-success">Success</span>
              </td>
              <td class="project-actions text-right">
                <a class="btn btn-primary btn-sm" href="../project/detail?pid=${dto.pid}">
                  <i class="fas fa-folder">
                  </i>
                  Detail
                </a>
                <a class="btn btn-info btn-sm" href="../project/update-form?pid=${dto.pid}">
                  <i class="fas fa-pencil-alt">
                  </i>
                  Edit
                </a>
                <a class="btn btn-danger btn-sm" href="../project/delete?pid=${dto.pid}">
                  <i class="fas fa-trash">
                  </i>
                  Delete
                </a>
              </td>
            </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <footer class="main-footer">
    <div class="float-right d-none d-sm-block">
      <b>Version</b> 3.2.0
    </div>
    <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="../plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../dist/js/demo.js"></script>
</body>
</html>
