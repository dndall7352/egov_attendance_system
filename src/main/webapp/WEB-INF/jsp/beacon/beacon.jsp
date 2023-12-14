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

</head>

<body style="padding: 20px;">
    <div id="header"></div>
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
        <thead id="list-table-head">
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
	    let pageVO_pageNum = ${pageVO.cri.pageNum};
	    let pageVO_amount = ${pageVO.cri.amount};
	    let pageVO_searchType = '${pageVO.cri.searchType}';
	    let pageVO_searchName = '${pageVO.cri.searchName}';
    </script>
    <script type="text/javascript" src="<c:url value='/js/beacon.js'/>"></script>
</body>
</html>