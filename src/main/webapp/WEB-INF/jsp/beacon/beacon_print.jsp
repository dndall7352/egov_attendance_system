<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AtoZSystem</title>
    <link rel="icon" href="/resources/images/atoz_logo_icon.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/beacon.css'/>"/>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<style type="text/css">
@media print{
	html, body { -webkit-print-color-adjust:exact; width: 210mm; height: 297mm; }
    table { page-break-inside:auto; }
    tr    { page-break-inside:avoid; page-break-after:auto; }
    thead { display:table-header-group; }
    tfoot { display:table-footer-group; }
	.no-print{
		visibility: hidden;
	}
	#printableArea, #printableArea *{
		visibility: visible;
	}
	#printableArea{
		position: absolute;
		left: 0;
		top: 0;
		margin: 0;
		width: 100%;
		height: 100%;
		overflow: visible;
	}
	#printableArea table td {
      border: 1px solid black;
      padding: .5rem .5rem;
      -webkit-print-color-adjust:exact;
	}
	#printableArea .thead-print{
		background-color: #e2e3e5;
		-webkit-print-color-adjust:exact;
	} 
}
#printableArea table td {
      border: 1px solid black;
      padding: .5rem .5rem;
      -webkit-print-color-adjust:exact;
}
#printableArea .thead-print{
background-color: #e2e3e5;
}
</style>
</head>

<body style="padding: 20px;">
    <div id="header" class="no-print"></div>
    <div id="data-space">
    <div style="display: flex; justify-content: space-between; align-items: baseline;" class="no-print">
        <div style="display: flex; align-items: baseline;">
            <select class="form-select" id="searchType" aria-label="Default select example" style="width: 150px; margin-right: 10px;">
                <option value="all" ${cri.searchType == 'all'? 'selected' : '' }>전체</option>
                <option value="uuid" ${cri.searchType == 'uuid'? 'selected' : '' }>UUID</option>
                <option value="com_name" ${cri.searchType == 'com_name'? 'selected' : '' }>회사명</option>
                <option value="note" ${cri.searchType == 'note'? 'selected' : '' }>참고 사항</option>
                <option value="major"
						${cri.searchType == 'major'? 'selected' : '' }>Major</option>
					<option value="minor"
						${cri.searchType == 'minor'? 'selected' : '' }>Minor</option>
            </select>
            <div class="input-group mb-3">
                <input type="text" class="form-control" id="searchName" style="text-align: center;" placeholder="검색어를 입력해주세요" aria-label="Recipient's username" aria-describedby="button-addon2" value="${cri.searchName }">
                <button class="btn btn-outline-secondary" type="button" id="button-addon2" style="display: flex; align-items: center;">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search"
                    viewBox="0 0 16 16">
                    <path
                        d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
                </svg>
                </button>
                <div style="display: flex; align-items: flex-end; margin-left: 10px; font-size: 20px;">
						<b>검색결과&nbsp;</b>
						<span style="color: red;">${cnt}</span>
						<span>건</span>
					</div>
              </div>
        </div>
        <button type="button" class="btn btn-success" id="print-btn">🖨 인쇄</button>
    </div>
    <div style="width: 100%; text-align: -webkit-center;">
    <div id="printableArea" style="width:210mm; height:297mm; ">
    <div style="display: flex; align-items: center; justify-content: space-between;">
    	<h2>비콘 목록</h2>
    	<span id="today"></span>
    </div>
    <%-- 
    <table class="table print-table" style="text-align: center;">
        <thead class="table-secondary" id="print-table-head">
            <tr>
                <td rowspan="2" style="width: 4%;">NO.</td>
                <td rowspan="2" style="width: 16%;">UUID</td>
                <td colspan="2" style="width: 29%;">사용처</td>
                <td colspan="2" style="width: 15%;">비콘 신호</td>
                <td rowspan="2" style="width: 15%;">설치 장소</td>
                <td rowspan="2" style="width: 5%;">비콘<br>상태</td>
                <td rowspan="2" style="width: 16%;">참고 사항</td>

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
        	<tr>
                <td class="beacon-number">${beacon.beaconNumber }</td>
                <td>${beacon.uuid }</td>
                <td>${beacon.comName }</td>
                <td>${beacon.comNumber }</td>
                <td>${beacon.major }</td>
                <td>${beacon.minor }</td>
                <td>${beacon.emplacement }</td>
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
    </div> --%>
    <br>
   	
   	<c:forEach var="beacon" items="${beaconList }">
        <table class="table-print"
                style="text-align: center; width: 100%; font-size: 13px; border: 1px solid black; margin-bottom: 5px;">
                
                    <tr>
                        <td style="width: 6%; background-color: #e2e3e5; border: 1px solid black; padding: .5rem .5rem;" rowspan="3">${beacon.beaconNumber }</td>
                        <td style="width: 8%; background-color: #e2e3e5; border: 1px solid black; padding: .5rem .5rem;" class="thead-print">회사명</td>
                        <td style="width: 33%; border: 1px solid black; padding: .5rem .5rem;">${beacon.comName }</td>
                        <td style="width: 13%; background-color: #e2e3e5; border: 1px solid black; padding: .5rem .5rem;" class="thead-print">Major</td>
                        <td style="width: 10%; border: 1px solid black; padding: .5rem .5rem;">${beacon.major }</td>
                        <td style="width: 30%; background-color: #e2e3e5; border: 1px solid black; padding: .5rem .5rem;" class="thead-print">참고 사항</td>
                    </tr>
                    <tr>
                        <td style=" background-color: #e2e3e5; border: 1px solid black; padding: .5rem .5rem;" class="thead-print">C.P.N</td>
                        <td style=" border: 1px solid black; padding: .5rem .5rem;">${beacon.comNumber }</td>
                        <td style=" background-color: #e2e3e5; border: 1px solid black; padding: .5rem .5rem;" class="thead-print">Minor</td>
                        <td style=" border: 1px solid black; padding: .5rem .5rem;">${beacon.minor }</td>
                        <td style=" border: 1px solid black; padding: .5rem .5rem;" rowspan="2" id="print-note">
							<c:choose>
								<c:when test="${fn:length(beacon.note) > 15}">
							    		${fn:substring(beacon.note, 0, 15)}...
							  	</c:when>
								<c:otherwise>${beacon.note }</c:otherwise>
							</c:choose>
						</td>
                    </tr>
                    <tr>
                        <td style=" background-color: #e2e3e5; border: 1px solid black; padding: .5rem .5rem;" class="thead-print">UUID</td>
                        <td style="font-size: 11px; vertical-align: middle; border: 1px solid black; padding: .5rem .5rem;">${beacon.uuid }</td>
                        <td style=" background-color: #e2e3e5; border: 1px solid black; padding: .5rem .5rem;" class="thead-print">비콘상태</td>
                        <td>
                        	<c:choose>
			                 <c:when test="${beacon.use == 1 }">정상</c:when>
			                 <c:when test="${beacon.use == 0 }">중지</c:when>
			                </c:choose>
			            </td>
                    </tr>
                 
            </table>
            </c:forEach>
    </div>
    </div>
	<form action="/beacon/printBeacon.do" method="get" name="searchPage">
		<input type="hidden" name="searchType" value="${pageVO.cri.searchType }">
		<input type="hidden" name="searchName" value="${pageVO.cri.searchName }">
	</form>
	
