<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/beacon.css'/>"/>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<style>
	.beacon-item{
		cursor: pointer;
	}
	.page-link.active{
		cursor: default;
	}
	#searchName.null-check{
	color: var(--bs-body-color);
    background-color: var(--bs-body-bg);
    border-color: #df203640;
    outline: 0;
    box-shadow: 0 0 0 0.25rem #df203640;
    }
</style>
</head>

<body style="padding: 20px;">
    <ul style="display: flex;align-items: center;justify-content: space-between;">
        <div class="gap-2 d-md-block">
            <button class="btn btn-secondary" type="button">기업 관리</button>
            <button class="btn btn-secondary" type="button">코드 관리</button>
            <button class="btn btn-primary" type="button" id="beacon-management">비콘 관리</button>
            <button class="btn btn-secondary" type="button">통계 관리</button>
            <button class="btn btn-secondary" type="button">고객 센터</button>
            <button class="btn btn-secondary" type="button">자료 관리</button>
        </div>
        <div>
            <p style="font-size: 20px; margin-top: auto; margin-bottom: auto; float: left; margin-right: 50px;">로그인 사용자</p>
            <a><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor"
                    class="bi bi-box-arrow-right" viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
                        d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z" />
                    <path fill-rule="evenodd"
                        d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z" />
                </svg>
            </a>
        </div>
    </ul>
    <hr style="border: 1px gray solid; margin-bottom: 20px 0;">
    <div style="display: flex; justify-content: space-between; align-items: baseline;">
        <div style="display: flex; align-items: baseline;">
            <select class="form-select" id="searchType" aria-label="Default select example" style="width: 150px; margin-right: 10px;">
                <option value="all" ${pageVO.cri.searchType == 'all'? 'selected' : '' }>전체</option>
                <option value="uuid" ${pageVO.cri.searchType == 'uuid'? 'selected' : '' }>UUID</option>
                <option value="com_name" ${pageVO.cri.searchType == 'com_name'? 'selected' : '' }>회사명</option>
                <option value="note" ${pageVO.cri.searchType == 'note'? 'selected' : '' }>참고 사항</option>
            </select>
            <div class="input-group mb-3">
                <input type="text" class="form-control" id="searchName" style="text-align: center;" placeholder="검색어를 입력해주세요" aria-label="Recipient's username" aria-describedby="button-addon2" value="${pageVO.cri.searchName }">
                <button class="btn btn-outline-secondary" type="button" id="button-addon2" style="display: flex; align-items: center;">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search"
                    viewBox="0 0 16 16">
                    <path
                        d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
                </svg>
                </button>
              </div>
        </div>
        <button type="button" class="btn btn-success" id="add-beacon-btn">+ 신규비콘</button>
    </div>
    <table class="table table-striped table-hover" style="text-align: center;">
        <thead>
            <tr>
                <td rowspan="2" class="col-001">NO.</td>
                <td rowspan="2" class="col-002">UUID</td>
                <td colspan="2" class="col-003">사용처</td>
                <td colspan="2" class="col-004">비콘 신호</td>
                <td rowspan="2" class="col-005">비콘<br>상태</td>
                <td rowspan="2" class="col-006">참고 사항</td>

            </tr>
            <tr>
                <td>회사명</td>
                <td>C.P.N</td>
                <td>Major</td>
                <td>Minor</td>
            </tr>
        </thead>
        <tbody>
        
        <c:forEach var="beacon" items="${beaconList }">
        	<tr class="beacon-item">
                <td class="beacon-number">${beacon.beaconNumber }</td>
                <td>${beacon.uuid }</td>
                <td>${beacon.comName }</td>
                <td>${beacon.comNumber }</td>
                <td>${beacon.major }</td>
                <td>${beacon.minor }</td>
                <td>
                <c:choose>
                 <c:when test="${beacon.use == 1 }">정상</c:when>
                 <c:when test="${beacon.use == 0 }">중지</c:when>
                </c:choose>
                </td>
                <td>${beacon.note }</td>
            </tr>
        </c:forEach>
           
        </tbody>
    </table>
    <br>
    <div>
		<nav aria-label="Page navigation example" id="beaconPage">
		  <ul class="pagination justify-content-center">
		  	<c:if test="${pageVO.prev }">
			    <li class="page-item"><a class="page-link" href="#" data-pagenum='${pageVO.startPage - 1 }'>이전</a></li>
			</c:if>
			<c:forEach var="num" begin="${pageVO.startPage }" end="${pageVO.endPage }">
			    <li class="page-item "><a class="page-link ${pageVO.cri.pageNum eq num ? 'active' : ''}" href="#" data-pagenum="${num }">${num }</a></li>
			</c:forEach>
			<c:if test="${pageVO.next }">
			    <li class="page-item"><a class="page-link" href="#" data-pagenum='${pageVO.endPage + 1 }'>다음</a></li>
			</c:if>
		  </ul>
		</nav>
