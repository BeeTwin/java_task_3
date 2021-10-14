<%@ page import="com.example.java_task3.logic.model.DirectoryModel" %>
<%@ page import = "java.util.*" %>
<%@ page import="com.example.java_task3.logic.model.FileModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IHateJava.com</title>
</head>
<body>
<p>Created at <%= new Date() %></p>
<%
    DirectoryModel model = (DirectoryModel) request.getAttribute("directory");
    String nickname = (String) request.getAttribute("nickname");
%>
<h1><%= model.FullPath %></h1>
<a <%
    if (model.ParentPath != null) {
%>
        href="./?path=<%=model.ParentPath%>&nickname=<%=nickname%>"
<%
    }
%>>
    Вверх
</a>
<table width="50%">
    <tr align="left">
        <th><b>Имя</b></th>
        <th><b>Размер</b></th>
        <th><b>Дата</b></th>
    </tr>
    <%
        for (FileModel child : model.Children) {
    %>
    <tr align="left">
        <th>
            <a href="./?path=<%=child.FullPath%>&nickname=<%=nickname%>">
                <%= child.Name %>
            </a>
        </th>
        <th>
            <%
                if (child.IsFile) {
            %>
            <a><%= child.Size %> B</a>
            <%
                }
            %>
        </th>
        <th>
            <a><%= child.Date %></a>
        </th>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>