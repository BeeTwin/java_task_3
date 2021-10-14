<%@ page import="com.example.java_task3.logic.model.DirectoryModel" %>
<%@ page import = "java.util.*" %>
<%@ page import="com.example.java_task3.logic.model.FileModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IHateJava.com</title>
</head>
<body>
<h1>Sign up</h1>
    <form align="center" method="post">
        <div class="text1">
            <label for="email">email: </label>
            <input type="text" id="email" name="email" placeholder="email" maxlength="15">
        </div>
        <div class="text1">
            <label for="nickname">nickname: </label>
            <input type="text" id="nickname" name="nickname" placeholder="nickname" maxlength="12">
        </div>
        <br>
        <div class="text1">
            <label for="pass">password: </label>
            <input type="password" id="pass" name="pass" placeholder="password" maxlength="12">
        </div>
        <br>
        <div>
            <input class="text1" type="submit" value="sign up" >
        </div>
        <div>
            <% if(request.getAttribute("error") != null){ %>
                <%=request.getAttribute("error")%>
           <%}%>
        </div>
    </form>
</body>
</html>