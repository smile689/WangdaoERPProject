<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>


<form action="${pageContext.request.contextPath}/login" method="post">
    <table border="1" width="600">
        <tr>
            <td>*用户名：</td>
            <td><input type="text" name="username" /> </td>
        </tr>
        <tr>
            <td>*密码:</td>
            <td><input type="password" name="password"  /> </td>
        </tr>


        <tr>
            <td><input type="submit"  value="登录" /></td>
            <td></td>
        </tr>
    </table>
</form>

</body>
</html>
