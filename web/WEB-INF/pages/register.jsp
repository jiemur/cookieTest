<%--
  Created by IntelliJ IDEA.
  User: abd
  Date: 2018/12/12
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--注册页面--%>
    <%--通过action属性的register经过web跳转到RegisterServlet--%>
    <form>
        用户名：<input type="text" name="username" id="unames" class="ajaxCla"><span id="message"></span><br>
        密码：<input type="password" name="pwd" id="pwd" placeholder="6-18 数字和字母"><br>
        确认密码：<input type="password" name="pwds" id="pwds" class="ajaxCla" placeholder="6-18 数字和字母"><span id="pmes"></span><br>
        电话：<input type="text" name="tele" id="tele" class="ajaxCla" placeholder="手机号码"><br>
        <input type="button" value="注册" id="btn" disabled="disabled"><%--修改按钮名字--%>
    </form>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            /*使用ajax*/
            var un;
            var pwd;
            var pwds;
            var tele;
            $(".ajaxCla").blur(function () {  //获取标签对象，绑定事件
                un = $("#unames").val(); //通过id获取这个标签对象,再获取这个对象的值
                pwd = $("#pwd").val();
                pwds = $("#pwds").val();
                tele = $("#tele").val();
                /*$("#message").text(un);  //获取标签对象，存放内容*/
                $.ajax({
                    url:"doRegister",   //没有提交也能够去java的这个DoRegisterServlet类
                    type:"post",  //提交方式，在浏览器网址隐藏
                    data:{"unames":un, "pwd":pwd, "pwds":pwds, "tele":tele},   //把值传入java代码中
                    success:function (result) {  //回调函数，这里接受传出的数据
                        if (result == "1"){
                            $("#message").text("可以注册");
                        }
                        if(result == "13"){
                            $("#message").text("可以注册");
                            $("#pmes").text("√");
                            $("#btn").removeAttr("disabled");
                        }
                        if(result == "14"){
                            $("#message").text("可以注册");
                            $("#pmes").text("密码不一致");
                        }
                        if(result == "15"){
                            $("#message").text("可以注册");
                            $("#pmes").text("密码不能为空");
                        }
                        if (result == "2"){
                            $("#message").text("用户名以存在");
                        }
                    }
                });
            });
            $("#btn").click(function () {
                $.ajax({
                    url:"doIt",
                    type:"post",
                    data:{"unames":un, "pwd":pwd, "pwds":pwds, "tele":tele},   //把值传入java代码中
                    success:function (data) {
                        if (data=="1"){
                            alert("注册成功");
                            window.location.href="login";  //跳转登录界面
                        }
                    }
                });
                /*alert("ffff");  //测试*/
            });
            /*alert("1");   //测试  */
        })
    </script>
</body>
</html>
