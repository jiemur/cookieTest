<%--
  Created by IntelliJ IDEA.
  User: abd
  Date: 2018/12/13
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--${p} 通过这个获取数据--%>
    <form action="doUpdate" method="post"><%--设置地址栏不显示私有数据--%>
        <input type="text" name="id" hidden="hidden" value="${p.productId}">
        商品名称：<input type="text" name="name" value="${p.productName}"><br>
        商品价格：<input type="text" name="price" value="${p.price}"><br>
        商品图片：<input type="text" name="url" value="${p.url}"><br>
        商品描述：<input type="text" name="des" value="${p.productDes}"><br>
        <input type="submit" value="修改">
    </form>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            /*alert("1");  //测试*/
        })
    </script>
</body>
</html>
