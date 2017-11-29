<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>CA AutoSys. Admin experience</title>
    <link href="<c:url value="/static/bootstrap/css/bootstrap.css"/>" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div style='float: right; background: #f6fdde;padding: 10px; margin-right: 10px; '>
    <div class="form-inline" align="right">
        <c:url value="/j_spring_security_check" var="loginUrl"/>
        <c:if test="${login eq null}">
            <form action="${loginUrl}" method="POST">
                <input id="login-username" type="text" class="form-control" name="j_login" value="" placeholder="username">
                <input id="login-password" type="password" class="form-control" name="j_password" placeholder="password">
                <input class="btn btn-default" type="submit" value="Sign in"/>

                <p><a href="/register">Register new user</a></p>

                <c:if test="${param.error ne null}">
                    <p>Wrong login or password!</p>
                </c:if>

                <c:if test="${param.logout ne null}">
                    <p>Chao!</p>
                </c:if>
            </form>
        </c:if>
    </div>
</div>
<c:if test="${login ne null}">
    <form>
        <c:url value="/update" var="updateUrl"/>
        <p>login is: <a href=${updateUrl}>${login}</a>,roles:</p>
        <c:forEach var="s" items="${roles}">
            <p><c:out value="${s}"/></p>
        </c:forEach>

        <p><a href="/register">Register new user</a></p>

        <c:if test="${param.error ne null}">
            <p>Wrong login or password!</p>
        </c:if>

        <c:if test="${param.logout ne null}">
            <p>Chao!</p>
        </c:if>
    </form>
</c:if>

</div>
<div class="container">
    <h3><img height="50" width="55" src="<c:url value="/static/logo.png"/>"/><a href="/">Utils List</a></h3>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="groupList" class="nav navbar-nav">
                    <li>
                        <button type="button" id="add_contact" class="btn btn-default navbar-btn">Add Contact</button>
                    </li>
                    <li>
                        <button type="button" id="delete_contact" class="btn btn-default navbar-btn">Delete Contact
                        </button>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

    <table class="table table-striped">
        <thead>
        <tr>
            <td></td>
            <td><b>Name</b></td>
            <td><b>Description</b></td>
            <td><b>Example</b></td>
            <td><b>Path_v</b></td>
        </tr>
        </thead>
        <c:forEach items="${utils}" var="util">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${util.id}" id="checkbox_${util.id}"/></td>
                <td>${util.name}</td>
                <td>${util.description}</td>
                <td>${util.example}</td>
                <td>${util.path}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<script>
    $('.dropdown-toggle').dropdown();

    $('#add_contact').click(function () {
        window.location.href = '/contact_add_page';
    });

    $('#delete_contact').click(function () {
        var data = {'toDelete[]': []};
        $(":checked").each(function () {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/contact/delete", data, function (data, status) {
            window.location.reload();
        });
    });
</script>
</body>
</html>
