<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<main id="main">
	<!-- ======= Contact Section ======= -->
	<section id="contact" class="contact">
		<div class="container">
			<div class="row">
				<div class="col"></div>
				<div class="col-xl-6">
					<h2>비밀번호 변경</h2>
				</div>
				<div class="col"></div>
			</div>
			<form id="changeForm" action="${root }/member/changePWUpdate" method="post">
			<input type="hidden" value="${memberEmail }" id="memberEmail" name="memberEmail">
				<fieldset>
					<div class="row">
						<div class="col"></div>
						<div class="col-xl-6">
							<label for="changePW"><b>User Password (*20자 이내)</b></label> <input
								type="password" placeholder="userpwd" id="changePW"
								name="userpwd" required>
						</div>
						<div class="col"></div>
					</div>

					<div class="row">
						<div class="col"></div>
						<div class="col-xl-6">
							<label for="pwd-repeat"><b>User Password Confirm (*20자 이내)</b></label> 
							<input type="password" placeholder="Repeat Password"
								name="pwd-repeat" id="pwd-repeat" required>
						</div>
						<div class="col"></div>
					</div>
					<div class="row">
						<div class="col"></div>
						<div class="col-xl-6">
							<button type="reset" class="cancelbtn">취소</button>
							<button class="signupbtn" id="changePWBtn">비밀 번호 변경</button>
						</div>
						<div class="col"></div>
					</div>
				</fieldset>
			</form>
		</div>
	</section>
	<!-- End Contact Section -->
</main>
<!-- End #main -->
<script>
$(document).ready(function(){
	$("#"changePWBtn"").click(function(){
		var changePW = $("#changePW").val();
		var pwd-repeat = $('#pwd-repeat').val();
		var memberEmail = $('#memberEmail').val();
		
		if(changePW != pwd-repeat){
			alert("비밀번호를 다시 확인해 주세요!");
		}else{
			$("#changeForm").submit();
		}
	});
})
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />