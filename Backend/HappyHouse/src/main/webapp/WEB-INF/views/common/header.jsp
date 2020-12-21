<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<c:if test="${cookie.ssafy_id.value ne null}">
	<c:set var="saveid" value="${cookie.ssafy_id.value}" />
	<c:set var="idck" value=" checked=\"checked\"" />
</c:if>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Remember Bootstrap Template - Index</title>
<meta content="" name="descriptison">
<meta content="" name="keywords">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link
	href="${root }/resources/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${root }/resources/assets/vendor/icofont/icofont.min.css"
	rel="stylesheet">
<link
	href="${root }/resources/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="${root }/resources/assets/vendor/venobox/venobox.css"
	rel="stylesheet">
<link
	href="${root }/resources/assets/vendor/owl.carousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="${root }/resources/assets/vendor/aos/aos.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="${root }/resources/assets/css/style.css" rel="stylesheet">
<link href="${root }/resources/assets/css/signup.css" rel="stylesheet">


<!-- 페이징 부트스트랩 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id"
	content="63894972582-2jh3ef11vno4sj29rn6j87vstvpe2rs5.apps.googleusercontent.com">


<!-- Vendor JS Files -->

<script src="<c:url value='/resources/assets/vendor/jquery/jquery.min.js'/>"></script>
<script
	src="<c:url value='/resources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
<script
	src="<c:url value='/resources/assets/vendor/jquery.easing/jquery.easing.min.js'/>"></script>
<script
	src="<c:url value='/resources/assets/vendor/php-email-form/validate.js'/>"></script>
<script
	src="<c:url value='/resources/assets/vendor/jquery-sticky/jquery.sticky.js'/>"></script>
<script
	src="<c:url value='/resources/assets/vendor/venobox/venobox.min.js'/>"></script>
<script
	src="<c:url value='/resources/assets/vendor/waypoints/jquery.waypoints.min.js'/>"></script>
<script
	src="<c:url value='/resources/assets/vendor/counterup/counterup.min.js'/>"></script>
<script
	src="<c:url value='/resources/assets/vendor/isotope-layout/isotope.pkgd.min.js'/>"></script>
<script
	src="<c:url value='/resources/assets/vendor/owl.carousel/owl.carousel.min.js'/>"></script>
<script src="<c:url value='/resources/assets/vendor/aos/aos.js'/>"></script>


