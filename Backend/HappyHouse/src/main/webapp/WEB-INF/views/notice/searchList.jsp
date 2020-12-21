<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
  <jsp:include page="/WEB-INF/views/common/header.jsp" />

   <!-- ======= main ======= -->
   <main id="main">
      <form name="pageform" id="pageform" method="GET" action="">
      <input type="hidden" name="action" id="action" value="list">
      <input type="hidden" name="pg" id="pg" value="">
      <input type="hidden" name="key" id="key" value="${key}">
      <input type="hidden" name="word" id="word" value="${word}">
      </form>
      <!-- ======= Contact Section ======= -->
      <section id="contact" class="contact">
         <div class="container">
            <h1>검색결과</h1>
            <div class="row"></div>
            <div align=right class="mb-3">
            <form action="<c:url value='/notice/searchNotice' />" method="post"
               id="searchForm">
               <input type="hidden" name="pg" id="pg" value="1"> <input
                  type="hidden"> <select class="form-control" id="searchKey"
                  name="searchKey">
                  <option value="all">전체</option>
                  <option value="title">제목</option>
                  <option value="writer">작성자</option>
               </select> <input type="search" class="form-control" id="searchWord" name="searchWord" value="${searchWord}"> 
               <button id="searchBtn" class="btn btn-secondary">검색</button>
            </form>
         </div>
            
            <table class="table table-striped table-bordered table-hover">
               <thead class="thead-dark">
                  <tr>
                     <th style="text-align:center;">번호</th>
                     <th style="text-align:center;">제목</th>
                     <th style="text-align:center;">작성자</th>
                     <th style="text-align:center;">날짜</th>
                  </tr>
               </thead>
               <c:forEach var="n" items="${notices}" varStatus="vs">
               <tr>
               
                  <td>${n.noticeNo }</td>
                  <td>
                  <a href="${root}/notice/detailNotice?no=${n.noticeNo}">${n.title }</a>
                  </td>
                  <td>${n.writer }</td>
                  <td>${n.date }</td>
               </tr>
               </c:forEach>
            </table>
            <table align="center">
                 <tr>
                    <td>
                    ${navigation.navigator}
                    </td>
                 </tr>
              </table>
         </div>
        </section><!-- End Contact Section -->
    </main><!-- End #main -->
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
/*       function pageMove(pg) { 
         document.getElementById("pg").value=pg;
         document.getElementById("pageform").action = "${root}/notice?action=list";
         document.getElementById("pageform").submit();
      } */
   </script>

  <jsp:include page="/WEB-INF/views/common/footer.jsp" />