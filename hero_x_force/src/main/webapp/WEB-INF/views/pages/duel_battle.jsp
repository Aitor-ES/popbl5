<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Start: Duel battle -->
<section id="duel-result">
  <div class="container-fluid">
  
    <!-- Start: Title -->
    <div class="row px-sm-4 pt-4 d-flex justify-content-center">
      <div class="col">
        <h2 class="title-style"><spring:message code="duel.battle.title"/></h2>
      </div>
    </div>
    <!-- End: Title -->
    
    <!-- Start: Card -->
    <div class="card mx-3 mx-sm-5 mt-4 mb-5">
              
      <!-- Battle header -->
      <div class="card-header p-3 bg-dark text-light">
        <div class="row d-flex justify-content-center align-items-center">
        
          <!-- Name -->
          <div class="p-0">
             <p class="mb-0">${match.user2.username} <span class="text-danger"> VS </span> ${match.user1.username}</p>
          </div>
        </div>
      </div>

      <!-- Battle body -->
      <div class="card-body">
        <div id="battle-log"></div>
      </div>
  
      <!-- Battle footer -->
      <div class="card-footer text-muted px-2">
        <div class="row">
          <!-- Close -->
          <div class="col p-0 d-flex justify-content-start align-items-center">
            <div class="row px-sm-4 mb-2">
              <button class="button-style btn btn-lg btn-warning" role="button" onclick="getBattleLog(); this.disabled=true;"><spring:message code="action.start"/></button>
            </div>
          </div>
            
          <!-- Close -->
          <div class="col p-0 d-flex justify-content-end align-items-center">
            <a class="button-style btn btn-lg btn-danger" id="close-button" href="${pageContext.request.contextPath}/profile/data" role="button" hidden="hidden">
              <i class="fas fa-times-circle"></i> <spring:message code="action.close"/>
            </a>
          </div>
        </div>
      </div>
    </div>
    <!-- End: Card -->
    
    <!-- Start: Top button -->
    <button class="button-style btn btn-lg btn-warning" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
    <!-- End: Top button -->
  
  </div>
</section>
<!-- End: Duel create -->    

<!-- Start: Battle script -->
<script>
  var log = document.getElementById('battle-log');
  var interval;
  var html = '';
  var i = 0;
  
  function getBattleLog() {
      $.ajax({
      	url : "${pageContext.request.contextPath}/duel/battle/update",
      	type : 'post',
      	beforeSend : function() {
      	},
      	success : function(data) {
          // WATCH OUT! If you don't return a JSON-formatted string, JSON.parse() will throw an exception
          // and Javascript will stop working. This can happen if the server sends something non-JSON.
          jsonObject = JSON.parse(data);
          
          interval = setInterval(function() {
          	printLine();
          }, 1000);
      	}
      });
  }
  
  function printLine() {
      html += '<p>' + jsonObject[i].battleLogLine + '</p>';
      log.innerHTML = html;
      log.scrollTop = log.scrollHeight;
      i++;
      if (i == jsonObject.length) {
      	clearInterval(interval);
      	var closeBtn = document.getElementById('close-button');
      	closeBtn.removeAttribute('hidden');
      }
  }
</script>
<!-- End: Battle script -->