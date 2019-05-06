<%--
  Created by IntelliJ IDEA.
  User: KLEE
  Date: 2019/4/28
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<% String path=request.getContextPath(); %>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<html>
<head>
    <title>Welcome</title>
    <script src="<%=path%>/js/jquery-3.3.1.js" type="text/javascript"></script>
    <script type="text/javascript">
        function  checkDel(adminName,adminId) {
            if(confirm("你确定删除"+adminName+"这条记录吗?")){
                location.href='<%=path%>/delete.do?adminid='+adminId;
            }
        }
        $(function () {
            $("#add").click(function () {
                location.href='../add.jsp';
            })
            $("#rlogin").click(function () {
                $("#form1").submit();
            })

        })
    </script>
</head>
<body bgcolor="#6495ed">
<center><h2>***************欢迎进入系统***************</h2></center>

        <table width="90%" align="center"  >
            <input type="button" value="新增" name="add" id="add" style="background-color: cornflowerblue" >
            <tr align="center" bgcolor="#ffebcd" height="30px">
                <td>序号</td>
                <td>用户id</td>
                <td>用户姓名</td>
                <td>用户电话</td>
                <td>用户密码</td>
                <td>用户性别</td>
                <td>操作</td>
            </tr>
        <c:choose>
            <c:when test="${adminList.size()==0}">
                <tr>
                    <td colspan="6" height="50px" align="center">
                        <b>&lt;不存在用户信息!&gt;</b>
                    </td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach items="${adminList}" varStatus="status" var="adminlist">
                    <tr align="center" bgcolor="#ffebcd">
                        <td align="center">${status.count}</td>
                        <td align="center">${adminlist.adminId}</td>
                        <td align="center">${adminlist.adminName}</td>
                        <td align="center">${adminlist.adminPhone}</td>
                        <td align="center">${adminlist.adminPwd}</td>
                        <td align="center">${adminlist.adminSex}</td>
                        <td align="center">
                            <a href="../xr.do?adminid=${adminlist.adminId}">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;

                            <a href="javascript:void(0)" onclick="checkDel('${adminlist.adminName}','${adminlist.adminId}')">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        </table>
        <p/>
    <form id="form1" name="form1" action="reLogin" method="post">
        <input type="button" id="rlogin" name="rlogin" value="从新登录" style="width: 100px;background-color: beige;color:olivedrab;margin-left:700px">
    </form>



</body>
</html>
