<%--
  Created by IntelliJ IDEA.
  User: josephhopkins
  Date: 7/6/21
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Ads</title>
</head>
<body>
<h1>Here are all the Ads:</h1>

<c:forEach var="ad" items="${ads}">
    <div class="ad">
        <h2>${ad.title}</h2>
        <p>${ad.description}</p>
        <p>posted by user id: ${ad.userId}</p>
        <p>ad id: ${ad.id}</p>
    </div>
</c:forEach>

</body>
</html>

