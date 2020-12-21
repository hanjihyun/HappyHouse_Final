<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<c:set var="root" value="${pageContext.request.contextPath }" />
  <jsp:include page="/WEB-INF/views/common/header.jsp" />

<form class="deleteMember" method="post" id="deleteMember" action='<c:url value="/member/deleteMember" />'>
   <div class="container-fluid">
      <div class="row">
         <div class="col"></div>
         <div class="col-xl-6">
            <h2>회원 탈퇴</h2>
            
         </div>
         <div class="col"></div>
      </div>
      <fieldset>
         <div class="row">
            <div class="col"></div>
            <div class="col-xl-6">
               <input type="hidden" name="userid" id="userid" value="${memberInfo.userid }" required>
               <input type="hidden" name="password" id="password" value="${memberInfo.userpwd }" required>
               <h4>${memberInfo.userid } 님</h4>
               
            </div>
            <div class="col"></div>
         </div>
         <div class="row">
            <div class="col"></div>
            <div class="col-xl-6">
               <label for="userpw"><b>비밀번호를 입력하세요.</b></label>
               <input type="password" placeholder="Password" id="userpw" name="userpw" required>
            </div>
            <div class="col"></div>
         </div>

         <div class="row">
            <div class="col"></div>
            <div class="col-xl-6">
               <button id="cancle" class="cancelbtn btn-secondary">취소</button>
               <input type="button" id="deleteBtn" class="deleteBtn btn-secondary" value="회원 탈퇴">
            </div>
            <div class="col"></div>
         </div>
      </fieldset>
   </div>
</form>   
  <script>
  $(document).ready(function() {
     $("#deleteBtn").click(function(){
        if($('#userpw').val()!=$('#password').val()){
            alert("비밀번호를 확인해 주세요");
            $("#userpwd").focus();
            return false;
         }
         location.href="${root}/member/deleteMember";
      });
     
      $("#cancle").click(function(){
         location.href='<c:url value="/member/myPage" />';
      });
      $("#deleteMember").submit(function(){
      
         if($('#userpw').val()!=$('#password').val()){
            alert("비밀번호를 확인해 주세요");
            $("#userpwd").focus();
            return false;
         }
      });
//       $("#deleteBtn").click(function(){
//          var pwd1 = $("#userpwd").val();
//          var pwd2 = $("#password").val();
//          console.log(pwd1);
//          console.log(pwd2);
//          if(pwd1 != pwd2){
//             alert("비밀번호를 확인해 주세요");
//             $("#userpwd").focus();
//             return false;
//          }else{
//             $("#deleteMember").submit();
//          }
//       });   
   });
 
   </script>
  <jsp:include page="/WEB-INF/views/common/footer.jsp" />
     