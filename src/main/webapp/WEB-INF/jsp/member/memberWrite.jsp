<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AtoZSystem</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

<script>
   /* 달력 */
$(function() {
   $( "#birth" ).datepicker({
      dateFormat: "yyyy-mm-dd",
      changeMonth: true,
      changeYear: true
   });  // birth라는 이름을 가진 요소에 달력 기능을 적용합니다.

   $("#btn_idcheck").click(function(){
      var userid = $("#userid").val();
      userid = $.trim(userid);
      if(userid == ""){
         alert("아이디를 입력하세요.");
         $("#userid").focus();
         return false;
      }
      $.ajax({
         type: "POST",  // 전송 타입
         data: "userid="+userid,  // 전송 타입 sjon
         url: "idcheck.do",  // 저장 주소(실제 경로) = action == 저장 장소
         dataType: "text",  //retuen type
         success: function(result) {  // 성공 메시지를 받았을 때 출력과 데이터 이동. 함수 처리를 해야 함 == 직접 함수 처리를 함. == 기능 부여를 하겠다. data == controller에서 준 data
            if (result == "Ok") {
               alert("사용 가능한 아이디입니다.");
               location.href = "loginWrite.do";  // 페이지 이동
            } else {
               alert("아이디가 이미 있습니다.");
            }
         },
         error: function() {  // 장애 발생
            alert("오류발생");
         }
      }); 
   });
   
   /* 데이터 유효성 체크 - id, pass, 이름 공백 체크 */
   $("#btn_submit").click(function() {
      // 값을 받아옴
      var userid = $.trim($("#userid").val());  // userid로 가 있는 아이디의 값을 체크(val())
      var pass = $.trim($("#pass").val());
      var name = $.trim($("#name").val());

      // 공백 제거
      userid = $.trim(userid);
      pass = $.trim(pass);
      name = $.trim(name);

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
      if (name === "") {
         alert("이름을 입력해주세요.");
         $("#name").focus();
         return false;
      }

      // 실제 데이터 공백 제거(화면에 있는 내용 공백 제거)
      $("#userid").val(userid);
      $("#pass").val(pass);
      $("#name").val(name);
      
      var formData = $("#fim").serialize(); // 시리얼라이즈 = 폼의 구성요소를 모두 형성해서 가져오겠다. 
      
      $.ajax({
         type: "POST",  // 전송 타입
         data: formData,  // 함수의 속성 == from
         url: "memberWriteSave.do",  // 저장 주소(실제 경로) = action == 저장 장소
         dataType: "text",  //retuen type
         success: function(data) {  // 성공 메시지를 받았을 때 출력과 데이터 이동. 함수 처리를 해야 함 == 직접 함수 처리를 함. == 기능 부여를 하겠다. data == controller에서 준 data
            if (data == "ok") {
               alert("저장완료");
               location.href = "loginWrite.do";  // 페이지 이동
            } else {
               alert("저장실패");
            }
         },
         error: function() {  // 장애 발생
            alert("오류 발생");
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
      <caption>회원가입</caption>
      <tr>
         <th><label for="userid">아이디</label></th>
         <td>
            <input type="text" name="userid" id="userid" placeholder="아이디 입력">
            <button type="button" id="btn_idcheck">중복체크</button>
         </td>
      </tr>
      <tr>
         <th><label for="pass">비밀번호</label></th>
         <td>
            <input type="password" name="pass" id="pass">
         </td>
      </tr>
      <tr>
         <th><label for="name">이름</label></th>
         <td>
            <input type="text" name="name" id="name">
         </td>
      </tr>
      <tr>
         <th><label for="department">부서</label>
         <td>
            <input type="text" id="department" name="department" required>
         </td>
      </tr>
      <tr>
         <th><label for="position">직급</label>
         <td>
            <input type="text" id="position" name="position" required>
         </td>
      </tr>
      <tr>
         <th><label for="employee_number">사번</label>
         <td>
            <input type="text" id="employee_number" name="employee_number" required>
         </td>
      </tr>
      <tr>
         <th><label for="phone">연락처</label></th>
         <td>
            <input type="text" name="phone" id="phone"> <span>&nbsp; (예: 010-1234-1234)</span>
         </td>
      </tr>
      <tr>
         <th><label for="email">이메일</label> 
         <td>
            <input type="email" id="email" name="email" required> 
         </td>
      </tr>
      <!-- 
      <tr>
         <th><label for="photo">사진</label>
         <td>
            <input type="file" id="photo" name="photo">
         </td>
      </tr>
          -->
   </table>

   <div class="div_button">
      <button type="button" id="btn_submit" >완료</button>
      <button type="reset">취소</button>
   </div>
</form>
</body>
</html>