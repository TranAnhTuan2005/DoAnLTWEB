<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf8">
    <title>modalquenmk</title>
    <style>
        body {
        font-family: 'Tahoma', Arial, sans-serif;
        }

        .modal {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        /*đăng nhập */
        .modal-content {
            display: flex;
            flex-direction: column;
            /*xắp xếp phần tử từ trên xuống theo chiều dọc*/
            text-align: center;

        }
        #mail{
            text-align: left;
        }

        /*định dang form bên trong: email, mật khẩu, nút đăng nhập*/
        #account-modal form {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

        /*giao diện cho ô input*/
        #account-modal input {
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        /*định dạng nút đăng nhập*/
        #account-modal button {
            background: #6D4C41;
            color: #fff;
            border: none;
            padding: 10px;
            cursor: pointer;
        }

        /*định dạng phần liên kết (các chữ màu tím)*/
        #account-modal a {
            color: #a46b2c;
            text-decoration: none;

        }

        /*phần mô tả (chữ màu xám)*/
        #account-modal p {
            font-size: 14px;
            color: #757575;

        }
    </style>
    <script>
        JSON
    </script>
</head>

<body>
    <!-- Modal cho Đăng nhập Tài khoản -->
    <div id="account-modal" class="modal">
        <div class="modal-content">
            <h2>Khôi phục mật khẩu</h2>
            <p id="mail">Nhập email của bạn:</p>
            <form>
                <input type="email" placeholder="Email" required>
                <p>This site is protected by reCAPTCHA and the Google <a
                        href="https://policies.google.com/privacy">Privacy Policy</a> and <a
                        href="https://policies.google.com/terms">Terms of Service</a> apply.</p>
                <button type="submit">Khôi phục</button>
                <p><a href="TrangChu.html">Bạn đã nhớ mật khẩu? Quay lại đăng nhập</a></p>
            </form>
        </div>
    </div>
</body>

</html>