<%--
  Created by IntelliJ IDEA.
  User: abd
  Date: 2018/12/12
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--登录界面--%>
    <%--通过action属性的login经过web跳转到DoLoginServlet--%>
    <form id="fm" method="post" action="doLogin"><%--表单,属性：要跳转的地址，提交方式设置隐藏--%>
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="pwd"><br>
        <input type="submit" value="登录" id="btn"><br> <%--登录按钮--%>
        <a href="register">尚未注册，请先注册</a>
    </form>
   <%-- <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
           $("#btn").click(function () {
               var fm = $("#fm").serialize();
               $.ajax({
                   url:"doLogin",
                   type:"post",
                   data:fm, /*{"fm":fm},*/
                   success:function (data) {
                       if (data=="1") {
                           alert("登录成功");
                           window.location.href="list";
                       }
                       if (data=="2") {
                           alert("密码输入错误，请重新输入");
                           window.location.href="login";
                       }
                       if (data=="3") {
                           alert("没有此用户");
                           window.location.href="register";

                       }
                       /*console.log(data);  //测试*/
                   }
               });
           });
        });
        /*alert("123")  //测试*/
    </script>--%>
</body>
</html>
