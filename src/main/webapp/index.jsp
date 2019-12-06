<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/5
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>邮件发送</title>
</head>
<body>
<form action="sendmail" enctype="multipart/form-data" method="post">
    选择附件：<input type="file" name="annex">
    <input type="submit" value="发送">
</form>
</body>
</html>
