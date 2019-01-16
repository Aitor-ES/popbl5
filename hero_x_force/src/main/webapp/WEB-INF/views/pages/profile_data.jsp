<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<section id="profile-data">
  <div class="container-fluid">
    <div class="row px-4 pt-4">
      <div class="col-lg-10">
        <c:choose>
          <c:when test="${pageContext.response.locale.language == 'es'}">
            <h2 class="title-style"><spring:message code="profile.data.subTitle" /> ${user.username}</h2>
          </c:when>
          <c:otherwise>
            <h2 class="title-style">${user.username}<spring:message code="profile.data.subTitle" /></h2>
          </c:otherwise>
        </c:choose>
      </div>
      <div class="col-lg-2 d-flex justify-content-end align-items-center">
          <a class="btn btn-lg btn-warning" href="${pageContext.request.contextPath}/profile/edit" role="button">
            <i class="fas fa-cog"></i> <spring:message code="action.edit"/>
          </a>
      </div>
    </div>
    
    <div class="row px-5">
      <div class="col-lg-6">
        <div class="row">
          <div class="col">
            <label><spring:message code="profile.data.username" /></label>
            <div class="input-group">
              <div class="input-group-prepend">
              	<span class="input-group-text"><i class="fas fa-user"></i></span>
              </div>
              <input type="text" class="form-control" value="${user.username}" readonly>
            </div>
          </div>
         </div>
      
        <div class="row mt-2">
          <div class="col">
            <label><spring:message code="profile.data.email" /></label>
            <div class="input-group">
              <div class="input-group-prepend">
              	<span class="input-group-text"><i class="fas fa-at"></i></span>
              </div>
              <input type="text" class="form-control" name='email' value="${user.email}" readonly>
            </div>
          </div>
         </div>
                 
        <div class="row mt-2">
          <div class="col">
            <label><spring:message code="profile.data.points" /></label>
            <div class="input-group">
              <div class="input-group-prepend">
              	<span class="input-group-text"><i class="fas fa-medal"></i></span>
              </div>
              <input type="text" class="form-control" name='points' value="${user.points}" readonly>
            </div>
          </div>
         </div>
               
        <div class="row mt-2">
          <div class="col">
            <label><spring:message code="profile.data.battlesWon" /></label>
            <div class="input-group">
              <div class="input-group-prepend">
              	<span class="input-group-text"><i class="fas fa-smile"></i></span>
              </div>
              <input type="text" class="form-control" name='battlesWon' value="${user.wins}" readonly>
            </div>
          </div>
         </div>
         
        <div class="row mt-2">
          <div class="col">
            <label><spring:message code="profile.data.battlesLost" /></label>
            <div class="input-group">
              <div class="input-group-prepend">
              	<span class="input-group-text"><i class="fas fa-sad-tear"></i></span>
              </div>
              <input type="text" class="form-control" name='battlesLost' value="${user.loses}" readonly>
            </div>
          </div>
        </div>
      </div>
      
      <div class="col-lg-6">
        <div id="win-chart" class="mt-4">
          <canvas id="pieChart"></canvas>
          <script>
            pieChart(${user.wins}, ${user.loses})
          </script>
        </div>
      </div>
    </div>
    
    <div class="row px-4 pt-5">
    	<div class="col">
        <h2 class="title-style"><spring:message code="profile.data.achievement.title" /></h2>
      </div>
    </div>
    
    <div class="row px-4 mb-5">
      <div class="col-lg-8">
        <table class="table ach-table">
          <thead>
            <tr>
              <th class="ach-table-header ach-table-data"><spring:message code="profile.data.achievement.name" /></th>
              <th class="ach-table-header ach-table-date"><spring:message code="profile.data.achievement.unlockedDate" /></th>
              <th class="ach-table-header ach-table-date"><spring:message code="profile.data.achievement.points" /></th>
              <th class="ach-table-header ach-table-date"><spring:message code="profile.data.achievement.description" /></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${achievementList}" var="achievement">
              <tr>
                <td>${achievement.name}</td>
                <td>${achievement.date}</td>
                <td>${achievement.points}</td>
                <td>${achievement.description}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
     
      <div class="col-lg-4">
        <!-- Circle chart -->
          <div id="achievement-chart" class="mt-4">
            <div class="c100 p50 big orange">
              <span>50%</span>
              <div class="slice">
                  <div class="bar"></div>
                  <div class="fill"></div>
              </div>
            </div>
          </div>
      </div>
    </div>
  </div>
  
  <!-- Start: Back to top button -->
  <button class="btn btn-lg btn-primary" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
  <!-- End: Back to top button -->
</section>