<!-- Template Main JS File -->
<script src="<c:url value='/resources/assets/js/main.js'/>"></script>
<script>
    $(document).ready(function(){
       $(".nav-link").dropdown();
    });
    <!-- Google Login API -->
  
      function onSignIn(googleUser) {
         var profile = googleUser.getBasicProfile();
         var guserid = profile.getId();
         var gusername = profile.getName();
         var gemail = profile.getEmail();
         console.log('gid:'+guserid+' gusername:'+gusername+' gemail:'+gemail);
         if(${memberInfo == null }){
            $.ajax({
               type: "POST",
               url : "<c:url value='/member/googleLogin' />",
               data: {
                  guserid: guserid,
                  gusername:gusername,
                  gemail: gemail
               },
               dataType: "html",
               success: function(data){
                  alert("로그인 되었습니다"); 
                  location.reload();
               },error:function(request,status,error){
//                    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                  }
            });
         }

      }

        $(function(){
            $("#logoutBtn").click(function(){
               var auth2 = gapi.auth2.getAuthInstance();
                auth2.signOut().then(function () {
                  console.log('User signed out.');
                });
               location.href="${root}/member/logout";
            });
        });
        
      
</script>
</head>

<body>

	<!-- ======= Top Bar ======= -->

	<section id="topbar" class="d-none d-lg-block">


		<div id="header_nav_confirmoff" align="right"
			style="margin-right: 10px;">
			<form id="weatherInfo">
				<P align="left">${temp } ${weather } </P>
			</form>
			<c:if test="${memberInfo == null }">
				<button
					onclick="document.getElementById('id01').style.display='block'"
					class="btn btn-dark">로그인</button>
				<button onclick="location.href = '<c:url value="/member/join" />'"
					class="btn btn-dark" id="signup">회원가입</button>
			</c:if>
		</div>
		<c:if test="${memberInfo != null }">
			<div id="header_nav_confirmoff" align="right"
				style="margin-right: 10px;">
				<strong>${memberInfo.username }</strong>님 환영합니다.
				<button id="logoutBtn" class="btn btn-dark">로그아웃</button>
				<button
					onclick="location.href = '<c:url value="/fav/favoriteList" />'"
					id="favBtn" class="btn btn-dark">관심매물</button>
				<button onclick="location.href = '<c:url value="/member/myPage" />'"
					id="myPage" class="btn btn-dark">마이페이지</button>

				<c:if test="${memberInfo.usertype eq 100}">
					<%-- 	   	  <button onclick = "location.href='${root}/member.do?action=memberInformForm&pg=1&key=&word='" id="ownerPage" class="btn btn-dark"style="display:inline;" >관리자 페이지</button> --%>
					<button
						onclick="location.href = '<c:url value="/member/memberInfo" />'"
						id="ownerPage" class="btn btn-dark" style="display: inline;">관리자
						페이지</button>
				</c:if>
			</div>
		</c:if>
	</section>

	<!-- ======= Header ======= -->
	<header id="header">
		<div class="container d-flex">

			<div class="logo mr-auto">
				<h1 class="text-light">
					<a href="${root}">HappyHouse</a>
				</h1>
				<!-- Uncomment below if you prefer to use an image logo -->
				<!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
			</div>

			<nav class="nav-menu d-none d-lg-block">
				<ul>

					<li><a href="${root}/map/houseSales">매매정보</a></li>
					<%--           <li><a href="${root}/safe/">공지사항</a></li> --%>
					<!-- Dropdown -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbardrop"
						data-toggle="dropdown"> 안전 지역 </a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="${root}/cctv/cctvLocation"
								style="color: black">CCTV 설치된 지역</a> 
							<a class="dropdown-item" href="${root}/cctv/cctvVideo" style="color: black">CCTV 영상 보기</a>
<%-- 							<a href="<c:url value="/cctv/cctvVideo" />">cctv</a> --%>
							<a class="dropdown-item" href="${root}/safety/safetyLevel" style="color: black">안전 지역 통계</a>	
						</div>
					</li>
					<li><a href="<c:url value="/notice/noticeList" />">공지사항</a></li>
					<%--           <li><a href="${root}/corona.jsp">코로나 선별 진료소</a></li> --%>
					<li><a href=" http://localhost:8080/">QnA</a></li>
					<li><a href="<c:url value="/corona/coronaList" />">코로나 선별
							진료소</a></li>

				</ul>
			</nav>
			<!-- .nav-menu -->

		</div>
	</header>
	<!-- End Header -->

	<!-- 로그인 모달창 -->
	<div id="id01" class="modal">

		<form class="modal-content animate" method="post" id="loginForm"
			name="loginForm" style="width: 30%;"
			action='<c:url value="/member/login" />'>
			<input type="hidden" name="action" id="act" value="login">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="close" title="Close Modal">&times;</span>
				<h2>Login</h2>
			</div>

			<div class="containerlogin">
				<input type="text" placeholder="ID" id="userid" name="userid"
					value="${saveid}" required> <input type="password"
					placeholder="Password" id="userpwd" name="userpwd" required>
				<div align="right">
					<label> <input type="checkbox" id="store" name="store"
						value="saveok" ${idck}>아이디 저장
					</label> <a href="<c:url value="/member/findPW"/>">비밀번호 찾기</a>
				</div>
				<div align="center">
					<div class="g-signin2" data-onsuccess="onSignIn"
						onclick="document.getElementById('id01').style.display='none'"
						data-longtitle="true"></div>
				</div>

				<button class="form-button btn-dark" type="submit" id="loginBtn">Login</button>
			</div>
		</form>
	</div>