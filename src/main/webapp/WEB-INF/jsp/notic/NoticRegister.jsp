<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="java.util.*" %>
<%
/**
 * @Class Name : NoticRegister.jsp
 * @Description : Notic Register 화면
 * @Modification Information
 * 
 * @author kke
 * @since 2023-12-10
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
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!--For Commons Validator Client Side-->
    <!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
    <!-- validator:javascript formName="noticVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

    <script type="text/javascript" language="javascript">

        /* 글 목록 화면 function */
        function fn_egov_selectList() {
            document.getElementById("detailForm").action = "<c:url value='/notic/NoticList.do'/>";
            document.getElementById("detailForm").submit();
        }

        /* 글 삭제 function */
        function fn_egov_delete() {
            document.getElementById("detailForm").action = "<c:url value='/notic/deleteNotic.do'/>";
            document.getElementById("detailForm").submit();
        }

        /* 글 등록 function */
        function fn_egov_save() {
            var frm = document.getElementById("detailForm");
            var registerFlag = '<c:out value="${registerFlag}"/>';
            var url = registerFlag == '등록' ? '/notic/addNotic.do' : '/notic/updateNotic.do';
            frm.action = url;
            frm.submit();
        }

        /*현재 시간 출력 date*/
        function getCurrentTimeFormatted() {
            var currentTime = new Date();
            var formattedTime = currentTime.toLocaleString('ko-KR', { year: 'numeric', month: '2-digit', day: '2-digit', hour: '2-digit', minute: '2-digit', second: '2-digit', hour12: true });
            return formattedTime;
        }

        $(document).ready(function() {
            setInterval(function() {
                $("#currentTimeDisplayFormatted").text(getCurrentTimeFormatted());
            }, 1000);
        });
    </script>
</head>
<body>
    <form:form modelAttribute="noticVO" name="detailForm" id="detailForm" >
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
                            <th>NUM *</th>
                            <td>
                                <form:input path="num" cssClass="essentiality" readonly="true" />
                            </td>            
                        </tr>   
                    </c:if>
                    <c:if test="${registerFlag == '등록'}">
                        <tr>
                            <th>NUM *</th>
                            <td>
                                <form:input path="num" cssClass="txt" readonly="false" />
                            </td>            
                        </tr>   
                    </c:if>       
                      
                    <tr>
                        <th>TITLE</th>
                        <td>
                            <form:input path="title" cssClass="txt"/>
                            &nbsp;<form:errors path="title" />
                        </td>
                    </tr>   
                    <tr>
                        <th>CONTENT</th>
                        <td>
                            <form:input path="content" cssClass="txt"/>
                            &nbsp;<form:errors path="content" />
                        </td>
                    </tr>   
                    <tr>
                        <th>DATES</th>
                        <td width="76%" height="70%" colspan="4">
                            <p id="currentTimeDisplayFormatted"></p>
                        </td>
                    </tr>   
                </table>
            </div>
        </div>
	        <div id="sysbtn">
    	        <ul>
        	        <li><span class="btn_blue_l"><a href="javascript:fn_egov_selectList();">List</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
            	    <li><span class="btn_blue_l"><a href="javascript:fn_egov_save();">저장<c:out value='${registerFlag}'/></a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
                	<c:if test="${registerFlag == '수정'}">
                    	<li><span class="btn_blue_l"><a href="javascript:fn_egov_delete();">삭제</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
 	    	        </c:if>
    	            <li><span class="btn_blue_l"><a href="javascript:document.detailForm.reset();">Reset</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
            	</ul>
        	</div>
        	<!-- 검색조건 유지 -->
        	<input type="hidden" name="searchCondition" value="<c:out value='${searchVO.searchCondition}'/>"/>
        	<input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>"/>
        	<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
    	</form:form>
	</body>
</html>
