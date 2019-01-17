<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Start: Ranking -->
<section id="ranking">
  <div class="container-fluid">
  
    <!-- Start: Title -->
    <div class="row px-sm-4 pt-4">
      <div class="col">
        <h2 class="title-style"><spring:message code="ranking.title" /></h2>
      </div>
    </div>
    <!-- End: Title -->
    
    <!-- Start: Table -->
    <div class="row px-sm-5 pt-4">
      <div class="col">
        <div class="table-overflow-x">
          <table class="myTable table table-hover">
            <thead class="thead-dark">
              <tr>
                <th><spring:message code="ranking.table.number" /></th>
                <th><spring:message code="ranking.table.username" /></th>
                <th><spring:message code="ranking.table.battlesWon" /></th>
                <th><spring:message code="ranking.table.battlesLost" /></th>
                <th><spring:message code="ranking.table.points" /></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${ranking}" var="user">
                <tr>
                  <td>${user.user_id}</td>
                  <td>${user.username}</td>
                  <td>${user.wins}</td>
                  <td>${user.loses}</td>
                  <td>${user.points}</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <!-- End: Table -->
 
    <!-- Start: Top button -->
    <button class="btn btn-lg btn-warning" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
    <!-- End: Top button -->
  
  </div>
</section>
<!-- End: Ranking -->