<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
       <html>
       <head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <title>Insert title here</title>
       </head>
       <body>

<table>
    <tr>
        <th>Resume Id</th>
        <th>Resume Address</th>
        <th>Resume Name</th>
        <th>Resume Phone</th>
    </tr>
    <c:forEach items="${resumes}" var="resume">
        <tr>
            <td><c:out value="${resume.id}"/></td>
            <td><c:out value="${resume.address}"/></td>
            <td><c:out value="${resume.name}"/></td>
            <td><c:out value="${resume.phone}"/></td>
        </tr>
    </c:forEach>
</table>


       </body>
       </html>