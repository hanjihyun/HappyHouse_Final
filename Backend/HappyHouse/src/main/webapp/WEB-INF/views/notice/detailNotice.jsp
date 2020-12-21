<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
  <jsp:include page="/WEB-INF/views/common/header.jsp" />

   <!-- ======= main ======= -->
   <main id="main">

      <div class="container" align="center">
         <div class="col-xl-8 m-5">
            <h2>${detailNotice.title }</h2>
         
               <input type="hidden" name="pg" id="pg" value="1">
                  <div class="form-group" align="left">
                     <textarea class="form-control" rows="10" disabled="disabled">${detailNotice.content }</textarea>
                  </div>
         <div class="row">
            <div class="col"></div>
            <div class="col-xl-6">
               <button id="cancelbtn2" class="cancelbtn2 btn-secondary">목록</button>
               <button id="updateBtn" class="updateBtn btn-secondary">수정</button>
               <button id="deleteBtn" class="cancelbtn2 btn-secondary">삭제</button>
            </div>
            <div class="col"></div>
         </div>
                  
            
         </div>
      </div>
      
   </main>
   <!-- End #main -->
<script type="text/javascript">
         $(function(){
            $("#cancelbtn2").click(function(){
               location.href="${root}/notice/noticeList";
            });
            $("#updateBtn").click(function(){
               if('${detailNotice.writer}' != '${memberInfo.userid}'){
                  alert("본인의 글만 수정 가능합니다.");
                  return;
               }else{
                  location.href="${root}/notice/updateNotice?no=${detailNotice.noticeNo}";
               }
            });
            $("#deleteBtn").click(function(){
               if('${detailNotice.writer}' != '${memberInfo.userid}'){
                  alert("본인의 글만 삭제 가능합니다.");
                  return;
               }else{
                  location.href="${root}/notice/deleteNotice?no=${detailNotice.noticeNo }";
               }
            });
         });
</script>
  <jsp:include page="/WEB-INF/views/common/footer.jsp" />