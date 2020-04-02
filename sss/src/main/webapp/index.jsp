<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>登录页</title>

    <style>
        div{
            padding:10px 10px 0 10px;
        }
    </style>
</head>
<body>
    <div>
        <fieldset>
            <form method="post" action="/resume/login">
                <div><p>用户名</p><input type="text" name="username" /></div>
                <div><p>密码</p><input type="text" name="password" /></div>
                <div><input type="submit" value="登录"/></div>
            </form>

        </fieldset>
    </div>
</body>
</html>
