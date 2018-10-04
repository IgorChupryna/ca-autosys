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

<jsp:include page="menu.jsp" flush="true"/>

<div class="container">
    <div class="row" align="center">


        <c:forEach items="${list}" var="list">
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-3" >
                <div class="boxes" style="background: #f7f7f7">
                    <div class="img-upper">
                        <img class="img-responsive" src=${list.pathIcon}>
                    </div>
                    <div class="description">
                        <h2>${list.name}</h2>
                        <p>${list.shortDesc}</p>
                        <button type="button" class="btn btn-primary">More</button>
                    </div>
                </div>
            </div>

        </c:forEach>

    </div>
</div>

</body>
</html>
