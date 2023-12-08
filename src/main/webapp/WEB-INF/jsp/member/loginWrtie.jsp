<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AtoZSystem</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<!-- 공백인지 아닌지 확인 -->
<script>
	/* 달력 */
$(function() {
	/* 데이터 유효성 체크 - id, pass, 이름 공백 체크 */
	$("#btn_submit").click(function() {
		// 값을 받아옴
		var userid = $.trim($("#userid").val());  // userid로 가 있는 아이디의 값을 체크(val())
		var pass = $.trim($("#pass").val());

		// 오류 체크
		if (userid === "") {
			alert("아이디를 입력해주세요.");
			$("#userid").focus();
			return false;
		}
		if (pass === "") {
			alert("비밀번호를 입력해주세요.");
			$("#pass").focus();
			return false;
		}
		
		var formData = $("#fim").serialize(); // 시리얼라이즈 = 폼의 구성요소를 모두 형성해서 가져오겠다. 
		
		$.ajax({
			type: "POST",  // 전송 타입
			data: "userid="+userid+"&pass="+pass,  // json타입
			url: "loginWriteSub.do",  // 저장 주소(실제 경로) = action == 저장 장소
			dataType: "text",  //retuen type
			
			success: function(result) {  // 성공 메시지를 받았을 때 출력과 데이터 이동. 함수 처리를 해야 함 == 직접 함수 처리를 함. == 기능 부여를 하겠다. data == controller에서 준 data
				if (result == "ok") {
					alert(userid+"님 로그인 되었습니다.");
					location.href ="boardList.do";  // 페이지 이동
				} else {
					alert("아이디 혹은 비밀번호가 틀렸습니다.");
				}
			},
			error: function() {  // 장애 발생
				alert("오류 발쌩!!");
			}
		}); 
	});
});

</script>
</head>
<style>
body {
	font-size: 9pt;
	color: #333333;
	font-family: 맑은 고딕;
}

a {
	text-decoration: none;
}

table {
	width: 600px;
	border-collapse: collapse;
}

th, td {
	border: 1px solid #cccccc;
	padding: 3px;
	line-height: 2;
}

caption {
	font-size: 15pt;
	font-weight: bold;
	margin-top: 10px;
	padding-bottom: 5px;
}

.div_button {
	width: 600px;
	text-align: center;
	margin-top: 5px;
}
</style>

<body>
<form id="fim">
<%@ include file = "../include/topmenu1.jsp" %>

	<table>

		<tr>
			<th><label for="userid">아이디</label></th>
			<td>
				<input type="text" name="userid" id="userid" placeholder="아이디 입력">

			</td>
		</tr>
		<tr>
			<th><label for="pass">비밀번호</label></th>
			<td>
				<input type="password" name="pass" id="pass">
			</td>
		</tr>
	</table>
	
		<div class="div_button">
		<button type="button" id="btn_submit" >로그인</button>

	</div>
</form>
</body>
</html>