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
        <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/beacon.css'/>"/>
</head>

<body style="padding: 20px;">
    <ul style="display: flex;align-items: center;justify-content: space-between;">
        <div class="gap-2 d-md-block">
            <button class="btn btn-secondary" type="button">기업 관리</button>
            <button class="btn btn-secondary" type="button">코드 관리</button>
            <button class="btn btn-primary" type="button">비콘 관리</button>
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
            <select class="form-select" aria-label="Default select example" style="width: 150px; margin-right: 10px;">
                <option value="all" selected>전체</option>
                <option value="UUID">UUID</option>
                <option value="com_name">회사명</option>
                <option value="note">참고 사항</option>
            </select>
            <div class="input-group mb-3">
                <input type="text" class="form-control" style="text-align: center;" placeholder="검색어를 입력해주세요" aria-label="Recipient's username" aria-describedby="button-addon2">
                <button class="btn btn-outline-secondary" type="button" id="button-addon2" style="display: flex; align-items: center;">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search"
                    viewBox="0 0 16 16">
                    <path
                        d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
                </svg>
                </button>
              </div>
        </div>
        <button type="button" class="btn btn-success">+ 신규비콘</button>
    </div>
    <table class="table table-striped table-hover" style="text-align: center;">
        <thead>
            <tr>
                <td rowspan="2" class="col-1">NO.</td>
                <td rowspan="2" class="col-2">UUID</td>
                <td colspan="2" class="col-3">사용처</td>
                <td colspan="2" class="col-4">비콘 신호</td>
                <td rowspan="2" class="col-5">비콘<br>상태</td>
                <td rowspan="2" class="col-6">참고 사항</td>

            </tr>
            <tr>
                <td>회사명</td>
                <td>C.P.N</td>
                <td>Major</td>
                <td>Minor</td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>123</td>
                <td>A1234567890BCDEF</td>
                <td>(주)에이투지시스템</td>
                <td>A1234567890BCDEF</td>
                <td>12345</td>
                <td>12345</td>
                <td>정상</td>
                <td>(주)에이투지시스템</td>
            </tr>
            <tr>
                <td>data1</td>
                <td>data2</td>
                <td>data3</td>
                <td>data4</td>
                <td>data5</td>
                <td>data6</td>
                <td>data7</td>
                <td>data8</td>
            </tr>
            <tr>
                <td>data1</td>
                <td>data2</td>
                <td>data3</td>
                <td>data4</td>
                <td>data5</td>
                <td>data6</td>
                <td>data7</td>
                <td>data8</td>
            </tr>
            <tr>
                <td>data1</td>
                <td>data2</td>
                <td>data3</td>
                <td>data4</td>
                <td>data5</td>
                <td>data6</td>
                <td>data7</td>
                <td>data8</td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </tbody>
    </table>
    <br>
    <div style="text-align: center;">페이지</div>
    <hr style="border: 1px #4472C4 solid; margin-bottom: 20px 0;">
    <!-- ì ê· ë²í¼ì´ë ê²ìë¬¼ í´ë¦­íë©´ ë¹ëê¸°ë¡ ìì¸ì ë³´ íì -->
    
</body>
</html>