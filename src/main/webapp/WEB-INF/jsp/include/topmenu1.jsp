<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>System TopMenu</title>
</head>

<style>

button {
	background-color: #9E9E9E; /* 배경색 */
	color: #ffffff;
	width: 75px; /* 버튼 너비 */
	height: 25px; /* 버튼 높이 */
	 /* 내부 여백 */
	margin: 5px;
	border: 0px solid #000000; /* 테두리 스타일 */
	border-radius: 7.5px; /* 테두리 둥글게 만들기 */
	box-shadow: 2px 2px 5px rgba(0.1, 0.1, 0.1, 0.6); /* 그림자 효과 */
	cursor: pointer; /* 마우스 커서 모양 */
	font-size: 13px;
	font-weight:bold;
}
button:hover {
    background-color: #4E79CA; /* 마우스를 올렸을 때 배경색 변경 */
}

button:active {
    background-color: #2F569D; /* 클릭했을 때 배경색 변경 */
}
</style>


<body> 
   <table>
      <tr>
      <button type="button" onclick="location='sCompanyWriteAndList.do'">기업 관리</button>
      <button type="button" onclick="location='sGroupCodeListAndWrite.do'">코드 관리</button>
      <button type="button" onclick="location='boardWrite.do'">비콘 관리</button>
      <button type="button" onclick="location='boardWrite.do'">통계 센터</button>
      <button type="button" onclick="location='boardWrite.do'">고객센터</button>
      <button type="button" onclick="location='boardWrite.do'">자료 관리</button>
      </tr>
   </table>

</body>
</html>