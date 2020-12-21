<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
  <jsp:include page="/WEB-INF/views/common/header.jsp" />


    <!-- ======= main ======= -->
    <main id="main">
        <!-- ======= Contact Section ======= -->
        <form name="pageform" id="pageform" method="GET" action="">
      <input type="hidden" name="action" id="action" value="memberInformForm">
      <input type="hidden" name="pg" id="pg" value="">
      <input type="hidden" name="key" id="key" value="${key}">
      <input type="hidden" name="word" id="word" value="${word}">
      </form>
        <section id="contact" class="contact">
            <div class="container">
                <h1>회원 정보 검색</h1>
                <div class="row"></div>
                <div align="right">
                   <form action="<c:url value='/member/searchMember' />" method="post" id="searchForm" >
<!--                   <input type="hidden" name="action" id="action" value="searchMember"> -->
                       <input type="hidden" name="pg" id="pg" value="1">
                    
                       <select class="form-control" name="searchKey" id="searchKey">
                          <option value="all">전체</option>
                           <option value="username" >이름</option>
                           <option value="userid">아이디</option>
                       </select>
                       <input type="search" class="form-control" placeholder="검색어 입력" name="searchWord" id="searchWord"  value="${searchWord}">
                       <button id="searchBtn" class="btn btn-secondary">검색</button>
                   </form>
                </div>
                <table class="table table-striped table-bordered table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th style="text-align:center;">아이디</th>
                            <th style="text-align:center;">이름</th>
                            <th style="text-align:center;">이메일</th>
                            <th style="text-align:center;">전화 번호</th>
                            <th style="text-align:center;">회원 삭제</th>
                        </tr>
                    </thead>
                   <c:forEach var="m" items="${members}" varStatus="vs">
                  <tr>
                     <td>${m.userid }</td>
                     <td>${m.username }</td>
                     <td>${m.email }</td>
                     <td>${m.phone }</td>
                     <td style="text-align:center;">
                     <!-- <button type="button" id="deleteBtn" class="btn btn-secondary">회원 탈퇴</button> -->
                     <a href='${root}/member/deleteMemberById?userid=${m.userid }'>회원 탈퇴</a>
                     </td>
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
/* $(function(){
    $("#deleteBtn").click(function(){
       var result = confirm("회원을 탈퇴 시키겠습니까?");
      if(result){
         console.log(m.userid);
         location.href="${root}/member/deleteMemberByID?userid=${m.userid }";
      }

    });
 }); */
 $(function() {
	 $('#searchKey option[value=${searchKey}]').prop('selected', 'selected').change();
      $("#searchBtn").click(function() {
         if ($("#searchWord").val() == "" && $("#searchKey").val() != "all" ) {
            alert("검색어를 입력하세요");
            return false;
         }
         if ($("#searchWord").val() == "" && $("#searchKey").val() == "all" ) {
            location.href="${root}/member/memberInfo";
         }
         $("#searchForm").submit();

      });

   });
/*    function delMember(){
      var result = confirm("회원을 탈퇴 시키겠습니까?");
      if(result){
         return true;
      }else{
          return false;
      }
   } */
/*    function pageMove(pg) { 
      document.getElementById("pg").value=pg;
      document.getElementById("pageform").action = "${root}/member.do?action=searchMember";
      document.getElementById("pageform").submit();
   } */
</script>

  <jsp:include page="/WEB-INF/views/common/footer.jsp" />