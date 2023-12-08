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

<script>
	$(document).ready(function() {
		$("#addCodeGroup").click(function() {
			$("#myForm").toggle(); // myForm이라는 id를 가진 요소의 가시성을 전환합니다.
		});
	});
</script>

<script>
	$(function() {
		// $("#frm").val("제목입력"); // 삭제
	});

	function fn_submit() {
		if ($.trim($("#code_group").val()) == "") {
			alert("코드 그룹명을 입력해 주세요!");
			$("#code_group").focus();
			return false;
		}
		$("#code_group").val($.trim($("#code_group").val()));

		if ($.trim($("#com_number").val()) == "") {
			alert("회사 고유 코드를 입력해 주세요!");
			$("#com_number").focus();
			return false;
		}
		$("#com_number").val($.trim($("#com_number").val()));

		if ($("#code_group_name").val() == "") {
			alert("그룹 코드를 입력해 주세요!");
			$("#code_group_name").focus();
			return false;
		}
		$("#code_group_name").val($.trim($("#code_group_name").val())); // 수정

		var formData = $("#frm").serialize();
		$.ajax({
			type : "POST",
			data : formData,
			url : "sGroupCodeWriteSave.do",
			dataType : "text",
			success : function(data) {
				if (data == "ok") {
					alert("저장완료");
					$("#myForm").toggle(); // 수정된 부분: 팝업을 나타내는 코드 추가
					location = "sGroupCodeListAndWrite.do";
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

	<!-- Write 버튼 부분 -->

	<div
		style="width: 600px; height: 200; margin-top: 0px; text-align: right; ' word-break: break-all;'">
		<button id="addCodeGroup"
			style='float: right; background-color: #68AA3B; width: 95px; font-size: 8pt;'
			type="submit">+코드 그룹 추가</button>
	</div>

	<!-- List 부분 -->
	<table>
		<tr>
			<td colspan="4"
				style="text-align: center; margin-top: 0px; word-break: break-all; background-color: #ededed;">코드
				그룹</td>
		</tr>
		<tr
			style='text-align: center; word-break: break-all; background-color: #ededed;'>
			<td width="10%"><label for="com_number">회사 고유 코드</label></td>
			<td width="10%"><label for="code_group_name">코드 그룹 명</label></td>
			<td width="10%"><label for="code_group">그룹 코드</label></td>
			<td width="30%"><label for="note">참고사항</label></td>
		</tr>
	</table>

	<div
		style="overflow-y: scroll; width: 617px; height: 200px; word-break: break-all;">
		<table style="height: 200px">
			<c:forEach var="result" items="${resultList}">
				<!-- items는 실제 외부 데이터 model.attribute -->
				<tr style='word-break: break-all;'>
					<td width="10%"><c:out value="${result.com_number}"></c:out></td>
					<td width="10%"><c:out value="${result.code_group_name}">
							<td width="10%">
						</c:out></td>
					<td width="10%"><a
						href="sCodeListAndWrite.do?group=${result.code_group }"><c:out
								value="${result.code_group}"></c:out></td>
					<td width="30%"><c:out value="${result.cg_note}"></c:out></td>
				</tr>
			</c:forEach>
			<!-- 	<script>
				console.log("code_group: " + '${result.code_group}');
				console.log("com_number: " + '${result.com_number}');
				console.log("code_group_name: " + '${result.code_group_name}');
				console.log("note: " + '${result.note}');
			</script>
 -->
		</table>
		</form>
	</div>

		<form name="frm" id="frm">
			<!-- Write 부분 -->
			<table>
				<tbody id="myForm" style="display: none;">
					<tr>
						<br>
						<br>
						<br>
						<td width="30"><label for="code_group">코드 그룹 명</label></td>
						<td width="10"><label for="com_number">회사 고유 코드</label></td>
						<td width="10"><label for="code_group_name">그룹 코드</label></td>
						<td width="10"><label for="note">참고사항</label></td>
					</tr>
					<tr>
						<td width="30"><input type="text" name="code_group"
							id="code_group" class="input1"></td>
						<td width="10"><input type="text" name="com_number"
							id="com_number" class="input1"></td>
						<td width="10"><input type="text" name="code_group_name"
							id="code_group_name" class="input1"></td>
						<td width="10"><input type="text" name="note" id="note"
							class="input1"></td>
					</tr>
					<tr>
						<td colspan="4">
							<button
								style='width: 40px; height: 23px; padding: 0px; float: right; font-size: 8pt; background-color: #68AA3B;'
								type="button" onclick="fn_submit(); return false;">저장</button>
						</td>
					</tr>
				</tbody>
			</table>

</body>
</html>

