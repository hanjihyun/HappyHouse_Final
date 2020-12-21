<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
  <jsp:include page="/WEB-INF/views/common/header.jsp" />

<form class="signupForm" method="post" id="signupForm" action='<c:url value="/member/join" />' ">
   <input type="hidden" name="action" id="act" value="join">
   <div class="container-fluid">
      <div class="row">
         <div class="col"></div>
         <div class="col-xl-6">
            <h2>Join Member</h2>
         </div>
         <div class="col"></div>
      </div>
      <fieldset>
         <div class="row">
            <div class="col"></div>
            <div class="col-xl-6">
               <label for="joinUserid"><b>User ID (*20자 이내)</b></label> 
               <input type="text" placeholder="ID" name="userid" id="joinUserid" required>
            </div>
            <div class="col"></div>
         </div>
         <div class="row">
            <div class="col"></div>
            <div class="col-xl-6">
               <label for="joinUserpwd"><b>User Password (*20자 이내)</b></label> 
               <input type="password" placeholder="Password" id="joinUserpwd" name="userpwd" required>
            </div>
            <div class="col"></div>
         </div>

         <div class="row">
            <div class="col"></div>
            <div class="col-xl-6">
               <label for="pwd-repeat"><b>User Password Confirm (*20자
                     이내)</b></label> <input type="password" placeholder="Repeat Password"
                  name="pwd-repeat" id="pwd-repeat" required>
            </div>
            <div class="col"></div>
         </div>


         <div class="row">
            <div class="col"></div>
            <div class="col-xl-6">
               <label for="joinUsername"><b>User Name (*10자 이내)</b></label> <input
                  type="text" placeholder="Name" name="username" id="joinUsername" required>
            </div>
            <div class="col"></div>
         </div>

         <div class="row">
            <div class="col"></div>
            <div class="col-xl-6">
               <label for="phone"><b>User CellPhone (*20자 이내)</b></label> <input
                  type="text" placeholder="01012345678" name="phone" id="phone"
                  required>
            </div>
            <div class="col"></div>
         </div>

         <div class="row">
            <div class="col"></div>
            <div class="col-xl-6">
               <label for="email"><b>User E-mail (*50자 이내)</b></label> <br> <input
                  type="text" placeholder="example@example.com" name="email" name="email" id="email"
                  style="width: 50%;" required> 
               <input type="hidden"
                  name="codeValue" id="codeValue" value="0">
               <button type="button" class="emailCheck" 
                  style="width: 45%; position: absolute; right: 3%" id="sendEmailCode">인증번호 전송</button>
            </div>
            <div class="col"></div>
         </div>
         
         <div class="row">
            <div class="col"></div>
            <div class="col-xl-6">
               <input type="text" placeholder="인증번호" name="code" id="code"
                  style="width: 50%;" required> 
               <input type="hidden"
                  name="codeChecked" id="codeChecked" value="0">
               <button type="button" class="emailCheck"
                  style="width: 45%; position: absolute; right: 3%" id="codeCheck">인증번호 확인</button>
            </div>
            <div class="col"></div>
         </div>
         
         <div class="row">
            <div class="col"></div>
            <div class="col-xl-6">
               <button type="reset" class="cancelbtn btn-dark">취소</button>
               <button type="button" class="signupbtn btn-dark" id="join">회원가입</button>
            </div>
            <div class="col"></div>
         </div>
      </fieldset>
   </div>
</form>   

<script>
$(document).ready(function(){
   $("#sendEmailCode").click(function(){
      event.preventDefault();
      var email = $('#email').val();
      if(email==""){
         alert("이메일을 작성하세요.");
         $("#userId").focus();
         return false;
      }
      alert('이메일이 발송되었습니다. 인증번호를 확인해주세요!');
      $.ajax({
         url:"${root}/member/sendEmailCode/"+email,
         type:'GET',
         success:function(data){
            $('#codeValue').val(data);
         }, error:function(request,status,error){
              alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
             }
      });
   });
   $("#codeCheck").click(function(){
      var code = $('#code').val();
      var codeValue = $('#codeValue').val();
      if(code!=codeValue){
         alert('인증번호가 일치하지않습니다. 인증번호를 다시 확인해주세요.');
         $("#code").focus();
         return false;
      }else{
         alert('인증번호가 일치하였습니다.');
         $('#codeChecked').val(1);
      }
      
   });
   $("#join").click(function(){
      var userid = $("#joinUserid").val();
      var pwd = $("#joinUserpwd").val();
      var pwdR = $("#pwd-repeat").val();
      var name = $("#joinUsername").val();
      var phone = $("#phone").val();
      var email = $("#email").val();

      if (userid=="") {
         alert("아이디를 확인하세요.");
         $("#userid").focus();
         return false;
      } else if (userid.length > 20) {
         //유효성 검사
         alert("아이디를 20자 이내로 적어주세요!");
         $("#userid").focus();
         return false;
      }else if (pwd == "") {
         alert("비밀번호를 확인하세요.");
         $("#userpwd").focus();
         return false;
      } else if (pwd.length > 20) {
         //유효성 검사
         alert("비밀번호를 20자 이내로 적어주세요!");
         $("#userpwd").focus();
         return false;
      }else if (pwdR == "") {
         alert("비밀번호를 확인하세요.");
         $("#pwd-repeat").focus();
         return false;
      } else if (pwdR.length > 20) {
         //유효성 검사
         alert("비밀번호 확인을 20자 이내로 적어주세요!");
         $("#pwd-repeat").focus();
         return false;
      }else if (pwd != pwdR) {
         alert("비밀번호 확인이 정확하지 않습니다. 다시 입력하세요");
         $("#userpwd").focus();
         return false;
      }else if (name == "") {
         alert("이름을 확인하세요.");
         $("#username").focus();
         return false;
      } else if (name.length > 10) {
         //유효성 검사
         alert("이름을 10자 이내로 적어주세요!");
         $("#username").focus();
         return false;
      }else if (phone == "") {
         alert("전화번호를 확인하세요.");
         $("#phone").focus();
         return false;
      } else if (phone.length > 20) {
         //유효성 검사
         alert("폰 번호를 20자 이내로 적어주세요!");
         $("#phone").focus();
         return false;
      }else if (email == "") {
         alert("이메일을 확인하세요.");
         $("#email").focus();
         return false;
      } else if (email.length > 20) {
         //유효성 검사
         alert("이메일 50자 이내로 적어주세요!");
         $("#email").focus();
         return false;
      }else if ($('#codeChecked').val() == 0){
         alert("이메일 인증을 먼저 하십시오.");
           /* $("#memberEmail").focus();    */
          return false;
       }else{
          $("#signupForm").submit();
       }
   });
})

</script>
  <jsp:include page="/WEB-INF/views/common/footer.jsp" />