<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
  <jsp:include page="/WEB-INF/views/common/header.jsp" />

   <!-- ======= main ======= -->
   <main id="main">
      <form name="pageform" id="pageform" method="GET" action="">
     <input type="hidden" name="pg" id="pg" value="">
      <input type="hidden" name="key" id="key" value="${key}">
      <input type="hidden" name="word" id="word" value="${word}">
      </form>
      <!-- ======= Contact Section ======= -->
      <section id="contact" class="contact">
         <div class="container">
            <h1>공지사항</h1>
            <div class="row"></div>
            <div align=right class="mb-3">
            <form action="<c:url value='/notice/noticeList' />" method="get" id="searchForm">
               <input type="hidden" name="pg" id="pg" value="1"> 
               <select class="form-control" id="searchKey" name="searchKey">
                  <option value="all" selected>전체</option>
                  <option value="title">제목</option>
                  <option value="writer">작성자</option>
               </select> <input type="search" class="form-control" id="searchWord" name="searchWord">
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
            <div align=right>
            <button id="writeBtn" class="btn btn-secondary">글쓰기</button>
            </div>
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
         
         $("#writeBtn").click(function(){
            if("${memberInfo}" == ""){
               alert("로그인 이후 이용해주세요");
               return;
            }else{
               location.href="${root}/notice/writeNotice";
            }
         });
      });
      function pageMove(pg) { 
         document.getElementById("pg").value=pg;
         document.getElementById("pageform").action = "${root}/notice/noticeList";
         document.getElementById("pageform").submit();
      }
   </script>

  <jsp:include page="/WEB-INF/views/common/footer.jsp" />