</div>

    <script type="text/javascript">
    
    $(function(){
    	// let pageVO_pageNum = ${pageVO.cri.pageNum};
 	  //  let pageVO_amount = ${pageVO.cri.amount};
 	  //  let pageVO_searchType = '${pageVO.cri.searchType}';
 	  //  let pageVO_searchName = '${pageVO.cri.searchName}';
 	    
 	    let today = new Date();   

 	    let year = today.getFullYear();
 	    let month = today.getMonth() + 1;
 	    let date = today.getDate(); 
 	    let day = today.getDay(); 
 	    $('#today').text(year + '/' + month + '/' + date);
 	    
 	   $.ajax({
 			url:"/systemAdmin/getHeader.do",
 			type: 'get',
 			data:{pageName:"beacon"},
 			success:function(response){
 				$('#header').html(response);
 			}
 		});
 		
 		const form = $('form[name="searchPage"]');
 		
 		$('#button-addon2').on('click', function(){ // 검색 기능
 			let searchType = $('#searchType').val();
 			let searchName = $('#searchName').val();
 			if(searchName == null || searchName == ''){
 				window.location.href = "/beacon/printBeacon.do";
 			}else{
 	    		form.find('input[name="searchType"]').val(searchType);
 	    		form.find('input[name="searchName"]').val(searchName);
 	    		form.submit();
 			}
 		});
 		
 		$('#print-btn').on('click',function(){
 			var printContents = $("#printableArea").html();
 		    var originalContents = $("body").html();
 		    
 		   $("body").html(printContents);
 	      window.print();
 	      $("body").html(originalContents);
 		})
    });
	   
    
    </script>
    <%-- <script type="text/javascript" src="<c:url value='/js/beacon.js'/>"></script> --%>
</body>
</html>