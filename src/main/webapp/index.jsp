<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
    String path=request.getContextPath();
%>
<html>
    <head>
        <script src="<%=path%>/js/jquery-3.3.1.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(function () {
                $("#loginbtn").click(function () {
                    var  name=$("#adminname").val();
                    var  pwd=$("#adminpwd").val();
                    if (name==""){
                        alert("请输入用户名!");
                        return;
                    }
                    if (pwd==""){
                        alert("请输入密码!");
                        return;
                    }
                    $("#form").submit();
                })
                $("#resbtn").click(function () {
                    window.location.href="register.jsp";
                })
            });
        </script>
        <style type="text/css">

        </style>
    </head>
    <body>

        <center><h2>用户登录界面</h2></center>
        <center>
        <form action="login.do" method="post" id="form" name="form" >
            <table  width="300px" bgcolor="#faebd7">
                <tr height="70px">
                    <td>用户名:</td>
                    <td>
                        <input type="text" id="adminname" name="adminname">
                    </td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td>
                        <input type="password" id="adminpwd" name="adminpwd">
                    </td>
                </tr>
                <tr align="left">
                    <td>
                        <input type="button" value="登录" id="loginbtn" name="loginbtn">
                    </td>
                    <td>
                        <input type="button" value="注册" id="resbtn" name="resbtn">
                    </td>
                </tr>
            </table>
        </form>
        </center>

    </body>
</html>
