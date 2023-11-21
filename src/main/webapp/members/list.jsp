<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Simple Tables</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="../../index3.html" class="nav-link">Home</a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="#" class="nav-link">Contact</a>
      </li>
    </ul>

    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
      <!-- Navbar Search -->
      <li class="nav-item">
        <a class="nav-link" data-widget="navbar-search" href="#" role="button">
          <i class="fas fa-search"></i>
        </a>
        <div class="navbar-search-block">
          <form class="form-inline">
            <div class="input-group input-group-sm">
              <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
              <div class="input-group-append">
                <button class="btn btn-navbar" type="submit">
                  <i class="fas fa-search"></i>
                </button>
                <button class="btn btn-navbar" type="button" data-widget="navbar-search">
                  <i class="fas fa-times"></i>
                </button>
              </div>
            </div>
          </form>
        </div>
      </li>

      <!-- Messages Dropdown Menu -->
      <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-comments"></i>
          <span class="badge badge-danger navbar-badge">3</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <a href="#" class="dropdown-item">
            <!-- Message Start -->
            <div class="media">
              <img src="../dist/img/user1-128x128.jpg" alt="User Avatar" class="img-size-50 mr-3 img-circle">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  Brad Diesel
                  <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">Call me whenever you can...</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
              </div>
            </div>
            <!-- Message End -->
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <!-- Message Start -->
            <div class="media">
              <img src="../dist/img/user8-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  John Pierce
                  <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">I got your message bro</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
              </div>
            </div>
            <!-- Message End -->
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <!-- Message Start -->
            <div class="media">
              <img src="../dist/img/user3-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  Nora Silvester
                  <span class="float-right text-sm text-warning"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">The subject goes here</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
              </div>
            </div>
            <!-- Message End -->
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
        </div>
      </li>
      <!-- Notifications Dropdown Menu -->
      <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-bell"></i>
          <span class="badge badge-warning navbar-badge">15</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <span class="dropdown-item dropdown-header">15 Notifications</span>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-envelope mr-2"></i> 4 new messages
            <span class="float-right text-muted text-sm">3 mins</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-users mr-2"></i> 8 friend requests
            <span class="float-right text-muted text-sm">12 hours</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-file mr-2"></i> 3 new reports
            <span class="float-right text-muted text-sm">2 days</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" data-widget="fullscreen" href="#" role="button">
          <i class="fas fa-expand-arrows-alt"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
          <i class="fas fa-th-large"></i>
        </a>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->
  <!-- /.main-sidebar Container -->
 <%@ include file="../main/main-sidebar.jsp"%>><!--               side bar side bar side bar                               -->>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Member manage</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Member manage</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Member List</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap">
                  <thead>
                  <tr>
                    <th>FullName</th>
                    <th>Email</th>
                    <th>PW</th>
                  </tr>
                  </thead>
                  <tbody>
                  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                  <c:forEach var="dto" items="${dtoList}">
                    <tr>
                      <td>${dto.fullName}</td>
                      <td><span class="tag tag-success">${dto.email}</span></td>
                      <td>${dto.pw}</td>
                    </tr>
                  </c:forEach>
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
        </div>
        <!-- /.row -->
        <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">
              <!-- /.card-header -->
