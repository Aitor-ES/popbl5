<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- Errors -->
<fmt:bundle basename="edu.mondragon.lang.Errors">

<!-- This takes the errors from the dispatcher -->
<c:if test="${not empty error}">
  <div class="alert alert-danger alert-dismissible fade show" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
    <strong>Error! </strong> <fmt:message key="${error}"/>
  </div>
</c:if>

</fmt:bundle>

<!-- Messages -->
<fmt:bundle basename="edu.mondragon.lang.Messages">

<!-- This takes the messages from the dispatcher -->
<c:if test="${not empty message}">
  <div class="alert alert-success alert-dismissible fade show" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
    <strong>Success! </strong> <fmt:message key="${message}"/>
  </div>
</c:if>

</fmt:bundle>