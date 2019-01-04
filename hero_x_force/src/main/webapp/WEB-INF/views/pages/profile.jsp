<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>Profile</h2>
<c:choose>
  <c:when test="${not empty user}">
    <p>Username: ${user.username}</p>
    <p>Email: ${user.email}</p>
  </c:when>
  <c:otherwise>
    <p>WIP</p>
  </c:otherwise>
</c:choose>