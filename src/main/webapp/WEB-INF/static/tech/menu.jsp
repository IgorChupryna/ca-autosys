<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<title>CA AutoSys. Admin experience</title>

<link href="<c:url value="/WEB-INF/static/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="/WEB-INF/static/bootstrap/js/bootstrap.min.js"></script>
<script src="https://www.w3schools.com/lib/w3.js"></script>
</head>

<div class="text-center" style="background: #f6fdde">
    <h4><strong>You may serfing in site by Guest (Automatically), by Register User or by Admin</strong></h4>
</div>

<body style="background-size: auto; background:  #d1ecf1">

    <div style='float: left;border-radius: 25px; background: #99dbf1;padding: 10px; margin-right: 10px; '>
        <img height="50" width="55" src="/static/auto.png"/><a
            href="https://www.ca.com/us/products/ca-workload-automation-ae.html">agility <br> made possible</a>
    </div>

    <div class="jumbotron text-center " style="background-size: auto; background-image:  url(/static/3.jpg); ">
        <h1 style="color: #99dbf1"> <a href="/" style="color: #d1ecf1">CA Workload Automation AE(CA AutoSys)</a> </h1>
        <p class="badge badge-pill badge-info">This is the site about experience administering the system CA AutoSys(AE Release 11.3.6 SP5)</p>
    </div>


<div class="navbar navbar-inverse navbar-fixed-left">
    <a class="navbar-brand" href="#">Menu</a>
    <div class="menu-list">
    <ul class="nav navbar-nav">
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Description<span
                class="caret"></span></a>
            <ul class="dropdown-menu"  role="menu">
                <li><a href="/description?name=AE System Requirements">AE Requirements</a></li>
                <li><a href="/description?name=AE Operating System and Database Support">AE OS and Database</a></li>
                <li><a href="/description?name=AE Release 11.3.6 SP5">AE Features/Fixed</a></li>
                <li><a href="/description?name=AE Known Issues">AE Known Issues</a></li>
                <li class="divider"></li>
                <li><a href="/description?name=WCC System Requirements">WCC Requirements</a></li>
                <li><a href="/description?name=WCC Operating System and Database Support">WCC OS and Database</a></li>
                <li><a href="/description?name=WCC Release 11.4 SP4">WCC Features/Fixed</a></li>
                <li><a href="/description?name=WCC Known Issues">WCC Known Issues</a></li>
                <li class="divider"></li>
                <li><a href="/description?name=CA Common Components">CCS Known Issues</a></li>
                <li><a href="/description?name=CA Common Components System Requirements">CCS Requirements</a></li>
                <li class="divider"></li>
                <li><a href="/description?name=WAAE, WCC, and EEM Compatibility">CA Compatibility</a></li>

            </ul>
        </li>
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Installation<span
                class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li><a href="/installation?name=Pre - Installation">Pre - Installation</a></li>
                <li><a href="/installation?name=Installation CCS">Installation CCS</a></li>
                <li><a href="/installation?name=Installation WAAE">Installation WAAE</a></li>
                <li><a href="/installation?name=Installation WCC">Installation WCC</a></li>
                <li><a href="/installation?name=Installation Agent">Installation Agent</a></li>
                <li><a href="/installation?name=Installation SAP plugin">Installation SAP plugin</a></li>
            </ul>
        </li>

        <li><a href="/commands">Utils</a></li>
        <li><a href="#">Link4</a></li>
        <li><a href="#">Link5</a></li>
    </ul>
    </div>
</div>

    <a id="back-to-top" href="#" class="btn btn-primary btn-lg back-to-top" role="button"
       title="Click to return on the top page" data-toggle="tooltip" data-placement="left"><span
            class="glyphicon glyphicon-chevron-up"></span></a>
    <script>
        $(document).ready(function () {
            $(window).scroll(function () {
                if ($(this).scrollTop() > 50) {
                    $('#back-to-top').fadeIn();
                } else {
                    $('#back-to-top').fadeOut();
                }
            });
            // scroll body to 0px on click
            $('#back-to-top').click(function () {
                $('#back-to-top').tooltip('hide');
                $('body,html').animate({
                    scrollTop: 0
                }, 800);
                return false;
            });

            $('#back-to-top').tooltip('show');

        });
    </script>

</body>
</html>