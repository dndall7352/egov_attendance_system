<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AtoZSystem</title>

<style>
body {
	font-size: 9pt;
}

table {
	width: 600px;
	border-collapse: collapse;
}

th, td {
	border: 1px solid #cccccc;
	padding: 3px;
}

.input1 {
	width: 90%;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.13.2/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.13.2/jquery-ui.min.js"></script>

<script>
	$(document).ready(function() {
		$("button").click(function() {
			$("#myForm").toggle(); // myForm이라는 id를 가진 요소의 가시성을 전환합니다.
		});
	});
</script>

<script>
	$(function() {
		// $("#frm").val("제목입력"); // 삭제
	});

	function fn_submit() {

		if ($("#code_name").val() == "") {
			alert("코드명을 입력해 주세요!");
			$("#code_name").focus();
			return false;
		}
		$("#code_name").val($.trim($("#code_name").val())); // 수정

		if ($.trim($("#code").val()) == "") {
			alert("코드를 입력해 주세요!");
			$("#code").focus();
			return false;
		}
		$("#code").val($.trim($("#code").val()));

		if ($.trim($("#code_group").val()) == "") {
			alert("그룹 코드를 입력해 주세요!");
			$("#code_group").focus();
			return false;
		}
		$("#code_group").val($.trim($("#code_group").val()));

		var formData = $("#frm").serialize();
		$.ajax({
			type : "POST",
			data : formData,
			url : "/sCodeWriteSave.do",
			dataType : "text",
			success : function(data) {
				if (data == "ok") {
					alert("저장완료");
					$("#myForm").toggle(); // 수정된 부분: 팝업을 나타내는 코드 추가
					window.location.href = "/sCodeListAndWrite.do?group=${sCodeVO.code_group}";
				} else {
					alert("저장실패");
				}
			},
			error : function() {
				alert("오류발생");
			}
		});
	}
</script>


</head>
<body>
	<%@ include file="../include/topmenu1.jsp"%>

	<button style='font-size: 8px; width: 50px; height: 23px; padding: 0px; position: absolute; left: 500; font-size: 8pt; background-color: #68AA3B;'
		value="인쇄하기" id="print" onclick="window.print()">인쇄</button>

	<!-- Write 버튼 부분 -->
	<div
		style="width: 600px; height: 200; margin-top: 0px; text-align: right; word-break: break-all;">

		<button
			style='float: right; background-color: #68AA3B; width: 95px; height: 23px; font-size: 8pt;'
			type="submit">+코드 추가</button>
	</div>

	<!-- List 부분 -->
	<table>
		<tr>
			<td colspan="5"
				style="text-align: center; margin-top: 0px; word-break: break-all; background-color: #ededed; ">코드</td>
		</tr>
		<tr align="center" style="background-color: #ededed;">
			<td width="40%">Group Name/Code Name</td>
			<td width="10%">code</td>
			<td width="40%">참고사항</td>
		</tr>


		<!-- <tr style='text-align: center; word-break: break-all;'>
			<td width="4%"><label for="count">번호</label></td>
			<td width="10%"><label for="code_group">그룹 코드</label></td>
			<td width="10%"><label for="code_name">코드명</label></td>
			<td width="10%"><label for="code">코드</label></td>
			<td width="30%"><label for="note">참고사항</label></td>
		</tr> -->
	</table>

	<div
		style="overflow-y: scroll; width: 617px; height: 200px; word-break: break-all;">
		<table>
			<!-- 그룹 네임   |그룹 code|참고사항
			행 번호/ 코드 네임 |코드     |
		-->
		
		<!-- doneLoop boolean 변수 선언 -->
		<c:set var="doneLoop" value="false"/>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<c:if test="${not doneLoop}">
        		<c:choose>
        		<c:when test="${result.code_group eq param.group}">
					<c:set var="param.group" value="${result.code_group}" />
					<tr align="center">
						<td width="40%"><c:out value="${result.code_group_name}"></c:out></td>
						<td width="10%"><c:out value="${result.code_group}"></c:out></td>
						<td width="40%"><c:out value="${result.cg_note}"></c:out></td>
					</tr>
					<!-- 반복문을 한 번만 실행하고 종료합니다 -->
				 <c:set var="doneLoop" value="true" />
           </c:when>
        </c:choose>
     </c:if>
   </c:forEach>

		</table>
		<table>
			<c:set var="cnt" value="1" />
			<c:forEach var="result" items="${resultList}" varStatus="status">
				<c:if test="${result.code_group eq param.group}">
					<tr>
						<td width="5%" align="center" ><c:out value="${cnt}"></c:out></td>
						<td width="35%"><c:out value="${result.code_name}"></c:out></td>
						<td width="10%" align="center"><c:out value="${result.code}"></c:out></td>
						<td width="40%"><c:out value="${result.c_note}"></c:out></td>
					</tr>

					<c:set var="cnt" value="${cnt+1 }" />
				</c:if>
			</c:forEach>
		</table>

<%--  <c:forEach var="result" items="${resultList}">
				<!-- items는 실제 외부 데이터 model.attribute -->
				<c:if test="${result.code_group eq param.group}">
					<tr style='word-break: break-all;'>
						<td width="10%"><c:out value="${result.code_group}"></c:out></td>
						<td width="10%"><c:out value="${result.code_name}"></c:out></td>
						<td width="10%"><c:out value="${result.code}"></c:out></td>
						<td width="30%"><c:out value="${result.note}"></c:out></td>
					</tr>
				</c:if>
			</c:forEach> --%>

	</div>
	
	<script>
		console.log("code_group: " + '${result.code_group}');
		console.log("com_number: " + '${result.com_number}');
		console.log("code_group_name: " + '${result.code_group_name}');
		console.log("note: " + '${result.c_note}');
	</script>

	<form name="frm" id="frm">
		<!-- Write 부분 -->
		<div id="myForm" style="display: none;">
			<table>
				<tbody>
					<tr style='word-break: break-all;'>
						<br>
						<br>
						<td width="10%"><label for="code_group">그룹 코드</label></td>
						<td width="10%"><label for="code_name">코드명</label></td>
						<td width="10%"><label for="code">코드</label></td>
						<td width="30%"><label for="note">참고사항</label></td>
					</tr>
					<tr>
						<td width="10"><input type="text" name="code_group"
							id="code_group" class="input1"></td>
						<td width="10"><input type="text" name="code_name"
							id="code_name" class="input1"></td>
						<td width="10"><input type="text" name="code" id="code"
							class="input1"></td>
						<td width="30"><input type="text" name="note" id="note"
							class="input1"></td>
					</tr>

				</tbody>
			</table>
			<button
				style='width: 40px; height: 23px; padding: 0px; right: 600px; font-size: 8pt; background-color: #68AA3B;'
				type="button" onclick="fn_submit(); return false;">저장</button>
		</div>
	</form>
</body>
</html>
