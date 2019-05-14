<%--
  Created by IntelliJ IDEA.
  User: KLEE
  Date: 2019/4/28
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
%>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Register</title>
    <script src="<%=path%>/js/jquery-3.3.1.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            document.getElementById("adminsex${admin.adminSex}").checked="checked";
        });

        $(function () {
            var adminnames=$("#adminname").val();
            $("#adminname").blur(function () {
                var adminname=$("#adminname").val();
                $.ajax({
                    type:'post',
                    url:'checkReg',
                    data:{adminName:adminname},
                    success:function (data) {
                        if (data==1){
                            document.getElementById("regbtn").disabled=false;
                        }
                        if (data==0){
                           if ($("#adminname").val()==adminnames){
                               document.getElementById("regbtn").disabled=false;
                           }
                           else {
                               alert('用户已存在，请更换!');
                               document.getElementById("regbtn").disabled=true;
                           }
                        }
                    }
                })
            })
            $("#regbtn").click(function () {
                var adminname=$("#adminname").val();
                var adminpwd=$("#adminpwd").val();
                var adminphone=$("#adminphone").val();
                var adminsex=$("input[name='adminsex']:checked").val();
                if (adminname==''){
                    alert("请输入用户名!");
                    return;
                }
                if (adminpwd==''){
                    alert("请输入密码!");
                    return;
                }
                if (adminphone==''){
                    alert("请输入电话号码!");
                    return;
                }
                if (adminsex==null){
                    alert("请选择性别!");
                    return;
                }
                $("#form").submit();

            })
        })
    </script>
</head>
<body>
    <center>
    <form action="edit.do" method="post" id="form" name="form" style="background-color: aliceblue">
        <input type="hidden" name="adminid" id="adminid" value="${admin.adminId}">
        <h2>用户编辑界面</h2>
        <p></p>
        <font>用户名:</font>
        <input type="text" name="adminname"  id="adminname" value="${admin.adminName}">
        <p/>
        &nbsp;<font>密码:</font>
        <input type="password" name="adminpwd"  id="adminpwd" value="${admin.adminPwd}">
        <p/>
        &nbsp;<font>电话:</font>
        <input type="text" name="adminphone"  id="adminphone" value="${admin.adminPhone}">
        <p/>
        <font>性别:</font> &nbsp;
        <input type="radio" name="adminsex" id="adminsex男" value="男"><label for="adminsex男">男</label>
        <input type="radio" name="adminsex" id="adminsex女" value="女"><label for="adminsex女">女</label>
        <p/>
        <input type="button" value="确定修改" id="regbtn" name="regbtn">
    </form>
    </center>
</body>
</html>
