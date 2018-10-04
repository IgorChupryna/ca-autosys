<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>CA AutoSys. Admin experience</title>
    <link href="<c:url value="../static/bootstrap/css/fancybox.min.css"/>" rel="stylesheet">
    <link href="<c:url value="../static/bootstrap/css/font-awesome.min.css"/>" rel="stylesheet">
    <link href="<c:url value="../static/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="/static/bootstrap/js/fancybox.min.js"></script>
    <script src="https://www.w3schools.com/lib/w3.js"></script>

</head>
<body>

<jsp:include page="menu.jsp" flush="true"/>


<div class="container">
    <h3><img height="50" width="55" src="<c:url value="/static/logo.png"/>"/><a href="/admin">Users List</a></h3>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="groupList" class="nav navbar-nav">
                    <li><button type="button" id="add_contact" class="btn btn-default navbar-btn">Add Contact</button></li>
                    <li><button type="button" id="delete_contact" class="btn btn-default navbar-btn">Delete Contact</button></li>

                </ul>
                <form class="navbar-form navbar-left" role="search" action="/search" method="post">
                    <div class="form-group">
                        <input type="text" class="form-control" name="pattern" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

    <table class="table table-striped">
        <thead>
        <tr>
            <td></td>
            <td><b>UserName</b></td>
            <td><b>Phone</b></td>
            <td><b>E-mail</b></td>

        </tr>
        </thead>
        <c:forEach items="${contacts}" var="contact">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${contact.id}" id="checkbox_${contact.id}"/></td>
                <td>${contact.name}</td>
                <td>${contact.phone}</td>
                <td>${contact.email}</td>

            </tr>
        </c:forEach>
    </table>

    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${allPages ne null}">
                <c:forEach var="i" begin="1" end="${allPages}">
                    <li><a href="/?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                </c:forEach>
            </c:if>

        </ul>
    </nav>
</div>

<script>
    $('.dropdown-toggle').dropdown();

    $('#add_contact').click(function(){
        window.location.href='/contact_add_page';
    });



    $('#delete_contact').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/contact/delete", data, function(data, status) {
            window.location.reload();
        });
    });
</script>



</body>
</html>