<%--              <div class="card-body">--%>
<%--                <table class="table table-bordered">--%>
<%--                  <thead>--%>
<%--                    <tr>--%>
<%--                      <th style="width: 10px">#</th>--%>
<%--                      <th>Task</th>--%>
<%--                      <th>Progress</th>--%>
<%--                      <th style="width: 40px">Label</th>--%>
<%--                    </tr>--%>
<%--                  </thead>--%>
<%--                  <tbody>--%>
<%--                    <tr>--%>
<%--                      <td>1.</td>--%>
<%--                      <td>Update software</td>--%>
<%--                      <td>--%>
<%--                        <div class="progress progress-xs">--%>
<%--                          <div class="progress-bar progress-bar-danger" style="width: 55%"></div>--%>
<%--                        </div>--%>
<%--                      </td>--%>
<%--                      <td><span class="badge bg-danger">55%</span></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>2.</td>--%>
<%--                      <td>Clean database</td>--%>
<%--                      <td>--%>
<%--                        <div class="progress progress-xs">--%>
<%--                          <div class="progress-bar bg-warning" style="width: 70%"></div>--%>
<%--                        </div>--%>
<%--                      </td>--%>
<%--                      <td><span class="badge bg-warning">70%</span></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>3.</td>--%>
<%--                      <td>Cron job running</td>--%>
<%--                      <td>--%>
<%--                        <div class="progress progress-xs progress-striped active">--%>
<%--                          <div class="progress-bar bg-primary" style="width: 30%"></div>--%>
<%--                        </div>--%>
<%--                      </td>--%>
<%--                      <td><span class="badge bg-primary">30%</span></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>4.</td>--%>
<%--                      <td>Fix and squish bugs</td>--%>
<%--                      <td>--%>
<%--                        <div class="progress progress-xs progress-striped active">--%>
<%--                          <div class="progress-bar bg-success" style="width: 90%"></div>--%>
<%--                        </div>--%>
<%--                      </td>--%>
<%--                      <td><span class="badge bg-success">90%</span></td>--%>
<%--                    </tr>--%>
<%--                  </tbody>--%>
<%--                </table>--%>
<%--              </div>--%>
              <!-- /.card-body -->
              <div class="card-footer clearfix">
                <ul class="pagination pagination-sm m-0 float-right">
                  <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
                  <li class="page-item"><a class="page-link" href="#">1</a></li>
                  <li class="page-item"><a class="page-link" href="#">2</a></li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
                </ul>
              </div>
            </div>
            <!-- /.card -->

<%--            <div class="card">--%>
<%--              <div class="card-header">--%>
<%--                <h3 class="card-title">Condensed Full Width Table</h3>--%>
<%--              </div>--%>
<%--              <!-- /.card-header -->--%>
<%--              <div class="card-body p-0">--%>
<%--                <table class="table table-sm">--%>
<%--                  <thead>--%>
<%--                    <tr>--%>
<%--                      <th style="width: 10px">#</th>--%>
<%--                      <th>Task</th>--%>
<%--                      <th>Progress</th>--%>
<%--                      <th style="width: 40px">Label</th>--%>
<%--                    </tr>--%>
<%--                  </thead>--%>
<%--                  <tbody>--%>
<%--                    <tr>--%>
<%--                      <td>1.</td>--%>
<%--                      <td>Update software</td>--%>
<%--                      <td>--%>
<%--                        <div class="progress progress-xs">--%>
<%--                          <div class="progress-bar progress-bar-danger" style="width: 55%"></div>--%>
<%--                        </div>--%>
<%--                      </td>--%>
<%--                      <td><span class="badge bg-danger">55%</span></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>2.</td>--%>
<%--                      <td>Clean database</td>--%>
<%--                      <td>--%>
<%--                        <div class="progress progress-xs">--%>
<%--                          <div class="progress-bar bg-warning" style="width: 70%"></div>--%>
<%--                        </div>--%>
<%--                      </td>--%>
<%--                      <td><span class="badge bg-warning">70%</span></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>3.</td>--%>
<%--                      <td>Cron job running</td>--%>
<%--                      <td>--%>
<%--                        <div class="progress progress-xs progress-striped active">--%>
<%--                          <div class="progress-bar bg-primary" style="width: 30%"></div>--%>
<%--                        </div>--%>
<%--                      </td>--%>
<%--                      <td><span class="badge bg-primary">30%</span></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>4.</td>--%>
<%--                      <td>Fix and squish bugs</td>--%>
<%--                      <td>--%>
<%--                        <div class="progress progress-xs progress-striped active">--%>
<%--                          <div class="progress-bar bg-success" style="width: 90%"></div>--%>
<%--                        </div>--%>
<%--                      </td>--%>
<%--                      <td><span class="badge bg-success">90%</span></td>--%>
<%--                    </tr>--%>
<%--                  </tbody>--%>
<%--                </table>--%>
<%--              </div>--%>
<%--              <!-- /.card-body -->--%>
<%--            </div>--%>
<%--            <!-- /.card -->--%>
<%--          </div>--%>
<%--          <!-- /.col -->--%>
<%--          <div class="col-md-6">--%>
<%--            <div class="card">--%>
<%--              <div class="card-header">--%>
<%--                <h3 class="card-title">Simple Full Width Table</h3>--%>

