<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >

 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Success</title>
</head>
<body>
    <div align="center">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>Pay Succeeded!</h2></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <h3>Payment made successfully :</h3>
                </td>
            </tr>
            <tr>
                <td>From :</td>
                <td>${userForm.from}</td>
            </tr>
            <tr>
                <td>To:</td>
                <td>${userForm.to}</td>
            </tr>
            <tr>
                <td>For (Amount):</td>
                <td>${userForm.amount}</td>
            </tr>
            <tr>
                <td>When:</td>
                <td>${userForm.when}</td>
            </tr>

        </table>
    </div>
</body>
</html>