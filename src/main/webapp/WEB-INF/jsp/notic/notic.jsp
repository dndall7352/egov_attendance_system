<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 사항 작성</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.13.2/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.13.2/jquery-ui.min.js"></script>

<style>
body {
    font-size: 9pt;
}

table {
    width: 60%;
    border-collapse: collapse;
}

th, td {
    border: 1px solid #cccccc;
    padding: 4px;
    font-size: 15px;
    text-align: center;
    color: #ffffff;
}

.input1 {
    width: 98%;
    height: 70%;
    font-size: 15px;
    display: block;
}

.textarea {
    width: 98%;
    height: 200px;
}

.btn {
    background-color: #68AA3B;
    color: #ffffff;
    width: 100px;
    height: 35px;
    padding: 10px;
    margin: 5px;
    border: 0px solid #000000;
    border-radius: 7.5px;
    box-shadow: 2px 2px 5px rgba(0.1, 0.1, 0.1, 0.6);
    cursor: pointer;
    font-size: 15px;
}
</style>

<script>
function fn_submit() {
    if ($.trim($("#title").val()) == "") {
        alert("제목을 입력해주세요!");
        $("#title").focus();
        return false;
    }
    $("#title").val($.trim($("#title").val()));

    if ($("#content").val() == "") {
        alert("내용을 입력해주세요!");
        $("#content").focus();
        return false;
    }
    $("#content").val($.trim($("#content").val()));

    var formData = $("#notic").serialize();
    $.ajax({ 
        type: "POST",
        data: formData,
        url: "noticWriteSave.do",
        dataType: "text",
        success: function(data) {
            if (data == "ok") {
                alert("저장완료");
                location = "noticList.do";
            } else {
                alert("저장실패");
            }
        },
        error: function() {
            alert("오류발생");
        }
    });
}

function getCurrentTimeFormatted() {
    var currentTime = new Date();
    var formattedTime = currentTime.toLocaleString('ko-KR', { year: 'numeric', month: '2-digit', day: '2-digit', hour: '2-digit', minute: '2-digit', second: '2-digit', hour12: true });
    return formattedTime;
}

$(document).ready(function() {
    setInterval(function() {
        $("#currentTimeDisplayFormatted").text(getCurrentTimeFormatted());
    }, 1000);
});


</script>
</head>

<body>
<center>
<form id="notic">
<table>
	<h1 style="font-family: 'Gothic', sans-serif; color: blue; font-size: 20pt;">공지 사항 신규 작성</h1>
	<tr>
		<td width="4%" height="40px" style="background-color:#4472C4;">신규</td>
		<td width="8%" style=" background-color:#4472C4;"><label for="title">공지 제목</label></td>
		<td width="50%"><input type="text" name="title" id="title" class="input1" placeholder="공지사항 제목 입력"></td>
		<td width="8%" style="background-color:#4472C4;">공지 일자</td>
		<td width="8%" style="background-color:#4472C4;"><p id="currentTimeDisplayFormatted"></p></td>
    </tr>
    <tr>
        <th width="4%" height="70%" colspan="1" style="background-color:#4472C4;"><label for="content">공지내용</label></th>
        <td width="76%" height="70%" colspan="4"><textarea type="content" name="content" id="content" class="textarea"></textarea></td> <!-- 이거 출력됨 -->
    </tr>
    <tr>
        <th colspan="5">
            <button class="btn" type="button" onclick="fn_submit();  return false;">저장</button>
            <button class="btn" type="reset">취소</button>
        </th>
    </tr>   
</table>
</form>
</body>

</html>