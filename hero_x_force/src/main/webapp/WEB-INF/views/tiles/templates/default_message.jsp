<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Start: Error messages -->
<c:if test="${not empty error}">
  <div class="alert alert-danger alert-dismissible fade show" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
    <strong><spring:message code="action.error"/> </strong> <spring:message code="${error}"/>
  </div>
</c:if>
<!-- End: Error messages -->

<!-- Start: Success messages -->
<c:if test="${not empty message}">
  <div class="alert alert-success alert-dismissible fade show" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
    <strong><spring:message code="action.success"/> </strong> <spring:message code="${message}"/>
  </div>
</c:if>
<!-- End: Success messages -->