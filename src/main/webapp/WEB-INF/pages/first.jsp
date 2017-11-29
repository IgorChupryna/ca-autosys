<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="row">
        <div class="col-sm-4" style="background: #b1dfbb">
            <h2>Administrating CA AutoSys</h2>
            <p align="left">This section describes how to install and configure CA Workload Automation AE components,
                dual event servers, and high availability options,
                and set up database connections. </p>
            <p>It also contains information about advanced configurations and
                upgrading an existing installation.</p>
            <p>To see CA Workload Automation AE provides various options to meet your security needs, which depend on
                your interface.</p>
            <p>
                <a class="btn btn-lg btn-primary" href="/admin" role="button">View WAAE &raquo;</a>
            </p>
        </div>
        <div class="col-sm-4" style="background: #ffe8a1">
            <h2>Demo video WCC</h2>
            <p>Administrating CA AutoSys in web interface is very easy</p>
            <video width="320" height="270" controls>
                <source src="/static/demo.wmv" type="video/mp4">
            </video>
        </div>
        <div class="col-sm-4" style="background: #f5c6cb">
            <h2>Manage simply</h2>
            <p>CA WCC is the GUI for CA AutoSys AE.</p>
            <img width="320" height="270" class="animated-gif" src="/static/n1.gif">
        </div>
    </div>
</div>
<br>
<div class="container" style="background: #d39e00">
    <div class="row">

        <div class="col-sm-4">
            <h3>Description</h3>
            <p>CA WA ,CA WCC,CA CSS</p>
            <p>Requariments, Features/Fixed, Known Issue, OS & DB</p>
            <a href="/table?name=Description" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">View
                Desc</a>
            <br><br>
        </div>
        <div class="col-sm-4" style="background: #f8d7da">
            <h3>Column 2</h3>
            <p>Lorem ipsum dolor..</p>
            <p>Ut enim ad..</p>
            <a href="/first" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Primary link</a>
            <br><br>
        </div>
        <div class="col-sm-4">
            <h3>Column 3</h3>
            <p>Lorem ipsum dolor..</p>
            <p>Ut enim ad..</p>
            <a href="/first" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Primary link</a>
            <br><br>
        </div>

    </div>
</div>
</body>
</html>
