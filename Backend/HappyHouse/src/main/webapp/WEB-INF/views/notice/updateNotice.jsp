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
         <form id="modifyNotice" method="post"
            action="<c:url value='/notice/modifyNotice' />">
            <fieldset>
               <input type="hidden" name="action" id="action" value="list">
               <div class="form-group" align="left">
                  <input type="text" class="form-control" id="title"
                     name="title" value="${detailNotice.title }" required>
               </div>
               <div class="form-group" align="left">
                  <textarea class="form-control" rows="10" id="content" name="content" >${detailNotice.content }</textarea>
               </div>
               <button id="updateBtn" type="button" class="btn btn-primary">수정</button>
               <button id="listBtn" type="button" class="btn btn-primary">목록</button>
            </fieldset>
         </form>
      </div>
      </div>
      <script type="text/javascript">
       $(function(){
            $("#updateBtn").click(function(){
                $("#modifyNotice").submit();
            });
            $("#listBtn").click(function(){
               location.href="${root}/notice/noticeList";
            });
         });
     </script>
   </main>
   <!-- End #main -->

  <jsp:include page="/WEB-INF/views/common/footer.jsp" />