<%--                <div class="card-tools">--%>
<%--                  <ul class="pagination pagination-sm float-right">--%>
<%--                    <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>--%>
<%--                    <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
<%--                    <li class="page-item"><a class="page-link" href="#">2</a></li>--%>
<%--                    <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
<%--                    <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>--%>
<%--                  </ul>--%>
<%--                </div>--%>
<%--              </div>--%>
<%--              <!-- /.card-header -->--%>
<%--              <div class="card-body p-0">--%>
<%--                <table class="table">--%>
<%--                  <thead>--%>
<%--                    <tr>--%>
<%--                      <th style="width: 10px">#</th>--%>
<%--                      <th>Task</th>--%>
<%--                      <th>Progress</th>--%>
<%--                      <th style="width: 40px">Label</th>--%>
<%--                    </tr>--%>
<%--                  </thead>--%>
<%--                  <tbody>--%>
<%--                    <tr>--%>
<%--                      <td>1.</td>--%>
<%--                      <td>Update software</td>--%>
<%--                      <td>--%>
<%--                        <div class="progress progress-xs">--%>
<%--                          <div class="progress-bar progress-bar-danger" style="width: 55%"></div>--%>
<%--                        </div>--%>
<%--                      </td>--%>
<%--                      <td><span class="badge bg-danger">55%</span></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>2.</td>--%>
<%--                      <td>Clean database</td>--%>
<%--                      <td>--%>
<%--                        <div class="progress progress-xs">--%>
<%--                          <div class="progress-bar bg-warning" style="width: 70%"></div>--%>
<%--                        </div>--%>
<%--                      </td>--%>
<%--                      <td><span class="badge bg-warning">70%</span></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>3.</td>--%>
<%--                      <td>Cron job running</td>--%>
<%--                      <td>--%>
<%--                        <div class="progress progress-xs progress-striped active">--%>
<%--                          <div class="progress-bar bg-primary" style="width: 30%"></div>--%>
<%--                        </div>--%>
<%--                      </td>--%>
<%--                      <td><span class="badge bg-primary">30%</span></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>4.</td>--%>
<%--                      <td>Fix and squish bugs</td>--%>
<%--                      <td>--%>
<%--                        <div class="progress progress-xs progress-striped active">--%>
<%--                          <div class="progress-bar bg-success" style="width: 90%"></div>--%>
<%--                        </div>--%>
<%--                      </td>--%>
<%--                      <td><span class="badge bg-success">90%</span></td>--%>
<%--                    </tr>--%>
<%--                  </tbody>--%>
<%--                </table>--%>
<%--              </div>--%>
<%--              <!-- /.card-body -->--%>
<%--            </div>--%>
<%--            <!-- /.card -->--%>

