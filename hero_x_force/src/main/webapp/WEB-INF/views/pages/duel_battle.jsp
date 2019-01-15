<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Spring tags -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- JSTL tags -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="duel-result">
  <div class="container-fluid">
    <h2>Battle!</h2>
    <a class="btn bd-highlight mr-1" href="${pageContext.request.contextPath}/duel/battle" role="button"
    onclick="updateBattleLog()">Start</a>
    <div id="battle-log"></div>
  </div>
</section>

<script>
	function updateBattleLog() {
		$.ajax({
			url : "${pageContext.request.contextPath}/duel/battle/update",
			type : 'post',
			beforeSend : function() {
			},
			success : function(data) {
				// WATCH OUT! If you don't return a JSON-formatted string, JSON.parse() will throw an exception
				// and Javascript will stop working. This can happen if the server sends something non-JSON.
				var jsonObject = JSON.parse(data);
				console.log(jsonObject);
				
				html = '';
				
				for (var i = 0; i < jsonObject.length; i++) {
					console.log(jsonObject[i].battleLogLine);
					html += '<p>' + jsonObject[i].battleLogLine; + '</p>';
				}
				var log = document.getElementById('battle-log');
				log.innerHTML = html;
				log.scrollTop = log.scrollHeight;
				
				//$('#battle-log').html(html);
			}
		});
	}

	// Runs updateBattleLog() each 3000 ms
	setInterval(updateBattleLog, 3000);
</script>