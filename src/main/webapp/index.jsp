<html>
<body>
<h2>Successful operation of resident travel service system</h2>
<%
    // 重定向到新地址
    String site = new String("http://localhost:8080/swagger/index.html");
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
%>
</body>

</html>
