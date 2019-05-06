
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
%>
<html>
<head>
    <title>Add</title>
    <script src="<%=path%>/js/jquery-3.3.1.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            $("#adminname").blur(function () {
                var adminname=$("#adminname").val();
                if (adminname==''){
                    alert('请输入用户名!');
                }
                else {
                    $.ajax({
                        type:'post',
                        url:'checkReg',
                        data:{adminName:adminname},
                        success:function (data) {
                            if (data==1) {

                            }
                            if (data==0){

                                alert('该用户名称已经存在,请更换!');
                            }
                        }
                    })
                }
            })

            $("#addbtn").click(function () {
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
                if (adminsex==''){
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
    <form action="add.do" method="post" id="form" name="form" style="background-color: aliceblue">
        <h2>用户添加界面</h2>
        <p></p>
        <font>用户名:</font>
        <input type="text" name="adminname"  id="adminname">
        <p/>
        &nbsp;<font>密码:</font>
        <input type="password" name="adminpwd"  id="adminpwd">
        <p/>
        &nbsp;<font>电话:</font>
        <input type="text" name="adminphone"  id="adminphone">
        <p/>
        <font>性别:</font> &nbsp;
        <input type="radio" name="adminsex" id="adminsex男" value="男"><label for="adminsex男">男</label>
        <input type="radio" name="adminsex" id="adminsex女" value="女"><label for="adminsex女">女</label>
        <p/>
        <input type="button" value="确定" id="addbtn" name="addbtn">
    </form>
</center>
</body>
</html>
