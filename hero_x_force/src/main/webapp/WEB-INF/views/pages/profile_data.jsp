<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Start: Profile data -->
<section id="profile-data">
  <div class="container-fluid">
  
    <!-- Start: Title & Button -->
    <div class="row px-sm-4 pt-4">
    
      <!-- Title -->
      <div class="col-8 col-sm-10">
        <c:choose>
          <c:when test="${pageContext.response.locale.language == 'es'}">
            <h2 class="title-style"><spring:message code="profile.data.subTitle" /> ${user.username}</h2>
          </c:when>
          <c:otherwise>
            <h2 class="title-style">${user.username}<spring:message code="profile.data.subTitle" /></h2>
          </c:otherwise>
        </c:choose>
      </div>
      
      <!-- Button -->
      <div class="col-4 col-sm-2 d-flex justify-content-end align-items-center">
          <a class="button-style btn btn-lg btn-warning" href="${pageContext.request.contextPath}/profile/edit" role="button">
            <i class="fas fa-cog"></i> <spring:message code="action.edit"/>
          </a>
      </div>
    </div>
    <!-- End: Title & Button -->
    
    <!-- Start: Data & Graph -->
    <div class="row px-sm-5 mt-4 mt-sm-2">
      
      <!-- Options -->
      <div class="col-lg-6 p-0">
      
        <!-- User name -->
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
      
        <!-- Email -->
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
         
        <!-- Points -->
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
        
        <!-- Wins -->
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
        
        <!-- Loses -->
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
      
      <!-- Graph -->
      <div class="col-lg-6">
        <div id="win-chart" class="mt-4">
          <canvas id="pieChart"></canvas>
          <script>pieChart(${user.wins}, ${user.loses});</script>
        </div>
      </div>
    </div>
    <!-- End: Data & Graph -->
    
    <!-- Start: Achievement title -->
    <div class="row px-sm-4 pt-5">
    	<div class="col">
        <h2 class="title-style"><spring:message code="profile.data.achievement.title" /></h2>
      </div>
    </div>
    <!-- End: Achievement title -->
    
    <!-- Start: Table & Chart -->
    <div class="row px-sm-5 pt-4 mb-4">
    
      <!-- Table -->
      <div class="col-sm-6">
        <div class="table-overflow-x">
          <table class="mySimpleTable table table-hover">
            <thead class="thead-dark">
              <tr>
                <th><spring:message code="profile.data.achievement.name" /></th>
                <th><spring:message code="profile.data.achievement.unlockedDate" /></th>
                <th><spring:message code="profile.data.achievement.points" /></th>
                <th><spring:message code="profile.data.achievement.description" /></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${userAchievementMapList}" var="userAchievementMap">
                <tr>
                  <td>${userAchievementMap.achievement.name}</td>
                  <td>${userAchievementMap.date} ${userAchievementMap.hour}</td>
                  <td>${userAchievementMap.achievement.points}</td>
                  <td>${userAchievementMap.achievement.description}</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
      
      <!-- Graph -->
      <div class="col-sm-6 mt-2 mt-sm-0 d-flex justify-content-center">
        <!-- Circle chart -->
          <div id="achievement-chart" class="mt-4">
            <div class="c100 p${achievementPercentage} big orange">
              <span>${achievementPercentage}%</span>
              <div class="slice">
                  <div class="bar"></div>
                  <div class="fill"></div>
              </div>
            </div>
          </div>
      </div>
    </div>
    <!-- End: Table & Chart -->
  
    <!-- Start: Top button -->
    <button class="button-style btn btn-lg btn-warning" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
    <!-- End: Top button -->
  
  </div>
</section>
<!-- End: Profile data -->