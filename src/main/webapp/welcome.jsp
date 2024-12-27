
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Comic+Neue:ital,wght@0,300;0,400;0,700;1,300;1,400;1,700&family=Lalezar&display=swap" rel="stylesheet">
    <title>Welcome</title>
    <link rel="stylesheet" href="style/general.css">
</head>
<body style="text-align: center;">
<h1>
    <%=request.getSession().getAttribute("username")%>
    <bean:message bundle="myMesseges" key="welcome.messege"/>
</h1>
<a href="products.do" target="_parent" style="text-decoration: none;">
    <label style="color: brown; "> <bean:message bundle="myMesseges" key="welcome.showlink"/> </label>
</a>
<br>
<html:errors bundle="myMesseges"/>
</body>
</html>