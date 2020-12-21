<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
  <jsp:include page="/WEB-INF/views/common/header.jsp" />

   <!-- ======= main ======= -->
   <main id="main">
      <div class="container" align="center">
         <div class="col-xl-8 m-5">
            <h2>게시글 쓰기</h2>
            <form id="writeform" method="post" action=""<c:url value='/notice/writeNotice' />"">
               <input type="hidden" name="action" id="action" value="write">
                  <div class="form-group" align="left">
                     <input type="text" class="form-control" placeholder="제목을 입력해주세요" id="title" name="title">
                  </div>
                  <div class="form-group" align="left">
                     <textarea class="form-control" rows="10" placeholder="내용을 입력해주세요" id="content" name="content"></textarea>
                  </div>
                  <button id="writeBtn" class="btn btn-primary">글작성</button>
                  <!-- <button type="reset" class="btn btn-warning">초기화</button> -->
            </form>
         </div>
      </div>
      <script type="text/javascript">
         $(function(){
            $("#writeBtn").click(function(){
               var title = $("#title").val();
               var content = $("#content").val();
               if(title == "" || content == ""){
                  alert("빈칸을 확인해 주세요");
                  return;
               }else{
                  $("#writeform").submit();   
               }
            });
         });
     </script>
   </main>
   <!-- End #main -->
  <jsp:include page="/WEB-INF/views/common/footer.jsp" />