<%--            <div class="card">--%>
<%--              <div class="card-header">--%>
<%--                <h3 class="card-title">Striped Full Width Table</h3>--%>
<%--              </div>--%>
<%--              <!-- /.card-header -->--%>
<%--              <div class="card-body p-0">--%>
<%--                <table class="table table-striped">--%>
<%--                  <thead>--%>
<%--                    <tr>--%>
<%--                      <th style="width: 10px">#</th>--%>
<%--                      <th>Task</th>--%>
<%--                      <th>Progress</th>--%>
<%--                      <th style="width: 40px">Label</th>--%>
<%--                    </tr>--%>
<%--                  </thead>--%>
<%--                  <tbody>--%>
<%--                    <tr>--%>
<%--                      <td>1.</td>--%>
<%--                      <td>Update software</td>--%>
<%--                      <td>--%>
<%--                        <div class="progress progress-xs">--%>
<%--                          <div class="progress-bar progress-bar-danger" style="width: 55%"></div>--%>
<%--                        </div>--%>
<%--                      </td>--%>
<%--                      <td><span class="badge bg-danger">55%</span></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>2.</td>--%>
<%--                      <td>Clean database</td>--%>
<%--                      <td>--%>
<%--                        <div class="progress progress-xs">--%>
<%--                          <div class="progress-bar bg-warning" style="width: 70%"></div>--%>
<%--                        </div>--%>
<%--                      </td>--%>
<%--                      <td><span class="badge bg-warning">70%</span></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>3.</td>--%>
<%--                      <td>Cron job running</td>--%>
<%--                      <td>--%>
<%--                        <div class="progress progress-xs progress-striped active">--%>
<%--                          <div class="progress-bar bg-primary" style="width: 30%"></div>--%>
<%--                        </div>--%>
<%--                      </td>--%>
<%--                      <td><span class="badge bg-primary">30%</span></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>4.</td>--%>
<%--                      <td>Fix and squish bugs</td>--%>
<%--                      <td>--%>
<%--                        <div class="progress progress-xs progress-striped active">--%>
<%--                          <div class="progress-bar bg-success" style="width: 90%"></div>--%>
<%--                        </div>--%>
<%--                      </td>--%>
<%--                      <td><span class="badge bg-success">90%</span></td>--%>
<%--                    </tr>--%>
<%--                  </tbody>--%>
<%--                </table>--%>
<%--              </div>--%>
<%--              <!-- /.card-body -->--%>
<%--            </div>--%>
<%--            <!-- /.card -->--%>
<%--          </div>--%>
<%--          <!-- /.col -->--%>
<%--        </div>--%>
<%--        <!-- /.row -->--%>
<%--        <div class="row">--%>
<%--          <div class="col-12">--%>
<%--            <div class="card">--%>
<%--              <div class="card-header">--%>
<%--                <h3 class="card-title">Responsive Hover Table</h3>--%>

<%--                <div class="card-tools">--%>
<%--                  <div class="input-group input-group-sm" style="width: 150px;">--%>
<%--                    <input type="text" name="table_search" class="form-control float-right" placeholder="Search">--%>

<%--                    <div class="input-group-append">--%>
<%--                      <button type="submit" class="btn btn-default">--%>
<%--                        <i class="fas fa-search"></i>--%>
<%--                      </button>--%>
<%--                    </div>--%>
<%--                  </div>--%>
<%--                </div>--%>
<%--              </div>--%>
<%--              <!-- /.card-header -->--%>
<%--              <div class="card-body table-responsive p-0">--%>
<%--                <table class="table table-hover text-nowrap">--%>
<%--                  <thead>--%>
<%--                    <tr>--%>
<%--                      <th>FullName</th>--%>
<%--                      <th>Email</th>--%>
<%--                      <th>PW</th>--%>
<%--                    </tr>--%>
<%--                  </thead>--%>
<%--                  <tbody>--%>
<%--                  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--                  <c:forEach var="dto" items="${dtoList}">--%>
<%--                    <tr>--%>
<%--                      <td>${dto.fullName}</td>--%>
<%--                      <td><span class="tag tag-success">${dto.email}</span></td>--%>
<%--                      <td>${dto.pw}</td>--%>
<%--                    </tr>--%>
<%--                  </c:forEach>--%>
<%--                  </tbody>--%>
<%--                </table>--%>
<%--              </div>--%>
<%--              <!-- /.card-body -->--%>
<%--            </div>--%>
<%--            <!-- /.card -->--%>
<%--          </div>--%>
<%--        </div>--%>
<%--        <!-- /.row -->--%>
<%--        <div class="row">--%>
<%--          <div class="col-12">--%>
<%--            <div class="card">--%>
<%--              <div class="card-header">--%>
<%--                <h3 class="card-title">Fixed Header Table</h3>--%>

<%--                <div class="card-tools">--%>
<%--                  <div class="input-group input-group-sm" style="width: 150px;">--%>
<%--                    <input type="text" name="table_search" class="form-control float-right" placeholder="Search">--%>

