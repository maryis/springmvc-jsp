<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JavaSchool
  Date: 6/28/2019
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
ana one
<c:out value="${requestScope.name}" /> <!--get request attribute -->
<c:out value="${requestScope.id}" />

</body>
</html>
