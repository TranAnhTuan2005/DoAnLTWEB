<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">


</head>

<style>
    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        font-family: "Segoe UI", sans-serif;
    }

    /* Căn giữa toàn màn hình */
    body {
        background-color: #e9ecef;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    /* Tiêu đề chính */
    .title {
        font-size: 28px;
        font-weight: 600;
        color: #333;
        margin-bottom: 20px;
    }

    /* Hộp đăng nhập */
    .login-container {
        background-color: #fff;
        width: 350px;
        padding: 30px 40px;
        border-radius: 4px;
        box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
        text-align: center;
    }

    /* Dòng phụ nhỏ bên dưới tiêu đề */
    .subtitle {
        color: #666;
        font-size: 14px;
        margin-bottom: 20px;
    }

    /* Nhóm input + icon */
    .input-group {
        position: relative;
        margin-bottom: 15px;
    }

    .input-group i {
        position: absolute;
        left: 10px;
        top: 50%;
        transform: translateY(-50%);
        color: #888;
    }

    /* Ô nhập */
    .input-group input {
        width: 100%;
        padding: 10px 10px 10px 35px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 14px;
        outline: none;
    }

    .input-group input:focus {
        border-color: #007bff;
    }

    /* Nút đăng nhập */
    .btn-login {
        width: 100%;
        background-color: #007bff;
        border: none;
        color: #fff;
        padding: 10px;
        font-size: 15px;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    .btn-login:hover {
        background-color: #0056b3;
    }


</style>

<body>
    <h2 class="title">Đăng nhập</h2>
    <div class="login-container">

        <p class="subtitle">Đăng nhập để bắt đầu phiên làm việc</p>

        <form id="loginForm">
            <div class="input-group">
                <i class="fa fa-user"></i>
                <input type="text" id="username" placeholder="Username" required>
            </div>
            <div class="input-group">
                <i class="fa fa-lock"></i>
                <input type="password" id="password" placeholder="Password" required>
            </div>
            <button type="submit" class="btn-login">Đăng nhập</button>
        </form>

    </div>

    <script>
        // Khi DOM tải xong
        document.addEventListener("DOMContentLoaded", () => {
            const form = document.getElementById("loginForm");

            form.addEventListener("submit", function (event) {
                event.preventDefault(); // ngăn form reload page

                const user = document.getElementById("username").value;
                const pass = document.getElementById("password").value;

                if (user === "admin" && pass === "123") {
                    window.location.href = "Admin-HomePage.html";
                } else {
                    // Xoá mật khẩu đã nhập
                    password.value = "";
                    password.focus();

                    alert("Sai tài khoản hoặc mật khẩu!");
                }
            });
        });
    </script>
</body>
</html>
