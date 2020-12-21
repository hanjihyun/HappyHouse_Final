<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<c:set var="root" value="${pageContext.request.contextPath }" />
  <jsp:include page="/WEB-INF/views/common/header.jsp" />
  
<form class="updateMyInfo" method="post" id="updateMyInfo" action="<c:url value='/member/updateMyInfo' />">
   <div class="container-fluid">
      <div class="row">
         <div class="col"></div>
         <div class="col-xl-6">
            <h2>나의 정보 수정</h2>
         </div>
         <div class="col"></div>
      </div>
      <fieldset>
      
      <div class="row">
               <div class="col"></div>
               <div class="col-xl-6">
                  <label for="id"><b>User ID</b></label> <input type="text"
                     name="userid" id="userid" value="${memberInfo.userid }"
                     required>
               </div>
               <div class="col"></div>
            </div>
            <div class="row">
               <div class="col"></div>
               <div class="col-xl-6">
                  <label for="userpwd1"><b>User Password (*20자 이내)</b></label> <input
                     type="password" placeholder="password" name="userpwd1" id="userpwd1">
               </div>
               <div class="col"></div>
            </div>

            <div class="row">
               <div class="col"></div>
               <div class="col-xl-6">
                  <label for="userpwd2"><b>User Password Confirm (*20자이내)</b></label> <input 
                     type="password" placeholder="Repeat Password"name="userpwd2" id="userpwd2">
               </div>
               <div class="col"></div>
            </div>
            <div class="row">
               <div class="col"></div>
               <div class="col-xl-6">
                  <label for="username"><b>User Name</b></label> <input type="text"
                     name="username" id="username" value="${memberInfo.username }">
               </div>
               <div class="col"></div>
            </div>

            <div class="row">
               <div class="col"></div>
               <div class="col-xl-6">
                  <label for="phone"><b>User CellPhone</b></label> <input
                     type="text" name="phone" id="phone" value="${memberInfo.phone }">
               </div>
               <div class="col"></div>
            </div>

            <div class="row">
               <div class="col"></div>
               <div class="col-xl-6">
                  <label for="email"><b>User E-mail</b></label> <input type="text"
                     name="email" id="email" value="${memberInfo.email }">
               </div>
               <div class="col"></div>
            </div>   
            <div class="row">
            <div class="col"></div>
            <div class="col-xl-6">
               <button type="reset" class="cancelbtn2 btn-secondary">취소</button>
               <button type="button" id="deleteBtn" class="withdraw btn-secondary">회원 탈퇴</button>
               <button type="button" id="updateBtn" class="signupbtn2 btn-secondary">회원 정보 수정</button>
            </div>
            <div class="col"></div>
         </div>
      </fieldset>
   </div>
</form>   
  <script>
   $(function(){
      $("#deleteBtn").click(function(){
         location.href="${root}/member/deleteMemberForm";
      });
      
      $("#updateBtn").click(function(){
   
         if($('#userpwd1').val()!=$('#userpwd2').val()){
            alert("비밀번호를 확인해 주세요");
            
         }else{
            $("#updateMyInfo").submit();
         }
      });
   });
 
   
      </script>
  <jsp:include page="/WEB-INF/views/common/footer.jsp" />