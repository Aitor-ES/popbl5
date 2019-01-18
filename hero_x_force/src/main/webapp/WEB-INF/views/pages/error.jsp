<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- HTML code -->
<!DOCTYPE html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    
    <!-- Remove NetBeans bug -->
    <link rel="shortcut icon" href="#" />
    
    <!-- Custom css -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/error.css"/>" />
    
    <!-- Title -->
    <title><spring:message code="header.appError" /></title>
  </head>
  <body>

    <div id="notfound">
      <div class="notfound">
        <div class="notfound-40X">
          <c:choose>
            <c:when test="${errorCode == 400}">
              <h1>4<span>0</span>0</h1>
            </c:when>
            <c:when test="${errorCode == 401}">
              <h1>4<span>0</span>1</h1>
            </c:when>
            <c:when test="${errorCode == 404}">
              <h1>4<span>0</span>4</h1>
            </c:when>
            <c:when test="${errorCode == 405}">
              <h1>4<span>0</span>5</h1>
            </c:when>
            <c:when test="${errorCode == 500}">
              <h1>5<span>0</span>0</h1>
            </c:when>
            <c:otherwise>
              <h1>6<span>6</span>6</h1>
            </c:otherwise>
          </c:choose>
        </div>
        <c:choose>
          <c:when test="${errorCode == 400}">
            <p><spring:message code="error.400"/></p>
          </c:when>
          <c:when test="${errorCode == 401}">
            <p><spring:message code="error.401"/></p>
          </c:when>
          <c:when test="${errorCode == 404}">
            <p><spring:message code="error.404"/></p>
          </c:when>
          <c:when test="${errorCode == 405}">
            <p><spring:message code="error.405"/></p>
          </c:when>
          <c:when test="${errorCode == 500}">
            <p><spring:message code="error.500"/></p>
          </c:when>
          <c:otherwise>
            <p><spring:message code="error.unknown"/></p>
          </c:otherwise>
        </c:choose>
        <a href="${pageContext.request.contextPath}/"><spring:message code="header.backToHome"/></a> 
      </div>
    </div>
    
  </body>
</html>