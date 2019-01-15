<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="cardlist">
  <div class="container-fluid">
    <div class="row px-4 pt-4">
      <div class="col">
        <h2 class="title-style"><spring:message code="card.list.title"/></h2>
      </div>
    </div>
   </div>
    
  <!-- Start: Back to top button -->
  <button class="btn btn-lg btn-primary" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
  <!-- End: Back to top button -->
</section>