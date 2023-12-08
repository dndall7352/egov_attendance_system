<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Departmenthead</title>
</head>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

<style>
button {
    background-color: #9E9E9E;
    color: #ffffff;
    width: 120px;
    height: 20px;
    padding: 10px;
    margin: 5px;
    border: 0px solid #000000;
    border-radius: 7.5px;
    box-shadow: 2px 2px 5px rgba(0.1, 0.1, 0.1, 0.6);
    cursor: pointer;
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
      <button type="button" onclick="location='boardWrite.do'">근태현황 보드</button>
      <button type="button" onclick="location='boardWrite.do'">공지사항 관리</button>
      <button type="button" onclick="location='boardWrite.do'">부서 관리</button>
      <button type="button" onclick="location='boardWrite.do'">근태 관리</button>
      <button type="button" onclick="location='boardWrite.do'">접속 로그</button>
      </tr>
   </table>

</body>
</html>