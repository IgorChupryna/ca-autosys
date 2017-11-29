<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>CA AutoSys. Admin experience</title>
    <link href="<c:url value="../static/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://www.w3schools.com/lib/w3.js"></script>
</head>
<body style="background-size: auto; background:  #d1ecf1">

<jsp:include page="../static/tech/menu.jsp" flush="true"/>

<div class="container">
    <table class="table table-striped table-bordered">
        <thead>
        <tr style="background: #f7ecb5">
            <td><b>#</b></td>
            <td><b>Name</b></td>
            <td><b>Short Description</b></td>
        </tr>
        </thead>
        <c:forEach items="${list}" var="list">
            <tr>
                <td>${list.id}</td>
                <td>
                    <a href="/<c:out value="${shemas}"></c:out>?name=<c:out value="${list.name}"></c:out>">${list.name}</a>
                </td>
                <td>${list.shortDesc}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
