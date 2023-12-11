<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
/**
 * @Class Name : CompanyInfoList.jsp
 * @Description : CompanyInfo List 화면
 * @Modification Information
 * 
 * @author johj
 * @since 2023-12-07
 * @version 1.0
 * @see
 *  
 * Copyright (C) All right reserved.
 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>목록</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/sample.css'/>" />

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




<script type="text/javaScript" language="javascript" defer="defer">
<!--
	/* 글 수정 화면 function */

	function fn_egov_select(comNumber) {
		document.getElementById("listForm").comNumber.value = comNumber;
		document.getElementById("listForm").action = "<c:url value='/companyInfo/updateCompanyInfoView.do'/>";
		document.getElementById("listForm").submit();
	}

	/* 글 등록 화면 function */
	function fn_egov_addView() {
		document.getElementById("listForm").action = "<c:url value='/companyInfo/addCompanyInfoView.do'/>";
		document.getElementById("listForm").submit();
	}

	/* pagination 페이지 링크 function */
	function fn_egov_link_page(pageNo) {
		document.getElementById("listForm").pageIndex.value = pageNo;
		document.getElementById("listForm").action = "<c:url value='/companyInfo/CompanyInfoList.do'/>";
		document.getElementById("listForm").submit();
	}
// -->
</script>
<style>
/* 토글 스위치의 스타일을 정의합니다. */
.toggle-switch {
	position: relative;
	display: inline-block;
	width: 30px; /* 너비를 30px로 조정 */
	height: 18px; /* 높이를 18px로 조정 */
}

.toggle-switch input {
	opacity: 0;
	width: 0;
	height: 0;
}

.toggle-slider {
	position: absolute;
	cursor: pointer;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	background-color: #ccc;
	-webkit-transition: .4s;
	transition: .4s;
}

.toggle-slider:before {
	position: absolute;
	content: "";
	height: 14px; /* 높이를 14px로 조정 */
	width: 14px; /* 너비를 14px로 조정 */
	left: 2px; /* 위치 조정 */
	bottom: 2px; /* 위치 조정 */
	background-color: white;
	-webkit-transition: .4s;
	transition: .4s;
}

input:checked+.toggle-slider {
	background-color: #2196F3;
}

input:focus+.toggle-slider {
	box-shadow: 0 0 1px #2196F3;
}

input:checked+.toggle-slider:before {
	-webkit-transform: translateX(12px); /* 위치 조정 */
	-ms-transform: translateX(12px); /* 위치 조정 */
	transform: translateX(12px); /* 위치 조정 */
}
</style>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function execDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				document.getElementById('zip_code').value = data.zonecode;
				document.getElementById('address_1').value = data.address;
			}
		}).open();
	}
</script>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
	$(document).ready(function() {
		$(".com-number-link").click(function() {
			$("#myForm").toggle(); // myForm이라는 id를 가진 요소의 가시성을 전환합니다.
		});
	});
</script>

