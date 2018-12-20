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
    <form action="doAdd" method="post" enctype="multipart/form-data">
        商品名称：<input type="text" name="name"><br>
        商品价格：<input type="text" name="price"><br>
        商品图片：<input type="file" name="file" onchange="imgChange(this)"><img id="img"><br>
        商品描述：<input type="text" name="des"><br>
        <input type="submit" value="添加">
    </form>
<script type="text/javascript">
   function imgChange(obj) {
        console.log(obj);
        console.log(obj.files[0])//获取到当前的这个文件
        /*一个文件读取器,*/
        var reader= new FileReader();
        console.log(reader);
        /!*加载读取器*!/
        reader.onload=function (ev) {
            var img=document.getElementById("img");
            img.src=ev.target.result;
        };
        reader.readAsDataURL(obj.files[0]);
    }

</script>
</body>
</html>
