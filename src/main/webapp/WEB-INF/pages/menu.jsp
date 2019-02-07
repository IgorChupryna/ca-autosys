<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<body style="background-size: auto; background:  #d1ecf1">


<div class="jumbotron text-center " style=" background-size: 100%; background-image:  url(/static/3.jpg); ">

    <div>
        <div style='float: left;border-radius: 25px; background: #99dbf1; margin-right: 5px; '>
            <a href="https://www.ca.com/us/products/ca-workload-automation-ae.html"><img height="50" width="55" src="/static/auto.png"/></a>
        </div>
        <nav class="navbar navbar-default navbar-inverse" role="navigation">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <c:url value="/j_spring_security_check" var="loginUrl"/>
                        <c:if test="${login eq null}">
                            <li><p class="navbar-text">Already have an account?</p></li>
                            <li class="dropdown" style="background: #31708f">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b><span
                                        class="caret"></span></a>
                                <ul id="login-dp" class="dropdown-menu">
                                    <li>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <p>Login via</p>
                                                <c:url value="${pageContext.request}" var="thisPage"/>
                                                <form class="form" role="form" method="post" action="${loginUrl}"
                                                      accept-charset="UTF-8" id="login-nav">
                                                    <div class="form-group">
                                                        <label class="sr-only" for="exampleInputEmail2">Username</label>
                                                        <input type="text" class="form-control" id="exampleInputEmail2"
                                                               name="j_login" placeholder="Username" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="sr-only"
                                                               for="exampleInputPassword2">Password</label>
                                                        <input type="password" class="form-control"
                                                               id="exampleInputPassword2" name="j_password"
                                                               placeholder="Password" required>
                                                        <div class="help-block text-right"><a href="/register">Register
                                                            new
                                                            user</a></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <button type="submit" class="btn btn-primary btn-block">Sign in
                                                        </button>
                                                    </div>
                                                    <c:if test="${param.error ne null}">
                                                        <p style="color: #ac2925">Wrong login or pass!</p>
                                                    </c:if>
                                                </form>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                        </c:if>
                        <c:if test="${login ne null}">
                            <c:url value="/update" var="updateUrl"/>
                            <c:url value="/logout" var="logoutUrl"/>
                            <li><p class="navbar-text">Welcome, <a href=${updateUrl}>${login}</a> , <a
                                    href="${logoutUrl}">logout</a></p></li>
                        </c:if>

                    </ul>
                </div>
            </div>
        </nav>
    </div>


    <h1 style="color: #99dbf1"><a href="/" style="color: #d1ecf1">CA Workload Automation AE(CA AutoSys)</a></h1>
    <p class="badge badge-pill badge-info">This is the site about experience administering the system CA AutoSys(AE
        Release 11.3.6 SP5)</p>
</div>


<div class="navbar navbar-inverse navbar-fixed-left">


    <a class="navbar-brand" href="/login">Home</a>
    <div class="menu-list">
        <ul class="nav navbar-nav">

            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Description<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                    <c:forEach items="${desc_m}" var="desc_m">
                        <li><a href='/Description?name=<c:out value="${desc_m}"/>'>${desc_m}</a></li>
                    </c:forEach>
                </ul>
            </li>

            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Installation<span
                    class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                    <c:forEach items="${inst}" var="inst">
                        <li><a href='/Installation?name=<c:out value="${inst}"/>'>${inst}</a></li>
                    </c:forEach>
                </ul>
            </li>

            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Administration<span
                    class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                    <c:forEach items="${adm}" var="adm">
                        <li><a href='/Administration?name=<c:out value="${adm}"/>'>${adm}</a></li>
                    </c:forEach>
                </ul>
            </li>

            <li><a href="#" class="dropdown-toggle" data-toggle="dropdown">Command<b class="caret"></b></a>
                <ul class="dropdown-menu">




                    <li class="dropdown-submenu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Maintain System</a>
                        <ul class="dropdown-menu">
                            <c:forEach items="${comm1}" var="comm1">
                                <li><a href='/Command?name=<c:out value="${comm1}"/>'>${comm1}</a></li>
                            </c:forEach>
                        </ul>
                    </li>

                    <li class="dropdown-submenu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Maintain Databases</a>
                        <ul class="dropdown-menu">
                            <c:forEach items="${comm2}" var="comm2">
                                <li><a href='/Command?name=<c:out value="${comm2}"/>'>${comm2}</a></li>
                            </c:forEach>
                        </ul>
                    </li>

                    <li class="dropdown-submenu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Manage Security</a>
                        <ul class="dropdown-menu">
                            <c:forEach items="${comm3}" var="comm3">
                                <li><a href='/Command?name=<c:out value="${comm3}"/>'>${comm3}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                    <li class="dropdown-submenu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Define Objects</a>
                        <ul class="dropdown-menu">
                            <c:forEach items="${comm4}" var="comm4">
                                <li><a href='/Command?name=<c:out value="${comm4}"/>'>${comm4}</a></li>
                            </c:forEach>
                        </ul>
                    </li>

                    <li class="dropdown-submenu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Monitor and Report</a>
                        <ul class="dropdown-menu">
                            <c:forEach items="${comm5}" var="comm5">
                                <li><a href='/Command?name=<c:out value="${comm5}"/>'>${comm5}</a></li>
                            </c:forEach>
                        </ul>
                    </li>

                </ul>
            </li>


            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Agent<span
                    class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                    <c:forEach items="${agt}" var="agt">
                        <li><a href='/Agent?name=<c:out value="${agt}"/>'>${agt}</a></li>
                    </c:forEach>
                </ul>
            </li>

            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">EEM<span
                    class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                    <c:forEach items="${eem_m}" var="eem_m">
                        <li><a href='/EEM?name=<c:out value="${eem_m}"/>'>${eem_m}</a></li>
                    </c:forEach>
                </ul>
            </li>

            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">WCC<span
                    class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                    <c:forEach items="${wcc_m}" var="wcc_m">
                        <li><a href='/WCC?name=<c:out value="${wcc_m}"/>'>${wcc_m}</a></li>
                    </c:forEach>
                </ul>
            </li>

            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">AEDB<span
                    class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                    <c:forEach items="${aedb_m}" var="aedb_m">
                        <li><a href='/AEDB?name=<c:out value="${aedb_m}"/>'>${aedb_m}</a></li>
                    </c:forEach>
                </ul>
            </li>


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