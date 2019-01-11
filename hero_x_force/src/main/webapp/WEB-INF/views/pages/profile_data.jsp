<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:choose>
  <c:when test="${not empty user}">
    <div class="container-fluid ">
      <div class="row">
        <div class="col align-self-start">
          <c:choose>
            <c:when test="${pageContext.response.locale.language == 'es'}">
              <h2><spring:message code="profile.subTitle" />${user.username}</h2>
            </c:when>
            <c:otherwise>
              <h2>${user.username}
                <spring:message code="profile.subTitle" />
              </h2>
            </c:otherwise>
          </c:choose>
        </div>
        <div class="col-2">
          <a class="btn btn-primary" href="${pageContext.request.contextPath}/profile/edit" role="button">
            <spring:message code="action.edit" />
          </a>
        </div>
      </div>
      <div class="row align-items-center">
        <div class="col">
          <p><spring:message code="profile.firstName" /></p>
          <p><spring:message code="profile.lastName" /></p>
          <p><spring:message code="profile.email" /></p>
          <p><spring:message code="profile.points" /></p>
          <p><spring:message code="profile.battlesWon" /></p>
          <p><spring:message code="profile.battlesLost" /></p>
        </div>
        <div class="col">
          <p>win percentage pie chart</p>
        </div>
      </div>
    </div>

    <div class="container-fluid ">
      <div class="row align-items-center">
        <div class="col-8" id="achievementTable">
          <h3><spring:message code="profile.achievement.title" /></h3>
          <table class="table">
            <thead>
              <tr>
                <th><spring:message code="profile.achievement.name" /></th>
                <th><spring:message code="profile.achievement.unlockedDate" /></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>Achievement 1</td>
                <td>12/21/2018</td>
              </tr>
              <tr>
                <td>Achievement 1</td>
                <td>12/21/2018</td>
              </tr>
              <tr>
                <td>Achievement 1</td>
                <td>12/21/2018</td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="col-4" id="winChart">
          <p>Achievement percentage pie chart</p>
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