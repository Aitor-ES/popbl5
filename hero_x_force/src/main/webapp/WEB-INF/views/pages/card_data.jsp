<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Spring tags -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- JSTL tags -->
<!--%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%-->

<section id="card-data">
  <div class="container-fluid">
    <div class="row">
      <div class="card-container col-2">
        <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
          alt="Hero X-Force Logo">
      </div>
      <div class="col">
        <div><h2>Card</h2></div>
        <div><spring:message code="card.data.saga"/></div>
        <div><spring:message code="card.data.type"/></div>
        <div><spring:message code="card.data.ability"/></div>
        <div><p>Special Ability Description</p></div>
      </div>
      <div class="col-1"><a class="btn btn-primary" href="#" role="button"><spring:message code="action.edit"/></a></div>
    </div>
  </div>
  
  <div class="container-fluid">
    <h3><spring:message code="deck.data.stats.title"/></h3>
    <div class="row">
      <div class="col-2"><spring:message code="card.data.stats.table.stats.heading"/></div>
      <div class="col-4"><spring:message code="card.data.stats.table.value.heading"/></div>
      <div class="col-4"><spring:message code="card.data.stats.table.ranking.heading"/></div>
      <div class="col-2"><spring:message code="card.data.stats.table.balance.heading"/></div>
    </div>
    <div class="row">
      <div class="col-2">
        <div><spring:message code="card.data.stats.table.stats.hp"/></div>
        <div><spring:message code="card.data.stats.table.stats.attack"/></div>
        <div><spring:message code="card.data.stats.table.stats.defense"/></div>
        <div><spring:message code="card.data.stats.table.stats.magicAttack"/></div>
        <div><spring:message code="card.data.stats.table.stats.magicDefense"/></div>
        <div><spring:message code="card.data.stats.table.stats.speed"/></div>
      </div>
      <div class="col-4">
        <div>Span 6</div>
        <div>Span 6</div>
        <div>Span 6</div>
        <div>Span 6</div>
        <div>Span 6</div>
        <div>Span 6</div>
      </div>
      <div class="col-4">
        <div>Span 6</div>
        <div>Span 6</div>
        <div>Span 6</div>
        <div>Span 6</div>
        <div>Span 6</div>
        <div>Span 6</div>
      </div>
      <div class="col-2">
        <div>Span 6</div>
      </div>
    </div>
  </div>
</section>