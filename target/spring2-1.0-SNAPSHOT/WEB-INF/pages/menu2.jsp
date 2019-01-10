<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<body style="background-size: auto; background:  #d1ecf1">
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>

<nav class="navbar navbar-default mega-nav " >
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#MainMenu" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="MainMenu">
            <ul class="nav navbar-nav menu-list">
                <li class="dropdown list-category">
                    <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <i class="fa fa-navicon"></i> Categories <i class="fa fa-angle-down" aria-hidden="true"></i>
                    </a>
                    <ul class="dropdown-menu mega-dropdown-menu">
                        <li><a href="#">Cushion</a></li>
                        <li><a href="#">Bath</a></li>
                        <li><a href="#">Air Conditioner</a></li>
                        <li><a href="#">Radiator</a></li>
                        <li><a href="#">Washing Machine</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">View all</a></li>
                    </ul>
                </li>
                <li><a href="#">Home</a></li>
                <li><a href="#">Products</a></li>
                <li><a href="#">Latest News</a></li>
                <li><a href="#">Contacts</a></li>
            </ul>
            <form id="mega-search" class="navbar-form navbar-right">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search...">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">
                            <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </span>
                </div>
            </form>
        </div>
    </div>
</nav>



<div style='float: left;border-radius: 25px; background: #99dbf1;padding: 10px; margin-right: 10px; '>
    <img height="50" width="55" src="/static/auto.png"/><a
        href="https://www.ca.com/us/products/ca-workload-automation-ae.html">agility <br> made possible</a>
</div>

<div class="jumbotron text-center " style="background-size: auto; background-image:  url(/static/3.jpg); ">
    <h1 style="color: #99dbf1"> <a href="/" style="color: #d1ecf1">CA Workload Automation AE(CA AutoSys)</a> </h1>
    <p class="badge badge-pill badge-info">This is the site about experience administering the system CA AutoSys(AE Release 11.3.6 SP5)</p>



</div>













<a id="back-to-top" href="#" class="btn btn-primary btn-lg back-to-top" role="button"
   title="Click to return on the top page" data-toggle="tooltip" data-placement="left"><span
        class="glyphicon glyphicon-chevron-up"></span></a>









<script>


    $(document).ready(function () {
        //Hover Menu in Header
        $('ul.nav li.dropdown').hover(function () {
            $(this).find('.mega-dropdown-menu').stop(true, true).delay(200).fadeIn(200);
            $('.darkness').stop(true, true).fadeIn();
        }, function () {
            $(this).find('.mega-dropdown-menu').stop(true, true).delay(200).fadeOut(200);
            $('.darkness').stop(true, true).delay(200).fadeOut();
        });
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