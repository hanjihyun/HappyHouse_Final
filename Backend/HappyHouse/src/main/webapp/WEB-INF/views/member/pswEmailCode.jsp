<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<c:set var="root" value="${pageContext.request.contextPath }"/>
 <jsp:include page="/WEB-INF/views/common/header.jsp" />
 
<section>
<!-- 인증번호 확인 창 -->
<div id="containerPswCode">
  <form class="modal-content animate" action="${root}/member/injeungNumChk" method="post" style="width:50%;">
    <br><br><br>
   <div class="pswCode" style="margin:0 auto;">
   <h2 class="text-center">인증번호 확인</h2>
      <input type="text" placeholder="인증번호 작성" id="pswcode" name="pswcode" autocomplete="off" required><br>
      <input type="hidden" value="${dice }" id="injeungNum" name="injeungNum">
      <input type="hidden" value="${email }" id="memberEmail" name="memberEmail">
       <div style="text-align:center;">
       <button class="signupbtn" type="submit" >확인</button>
      </div>
   </div>
  <div><br><br></div>
     
  </form>
</div>
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />