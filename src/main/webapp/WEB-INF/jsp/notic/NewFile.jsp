<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!--<meta charset="UTF-8">-->
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet" /> 
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet" /> 
	
	
<title>공지사항 목록</title>
<!--<link type="text/css" rel="stylesheet" href="/test_4/css/egovframework/sas.css">
<link type="text/css" rel="stylesheet" href="/test_4/css/egovframework/_backdrop.css">
<link type="text/css" rel="stylesheet" href="/test_4/css/egovframework/_breakpoints.css">
<link type="text/css" rel="stylesheet" href="/test_4/css/egovframework/_buttons.css">
<link type="text/css" rel="stylesheet" href="/test_4/css/egovframework/_dropdown.css">
<link type="text/css" rel="stylesheet" href="/test_4/css/egovframework/_navber.css">
<link type="text/css" rel="stylesheet" href="/test_4/css/egovframework/_table.css"> -->
</head>

<body>
<%@ include file = "../include/topmenu1.jsp" %>
	<div class="table-container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col"><font style="vertical-align: inherit"><font
							style="vertical-align: inherit">NO</font></font></th>
					<th scope="col"><font style="vertical-align: inherit"><font
							style="vertical-align: inherit">공지제목</font></font></th>
					<th scope="col"><font style="vertical-align: inherit"><font
							style="vertical-align: inherit">공지 일자</font></font></th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<tr>
					<th scope="row"><font style="vertical-align: inherit"><font
							style="vertical-align: inherit">100</font></font></th>
					<td><font style="vertical-align: inherit"><font
							style="vertical-align: inherit">공지
								제목입니다.</font></font></td>
					<td><font style="vertical-align: inherit"><font
							style="vertical-align: inherit">2023/09/11
								11:12:34</font></font></td>
				</tr>
				<tr>
					<th scope="row"><font style="vertical-align: inherit"><font
							style="vertical-align: inherit">99</font></font></th>
					<td><font style="vertical-align: inherit"><font
							style="vertical-align: inherit">공지제목입니다.</font></font>
					</td>
					<td><font style="vertical-align: inherit"><font
							style="vertical-align: inherit">2023/09/11
								11:12:34</font></font></td>
				</tr>
				<tr>
					<th scope="row"><font style="vertical-align: inherit"><font
							style="vertical-align: inherit">98</font></font></th>
					<td><font style="vertical-align: inherit"><font
							style="vertical-align: inherit">공지제목입니다.</font></font>
					</td>
					<td><font style="vertical-align: inherit"><font
							style="vertical-align: inherit">2023/09/11
								11:12:34</font></font></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>

</html>