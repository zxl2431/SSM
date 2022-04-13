<%--
  Created by IntelliJ IDEA.
  User: zhangxianlin
  Date: 2022/4/13
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新用户信息</title>
</head>
<body>

<h3>修改用户</h3>
${requestScope}
<form action="/user/update" method="post">
    姓名：<input type="text" name="username" value="${ user.username }"><br>
    密码：<input type="text" name="password" value="${ user.password }"><br>
    金额：<input type="text" name="money" value="${ user.money }"><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
