<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:choose>
  <c:when test="${not empty user}">
  
    <div class="container-fluid">
      <div class= "profileDataBox">
        <div class="row">
          <div class="col align-self-start fc">
            <c:choose>
              <c:when test="${pageContext.response.locale.language == 'es'}">
                <h2><spring:message code="profile.subTitle" />${user.username}</h2>
              </c:when>
              <c:otherwise>
              <h2 id="titleStyle">${user.username}
                <spring:message code="profile.subTitle" />
              </h2>
            </c:otherwise>
          </c:choose>
        </div>
        <div class="col-2">
         <div class="editButtonProfile">
          <img src="${pageContext.request.contextPath}/static/img/default/edit.jpg" alt="edit icon">
          <a class="btn btn-danger" href="${pageContext.request.contextPath}/profile/edit" role="button">
          <spring:message code="action.edit" /></a>
          </div>
        </div>
      </div>
      <div class="row align-items-center">
        <div class="col userElements">
          <p class="elementsDataBox"><spring:message code="profile.firstName" /></p>
          <p class="elementsDataBox"><spring:message code="profile.lastName" /></p>
          <p class="elementsDataBox"><spring:message code="profile.email" /></p>
          <p class="elementsDataBox"><spring:message code="profile.points" /></p>
          <p class="elementsDataBox"><spring:message code="profile.battlesWon" /></p>
          <p class="elementsDataBox"><spring:message code="profile.battlesLost" /></p>
        </div>
        <div class="col">
          <p>win percentage pie chart</p>
        </div>
      </div>
    </div>
    </div>
    <div class="container-fluid ">
    <div class= "profileDataBox">
      <div class="row align-items-center">
        <div class="col-8" id="achievementTable">
          <h3 id="titleStyle"><spring:message code="profile.achievement.title" /></h3>
          <table class="table achTable">
            <thead>
              <tr>
                <th class="achTableHeader achTableData"><spring:message code="profile.achievement.name" /></th>
                <th class="achTableHeader achTableDate"><spring:message code="profile.achievement.unlockedDate" /></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${achievementList}" var="achievement">
                <tr>
                  <td>${achievement.name}</td>
                  <td>${achievement.description}</td>
                  <td>${achievement.points}</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
        <div class="col-4" id="winChart">
          <p>Achievement percentage pie chart</p>
        </div>
      </div>
    </div>
    </div>
  </c:when>
  <c:otherwise>
    <div class="alert alert-danger alert-dismissible" role="alert">
      <p>An error has been occurred</p>
      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
  </c:otherwise>
</c:choose>