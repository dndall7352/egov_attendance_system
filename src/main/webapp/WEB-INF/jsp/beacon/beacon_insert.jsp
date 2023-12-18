<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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

<div class="modal fade" id="searchCPN" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="staticBackdropLabel">회사명 검색</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body" style="min-height: 100px;">
        <div class="input-group mb-3">
		  <select class="form-select" id="category">
		    <option value="com_name" selected>회사명</option>
		    <option value="com_number">C.P.N</option>
		  </select>
		  <input type="text" class="form-control" id="searchText" style="width: 50%;">
		  <button class="btn btn-outline-secondary" type="button" id="search-company-btn" >검색</button>
		</div>
		<!-- <hr style="border: 1px gray solid; margin-bottom: 20px 0;"> -->
		<div style="padding-left: 5%; padding-right: 5%;">
			<b>검색결과&nbsp;</b>
			<span id="search-cnt" style="color: red;"></span>
			<span>건</span>
			<table class="table table-sm table-hover">
				<thead style="text-align: center;" class="table-secondary">
					<tr>
						<th scope="col">C.P.N</th>
						<th scope="col" style="width: 60%;">회사명</th>
						
					</tr>
				</thead>
				<tbody class="table-group-divider" id="search-company-list">
				</tbody>
			</table>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>

<form id="insert-beacon-form" method="post" action="/beacon/insertBeacon.do">
    <table class="table select-beacon-table" style="min-width: 100%; width: 100%;">
        <tr>
            <td class="thead" style="width: 12%;"></td>
            <td class="thead" id="detail-number" style="width: 35%;">신규 비콘 추가</td>
            <td rowspan="4" class="thead" style="width: 9%;">비콘<br>정보</td>
            <td class="thead" style="width: 9%;">UUID</td>
            <td class="table-input" style="width: 35%;"><input type="text" class="table-input-text" name="uuid" maxlength="32" value=""></td>
        </tr>
        <tr>
            <td class="thead">회사명</td>
            <td id="cpn-com-name" style="background-color: #B0C3E6; text-align: left; cursor: default;"></td>
            <td class="thead">Major</td>
            <td class="table-input"><input type="text" class="table-input-text beacon-code" maxlength="5" name="major" value=""></td>
        </tr>
        <tr>
            <td class="thead">C.P.N</td>
            <td class="table-input" style=" background-color: #B0C3E6;">
            	<div style="display: flex; justify-content: space-between;">
            		<input type="text" class="table-input-text" style="width:80%; justify-content: space-between;  background-color: #B0C3E6; cursor: default;" readonly="readonly" name="com_number" value="">
            		<button type="button" class="btn btn-success" id="cpn-search-btn" style="height: 30px; display: flex; align-items: center;">검색</button>
            	</div>
            </td>
            <td class="thead">Minor</td>
            <td class="table-input"><input type="text" class="table-input-text beacon-code" maxlength="5" name="minor" value=""></td>
        </tr>
        <tr>
            <td class="thead">설치장소</td>
            <td class="table-input"><input type="text" class="table-input-text" name="emplacement" maxlength="200" value=""></td>
            <td class="thead">비콘상태</td>
            <td class="table-input">
                <div id="beacon-state">
                    <div data-state="1" class="selected">정상</div>
                    <div data-state="0">중지</div>
                </div>
            </td>
        </tr>
        <tr>
            <td class="thead" style="height: 120px;">참고 사항</td>
            <td colspan="4" class="table-input" style="vertical-align: middle;">
            	<textarea name="note" maxlength="50"></textarea>
            </td>
        </tr>
    </table>
    <div style="width: 100%; text-align: right">
    <button type="button" class="btn btn-success" id="insert-beacon-btn">저장</button>
    </div>
 </form> 

 
    <script>

        $('#beacon-state').on('click', function(){ // 상태 체크
            $(this).find('div').each(function(){
               	$(this).toggleClass('selected');
            });
        });
        
        $('input[name="com_number"]').on('input', function(){ // c.p.n 데이터 타입
        	let inputVal = $(this).val();
        	inputVal = inputVal.replace(/[^0-9]/g, '');
        	$(this).val(inputVal);
        });
        
        $('#cpn-search-btn').on('click', function(){
     	   $.ajax({
     		  url:"/beacon/searchCompanyList.do",
     		  method: 'post',
     		  dataType:'json',
     		  success: function(response){
     			  let content =  $('#search-company-list');
     			  content.empty();
     			  console.log(response);
     			  var cnt = response.cnt;
     			  var data = response.resultList;
     			  $('#search-cnt').text(cnt);
     			  for(var i=0; i<data.length; i++){
     				  var com_number = data[i].comNumber;
     				  var com_name = data[i].comName;
     				  
     				  var append_html = '<tr class="company-item">' + 
 						  						'<td>' + com_number + '</td>' + 
 						  						'<td>' + com_name + '</td>' + 
 						  				 '</tr>';
 					content.append(append_html);
     			  }
     		  }
     	   });
     	   $('#searchCPN').modal('show');
        });
        
        $('#searchCPN').on('click', '#search-company-btn', function(){
      	  var selected = $('#category').val();
      	  var inputText = $('#searchText').val();
      	  
      	  if(selected == 'select'){
      		  alert('옵션을 선택해주세요.');
      		  return;
      	  }else if(inputText == ''){
      		  alert('검색어를 입력하세요');
      		  return;
      	  }
      	  
      	  $.ajax({
      		  url:'/beacon/searchCompany.do',
      		  method:'post',
      		  contentType: 'application/json',
      		  data :JSON.stringify({
      			  searchType : selected,
      			  searchText : inputText
      		  }),
      		  dataType:'json',
      		  success: function(response){
      			let content =  $('#search-company-list');
  			  content.empty();
  			  console.log(response);
  			  var cnt = response.cnt;
  			  var data = response.resultList;
  			  $('#search-cnt').text(cnt);
  			  for(var i=0; i<data.length; i++){
  				  var com_number = data[i].comNumber;
  				  var com_name = data[i].comName;
  				  
  				  var append_html = '<tr class="company-item">' + 
						  						'<td>' + com_number + '</td>' + 
						  						'<td>' + com_name + '</td>' + 
						  				 '</tr>';
					content.append(append_html);
      			  }

      		  }
      	  });
        });
        
        $('#searchCPN').on('click', '.company-item', function(){
      	  let com_number = $(this).children('td:nth-child(1)').text();
      	  let com_name = $(this).children('td:nth-child(2)').text();
      	  $('#searchCPN').modal('hide');
      	  $('input[name="com_number"]').val(com_number);
      	  $('#cpn-com-name').text(com_name);
      	  
        })
        
        $('.beacon-code').on('input', function(){
    	  let inputVal = $(this).val();
    	  inputVal = inputVal.replace(/[^0-9]/g, '');
    	  $(this).val(inputVal);
      });
        
        $('input[name="uuid"]').on('input',function(){
      	  var inputValue = $(this).val().replace(/[^a-zA-Z0-9]/g, '');
      	  $(this).val(inputValue.toUpperCase());
        })
      
    </script>
