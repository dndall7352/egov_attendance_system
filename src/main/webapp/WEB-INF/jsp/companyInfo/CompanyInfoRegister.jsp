<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : CompanyInfoRegister.jsp
  * @Description : CompanyInfo Register 화면
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

<c:set var="registerFlag" value="${empty companyInfoVO.comNumber ? '등록' : '수정'}"/>

<title> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>


<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="companyInfoVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 목록 화면 function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/companyInfo/CompanyInfoList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/companyInfo/deleteCompanyInfo.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation기능 보완 */
	
  	frm.action = "<c:url value="${registerFlag == '등록' ? '/companyInfo/addCompanyInfo.do' : '/companyInfo/updateCompanyInfo.do'}"/>";
    frm.submit();

}

// -->
</script>

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


</head>
<body>

<form:form modelAttribute="companyInfoVO" name="detailForm" id="detailForm" encType="multipart/form-data">
<div id="content_pop">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images//title_dot.gif'/>" alt="" /><c:out value="${registerFlag}"/></li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<div id="table">
	<table width="100%" border="1" cellpadding="0" cellspacing="0" >
		<colgroup>
			<col width="150"/>
			<col width=""/>
		</colgroup>
			
		<c:if test="${registerFlag == '수정'}">
	   <tr>
			<th>회사 고유 번호(C.P.N)</th>
			<td>
				<form:input path="comNumber" cssClass="essentiality" readonly="true" />
			</td>			
		</tr>	
		</c:if>
		<c:if test="${registerFlag == '등록'}">
	   <tr>
			<th>COM_NUMBER *</th>
			<td>
				<form:input path="comNumber" cssClass="txt" readonly="false" />
			</td>			
		</tr>	
		</c:if>		
		<tr>
			<th>COM_NAME</th>
			<td>
				<form:input path="comName" cssClass="txt"/>
				&nbsp;<form:errors path="comName" />
			</td>
		</tr>	
		<tr>
			<th>COM_CI</th>
			<td>
				<input type="file" name="uploadFile">
				&nbsp; <form:errors path="uploadFile" />
			</td>
		</tr>	
		<tr>
			<th>COM_EMAIL</th>
			<td>
				<form:input path="comEmail" cssClass="txt"/>
				&nbsp;<form:errors path="comEmail" />
			</td>
		</tr>	
		<tr>
			<th>CEO_NAME</th>
			<td>
				<form:input path="ceoName" cssClass="txt"/>
				&nbsp;<form:errors path="ceoName" />
			</td>
		</tr>	
		<tr>
			<td>주소</td>
			<td colspan="4">
			<input type="text" name="zip_code" id="zip_code" placeholder="우편번호" class="input1"> 
			<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기">
			<input type="text" name="address_1" id="address_1" placeholder="도로명주소" style="width: 500px" class="input1">
			<input type="text" name="address_2" id="address_2" placeholder="상세주소" style="width: 500px" class="input1"></td>
		</tr>
		<tr>
			<th>NOTE</th>
			<td>
				<form:input path="note" cssClass="txt"/>
				&nbsp;<form:errors path="note" />
			</td>
		</tr>	
		<tr>
			<th>CEO_PHONE</th>
			<td>
				<form:input path="ceoPhone" cssClass="txt"/>
				&nbsp;<form:errors path="ceoPhone" />
			</td>
		</tr>	
	</table>
  </div>
	<div id="sysbtn">
		<ul>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_selectList();">List</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_save();"><c:out value='${registerFlag}'/></a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
			<c:if test="${registerFlag == '수정'}">
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_delete();">삭제</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
			</c:if>
			<li><span class="btn_blue_l"><a href="javascript:document.detailForm.reset();">Reset</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li></ul>
	</div>
</div>
<!-- 검색조건 유지 -->
<input type="hidden" name="searchCondition" value="<c:out value='${searchVO.searchCondition}'/>"/>
<input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>"/>
<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
</form:form>
</body>
</html>

