<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>CA AutoSys. Admin experience. Installation</title>
    <link href="<c:url value="../static/bootstrap/css/fancybox.min.css"/>" rel="stylesheet">
    <link href="<c:url value="../static/bootstrap/css/font-awesome.min.css"/>" rel="stylesheet">
    <link href="<c:url value="../static/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="/static/bootstrap/js/fancybox.min.js"></script>
    <script src="https://www.w3schools.com/lib/w3.js"></script>


</head>
<body style="background-size: auto; background: #d1ecf1">
<jsp:include page="menu.jsp" flush="true"/>


<div class="container">
    <h1>${install.name}</h1>
    <div class="">
        <br>

        <p><b>Unit:</b></p>
        <p></p>
        <div class="toc-macro client-side-toc-macro  conf-macro output-block hidden-outline"
             data-headerelements="H1,H2,H3,H4,H5,H6,H7" data-hasbody="false" data-macro-name="toc">
            <ul style="">
                <li><span class="toc-item-body" data-outline="1"><span class="toc-outline"></span><a
                        href="#Requirements" class="toc-link">Requirements</a></span>
                </li>
                <li><span class="toc-item-body" data-outline="2"><span class="toc-outline"></span><a
                        href="#Algorithm" class="toc-link">Algorithm</a></span>
                </li>
                <li><span class="toc-item-body" data-outline="3"><span class="toc-outline"></span><a
                        href="#VideoInstallation" class="toc-link">Video installation</a></span>
                </li>
                <li><span class="toc-item-body" data-outline="4"><span class="toc-outline"></span><a
                        href="#ScreensInstallations" class="toc-link">Screens installations</a></span>
                </li>
            </ul>
        </div>
    </div>
    <h2 class="heading2" id="Requirements">Requirements</h2>
    <div w3-include-html=${install.requirements}></div>

    <h2 class="heading2" id="Algorithm">Algorithm</h2>
    <div w3-include-html=${install.algoritm}></div>
    <script>
        w3.includeHTML();
    </script>
</div>


<div class="container">
    <p></p>
    <h2 class="heading2" id="VideoInstallation">Video installation</h2>
    <div class="embed-responsive embed-responsive-4by3">
        <iframe width="560" height="315" src="https://www.youtube.com/embed/${install.pathVideo}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
    </div>
</div>




<div class="container">
    <br>
    <h2 class="heading2" id="ScreensInstallations">Screens installation</h2>
    <div class="row">
        <div class='list-group gallery'>
            <c:forEach items="${install.imgs}" var="list">
                <div class='col-sm-4 col-xs-6 col-md-3 col-lg-3'>
                    <a class="thumbnail fancybox" rel="ligthbox" href="${list.path}">
                        <img class="img-responsive" alt="" src="${list.path}"/>
                        <div class='text-right'>
                            <small class='text-muted'>${list.desc}</small>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div> <!-- list-group / end -->
    </div> <!-- row / end -->
</div>
<!-- container / end -->

<div class="container">
    <div class="chatContainer">
        <div class="chatTitleContainer">Comments</div>
        <div class="chatHistoryContainer">
            <ul class="formComments">
                <c:forEach items="${install.comments}" var="list" varStatus="myIndex">
                    <li class="commentLi commentstep-1" data-commentid="${myIndex.index}">
                        <table class="form-comments-table">
                            <tr>
                                <td>
                                    <div class="comment-timestamp">[ ${list.time} ]</div>
                                </td>
                                <td>
                                    <div class="comment-user">${list.user}</div>
                                </td>
                                <td>
                                    <div class="comment-avatar"><img src="${list.pathAvatar}"></div>
                                </td>
                                <td>
                                    <div id="comment-${myIndex.index}" data-commentid="${myIndex.index}" class="comment comment-step1">${list.body}
                                        <c:if test="${login == list.user}">
                                            <div id="commentactions-${myIndex.index}" class="comment-actions">
                                                <form id="del" method="POST" action="/delComment?name=<c:out value="${install.name}"></c:out>&id=<c:out value="${list.id}"></c:out>&table=Installation">
                                                    <button type="submit" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i>Delete</button>
                                                </form>
                                            </div>
                                        </c:if>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="input-group input-group-sm chatMessageControls">
            <span class="input-group-addon" id="sizing-addon3">Comment</span>
            <p><textarea style="width:100%;" name="body" id="body" rows="10" cols="75"
                         placeholder="Type your message here.." name="text" form="send"></textarea></p>
            <form id="send" method="POST"
                  action="/addComment?name=<c:out value="${install.name}"></c:out>&id=<c:out value="${install.id}"></c:out>&table=Installation">
                <button style="width: 20%" class="btn btn-primary" type="submit"><i class="fa fa-send"></i>Send</button>
                <button id="clearMessageButton" class="btn btn-default" type="button" onclick="clearContents(body)"><i
                        class="fa fa-deaf"></i> Clear
                </button>
            </form>
        </div>
    </div>
</div>





<script>
    $(document).ready(function () {
        //FANCYBOX
        //https://github.com/fancyapps/fancyBox
        $(".fancybox").fancybox({
            openEffect: "none",
            closeEffect: "none"
        });
    });

    $(document).ready(function () {
        initUIEvents();
    });

    function initUIEvents() {
        $(".comment").unbind().click(function () {

            var currentComment = $(this).data("commentid");

            $("#commentactions-" + currentComment).slideDown("fast");

        });


        $(".commentLi").hover(function () {
            var currentComment = $(this).data("commentid");
            $("#comment-" + currentComment).stop().animate({
                opacity: "1",
                backgroundColor: "#f8f8f8",
                borderLeftWidth: "4px"
            }, {
                duration: 100, complete: function () {
                }
            });

        }, function () {

            var currentComment = $(this).data("commentid");

            $("#comment-" + currentComment).stop().animate({
                opacity: "1",
                backgroundColor: "#fff",
                borderLeftWidth: "1px"
            }, {
                duration: 100, complete: function () {
                }
            });
            $("#commentactions-" + currentComment).slideUp("fast");

        });

    }

    function clearContents(element) {
        element.value = '';
    }


</script>

</body>
</html>
