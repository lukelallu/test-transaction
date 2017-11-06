<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
    <div align="center">
        <form:form action="pay" method="post" commandName="userForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Transaction POC - Make a Payment </h2></td>
                </tr>
                <tr>
                    <td>From Whom:</td>
                    <td><form:input path="from" /></td>
                </tr>
                <tr>
                    <td>Pay Whom:</td>
                    <td><form:input path="to" /></td>
                </tr>
                <tr>
                    <td>Amount:</td>
                    <td><form:input path="amount" /></td>
                </tr>
                <tr>
                    <td>When (mm/dd/yyyy):</td>
                    <td><form:input path="when" /></td>
                </tr>

                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Pay" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>