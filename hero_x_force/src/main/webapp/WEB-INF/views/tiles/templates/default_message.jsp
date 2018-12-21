<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- JSTL library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Spring library -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Errors -->

<!-- This takes the errors from the dispatcher -->
<c:if test="${not empty error}">
  <div class="alert alert-danger alert-dismissible fade show" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
    <spring:message code="${error}"/>
  </div>
</c:if>

<!-- Messages -->

<!-- This takes the messages from the dispatcher -->
<c:if test="${not empty message}">
  <div class="alert alert-success alert-dismissible fade show" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
    <spring:message code="${message}"/>
  </div>
</c:if>