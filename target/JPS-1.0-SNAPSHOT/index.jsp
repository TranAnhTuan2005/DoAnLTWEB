<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 02/01/2026
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /* Đây là file cầu nối.
       Khi chạy server, nó sẽ chạy file này đầu tiên.
       Nhiệm vụ duy nhất của nó là "đá" người dùng sang Servlet.
    */
    response.sendRedirect("Trangchu-login");
%>