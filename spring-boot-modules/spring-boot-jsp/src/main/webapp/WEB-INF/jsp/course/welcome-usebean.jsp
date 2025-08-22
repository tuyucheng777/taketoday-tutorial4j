<html>
<head>
    <title>Welcome to Course</title>
</head>
<body>
<p>Using jsp:useBean action</p>
<jsp:useBean id="welcomeBean" class="cn.tuyucheng.taketoday.boot.jsp.coursewelcome.CourseWelcome"/>
<div>
    <%= welcomeBean.greeting("Kevin")%>
</div>
<div>
    <%= cn.tuyucheng.taketoday.boot.jsp.coursewelcome.CourseWelcome.staticWelcome("Java Collections")%>
</div>
</body>
</html>