</div>
	<form action="/beacon/beaconList.do" method="get" name="searchPage">
		<input type="hidden" name="pageNum" value="1">
		<input type="hidden" name="amount" value="${pageVO.cri.amount }">
		<input type="hidden" name="searchType" value="${pageVO.cri.searchType }">
		<input type="hidden" name="searchName" value="${pageVO.cri.searchName }">
	</form>

    <hr style="border: 1px #4472C4 solid; margin-bottom: 20px 0;">
    <div id="detail-field"></div>
    
    
    <script type="text/javascript">
    $(function() {
    	const form = $('form[name="searchPage"]');
    	$('#beacon-management').on('click', function(){
    		window.location.href = '/beacon/beacon.do';
    	});
    	
    	$('#button-addon2').on('click', function(){ // 검색 기능
    		let searchType = $('#searchType').val();
    		let searchName = $('#searchName').val();
    		if(searchName == null || searchName == ''){
    			$('#searchName').addClass('null-check');
    			setTimeout(function(){
    				$('#searchName').removeClass('null-check');
    			}, 2000);
    		}else{
	    		form.find('input[name="searchType"]').val(searchType);
	    		form.find('input[name="searchName"]').val(searchName);
	    		form.submit();
    		}
    	});
    	
    	
    	$('#beaconPage .page-item').on('click', function(){ // 페이지 기능
    		let pageNum = $(this).find('.page-link').data('pagenum');
    		if(pageNum != ${pageVO.cri.pageNum}){
	    		form.find('input[name="pageNum"]').val(pageNum);
	    		form.submit();
    		}else{
    			return;
    		}
    	});
		$('#add-beacon-btn').on('click', function(){ // 신규 비콘 추가
			
		if($(this).hasClass('onClicked')){
			$('#detail-field').empty();
			$(this).text('+ 신규비콘');
		}else{
			$(this).text('- 신규비콘');
    		$.ajax({
    			type:'get',
    			url:'/beacon/insertJspPage.do',
    			success:function(response){
    				$('#detail-field').html(response);
    			}
    		});
		}
		$(this).toggleClass('onClicked');
    	});
		
        $('table').on('click', '.beacon-item', function() { // 해당 비콘 상세 정보
            let beaconNumber = $(this).children('.beacon-number').text();
            if(!$('#detail-field').is(':empty') && $('.table.select-beacon-table #detail-number').text() == beaconNumber){
            	$('#detail-field').empty();
            }else{
	            $.ajax({
	                type: 'GET',
	                url: '/beacon/selectBeacon.do', // beacon_select.jsp에 대한 경로를 정확히 지정해야 합니다.
	                data: { beaconNumber: beaconNumber },
	                success: function(response) {
	                    // 서버에서 받은 HTML을 detail-field에 추가
	                    $('#detail-field').html(response);
	                    
	                },
	            });
            }
        });
         $('#detail-field').on('click','#update-beacon-btn', function(){ // 상세 비콘 수정
        	let com_number = $('input[name="com_number"]').val();
			let emplacement = $('input[name="emplacement"]').val();
			let uuid = $('input[name="uuid"]').val();
			let major = $('input[name="major"]').val();
			let minor = $('input[name="minor"]').val();
			console.log(emplacement);
			console.log(uuid);
        	findComName(com_number);
        	if($('#cpn-com-name').text() != "" && emplacement != "" && uuid != "" && major != "" && minor != ""){
        		var addData = {
        				beacon_number : $('#detail-number').text(),
        				com_name : $('#cpn-com-name').text(),
        				use : $('#beacon-state').find('.selected').data('state'),
        				pageNum : ${pageVO.cri.pageNum},
        				amount : ${pageVO.cri.amount},
        				searchType : '${pageVO.cri.searchType}',
        				searchName : '${pageVO.cri.searchName}'
        		}
        		$.each(addData, function(key, value){
        			var appendInput = $("<input>").attr({
            			type:"hidden",
            			name:key,
            			value: value
            		});
        			$('#update-beacon-form').append(appendInput);
        		});
        		
        		$('#update-beacon-form').submit();
        	}else{
        		$('#beaconModal').find('.modal-body p').text('내용을 입력하세요');
				$('#beaconModal').modal('show');
        	}
        });
       
        
    });
    
    	
    </script>
</body>
</html>