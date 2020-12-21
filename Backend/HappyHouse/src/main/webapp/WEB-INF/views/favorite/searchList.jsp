<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<jsp:include page="/WEB-INF/views/common/header.jsp" />

<!-- ======= main ======= -->
<main id="main">
	<form name="pageform" id="pageform" method="GET" action="">
		<input type="hidden" name="action" id="action" value="list"> <input
			type="hidden" name="pg" id="pg" value=""> <input
			type="hidden" name="key" id="key" value="${key}"> <input
			type="hidden" name="word" id="word" value="${word}">
	</form>
	<!-- ======= Contact Section ======= -->
	<section id="contact" class="contact">
		<div class="container">
			<h1>관심 매물</h1>
			<div class="row"></div>
			<div align=right class="mb-3">
				<form action="<c:url value='/fav/searchfavorite' />" method="post" id="searchForm">
					<input type="hidden" name="pg" id="pg" value="1"> 
					<input type="hidden"> 
					<select class="form-control" id="searchKey" name="searchKey">
						<option value="all" selected>전체</option>
						<option value="dong">동</option>
						<option value="aptName">아파트</option>
					</select> <input type="search" class="form-control" id="searchWord" name="searchWord" value="${searchWord}">
					<button id="searchBtn" class="btn btn-secondary">검색</button>
				</form>
			</div>
		
			<table class="table table-striped table-bordered table-hover">
				<thead class="thead-dark">
					<tr>
						<th style="text-align: center;">동</th>
						<th style="text-align: center;">아파트명</th>
						<th style="text-align: center;">건축년도</th>
						<th style="text-align: center;">층</th>
						<th></th>
					</tr>
				</thead>
				<c:forEach var="n" items="${favoriteH }" varStatus="vs">
					<tr>
						<td style="text-align:center;"><a href='${root}/map/detailHouse?no=${n.no}'>${n.dong }</a></td>
						<td style="text-align:center;">${n.aptName }</td>
						<td style="text-align:center;">${n.buildYear }</td>
						<td style="text-align:center;">${n.floor }</td>
						<td style="text-align:center;"><a href="${root}/fav/favoritedelete?no=${n.no}" class="btn btn-primary">삭제</a></td>
					</tr>
				</c:forEach>
				<c:if test="${empty favoriteH}">
					<tr>
						<td colspan="5" class="text-center">관심매물이 존재하지 않습니다.</td>
					</tr>
				</c:if>
			</table>
		
			<table align="center">
				<tr>
					<td>${navigation.navigator}</td>
				</tr>
			</table>
		</div>
	</section>
	<!-- End Contact Section -->
</main>
<!-- End #main -->
<script type="text/javascript">
      $(function(){
    	  $('#searchKey option[value=${searchKey}]').prop('selected', 'selected').change();
         $("#searchBtn").click(function(){
            if ($("#searchWord").val() == "" && $("#searchKey").val() != "all" ) {
               alert("검색어를 입력하세요");
               return false;
            }
           if ($("#searchWord").val() == "" && $("#searchKey").val() == "all" ) {
             location.href="${root}/notice/noticeList";
          }
            $("#searchForm").submit();

         });
     
      });
      $("#allDel").click(function () {
			$("input[name='favoriteNo']").prop("checked", this.checked);
		});
 
      function pageMove(pg) { 
         document.getElementById("pg").value=pg;
         document.getElementById("pageform").action = "${root}/notice?action=list";
         document.getElementById("pageform").submit();
      }
   </script>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />