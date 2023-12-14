<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<ul style="display: flex;align-items: center;justify-content: space-between;">
        <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
            <div class="btn-group" role="group"">
                <button type="button" class="btn dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" data-page-name="company">
                  기업 관리
                </button>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="#">기업 등록 관리</a></li>
                  <li><a class="dropdown-item" href="#">기업 목록 인쇄</a></li>
                  <li><a class="dropdown-item" href="#">기업 관리자 기능</a></li>
                </ul>
            </div>
            <div class="btn-group" role="group">
                <button type="button" class="btn dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" data-page-name="code">
                    코드 관리
                </button>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="#">코드 등록 관리</a></li>
                  <li><a class="dropdown-item" href="#">코드 목록 인쇄</a></li>
                </ul>
            </div>
            <div class="btn-group" role="group">
                <button type="button" class="btn dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" data-page-name="beacon">
                    비콘 관리
                </button>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="/beacon/beaconList.do">비콘 등록 관리</a></li>
                  <li><a class="dropdown-item" href="/beacon/printBeacon.do">비콘 목록 인쇄</a></li>
                </ul>
            </div>
            <div class="btn-group" role="group">
                <button type="button" class="btn dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" data-page-name="statistics">
                    통계 관리
                </button>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="#">통계 프로그램 등록 관리</a></li>
                  <li><a class="dropdown-item" href="#">통계 프로그램 목록 관리</a></li>
                </ul>
            </div>
            <div class="btn-group" role="group">
                <button type="button" class="btn dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" data-page-name="service">
                    고객 센터
                </button>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="#">Q/A 게시판</a></li>
                  <li><a class="dropdown-item" href="#">문의 목록 인쇄</a></li>
                </ul>
            </div>
            <div class="btn-group" role="group">
                <button type="button" class="btn dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" data-page-name="data">
                    자료 관리
                </button>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="#">DB 자료 관리</a></li>
                  <li><a class="dropdown-item" href="#">DB 관리 내용 목록 인쇄</a></li>
                </ul>
            </div>
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
    
    <script type="text/javascript">
    $(function(){
    	var pageName = '${pageName}';
    	$('.btn.dropdown-toggle').each(function(){
    		if($(this).data('page-name') == pageName){
    			$(this).addClass('btn-primary');
    		}else{
    			$(this).addClass('btn-secondary');
    		}
    	});
    });
    	
    </script>