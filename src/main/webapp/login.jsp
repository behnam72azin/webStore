
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<!DOCTYPE html>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Comic+Neue:ital,wght@0,300;0,400;0,700;1,300;1,400;1,700&family=Lalezar&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style/general.css">
    <link rel="stylesheet" href="style/login.css">


</head>
<body>

<html:form action="login" method="post" styleId="strutsFormId">
    <html:hidden property="method" styleId="strutsMethod"/>
    <div class="container">
        <div class="part-top" ></div>
        <div class="part-mid">
            <div style="display: flex; flex: 1;"></div>
            <div>

                <div id="loginForm" class="login-div">
                    <div>
                        <h2><bean:message bundle="myMesseges" key="login.label"/></h2>
                    </div>

                    <div class="form-login-div">
                        <div class="userpass-lable-div">
                            <label for="username" class="userpass-lable" > <bean:message bundle="myMesseges" key="login.label.username" /> </label>
                            <label for="password" class="userpass-lable"> <bean:message bundle="myMesseges" key="login.label.password" /> </label>
                        </div>
                        <div class="userpass-input-div">



                            <html:text property="userName" styleId="username" styleClass="userpass-input" />
                            <span id="usernameError" class="error"></span><br>
                            <html:text property="passWord" styleId="password" styleClass="userpass-input" />
                            <span id="passwordError" class="error">
                                    <logic:equal value="true" name="noCustomer">
                                        <bean:message bundle="myMesseges" key="login.noCustomer.messege"/>
                                    </logic:equal>
                            </span><br>

                        </div>
                    </div>
                    <div>
                        <div class="radio-container">
                            <label>
                                <html:radio property="role" value="admin" />
                                <bean:message bundle="myMesseges" key="login.label.admin"/>
                            </label>
                        </div>
                        <div class="radio-container">
                            <label>
                                <html:radio property="role" value="customer"/>
                                <bean:message bundle="myMesseges" key="login.label.customer"/>
                            </label>
                        </div>
                    </div>
                    <div class="button-div">
                        <div class="button-div">
                            <button type="button" onclick="validateLogin()" class="login-botton"><bean:message bundle="myMesseges" key="login.button"/></button>
                        </div>
                        <div>
                            <a href="register.do" class="link-sabt"><bean:message bundle="myMesseges" key="login.link.register"/></a>
                        </div>
                    </div>

                </div>
            </div>
            <div style="display: flex; flex: 1;"></div>
        </div>
        <div class="part-down"></div>
    </div>

</html:form>

</body>
<script>
    function validateLogin() {
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;
        let valid = true;

        if (!username) {
            document.getElementById("usernameError").textContent = "<bean:message bundle="myMesseges" key="login.inputUsername.messege"/>";
            valid = false;
        } else {
            document.getElementById("usernameError").textContent = "";
        }

        if (!password) {
            document.getElementById("passwordError").textContent = "<bean:message bundle="myMesseges" key="login.inputPassword.messege"/>";
            valid = false;
        } else {
            document.getElementById("passwordError").textContent = "";
        }

        if (valid) {
            document.getElementById("strutsMethod").value = "loginClient"
            document.getElementById("strutsFormId").submit();
        }
    }

</script>
</html>
