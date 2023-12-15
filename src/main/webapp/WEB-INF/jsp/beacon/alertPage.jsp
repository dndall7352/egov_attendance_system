<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <script>
        var alertMessage = "${alertMessage}";
        var redirectUrl = "${redirectUrl}";

        if (alertMessage) {
            alert(alertMessage);

            // 이동할 URL이 존재하면 페이지 이동
            if (redirectUrl) {
                window.location.href = redirectUrl;
            }
        }
    </script>
</body>
</html>