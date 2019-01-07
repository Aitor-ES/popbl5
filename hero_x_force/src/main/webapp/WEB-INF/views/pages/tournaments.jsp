<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>



<!-- Spring library -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- JSTL library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<h2>
  <spring:message code="tournaments.header" />
</h2>
<button type="submit" class="btn btn-primary">
  <spring:message code="tournaments.create" />
</button>
<h2>
  <spring:message code="tournaments.join" />
</h2>
<!--  <c:forEach items="${tournamentList}" var="tournament">
    <div id="accordion">
      <div class="card">
        <div class="card-header" id="heading-${tournament.id}">
          <h5 class="mb-0">
            <button class="btn btn-link" data-toggle="collapse"
              data-target="#collapse-${tournament.id}"
              aria-expanded="true"
              aria-controls="collapse-${tournament.id}">${tournament.name}</button>
          </h5>
        </div>
        <div id="collapse-${tournament.id}" class="collapse"
          aria-labelledby="heading-${tournament.id}"
          data-parent="#accordion">
          <div class="card-body">
           <ul class="list-group">
             <c:forEach items="${tournament}" var="user">
               <li class="list-group-item">${user.username}</li>
             </c:forEach>
          </ul>
            <button type="submit" class="btn btn-success">
              <spring:message code="tournaments.join" />
            </button>
          </div>
        </div>
      </div>
      </div>
  </c:forEach> -->

<div id="accordion">
  <div class="card">
    <div class="card-header" id="headingOne">
      <h5 class="mb-0">
        <button class="btn btn-link" data-toggle="collapse"
          data-target="#collapseOne" aria-expanded="true"
          aria-controls="collapseOne">T1</button>
      </h5>
    </div>
    <div id="collapseOne" class="collapse" aria-labelledby="headingOne"
      data-parent="#accordion">
      <div class="card-body">
        <ul class="list-group">
          <li class="list-group-item">iMewndi</li>
          <li class="list-group-item">ETA</li>
          <li class="list-group-item">GRAPO</li>
          <li class="list-group-item">GAL</li>
          <li class="list-group-item">ALQAEDA</li>
        </ul>
        <button type="submit" class="btn btn-success">
          <spring:message code="tournaments.join" />
        </button>
      </div>
    </div>
  </div>

  <div class="card">
    <div class="card-header" id="headingTwo">
      <h5 class="mb-0">
        <button class="btn btn-link" data-toggle="collapse"
          data-target="#collapseTwo" aria-expanded="true"
          aria-controls="collapseTwo">T2</button>
      </h5>
    </div>

    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
      data-parent="#accordion">
      <div class="card-body">
        <ul class="list-group">
          <li class="list-group-item">iMewndi</li>
          <li class="list-group-item">Dapibus ac facilisis in</li>
          <li class="list-group-item">Morbi leo risus</li>
          <li class="list-group-item">Porta ac consectetur ac</li>
          <li class="list-group-item">Vestibulum at eros</li>
        </ul>
        <button type="submit" class="btn btn-success">
          <spring:message code="tournaments.join" />
        </button>
      </div>
    </div>
  </div>

  <div class="card">
    <div class="card-header" id="headingThree">
      <h5 class="mb-0">
        <button class="btn btn-link" data-toggle="collapse"
          data-target="#collapseThree" aria-expanded="true"
          aria-controls="collapseThree">T3</button>
      </h5>
    </div>

    <div id="collapseThree" class="collapse"
      aria-labelledby="headingThree" data-parent="#accordion">
      <div class="card-body">
        <ul class="list-group">
          <li class="list-group-item">iMewndi</li>
          <li class="list-group-item">Dapibus ac facilisis in</li>
          <li class="list-group-item">Morbi leo risus</li>
          <li class="list-group-item">Porta ac consectetur ac</li>
          <li class="list-group-item">Vestibulum at eros</li>
        </ul>
        <button type="submit" class="btn btn-success">
          <spring:message code="tournaments.join" />
        </button>
      </div>
    </div>
  </div>

  <div class="card">
    <div class="card-header" id="headingFour">
      <h5 class="mb-0">
        <button class="btn btn-link" data-toggle="collapse"
          data-target="#collapseFour" aria-expanded="true"
          aria-controls="collapseFour">T4</button>
      </h5>
    </div>

    <div id="collapseFour" class="collapse"
      aria-labelledby="headingFour" data-parent="#accordion">
      <div class="card-body">
        <ul class="list-group">
          <li class="list-group-item">iMewndi</li>
          <li class="list-group-item">Dapibus ac facilisis in</li>
          <li class="list-group-item">Morbi leo risus</li>
          <li class="list-group-item">Porta ac consectetur ac</li>
          <li class="list-group-item">Vestibulum at eros</li>
        </ul>
        <button type="submit" class="btn btn-success">
          <spring:message code="tournaments.join" />
        </button>
      </div>
    </div>
  </div>

  <div class="card">
    <div class="card-header" id="headingFive">
      <h5 class="mb-0">
        <button class="btn btn-link" data-toggle="collapse"
          data-target="#collapseFive" aria-expanded="true"
          aria-controls="collapseFive">T5</button>
      </h5>
    </div>

    <div id="collapseFive" class="collapse"
      aria-labelledby="headingFive" data-parent="#accordion">
      <div class="card-body">
        <ul class="list-group">
          <li class="list-group-item">iMewndi</li>
          <li class="list-group-item">Dapibus ac facilisis in</li>
          <li class="list-group-item">Morbi leo risus</li>
          <li class="list-group-item">Porta ac consectetur ac</li>
          <li class="list-group-item">Vestibulum at eros</li>
        </ul>
        <button type="submit" class="btn btn-success">
          <spring:message code="tournaments.join" />
        </button>
      </div>
    </div>
  </div>

</div>