<%--                    <div class="input-group-append">--%>
<%--                      <button type="submit" class="btn btn-default">--%>
<%--                        <i class="fas fa-search"></i>--%>
<%--                      </button>--%>
<%--                    </div>--%>
<%--                  </div>--%>
<%--                </div>--%>
<%--              </div>--%>
<%--              <!-- /.card-header -->--%>
<%--              <div class="card-body table-responsive p-0" style="height: 300px;">--%>
<%--                <table class="table table-head-fixed text-nowrap">--%>
<%--                  <thead>--%>
<%--                    <tr>--%>
<%--                      <th>ID</th>--%>
<%--                      <th>User</th>--%>
<%--                      <th>Date</th>--%>
<%--                      <th>Status</th>--%>
<%--                      <th>Reason</th>--%>
<%--                    </tr>--%>
<%--                  </thead>--%>
<%--                  <tbody>--%>
<%--                    <tr>--%>
<%--                      <td>183</td>--%>
<%--                      <td>John Doe</td>--%>
<%--                      <td>11-7-2014</td>--%>
<%--                      <td><span class="tag tag-success">Approved</span></td>--%>
<%--                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>219</td>--%>
<%--                      <td>Alexander Pierce</td>--%>
<%--                      <td>11-7-2014</td>--%>
<%--                      <td><span class="tag tag-warning">Pending</span></td>--%>
<%--                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>657</td>--%>
<%--                      <td>Bob Doe</td>--%>
<%--                      <td>11-7-2014</td>--%>
<%--                      <td><span class="tag tag-primary">Approved</span></td>--%>
<%--                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>175</td>--%>
<%--                      <td>Mike Doe</td>--%>
<%--                      <td>11-7-2014</td>--%>
<%--                      <td><span class="tag tag-danger">Denied</span></td>--%>
<%--                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>134</td>--%>
<%--                      <td>Jim Doe</td>--%>
<%--                      <td>11-7-2014</td>--%>
<%--                      <td><span class="tag tag-success">Approved</span></td>--%>
<%--                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>494</td>--%>
<%--                      <td>Victoria Doe</td>--%>
<%--                      <td>11-7-2014</td>--%>
<%--                      <td><span class="tag tag-warning">Pending</span></td>--%>
<%--                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>832</td>--%>
<%--                      <td>Michael Doe</td>--%>
<%--                      <td>11-7-2014</td>--%>
<%--                      <td><span class="tag tag-primary">Approved</span></td>--%>
<%--                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>982</td>--%>
<%--                      <td>Rocky Doe</td>--%>
<%--                      <td>11-7-2014</td>--%>
<%--                      <td><span class="tag tag-danger">Denied</span></td>--%>
<%--                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>--%>
<%--                    </tr>--%>
<%--                  </tbody>--%>
<%--                </table>--%>
<%--              </div>--%>
<%--              <!-- /.card-body -->--%>
<%--            </div>--%>
<%--            <!-- /.card -->--%>
<%--          </div>--%>
<%--        </div>--%>
<%--        <!-- /.row -->--%>
<%--        <div class="row">--%>
<%--          <div class="col-12">--%>
<%--            <div class="card">--%>
<%--              <div class="card-header">--%>
<%--                <h3 class="card-title">Expandable Table</h3>--%>
<%--              </div>--%>
<%--              <!-- ./card-header -->--%>
<%--              <div class="card-body">--%>
<%--                <table class="table table-bordered table-hover">--%>
<%--                  <thead>--%>
<%--                    <tr>--%>
<%--                      <th>#</th>--%>
<%--                      <th>User</th>--%>
<%--                      <th>Date</th>--%>
<%--                      <th>Status</th>--%>
<%--                      <th>Reason</th>--%>
<%--                    </tr>--%>
<%--                  </thead>--%>
<%--                  <tbody>--%>
<%--                    <tr data-widget="expandable-table" aria-expanded="false">--%>
<%--                      <td>183</td>--%>
<%--                      <td>John Doe</td>--%>
<%--                      <td>11-7-2014</td>--%>
<%--                      <td>Approved</td>--%>
<%--                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>--%>
<%--                    </tr>--%>
<%--                    <tr class="expandable-body">--%>
<%--                      <td colspan="5">--%>
<%--                        <p>--%>
<%--                          Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.--%>
<%--                        </p>--%>
<%--                      </td>--%>
<%--                    </tr>--%>
<%--                    <tr data-widget="expandable-table" aria-expanded="true">--%>
<%--                      <td>219</td>--%>
<%--                      <td>Alexander Pierce</td>--%>
<%--                      <td>11-7-2014</td>--%>
<%--                      <td>Pending</td>--%>
<%--                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>--%>
<%--                    </tr>--%>
<%--                    <tr class="expandable-body">--%>
<%--                      <td colspan="5">--%>
<%--                        <p>--%>
<%--                          Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.--%>
<%--                        </p>--%>
<%--                      </td>--%>
<%--                    </tr>--%>
<%--                    <tr data-widget="expandable-table" aria-expanded="true">--%>
<%--                      <td>657</td>--%>
<%--                      <td>Alexander Pierce</td>--%>
<%--                      <td>11-7-2014</td>--%>
<%--                      <td>Approved</td>--%>
<%--                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>--%>
<%--                    </tr>--%>
<%--                    <tr class="expandable-body">--%>
<%--                      <td colspan="5">--%>
<%--                        <p>--%>
<%--                          Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.--%>
<%--                        </p>--%>
<%--                      </td>--%>
<%--                    </tr>--%>
<%--                    <tr data-widget="expandable-table" aria-expanded="false">--%>
<%--                      <td>175</td>--%>
<%--                      <td>Mike Doe</td>--%>
<%--                      <td>11-7-2014</td>--%>
<%--                      <td>Denied</td>--%>
<%--                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>--%>
<%--                    </tr>--%>
<%--                    <tr class="expandable-body">--%>
<%--                      <td colspan="5">--%>
<%--                        <p>--%>
<%--                          Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.--%>
<%--                        </p>--%>
<%--                      </td>--%>
<%--                    </tr>--%>
<%--                    <tr data-widget="expandable-table" aria-expanded="false">--%>
<%--                      <td>134</td>--%>
<%--                      <td>Jim Doe</td>--%>
<%--                      <td>11-7-2014</td>--%>
<%--                      <td>Approved</td>--%>
<%--                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>--%>
<%--                    </tr>--%>
<%--                    <tr class="expandable-body">--%>
<%--                      <td colspan="5">--%>
<%--                        <p>--%>
<%--                          Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.--%>
<%--                        </p>--%>
<%--                      </td>--%>
<%--                    </tr>--%>
<%--                    <tr data-widget="expandable-table" aria-expanded="false">--%>
<%--                      <td>494</td>--%>
<%--                      <td>Victoria Doe</td>--%>
<%--                      <td>11-7-2014</td>--%>
<%--                      <td>Pending</td>--%>
<%--                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>--%>
<%--                    </tr>--%>
<%--                    <tr class="expandable-body">--%>
<%--                      <td colspan="5">--%>
<%--                        <p>--%>
<%--                          Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.--%>
<%--                        </p>--%>
<%--                      </td>--%>
<%--                    </tr>--%>
<%--                    <tr data-widget="expandable-table" aria-expanded="false">--%>
<%--                      <td>832</td>--%>
<%--                      <td>Michael Doe</td>--%>
<%--                      <td>11-7-2014</td>--%>
<%--                      <td>Approved</td>--%>
<%--                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>--%>
<%--                    </tr>--%>
<%--                    <tr class="expandable-body">--%>
<%--                      <td colspan="5">--%>
<%--                        <p>--%>
<%--                          Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.--%>
<%--                        </p>--%>
<%--                      </td>--%>
<%--                    </tr>--%>
<%--                    <tr data-widget="expandable-table" aria-expanded="false">--%>
<%--                      <td>982</td>--%>
<%--                      <td>Rocky Doe</td>--%>
<%--                      <td>11-7-2014</td>--%>
<%--                      <td>Denied</td>--%>
<%--                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>--%>
<%--                    </tr>--%>
<%--                    <tr class="expandable-body">--%>
<%--                      <td colspan="5">--%>
<%--                        <p>--%>
<%--                          Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.--%>
<%--                        </p>--%>
<%--                      </td>--%>
<%--                    </tr>--%>
<%--                  </tbody>--%>
<%--                </table>--%>
<%--              </div>--%>
<%--              <!-- /.card-body -->--%>
<%--            </div>--%>
<%--            <!-- /.card -->--%>
<%--          </div>--%>
<%--        </div>--%>
<%--        <!-- /.row -->--%>
<%--        <div class="row">--%>
<%--          <div class="col-12">--%>
<%--            <div class="card">--%>
<%--              <div class="card-header">--%>
<%--                <h3 class="card-title">Expandable Table Tree</h3>--%>
<%--              </div>--%>
<%--              <!-- ./card-header -->--%>
<%--              <div class="card-body p-0">--%>
<%--                <table class="table table-hover">--%>
<%--                  <tbody>--%>
<%--                    <tr>--%>
<%--                      <td class="border-0">183</td>--%>
<%--                    </tr>--%>
<%--                    <tr data-widget="expandable-table" aria-expanded="true">--%>
<%--                      <td>--%>
<%--                        <i class="expandable-table-caret fas fa-caret-right fa-fw"></i>--%>
<%--                        219--%>
<%--                      </td>--%>
<%--                    </tr>--%>
<%--                    <tr class="expandable-body">--%>
<%--                      <td>--%>
<%--                        <div class="p-0">--%>
<%--                          <table class="table table-hover">--%>
<%--                            <tbody>--%>
<%--                              <tr data-widget="expandable-table" aria-expanded="false">--%>
<%--                                <td>--%>
<%--                                  <i class="expandable-table-caret fas fa-caret-right fa-fw"></i>--%>
<%--                                  219-1--%>
<%--                                </td>--%>
<%--                              </tr>--%>
<%--                              <tr class="expandable-body">--%>
<%--                                <td>--%>
<%--                                  <div class="p-0">--%>
<%--                                    <table class="table table-hover">--%>
<%--                                      <tbody>--%>
<%--                                        <tr>--%>
<%--                                          <td>219-1-1</td>--%>
<%--                                        </tr>--%>
<%--                                        <tr>--%>
<%--                                          <td>219-1-2</td>--%>
<%--                                        </tr>--%>
<%--                                        <tr>--%>
<%--                                          <td>219-1-3</td>--%>
<%--                                        </tr>--%>
<%--                                      </tbody>--%>
<%--                                    </table>--%>
<%--                                  </div>--%>
<%--                                </td>--%>
<%--                              </tr>--%>
<%--                              <tr data-widget="expandable-table" aria-expanded="false">--%>
<%--                                <td>--%>
<%--                                  <button type="button" class="btn btn-primary p-0">--%>
<%--                                    <i class="expandable-table-caret fas fa-caret-right fa-fw"></i>--%>
<%--                                  </button>--%>
<%--                                  219-2--%>
<%--                                </td>--%>
<%--                              </tr>--%>
<%--                              <tr class="expandable-body">--%>
<%--                                <td>--%>
<%--                                  <div class="p-0">--%>
<%--                                    <table class="table table-hover">--%>
<%--                                      <tbody>--%>
<%--                                        <tr>--%>
<%--                                          <td>219-2-1</td>--%>
<%--                                        </tr>--%>
<%--                                        <tr>--%>
<%--                                          <td>219-2-2</td>--%>
<%--                                        </tr>--%>
<%--                                        <tr>--%>
<%--                                          <td>219-2-3</td>--%>
<%--                                        </tr>--%>
<%--                                      </tbody>--%>
<%--                                    </table>--%>
<%--                                  </div>--%>
<%--                                </td>--%>
<%--                              </tr>--%>
<%--                              <tr>--%>
<%--                                <td>219-3</td>--%>
<%--                              </tr>--%>
<%--                            </tbody>--%>
<%--                          </table>--%>
<%--                        </div>--%>
<%--                      </td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>657</td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>175</td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>134</td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>494</td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>832</td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                      <td>982</td>--%>
<%--                    </tr>--%>
<%--                  </tbody>--%>
<%--                </table>--%>
<%--              </div>--%>
<%--              <!-- /.card-body -->--%>
<%--            </div>--%>
<%--            <!-- /.card -->--%>
<%--          </div>--%>
<%--        </div>--%>
        <!-- /.row -->
      </div><!-- /.container-fluid --></div>
      </div>
      </div>
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
