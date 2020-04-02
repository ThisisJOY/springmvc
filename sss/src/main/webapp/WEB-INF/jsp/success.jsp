<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <html>
       <head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <title>Resume</title>

           <script type="text/javascript" src="/js/jquery.min.js"></script>

           <script>
               $(function () {

                   $("#ajaxBtn").bind("click",function () {
                       // 发送ajax请求
                       $.ajax({
                           url: '/resume/handle',
                           type: 'POST',
                           data: '{"address":"深圳","name":"李四", "phone": "161000000"}',
                           contentType: 'application/json;charset=utf-8',
                           dataType: 'json',
                           success: function (data) {
                               alert(data.name);
                               setTimeout(function(){
                                  location.reload();
                               }, 100);

                           }
                       })

                   })


               })


           </script>

       </head>
       <body>

    <div>
        <fieldset>
            <p>添加一个resume</p>
            <input type="button" id="ajaxBtn" value="添加" style="float: right;"/>
        </fieldset>
    </div>
<table align="center" cellpadding="20" cellspacing="0" border="2" bgcolor="lightgreen">
    <tr>
        <th>Id</th>
        <th>Address</th>
        <th>Name</th>
        <th>Phone</th>
        <th />
        <th />
    </tr>
    <c:forEach items="${resumes}" var="resume">
        <tr>
            <td><c:out value="${resume.id}"/></td>
            <td><c:out value="${resume.address}"/></td>
            <td><c:out value="${resume.name}"/></td>
            <td><c:out value="${resume.phone}"/></td>
            <td>
                <form method="post" action="/resume/handle/${resume.id}/lisi">
                     <input type="hidden" name="_method" value="put"/>
                     <input type="submit" value="编辑"/>
                 </form>
            </td>
            <td>
                <form method="post" action="/resume/handle/${resume.id}">
                                 <input type="hidden" name="_method" value="delete"/>
                                 <input type="submit" value="删除"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

       </body>
       </html>