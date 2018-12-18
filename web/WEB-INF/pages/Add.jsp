<%--
  Created by IntelliJ IDEA.
  User: abd
  Date: 2018/12/13
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>添加界面</p><br>
    <form action="doAdd" method="post">
        商品名称：<input type="text" name="name"><br>
        商品价格：<input type="text" name="price"><br>
        商品图片：<input type="text" name="url"><br>
        商品描述：<input type="text" name="des"><br>
        <input type="submit" value="添加">
    </form>
</body>
</html>
