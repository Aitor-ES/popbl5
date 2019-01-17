<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section id="card-data">
  <div class="container-fluid">
    <div class="row px-4 pt-4 mb-4">
      <div class="col-10">
        <h2 class="title-style">${card.name}</h2>
      </div>
    </div>
    
    <div class="row">
      <div class="col-sm-5 col-12 ml-5">
        <div class="heroCardFather" id="card${card.cardId}">
          <div class="heroCardStatic">
            <div class="cardImg" style="background-image: url('${pageContext.request.contextPath}/static/img/card/heroes/${card.name}.png')"></div>
            <img class="templateImg"
              src="${pageContext.request.contextPath}/static/img/card/templates/${fn:toLowerCase(card.type)}-template.png"
              alt="edit icon">
            <div class="titleArea">
            <script>changeTitleFontSize();</script>
              <div class="heroName" id="${card.name}">${card.name}</div>
            </div>
            <div class="stats">
              <div class="ATK statName">ATK</div>
              <div class="DEF statName">DEF</div>
              <div class="SPD statName">SPD</div>
              <div class="HP statName">HP</div>
              <div class="MATK statName">MATK</div>
              <div class="MDEF statName">MDEF</div>
               <div class="ATK_VAL statValue" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.atk}</div>
                <div class="DEF_VAL statValue" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.def}</div>
                <div class="SPD_VAL statValue" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.spd}</div>
                <div class="HP_VAL statValue" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.hp}</div>
                <div class="MATK_VAL statValue" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.magAtk}</div>
                <div class="MDEF_VAL statValue" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.magDef}</div>
            </div>
            <div class="sagaArea">
              <div class="saga">${card.saga}</div>
            </div>
            <div class="levelArea">
              <c:forEach var="i" begin="1" end="${card.stars}">
                <div class="levelStar"></div>
              </c:forEach>
            </div>
            <div class="abilityArea">
              <div class="abilityTitle">SPECIAL ABILITY:</div>
				<div class="abilityName" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.ability.name}</div>
            </div>
          </div>
        </div>
      </div>
      
      <div class="col-sm-6 col-12">
        <div class="row">
          <div class="col">
            <label><spring:message code="card.data.saga" /></label>
            <div class="input-group">
              <div class="input-group-prepend">
                <span class="input-group-text"><i class="fas fa-gamepad"></i></span>
              </div>
              <input type="text" class="form-control" value="${card.saga}" readonly>
            </div>
          </div>
        </div>
        
        <div class="row mt-2">
          <div class="col">
            <label><spring:message code="card.data.type" /></label>
            <div class="input-group">
              <div class="input-group-prepend">
                <span class="input-group-text"><i class="fas fa-star"></i></span>
              </div>
              <input type="text" class="form-control" name='email' value="${card.type}" readonly>
            </div>
          </div>
         </div>
                   
        <div class="row mt-2">
          <div class="col">
            <label><spring:message code="card.data.ability" /></label>
            <div class="input-group">
              <div class="input-group-prepend">
                <span class="input-group-text"><i class="fab fa-phoenix-squadron"></i></span>
              </div>
              <input type="text" class="form-control" name='points' value="${card.ability.name}" readonly>
            </div>
          </div>
         </div>
                 
        <div class="row mt-2">
          <div class="col">
            <label><spring:message code="card.data.description" /></label>
            <div class="input-group">
              <div class="input-group-prepend">
                <span class="input-group-text"><i class="fas fa-pencil-alt"></i></span>
              </div>
              <textarea rows="3" class="form-control" name='battlesWon' style="resize:none" readonly>${card.ability.description}</textarea>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    <div class="row px-4 pt-4 mb-4">
      <div class="col-12 col-sm-4">
        <h2 class="title-style"><spring:message code="card.data.stats.title"/></h2>
        <div class="table-overflow-x">
          <table class="mySimpleTable table table-hover">
            <thead class="thead-dark">
              <tr>
                <th><spring:message code="card.data.stats.table.stats.heading" /></th>
                <th><spring:message code="card.data.stats.table.value.heading" /></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td><spring:message code="card.data.stats.table.stats.hp"/></td>
                <td>${card.hp}</td>
              </tr>
              <tr>
                <td><spring:message code="card.data.stats.table.stats.attack"/></td>
                <td>${card.atk}</td>
              </tr>
              <tr>
                <td><spring:message code="card.data.stats.table.stats.defense"/></td>
                <td>${card.def}</td>
              </tr>
              <tr>
                <td><spring:message code="card.data.stats.table.stats.magicAttack"/></td>
                <td>${card.magAtk}</td>
              </tr>
              <tr>
                <td><spring:message code="card.data.stats.table.stats.magicDefense"/></td>
                <td>${card.magDef}</td>
              </tr>
              <tr>
                <td><spring:message code="card.data.stats.table.stats.speed"/></td>
                <td>${card.spd}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      
      <div class="col-12 col-sm-4">
        <h2 class="title-style"><spring:message code="card.data.bar.title"/></h2>
        <canvas class="col-12 mt-5" id="horizontalBar" ></canvas>
       
      </div>
      
      <div class="col-12 col-sm-4">
        <h2 class="title-style"><spring:message code="card.data.balance.title"/></h2>
        <div id="chart" class="radar-chart">
         
          <!-- CHART -->
        </div>
      </div>
      <div class="col-2 radar-col">
         <div id="chart" class="radar-chart">
 
       <script>
        var config = {
                maxValue: 200,
                levels: 5,
                fontFamily: "orbitron",
                fontSize: "1.3rem"
          }
          $.ajax({
          	  data: {id: "${card.cardId}"},
          	  url: "${pageContext.request.contextPath}/card/stats",
          	  type: 'get',
          	  beforeSend: function(){
      		  },
      	  	  success: function(data){
      			  var jsonObject = JSON.parse(data);
      			  console.log(jsonObject);
      			 
      	          //Call function to draw the Radar chart
      	          drawHorizontalBarChart(jsonObject);
      	          radar_chart.draw("#chart", jsonObject, config);
      		  }
  		  });
          
        </script>
       </div>
      </div>
    </div>
 </div>
  <!-- Start: Back to top button -->
  <button class="btn btn-lg btn-primary" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
  <!-- End: Back to top button -->  
</section>