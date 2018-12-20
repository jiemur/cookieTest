<%--
  Created by IntelliJ IDEA.
  User: wzn
  Date: 2018/12/20
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="img" method="post" enctype="multipart/form-data"> <%--指定传输类型--%>
    <input type="file" name="file" onchange="imgChange(this)">< img id="img" width="100" height="100"><br>  <%--文件选择按钮--%>
    <input type="submit">
</form>
<script type="text/javascript">
    function imgChange(obj) {   /*传进来当前对象标签*/
        //console.log(obj);
        //console.log(obj.files[0]);  //获取当前对象文件
        if ((obj.files[0].name).substr((obj.files[0].name).indexOf(".")+1)=="ico"){
            var reader = new FileReader();  /*文件读取器*/
            //console.log(reader);
            reader.onload=function (ev) {   /*加载触发方法*/
                //console.log(ev);
                var img = document.getElementById("img");
                img.src=ev.target.result;  /*添加到img标签*/
            }
            reader.readAsDataURL(obj.files[0]);  /*把文件转换为src*/
        }else{
            alert("格式不对 重新选择");
            img.src="";
        }
    }
</script>
</body>
</html>
