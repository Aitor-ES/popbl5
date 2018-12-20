<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- FMT library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- JSTL library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:bundle basename="edu.mondragon.lang.View">

<h2>Profile</h2>
<c:choose>
  <c:when test="${not empty user}">
    <p><fmt:message key="userForm.nickname"/> ${user.firstName}</p>
    <p><fmt:message key="userForm.email"/> ${user.email}</p>
  </c:when>
  <c:otherwise>
    <p>WIP</p>
  </c:otherwise>
</c:choose>

</fmt:bundle>