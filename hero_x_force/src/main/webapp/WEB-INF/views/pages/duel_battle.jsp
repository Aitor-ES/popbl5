<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="duel-result">
  <div class="container-fluid">
    <h2>Battle!</h2>
    <button class="btn bd-highlight mr-1" role="button" onclick="getBattleLog()">Start</button>
    <div id="battle-log"></div>
    <a class="btn btn-lg" id="close-button" href="${pageContext.request.contextPath}/profile/data" role="button" hidden="hidden">
      <spring:message code="action.close"/></a>
  </div>
</section>

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