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

<jsp:include page="menu.jsp" flush="true"/>


<br><br>

<div class="container ">
    <div class="pricing-table  row">
        <div class="col-lg-4 col-sm-4 col-xs-6 col-md-4 plan plan-name-main" style="background: #b1dfbb" onclick="location.href='/second';">
            <h2>Administration</h2>
            <strong>ConfigureAE, WCC, EEM, Agent, Commands</strong>
            <img width="370" height="250" class="animated-gif" src="/static/adm.png">

        </div>
        <div class="col-lg-4 col-sm-4 col-xs-6 col-md-4 plan plan-name-main" style=" background: #ffe8a1">

            <h2>Demonstration</h2>
            <strong>Administrating CA AutoSys in web is easy</strong>

            <br>
            <br>
            <iframe class="animated-mp4" src="https://www.youtube.com/embed/DlrNeBTdkCI" frameborder="0"
                    allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                    allowfullscreen></iframe>

        </div>
        <div class="col-lg-4 col-sm-4 col-xs-6 col-md-4 plan plan-name-main" style="background: #f5c6cb">
            <h2>Scheduler</h2>
            <strong>CA WCC is the GUI for CA AutoSys AE</strong>
            <img width="320" height="270" class="animated-gif" src="/static/main_fon.jpg">
        </div>

</br>

        <div class="col-lg-4 col-sm-4 col-xs-6 col-md-4 plan plan-name-main" onclick="location.href='/table?name=Description&view=unchecked';">
            <div class="plan-name-aedb">
                <h2>Description</h2>
                <p>CA WA ,CA WCC,CA CSS</p>
            </div>
            <ul>
                <li class="plan-feature">Requariments, Features/Fixed, Known Issue, OS & DB</li>
            </ul>
            <br><br>

        </div>
        <div class="col-lg-4 col-sm-4 col-xs-6 col-md-4 plan plan-name-main" onclick="location.href='/table?name=Installation&view=unchecked';">
            <div class="plan-name-waae">
                <h2>Installation</h2>
                <p><strong>WAAE ,WCC,CSS, agent, plugin SAP</strong></p>
            </div>
            <ul>
                <li class="plan-feature"> Requirements, algorithm, example video and screens</li>
            </ul>
            <br><br>
        </div>
        <div class="col-lg-4 col-sm-4 col-xs-6 col-md-4 plan plan-name-main" onclick="location.href='/first';">
            <div class="plan-name-command">
                <h2>Documents</h2>
                <p>Reference / Errors & Warnings / Security</p>
            </div>
            <ul>
                <li class="plan-feature"> This section includes pdf-files with official manuals</li>
            </ul>
            <br><br>
        </div>

    </div>
</div>


</body>
</html>
