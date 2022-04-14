<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangxianlin
  Date: 2022/4/14
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
 ${name}

 <table>
     <tr>
         <td>名字</td>
         <td>年龄</td>
     </tr>
     <c:forEach items="${users}" var="user">
         <tr>
             <td>${user.username}</td>
             <td>${user.birthday}</td>
         </tr>
     </c:forEach>
 </table>
</body>
</html>
