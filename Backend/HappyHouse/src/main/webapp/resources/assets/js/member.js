$(document).ready(function() {
	
	//회원가입 - 아이디 중복 체크
	$("#join").click(function() {
		var userid = $('#id').val();
		console.log(id);
		
		$.ajax({
			url:"data/users.xml",
			type: "GET",
			dataType: "xml",
			success: function(data) {
				$(data).find('user').each(function() {
					if(userid == $(this).attr("id") ) {
						alert("아이디가 이미 존재합니다. 다른 아이디를 이용하세요");
						return false; // break;  * return true; continue
					}else{
						alert("사용가능한 아이디 입니다.");
						return false;
					}
				});
				
			}
		})
	});
	
//	로그인
	$("#loginBtn").click(function() {
		var userid = $('#uname').val();
		var userpsw = $('#password').val();
		
		
		$.ajax({
			url: "data/users.xml",
			type: "POST",
			cache: false,
			dataType: "xml",
			success: function(data) {
				/*alert(data);*/
				var login = false;
				var username = '';
				$(data).find('user').each(function() {
					if(userid == $(this).attr("id") && userpsw == $(this).find("psw").text()) {
						username = $(this).find("name").text();
						login = true;
						return false; // break;  * return true; continue
					}
				});
				
				if(login) {
					
					$("#header_nav_confirmoff").css("display", "none");
					$("#header_nav_confirmon").css("display", "block");
					$("#profile_msg").html("<b>" + username + "</b>님 안녕하세요.");
					
					alert("로그인 성공");
				} else {
					alert("아이디 또는 비밀번호 확인!!!");
				}
		
			}
		});
	});
	
	//로그아웃
	$("#logoutBtn").click(function() {
		$("#header_nav_confirmoff").css("display", "block");
		$("#header_nav_confirmon").css("display", "none");
	});
	
	

});