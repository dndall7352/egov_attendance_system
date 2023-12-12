<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AtoZSystem</title>
<style type="text/css">
	.table.select-beacon-table td{
		height: 50px;
		vertical-align: middle;
	}
</style>
</head>
<body>
  <c:set var="beacon" value="${beaconDTO }"></c:set>
    <table class="table select-beacon-table" style="min-width: 100%; width: 100%;">
        <tr>
            <td class="thead" style="width: 12%;">NO</td>
            <td class="thead" id="detail-number" style="width: 35%;">${beacon.beacon_number }</td>
            <td rowspan="4" class="thead" style="width: 9%;">비콘<br>정보</td>
            <td class="thead" style="width: 9%;">UUID</td>
            <td class="table-input" style="width: 35%;"><input type="text" class="table-input-text" name="uuid" value="${beacon.uuid }"></td>
        </tr>
        <tr>
            <td class="thead">회사명</td>
            <td class="thead">${beacon.com_name }</td>
            <td class="thead">Major</td>
            <td class="table-input"><input type="text" class="table-input-text" name="major" value="${beacon.major }"></td>
        </tr>
        <tr>
            <td class="thead">C.P.N</td>
            <td class="table-input">
            	<div style="display: flex; justify-content: space-between;">
            		<input type="text" class="table-input-text" style="width:80%; justify-content: space-between;" name="com_number" value="${beacon.com_number }">
            		<button type="button" class="btn btn-success" id="cpn-search-btn">검색</button>
            	</div>
            </td>
            <td class="thead">Minor</td>
            <td class="table-input"><input type="text" class="table-input-text" name="minor" value="${beacon.minor }"></td>
        </tr>
        <tr>
            <td class="thead">설치장소</td>
            <td class="table-input"><input type="text" class="table-input-text" name="emplacement" placeholder="위치"></td>
            <td class="thead">비콘상태</td>
            <td class="table-input">
                <div id="beacon-state" style="display: flex; width: 100px; height: 40px; background-color: #5B9BD5; border-radius: 30px; align-items: center; justify-content: space-evenly; cursor: pointer; user-select:none;">
                    <div data-state="1">정상</div>
                    <div data-state="0">중지</div>
                </div>
            </td>
        </tr>
        <tr>
            <td class="thead" style="height: 120px;">참고 사항</td>
            <td colspan="4" class="table-input" style="vertical-align: middle;"><input type="text" class="table-input-text" name="참고사항" value="${beacon.note }"></td>
        </tr>
    </table>
    <button type="button" class="btn btn-success" style="width: 100px; font-weight: 600; position: absolute; right: 30px;">저장</button>
    <script>
    	$('#beacon-state').children('div[data-state="${beacon.use}"]').addClass('selected');

        $('#beacon-state').on('click', function(){
            $(this).find('div').each(function(){
               	$(this).toggleClass('selected');
            });
        });
        $('#cpn-search-btn').on('click', function(){
        	$.ajax({
        		url:
        	});
        })
        
        
    </script>
</body>
</html>