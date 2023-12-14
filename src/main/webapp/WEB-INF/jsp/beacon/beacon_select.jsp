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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
	.table.select-beacon-table td{
		height: 50px;
		vertical-align: middle;
	}
</style>
</head>
<body>
 <div class="modal" id="beaconModal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title"></h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p style="text-align: center;"></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<form id="update-beacon-form" method="post" action="/beacon/updateBeacon.do">
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
            <td class="thead" id="cpn-com-name">${beacon.com_name }</td>
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
            <td class="table-input"><input type="text" class="table-input-text" name="emplacement" value="${beacon.emplacement }"></td>
            <td class="thead">비콘상태</td>
            <td class="table-input">
                <div id="beacon-state">
                    <div data-state="1">정상</div>
                    <div data-state="0">중지</div>
                </div>
            </td>
        </tr>
        <tr>
            <td class="thead" style="height: 120px;">참고 사항</td>
            <td colspan="4" class="table-input" style="vertical-align: middle;"><textarea name="note" >${beacon.note }</textarea></td>
        </tr>
    </table>
    <button type="button" class="btn btn-success" id="update-beacon-btn">저장</button>
 </form> 

 
    <script>
    	$('#beacon-state').children('div[data-state="${beacon.use}"]').addClass('selected');

        $('#beacon-state').on('click', function(){ // 상태 체크
            $(this).find('div').each(function(){
               	$(this).toggleClass('selected');
            });
        });
        $('#cpn-search-btn').on('click', function(e){ // c.p.n 검색 기능
        	e.preventDefault();
        	let com_number = $(this).prev().val();
        	if(com_number != ''){
        		findComName(com_number);
        	}else{
        		$('#cpn-com-name').text('');
        		$('#beaconModal').find('.modal-body p').text('일치하는 회사가 없습니다.');
				$('#beaconModal').modal('show');
        	}
        	
        });
        $('input[name="com_number"]').on('input', function(){ // c.p.n 데이터 타입
        	let inputVal = $(this).val();
        	inputVal = inputVal.replace(/[^0-9]/g, '');
        	$(this).val(inputVal);
        });
        
        function findComName(com_number){ // 일치 여부 함수
        	$.ajax({
        		url:'/beacon/searchComNumber.do',
        		method:'POST',
        		data:JSON.stringify({'com_number':com_number}),
        		contentType: 'application/json',
        		success: function(response){
        			if(response == ''){
        				$('#cpn-search-btn').prev().val('');
        				$('#cpn-com-name').text('');
        				$('#beaconModal').find('.modal-body p').text('일치하는 회사가 없습니다.');
        				$('#beaconModal').modal('show');
        			
        			}else{
        				$('#cpn-com-name').text(response.replace(/["]/g, ''));
        			}
        			
        		}

        	});
        }
        
        
       
        
        
    </script>
</body>
</html>