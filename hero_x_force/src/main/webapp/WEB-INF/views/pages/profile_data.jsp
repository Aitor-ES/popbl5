<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container-fluid">
  <div class="profile-data-box">
    <div class="row">
      <div class="col align-self-start fc">
        <c:choose>
          <c:when test="${pageContext.response.locale.language == 'es'}">
            <h2 id="title-style"><spring:message code="profile.data.subTitle" /> ${user.username}</h2>
          </c:when>
          <c:otherwise>
            <h2 id="title-style">${user.username}<spring:message code="profile.data.subTitle" /></h2>
          </c:otherwise>
        </c:choose>
      </div>
      <div class="col-2">
          <a class="btn btn-lg btn-warning" href="${pageContext.request.contextPath}/profile/edit" role="button">
            <i class="fas fa-cog"></i> <spring:message code="profile.data.edit"/>
          </a>
      </div>
    </div>
    <div class="row align-items-center">
      <div class="col user-elements">
        <p class="elementsDataBox">
          <spring:message code="profile.data.username" />
          ${user.username}
        </p>
        <p class="elementsDataBox">
          <spring:message code="profile.data.email" />
          ${user.email}
        </p>
        <p class="elementsDataBox">
          <spring:message code="profile.data.points" />
          ${user.points}
        </p>
        <p class="elementsDataBox">
          <spring:message code="profile.data.battlesWon" />
          ${user.wins}
        </p>
        <p class="elementsDataBox">
          <spring:message code="profile.data.battlesLost" />
          ${user.loses}
        </p>
      </div>
      <div class="col">
        <p>IKER: win percentage pie chart</p>
      </div>
    </div>
  </div>
</div>
<div class="container-fluid ">
  <div class="profile-data-box">
    <div class="row align-items-center">
      <div class="col-8" id="achievement-table">
        <h3 id="title-style">
          <spring:message code="profile.data.achievement.title" />
        </h3>
        <table class="table ach-table">
          <thead>
            <tr>
              <th class="ach-table-header ach-table-data"><spring:message
                  code="profile.data.achievement.name" /></th>
              <th class="ach-table-header ach-table-date"><spring:message
                  code="profile.data.achievement.unlockedDate" /></th>
              <th class="ach-table-header ach-table-date"><spring:message
                  code="profile.data.achievement.points" /></th>
              <th class="ach-table-header ach-table-date"><spring:message
                  code="profile.data.achievement.description" /></th>
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
      <div class="col-4" id="win-chart">
        <p>IKER: Achievement percentage pie chart</p>
      </div>
    </div>
  </div>
</div>