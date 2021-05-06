<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <title>Welcome</title>
  <style>
    * {box-sizing: border-box;}

    /* Style the navbar */
    .topnav {
      overflow: hidden;
      background-color: #e9e9e9;
    }

    /* Navbar links */
    .topnav a {
      float: left;
      display: block;
      color: black;
      text-align: center;
      padding: 14px 16px;
      text-decoration: none;
      font-size: 17px;
    }

    /* Navbar links on mouse-over */
    .topnav a:hover {
      background-color: #ddd;
      color: black;
    }

    /* Active/current link */
    .topnav a.active {
      background-color: #2196F3;
      color: white;
    }

    /* Style the input container */
    .topnav .login-container {
      float: right;
    }

    /* Style the input field inside the navbar */
    .topnav input[type=text] {
      padding: 6px;
      margin-top: 8px;
      font-size: 17px;
      border: none;
      width: 150px; /* adjust as needed (as long as it doesn't break the topnav) */
    }

    /* Style the button inside the input container */
    .topnav .login-container button {
      float: right;
      padding: 6px;
      margin-top: 8px;
      margin-right: 16px;
      background: #ddd;
      font-size: 17px;
      border: none;
      cursor: pointer;
    }

    .topnav .login-container button:hover {
      background: #ccc;
    }

    /* Add responsiveness - On small screens, display the navbar vertically instead of horizontally */
    @media screen and (max-width: 600px) {
      .topnav .login-container {
        float: none;
      }
      .topnav a, .topnav input[type=text], .topnav .login-container button {
        float: none;
        display: block;
        text-align: left;
        width: 100%;
        margin: 0;
        padding: 14px;
      }
      .topnav input[type=text] {
        border: 1px solid #ccc;
      }
    }
  </style>

</head>
<body>
<div class="container">
  <div class="topnav">
    <p>Hello <c:out value="${userRole}"/></p>
    <a href="/demo/">Home</a>
    <a class="active" href="/demo/home">User Home</a>
    <c:choose>
      <c:when test="${userRole=='ROLE_ANONYMOUS'}">
        <a href="/login">Login</a>
      </c:when>
      <c:otherwise>
        <a href="/logout">Logout</a>
      </c:otherwise>
    </c:choose>
  </div>

  <h2>Person List</h2>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Email</th>
    </tr>
    </thead>
    <tbody>
      <c:forEach var="person" items="${persons}">
        <tr>
          <td><c:out value="${person.id}" /></td>
          <td><c:out value="${person.firstName}" /></td>
          <td><c:out value="${person.lastName}" /></td>
          <td><c:out value="${person.email}" /></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <c:if test="${userRole=='ROLE_ADMIN'}">
    <h2>User List</h2>
    <table class="table">
      <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Username</th>
        <th scope="col">Role</th>
        <th scope="col">Person ID</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="user" items="${users}">
        <tr>
          <td><c:out value="${user.id}" /></td>
          <td><c:out value="${user.username}" /></td>
          <td><c:out value="${user.userRole}" /></td>
          <td><c:out value="${user.personId}" /></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:if>

</div>
</body>
</html>