</head>
<body>
	<form:form modelAttribute="searchVO" name="listForm" id="listForm"
		method="post">
		<input type="hidden" name="comNumber" />
		<div id="content_pop">
			<!-- 타이틀 -->
			<div id="title">
				<ul>
					<li><img
						src="<c:url value='/images/egovframework/example/title_dot.gif'/>"
						alt="title" /> List</li>
				</ul>
			</div>
			<!-- // 타이틀 -->
			<table>
				<!-- 비동기 전송방식. searchText라는 이름으로 넘어가게 됨 -->
				<form name="searchFrm" method="post" action="CompanyInfoList.do">
					<select name="searchCondition" id="searchCondition"
						style="height: 23px; width: 90px;">
						<option value="all">전체</option>
						<option value="comName">회사명</option>
						<option value="comNumber">C.PN</option>
						<option value="note">참고사항</option>
					</select> &nbsp <input style="height: 18px; width: 150px;" type="text"
						name="searchKeyword" id="searchKeyword">
						<button type="submit"
							style='font-size: 8px; width: 25px; height: 25px; border-radius: 50%; padding: 0px; position: absolute; left: 255; font-size: 8pt; background-color: #4f5d73;'>🔍</button>
				</form>
				<!-- 인쇄 부분 -->
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

				<button
					style='font-size: 8px; width: 40px; height: 23px; font-size: 8pt; background-color: #68AA3B;'
					value="인쇄하기" id="print" onclick="window.print()">인쇄</button>
				<div id="sysbtn">
					<span class="btn_blue_l"><a
						href="javascript:fn_egov_addView();">등록</a><img
						src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>"
						alt="" /> </span>
				</div>
			</table>
			<!-- List -->
			<div id="table">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<colgroup>
						<col />
						<col />
						<col />
						<col />
						<col />
						<col />
						<col />
						<col />
						<col />
						<col />
					</colgroup>
					<tr>
						<th align="center">NO.</th>
						<th align="center">회사 고유 번호</th>
						<th align="center">회사명</th>
						<th align="center">사용자 수</th>
						<th align="center">사용<br />비콘수</bt></th>
						<th align="center">상태</th>
						<th align="center">참고사항</th>
					</tr>
					<c:forEach var="result" items="${resultList}" varStatus="status">

						<tr>
							<td align="center" class="listtd"><c:out
									value="${result.num}" /></td>

							<td align="center" class="listtd"><a href="#"
								class="com-number-link"><c:out value="${result.comNumber}" /></a></td>

							<td align="center" class="listtd"><c:out
									value="${result.comName}" /></td>

							<td align="center" class="listtd"><c:out
									value="${result.employeeCount}" /></td>

							<td align="center" class="listtd"><c:out
									value="${result.beaconCount}" /></td>

							<td align="center" class="listtd"><c:out
									value="${result.use == 1 ? '정상' : '중지'}" /></td>

							<td align="center" class="listtd"><c:out
									value="${result.note}" /></td>
						</tr>
					</c:forEach>

				</table>
			</div>
			<!-- /List -->
			<div id="paging">
				<ui:pagination paginationInfo="${paginationInfo}" type="image"
					jsFunction="fn_egov_link_page" />
				<form:hidden path="pageIndex" />
			</div>
			<div id="sysbtn1">
				<ul>
					<li></li>
				</ul>
			</div>
		</div>


		<form name="frm" id="frm">
			<!-- Write 부분 -->
			<div id="myForm" style="display: none;">
				<table class="tg">
					<tbody>
						<c:forEach var="result" items="${resultList}" varStatus="status">
							<c:if test="${result.comNumber eq result.comNumber}">
								<tr>
									<td><label for="num">NO</label></td>
									<td><c:out value="${result.num}"></c:out></td>
									<td colspan="2"><label for="comNumber">회사고유번호<br>(C.P.N)
										</label></td>
									<td><c:out value="${result.comNumber}"></c:out></td>
								</tr>
								<tr>
									<td><label for="com_name">회사명</label></td>
									<td><c:out value="${result.comName}"></c:out></td>
									<td colspan="2"><label for="ceo_name">대표자</label></td>
									<td><c:out value="${result.ceoName}"></c:out></td>
								</tr>
								<tr>
									<td><label for="phone_number">연락처</label></td>
									<td><c:out value="${result.ceoPhone}"></c:out></td>
									<td colspan="2"><label for="email">이메일</label></td>
									<td><c:out value="${result.email}"></c:out></td>
									</td>
								</tr>
								<tr>
									<td><label for="address">주소</label></td>
									<td colspan="4"><c:out value="${result.zipCode}"></c:out>
										<c:out value="${result.address1}"></c:out> <c:out
											value="${result.address2}"></c:out></td>
								</tr>
								<tr>
									<td width="10%" rowspan="4"><label for="com_ci">회사
											로고</label></td>
									<td rowspan="4">
										 <img src="<c:url value='C:/resources/company/${result.comCi}' />" alt="회사 로고"/>
									</td>
									<td rowspan="3">기업 관리자</td>
									<td><label for="name">성명</label></td>
									<td><c:out value="${result.name}"></c:out></td>
								</tr>
								<tr>
									<td><label for="id">아이디</label></td>
									<td><c:out value="${result.id}"></c:out></td>
								</tr>
								<tr>
									<td><label for="pw">암호</label></td>
									<td><c:out value="${result.password}"></c:out></td>
								</tr>

								<tr>
									<td colspan="2"><label for="user_count">사용자 수</label></td>

									<td><c:out value="${result.employeeCount}"></c:out></td>

								</tr>


								<tr>
									<td><label for="uses">상태</label></td>
									<td><label class="toggle-switch" style=""> <input
											type="checkbox"> <span class="toggle-slider"></span></label></td>


									<td colspan="2"><label for="uses_count">사용 비콘수</label></td>
									<td><c:out value="${result.beaconCount}"></c:out></td>
									</tr>
									</tr>
									</c:if>
						</c:forEach>


						<!-- 반복문을 한 번만 실행하고 종료합니다 -->


					</tbody>
				</table>

				<button
					style='width: 40px; height: 23px; padding: 0px; right: 600px; font-size: 8pt; background-color: #68AA3B;'
					type="button" onclick="fn_submit(); return false;">저장</button>
			</div>
		</form>
	</form:form>
</body>
</html>
