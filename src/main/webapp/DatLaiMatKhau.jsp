<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đặt lại mật khẩu</title>

    <style>
        body {
            font-family: Tahoma, Arial, sans-serif;
            background: #f5f5f5;
        }

        .box {
            width: 400px;
            margin: 100px auto;
            background: #fff;
            padding: 25px;
            border-radius: 6px;
            text-align: center;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 12px;
        }

        button {
            background: #6D4C41;
            color: white;
            border: none;
            padding: 10px;
            width: 100%;
            cursor: pointer;
        }

        .error {
            color: red;
            margin-bottom: 10px;
        }
    </style>
</head>

<body>

<div class="box">
    <h2>Đặt lại mật khẩu</h2>

    <!-- hiexn thị lỗi -->
    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>


    <form method="post" action="<c:url value='/ResetPassword'/>">

        <!-- token được servlet set -->
        <input type="hidden" name="token" value="${token}">

        <input type="password"
               name="password"
               placeholder="Mật khẩu mới"
               required>

        <small>
            Mật khẩu ≥ 8 ký tự, gồm chữ, số và ký tự đặc biệt
        </small>

        <br><br>

        <button type="submit">Đặt lại mật khẩu</button>
    </form>

</div>

</body>
</html>
