
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
    <title>Register</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Comic+Neue:ital,wght@0,300;0,400;0,700;1,300;1,400;1,700&family=Lalezar&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style/general.css">
    <link rel="stylesheet" href="style/register.css">

</head>
<body>
<html:form action="register" method="post" styleId="strutsFormId">
    <html:hidden property="method" styleId="method"/>
    <html:hidden property="messege" styleId="strutsMessege"/>
    <div class="container">
        <div class="part-top" ></div>
        <div class="part-mid">
            <div style="display: flex; flex: 1;"></div>
            <div>

                <div id="registerForm" class="login-div">
                    <div>
                        <h2><bean:message bundle="myMesseges" key="register.label"/></h2>
                    </div>
                    <div class="form-login-div">
                        <div class="userpass-lable-div">
                            <label for="username" class="user-lable"><bean:message bundle="myMesseges" key="register.label.username"/></label>
                            <label for="password" class="pass-lable"><bean:message bundle="myMesseges" key="register.label.password"/></label>
                        </div>
                        <div class="userpass-input-div">
                            <html:text property="userName" styleId="username" styleClass="userpass-input" />
                            <span id="usernameError" class="error"></span><br>
                            <html:text property="passWord" styleId="password" styleClass="userpass-input" />
                        </div>
                    </div>
                    <div class="alarm-lable-div">
                        <p id="passwordError" class="error"></p>
                    </div>

                    <div>
                        <div class="radio-container">
                            <label>
                                <html:radio property="role" value="admin" />
                                <bean:message bundle="myMesseges" key="register.label.admin"/>
                            </label>
                        </div>
                        <div class="radio-container">
                            <label>
                                <html:radio property="role" value="customer"/>
                                <bean:message bundle="myMesseges" key="register.label.customer"/>
                            </label>
                        </div>
                    </div>

                    <div class="button-div">
                        <div class="button-div">
                            <button type="button" onclick="validateRegister()" class="login-botton">
                                    <bean:message bundle="myMesseges" key="register.button.submit"/>
                            </button>
                        </div>
                        <div>
                            <a href="login.do" class="link-sabt"> <bean:message bundle="myMesseges" key="register.link.login"/> </a>
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
    function validateRegister()  {
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;
        let valid = true;

        if (!username) {
            document.getElementById("usernameError").textContent = "<bean:message bundle="myMesseges" key="register.inputUsername.messege"/>";
            valid = false;
        } else {
            document.getElementById("usernameError").textContent = "";
        }

        if (!password) {
            document.getElementById("passwordError").textContent = "<bean:message bundle="myMesseges" key="register.inputPassword.messege"/>";
            valid = false;
        } else {
            const regex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
            if (!regex.test(password)) {
                document.getElementById("passwordError").textContent = "<bean:message bundle="myMesseges" key="register.errorPassword.messege"/>";
                valid = false;
            } else {
                document.getElementById("passwordError").textContent = "";
            }
        }

        if (valid) {
            document.getElementById("method").value="registerClient";
            document.getElementById("strutsFormId").submit();
        }
    }


    window.onload = function() {
            document.getElementById("passwordError").textContent = document.getElementById("strutsMessege").value;
    };

</script>
</html>
