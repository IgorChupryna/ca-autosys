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


<div class="container" >

    <div class="pricing-table row">

        <div class="plan col-sm-4 col-lg-4" onclick="location.href='/table?name=Administration&view=unchecked';">
            <div class="plan-name-waae">
                <h2>Config WAAE</h2>
                <span>Configuration CA AutoSys</span>
            </div>
            <ul>
                <li class="plan-feature">Configure WAAE components,
                    Start/Stop system, EM, globalVar
                </li>
                <li class="plan-feature"><strong>config.ACE, unicntrl, csampmux, oprdb, profile.CA</strong></li>

            </ul>
        </div>


        <div style="z-index:55;" class="plan col-sm-4 col-lg-4"
             onclick="location.href='/table?name=Command&view=unchecked';">
            <div class="plan-name-command">
                <h2>AE Commands</h2>
                <span>AE client utilities</span>
            </div>
            <ul>
                <li class="plan-feature">Client utilities let you manage your environment and workload</li>
                <li class="plan-feature"><strong>sendevent, jil, autorep, autocal_asc, as_safetool</strong></li>
            </ul>
        </div>
        <div class="plan col-sm-4 col-lg-4" onclick="location.href='/table?name=Agent&view=unchecked';">
            <div class="plan-name-agent">
                <h2>AE Agent</h2>
                <span>CA WAAE Agent on Linux</span>
            </div>
            <ul>
                <li class="plan-feature">Configure agent by editing the following agent parameters in the
                    config file
                </li>
                <li class="plan-feature"><strong>cybAgent, agentparm.txt, password, PluginInstaller</strong></li>
            </ul>
        </div>
    </div>
    <div class="pricing-table  row">

        <div class="plan col-sm-4 col-lg-4" onclick="location.href='/table?name=WCC&view=unchecked';">
            <div class="plan-name-wcc">
                <h2>CA WCC</h2>
                <span>CA Workload Control Center</span>
            </div>
            <ul>
                <li class="plan-feature">CA Workload Control Center (WCC) is the UI for Workload automation AE</li>
                <li class="plan-feature"><strong>Dashboard, QuickView, QuickEdit, Reporting ,Credentials</strong></li>
            </ul>
        </div>


        <div style="z-index:55;" class="plan col-sm-4 col-lg-4"
             onclick="location.href='/table?name=AEDB&view=unchecked';">
            <div class="plan-name-aedb">
                <h2>AEDB</h2>
                <span>Schema,Tables, Procedures in DB</span>
            </div>
            <ul>
                <li class="plan-feature">Manage tables, procedure sync if you have dual mode</li>
                <li class="plan-feature"><strong>autobcpORA.pl, CreateAEDB.pl, waae_oracle.sql,
                    procedures.sql</strong></li>

            </ul>
        </div>
        <div class="plan col-sm-4 col-lg-4" onclick="location.href='/table?name=EEM&view=unchecked';">
            <div class="plan-name-eem">
                <h2>CA EEM</h2>
                <span>CA Embedded Entitlements Manager</span>
            </div>
            <ul>
                <li class="plan-feature">CA EEM is an embedded tool that is available to CA products</li>
                <li class="plan-feature"><strong>safex, eiamadmin, LDAP Directory, policies</strong></li>
            </ul>
        </div>
    </div>

</div>


</body>
</html>
