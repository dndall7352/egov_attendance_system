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
    <table class="table select-beacon-table" style="min-width: 100%; width: 100%;">
        <tr>
            <td class="thead" style="width: 12%;"></td>
            <td class="thead" id="detail-number" style="width: 35%;">신규 비콘 추가</td>
            <td rowspan="4" class="thead" style="width: 9%;">비콘<br>정보</td>
            <td class="thead" style="width: 9%;">UUID</td>
            <td class="table-input" style="width: 35%;"><input type="text" class="table-input-text" name="uuid" value=""></td>
        </tr>
        <tr>
            <td class="thead">회사명</td>
            <td class="thead" id="cpn-com-name"></td>
            <td class="thead">Major</td>
            <td class="table-input"><input type="text" class="table-input-text" name="major" value=""></td>
        </tr>
        <tr>
            <td class="thead">C.P.N</td>
            <td class="table-input">
            	<div style="display: flex; justify-content: space-between;">
            		<input type="text" class="table-input-text" style="width:80%; justify-content: space-between;" name="com_number" value="">
            		<button type="button" class="btn btn-success" id="cpn-search-btn">검색</button>
            	</div>
            </td>
            <td class="thead">Minor</td>
            <td class="table-input"><input type="text" class="table-input-text" name="minor" value=""></td>
        </tr>
        <tr>
            <td class="thead">설치장소</td>
            <td class="table-input"><input type="text" class="table-input-text" name="emplacement" value=""></td>
            <td class="thead">비콘상태</td>
            <td class="table-input">
                <div id="beacon-state" style="display: flex; width: 100px; height: 40px; background-color: #5B9BD5; border-radius: 30px; align-items: center; justify-content: space-evenly; cursor: pointer; user-select:none;">
                    <div data-state="1" class="selected">정상</div>
                    <div data-state="0">중지</div>
                </div>
            </td>
        </tr>
        <tr>
            <td class="thead" style="height: 120px;">참고 사항</td>
            <td colspan="4" class="table-input" style="vertical-align: middle;"><input type="text" class="table-input-text" name="note" value=""></td>
        </tr>
    </table>
    <button type="button" class="btn btn-success" id="insert-beacon-btn" style="width: 100px; font-weight: 600; position: absolute; right: 30px;">저장</button>
 </form> 

 
    <script>

        $('#beacon-state').on('click', function(){
            $(this).find('div').each(function(){
               	$(this).toggleClass('selected');
            });
        });
        
        $('#cpn-search-btn').on('click', function(){
        	let com_number = $(this).prev().val();
        	findComName(com_number);
        	
        });
        $('input[name="com_number"]').on('input', function(){
        	let inputVal = $(this).val();
        	inputVal = inputVal.replace(/[^0-9]/g, '');
        	$(this).val(inputVal);
        });
        
        function findComName(com_number){
        	$.ajax({
        		url:'/beacon/searchComNumber.do',
        		method:'POST',
        		data:JSON.stringify({'com_number':com_number}),
        		contentType: 'application/json',
        		success: function(response){
        			if(response == ''){
        				console.log('asdfadsf');
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