<template>
  <div id="app">
    <section id="topbar" class="d-none d-lg-block">
      <div id="header_nav_confirmoff" align="right" style="margin-right: 10px;">
        <strong>한지현</strong>님 환영합니다.
				<button id="logoutBtn" class="btn btn-dark">로그아웃</button>
        <button onclick="" id="favBtn" class="btn btn-dark">관심매물</button>
				<button onclick="" id="myPage" class="btn btn-dark">마이페이지</button>
      </div>
    </section>

   <header id="header">
		<div class="container d-flex">

			<div class="logo mr-auto">
				<h1 class="text-light">
					<a href="http://localhost:8001/happyHouse/">HappyHouse</a>
				</h1>
				<!-- Uncomment below if you prefer to use an image logo -->
				<!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
			</div>

			<nav class="nav-menu d-none d-lg-block">
				<ul>

					<li><a href="http://localhost:8001/happyHouse/map/houseSales">매매정보</a></li>
					<!-- Dropdown -->
					<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbardrop"	data-toggle="dropdown"> 안전 지역 </a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="" style="color: black">CCTV 설치된 지역</a> 
							<a class="dropdown-item" href="" style="color: black">CCTV 영상 보기</a>
							<a class="dropdown-item" href="" style="color: black">안전 지역 통계</a>	
						</div>
					</li>
					<li><a href="http://localhost:8001/happyHouse/notice/noticeList">공지사항</a></li>
					<li><a href=" http://localhost:8080/">QnA</a></li>
					<li><a href="http://localhost:8001/happyHouse/corona/coronaList">코로나 선별 진료소</a></li>

				</ul>
			</nav>
			<!-- .nav-menu -->

		</div>
	</header>
  </div>
</template>
