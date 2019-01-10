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
    <div class="row">
        <div class="col-md-4">
            <div class="btn_switch_outer">
                <span class="btn_switch_label">Table</span>
                <div class="btn_switch">
                    <input type="checkbox" name="switch" id="switch" onclick="validate()" <c:out
                            value="${view}"></c:out>>
                    <label for="switch"></label>
                </div>
            </div>
        </div>
    </div>
</div>


<c:if test="${view == 'checked'}">
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
</c:if>

<c:if test="${view == 'unchecked'}">
    <div class="container">
        <div class="row" align="center">
            <c:forEach items="${list}" var="list">
                <div class="plan col-xs-12 col-sm-12 col-md-6 col-lg-3"  onclick="location.href='/<c:out value="${shemas}"></c:out>?name=<c:out value="${list.name}"></c:out>';">
                    <div class="boxes" style="background: #f7f7f7">
                        <div class="img-upper">
                            <img class="img-responsive" src=${list.pathIcon}>
                        </div>
                        <div class="description">
                            <h2>${list.name}</h2>
                            <p>${list.shortDesc}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</c:if>

<script>


    function validate() {
        if (document.getElementById("switch").checked) {
            window.location.href = "/table?name=<c:out value="${shemas}"></c:out>&view=checked";
        } else {
            window.location.href = "/table?name=<c:out value="${shemas}"></c:out>&view=unchecked";
        }
    }


</script>


</body>
</html>
