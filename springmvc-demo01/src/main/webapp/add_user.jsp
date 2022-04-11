<%--
  Created by IntelliJ IDEA.
  User: zhangxianlin
  Date: 2022/4/11
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC</title>
    <script src="/js/jquery-2.2.3.min.js"></script>
    <script>
        $(function () {
            ///数据以JSON格式提交
            $('#btn').click(function () {
                $.ajax({
                    url:'/user/request/body/json',
                    type:'post',
                    data:'{"username":"小虎","telephone":"13670081111","hight":2}',
                    contentType:'application/json;charset=utf-8',    //指定提交数据类型JSON
                    success:function (data) {
                        alert(data);
                    }
                });
            });

        })
    </script>
</head>
<body>

    <div>
        获取JSON数据
        <button type="button" id="jsonbtn">获取JSON</button>
    </div>
    <div>
        <button type="button" id="btn">提交JSON</button>
    </div>

    <div>
        <form action="/user/request/body/str" method="post">
            用户名字：<input name="username" /><br/>
            用户手机号：<input name="telephone" /><br/>
            用户身高：<input name="hight" /><br/>
            <button>提交</button>
        </form>
    </div>

</body>
</html>
