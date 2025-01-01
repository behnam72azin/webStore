
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

<h2><bean:message bundle="myMesseges" key="welcome.label.selectedProduct"/></h2>

<html:form action="/welcome" method="post" styleId="strutsFormId" onsubmit="return validateForm();">
    <html:hidden property="method" styleId="strutsMethod"/>
    <label for="select-product"><bean:message bundle="myMesseges" key="welcome.label.selectProductGroup"/> </label>
    <html:select property="selectedProduct" styleId="select-product">
        <html:option value="">-- لطفاً یک گزینه انتخاب کنید --</html:option>
        <html:options property="nameProducts"/>
    </html:select>
    <br/><br/>
    <span id="error-message" style="color: red;"></span>
    <br/><br/>
    <html:submit value="ورود"/>
</html:form>

<%--<a href="products.do" target="_parent" style="text-decoration: none;">--%>
<%--    <label style="color: brown; "> <bean:message bundle="myMesseges" key="welcome.showlink"/> </label>--%>
<%--</a>--%>
<br>
<html:errors bundle="myMesseges"/>
</body>
<script>
    function validateForm() {
        var selectedProduct = document.getElementById("select-product").value;
        var errorMessage = document.getElementById("error-message");
        if (selectedProduct === "" || selectedProduct == null) {
            errorMessage.innerText = "لطفاً یک محصول از لیست انتخاب کنید.";
            return false;
        }
        errorMessage.innerText = "";
        document.getElementById("strutsMethod").value = "selectedProduct";
        return true;
    }
</script>

</html>