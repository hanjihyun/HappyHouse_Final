<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <jsp:include page="/WEB-INF/views/common/header.jsp" />
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<c:set var="root" value="${pageContext.request.contextPath }"/>
    <!-- ======= main ======= -->
    <main id="main">
        <!-- ======= Contact Section ======= -->
        <section id="contact" class="contact">
            <div class="container">
                <div class="row">
                    <div class="col"></div>
                    <div class="col-xl-6">
                        <h2>비밀번호 찾기</h2>
                    </div>
                    <div class="col"></div>
                </div>
                <form id="findPwForm">
	                <fieldset>
	                    <div class="row">
	                        <div class="col"></div>
	                        <div class="col-xl-6">
	                            <label for="userId"><b>User ID</b></label>
	                            <input type="text" placeholder="ID" name="userId" id="userId" required>
	                        </div>
	                        <div class="col"></div>
	
	                    </div>
	
	                    <div class="row">
	                        <div class="col"></div>
	                        <div class="col-xl-6">
	                            <label for="email"><b>Email</b></label> <br>
	                            <input type="text" placeholder="Email" name="email" id="email" style="width:50%;"  required>
	                      	 <input type="hidden" class="idChecked" name="idChk" id="idChk" value="0">
	                      	  <button class="emailCheck" onclick="searchEmail();"  style="width:45%; position:absolute; right:3%" id="emailCheck">이메일 인증</button>
	                    
	                       </div>
	                      
	                       <div class="col">
	                       	   </div>
	                    </div>
	                     
	                    <div class="row">
	                        <div class="col"></div>
	                        <div class="col-xl-6">
	                            <button type="reset" class="cancelbtn">취소</button>
	                            <button class="signupbtn" onclick="sendEmailAction();" id="findPw">인증 번호 전송</button>
	                        </div>
	                        <div class="col"></div>
	                    </div>
	                </fieldset>
                </form>
            </div>
        </section><!-- End Contact Section -->
    </main><!-- End #main -->
<script type="text/javascript">
$(document).ready(function(){
	$("#emailCheck").click(function(){
		var userid = $("#userId").val();
		var email = $('#email').val();
		console.log(email);
		
		if(userid==""){
			alert("아이디를 작성하세요.");
			$("#userId").focus();
			return false;
		}else if(email==""){
			alert("이메일을 작성하세요.");
			$("#email").focus();
			return false;
		}
	});
})
	function searchEmail(){
	event.preventDefault();
		var userid = $("#userId").val();
		var email = $('#email').val();
		
		$.ajax({
			url:"${root}/member/searchEmail/"+email+"/"+userid,
			type:'GET',
			success:function(reponse){
		console.log(reponse);
				if(reponse == "1"){
					alert("이메일이 존재합니다. 비밀번호 변경 버튼을 누르면 인증 번호가 전송됩니다.");
					document.getElementById("idChk").value = 1;
// 					document.findPwForm.idChk.value=1;
				}else{
					alert("존재하지 않는 이메일입니다. 회원가입 후 이용하세요!");
					//location.reload();
				}
				
			}, error:function(request,status,error){
		        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
		       }
		});
	} 
	function sendEmailAction(){
		event.preventDefault();
		 if (document.getElementById("idChk").value == 0)
		 {
			alert("이메일 인증을 먼저 하십시오.");
			//console.log("dididi");
		     /* $("#memberEmail").focus();    */
		    return false;
		 }else{
			 var email = $('#email').val();
			location.href="${root }/member/sendEmailAction?email="+email;
		 }
	}
</script>

  <jsp:include page="/WEB-INF/views/common/footer.jsp" />