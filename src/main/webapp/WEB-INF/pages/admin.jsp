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

<div align="center">
    <h1>Secret page for admins only!</h1>

    <c:url value="/logout" var="logoutUrl" />
    <p>Click to logout: <a href="${logoutUrl}">LOGOUT</a></p>





        <div class="container">
            <div class="row" align="center">

                    <div class="plan col-xs-12 col-sm-12 col-md-6 col-lg-4"  onclick="location.href='/users';">
                        <div class="boxes" style="background: #f7f7f7">
                            <div class="img-upper">
                                <img class="img-responsive" src='/static/manag/iconUsers.png'>
                            </div>
                            <div class="description">
                                <h2>User managment</h2>
                                <p>This article about managments users. There are Add user, Delete user, Update datas</p>
                            </div>
                        </div>
                    </div>

                <div class="plan col-xs-12 col-sm-12 col-md-6 col-lg-4"  onclick="location.href='/sendmail';">
                    <div class="boxes" style="background: #f7f7f7">
                        <div class="img-upper">
                            <img class="img-responsive" src='/static/manag/iconSendmail.png'>
                        </div>
                        <div class="description">
                            <h2>SendMail & SMS</h2>
                            <p>This features can manually send mail or sms information to user</p>
                        </div>
                    </div>
                </div>

                <div class="plan col-xs-12 col-sm-12 col-md-6 col-lg-4" onclick="location.href='/content';">
                    <div class="boxes" style="background: #f7f7f7">
                        <div class="img-upper">
                            <img class="img-responsive" src='/static/manag/iconContent.jpg'>
                        </div>
                        <div class="description">
                            <h2>Content managment</h2>
                            <p>The collection, managing, and publishing of information in any form</p>
                        </div>
                    </div>
                </div>

            </div>
        </div>


    <script>




    </script>


</div>
</body>
</html>
