<%--
  Created by IntelliJ IDEA.
  User: wzn
  Date: 2018/12/19
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="img" enctype="multipart/form-data" method="post">
        <input type="file" name="file" onchange="imgChange(this)">
        <input type="submit" value="提交">
    </form>
<script type="text/javascript">
    function imgChange(obj) {
        
    }
</script>
</body>
</html>
