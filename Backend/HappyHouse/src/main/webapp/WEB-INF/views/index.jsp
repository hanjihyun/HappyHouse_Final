<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />

<%-- <c:import url="/views/common/header.jsp"/> --%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<style>
.ticker {
 width: 900px;
 height: 140px;
 overflow: hidden;
 margin: 0;
 padding: 0;
 list-style: none;
 border-radius: 5px;
}

</style>
<!-- ======= Hero Section ======= -->
<section id="hero">
	<div class="hero-container" data-aos="fade-up">
		<h1>행복한 우리집</h1>
		<h2>우리 사이트를 소개합니다.</h2>
		<a href="<c:url value="/main/introduce"/>"
			class="btn-get-started scrollto">여기 누르세요 버튼</a>
	</div>
</section>
<!-- End Hero -->

<main id="main">

	<!-- ======= Why Us Section ======= -->
	<section id="why-us" class="why-us">
		<div class="container">

			<div class="section-title" data-aos="zoom-in">
				<h2>오늘의 부동산 핫 이슈는??</h2>
				<h3>
					오늘의 <span>부동산 뉴스</span>?
				</h3>
				<p>***********************************</p>
			</div>

			<div class="row">
				<div class="col-lg mt-4 mt-lg-0">
					<div class="box" data-aos="fade-up" data-aos-delay="100">
						<div class="rolling">
						<h4>부동산 뉴스</h4>
						<div>
					  <ul id="ticker_01" class="ticker">
					  <c:forEach var="n" items="${news}" varStatus="vs">
					      <li style="margin:10px">
					          <a>${n}</a>
					      </li>
					     </c:forEach>
					  </ul>
					  </div>
					</div>
						
       
			
					</div>
				</div>
			</div>

		</div>
	</section>
	<!-- End Why Us Section -->

	<!-- ======= Counts Section ======= -->
	<section id="counts" class="counts">
		<div class="container">

			<div class="row counters">

				<div class="col-lg-3 col-6 text-center">
					<span data-toggle="counter-up">232</span>
					<p>아파트 전월세 건수</p>
				</div>

				<div class="col-lg-3 col-6 text-center">
					<span data-toggle="counter-up">${hoseDealC}</span>
					<p>아파트 매매 건수</p>
				</div>

				<div class="col-lg-3 col-6 text-center">
					<span data-toggle="counter-up">1463</span>
					<p>주택 전월세 건수</p>
				</div>

				<div class="col-lg-3 col-6 text-center">
					<span data-toggle="counter-up">320</span>
					<p>주택 매매 건수</p>
				</div>

			</div>

		</div>
	</section>
	<!-- End Counts Section -->

	<!-- ======= Services Section ======= -->
	<section id="services" class="services">
		<div class="container">

			<div class="section-title" data-aos="zoom-in">
				<h2>Services</h2>
				<h3>
					우리의 다양한 <span>서비스를</span>이용해 보세요
				</h3>
				<p>우리 사이트의 다양한 서비스를 이용해 보세요</p>
			</div>
			<div class="row">
				<div class="col">
					<div class="icon-box" data-aos="zoom-in">
						<div class="icon">
							<i class="bx bxl-dribbble"></i>
						</div>
						<h4>
							<a href="${root }/fav/favoriteList">관심지역 매물입니다.</a>
						</h4>
						<p>내가 관심있는 매물 목록을 확인해 보세요.</p>
					</div>
				</div>
				<div class="col">
					<div class="icon-box" data-aos="zoom-in" data-aos-delay="100">
						<div class="icon">
							<i class="bx bx-file"></i>
						</div>
						<h4>
							<a href="${root }/notice/noticeList">공지사항 입니다.</a>
						</h4>
						<p>우리 홈페이지 공지사항을 확인해 보세요.</p>
					</div>
				</div>
			</div>

		</div>
	</section>
	<!-- End Services Section -->

	<!--     </form> -->

</main>
<script>
function tick(){
    $('#ticker_01 li:first').slideUp(function(){$(this).appendTo($('#ticker_01')).slideDown();});
}
setInterval(function(){tick()},4000);
</script>
<!-- End #main -->
<jsp:include page="/WEB-INF/views/common/footer.jsp" />
<%-- <c:import url="/views/common/footer.jsp"/> --%>
