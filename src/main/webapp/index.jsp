<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
    String path=request.getContextPath();
%>
<html>
    <head>
        <link href="<%=path%>/bootstrap/bootstrap.css" rel="stylesheet"/>
        <link href="<%=path%>/bootstrap-table/bootstrap-table.css" rel="stylesheet"/>
        <script src="<%=path%>/js/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="<%=path%>/bootstrap/bootstrap.js" type="text/javascript"></script>
        <script src="<%=path%>/bootstrap-table/bootstrap-table.js" type="text/javascript"></script>
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
            div{
                width: 400px;
                height: 500px;
                margin: 0 auto;
                background-color:#b1dfbb;
                border-radius: 10px;

            }
        </style>
    </head>
    <body>
        <div>
        <center><h3 style="color: #005cbf">用户登录界面</h3></center>
        <center>
        <form action="login.do" method="post" id="form" name="form">
            <table  width="300px" >
                <tr height="70px">
                    <td>用户名:</td>
                    <td>
                        <input type="text" id="adminname" name="adminname" >
                    </td>
                </tr>
                <tr>
                    <td>密&nbsp;&nbsp;&nbsp;码:</td>
                    <td>
                        <input type="password" id="adminpwd" name="adminpwd">
                    </td>
                </tr>
                <tr height="30px">
                    <td></td>
                </tr>
                <tr >
                    <td colspan="2">
                        <input type="button" value="登录" id="loginbtn" name="loginbtn" style="width: 100%;background-color: #005cbf;color: white">
                    </td>
                </tr>
                <tr  align="right">
                    <td colspan="2">
                        <a href="register.jsp" style="text-decoration: none;color:red"><i>注册</i>>>></a>
                    </td>

                </tr>
            </table>
        </form>

        </center>
        </div>

    </body>
</html>
