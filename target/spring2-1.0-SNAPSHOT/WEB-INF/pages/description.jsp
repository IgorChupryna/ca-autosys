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
    <script src="https://www.w3schools.com/lib/w3.js"></script>
</head>
<body style="background-size: auto; background:  #d1ecf1">

<jsp:include page="menu.jsp" flush="true"/>
<div class="container">
    <h1>${desc.name}</h1>
    <div w3-include-html=${desc.path}></div>
    <script>
        w3.includeHTML();
    </script>
</div>


<div class="container">
    <div class="chatContainer">
        <div class="chatTitleContainer">Comments</div>
        <div class="chatHistoryContainer">
            <ul class="formComments">


                <c:forEach items="${desc.comments}" var="list" varStatus="myIndex">
                    <li class="commentLi commentstep-1" data-commentid="${myIndex.index}">

                        <table class="form-comments-table">
                            <tr>
                                <td>
                                    <div class="comment-timestamp">${list.time}</div>
                                </td>
                                <td>
                                    <div class="comment-user">${list.user}</div>
                                </td>
                                <td>
                                    <div class="comment-avatar">
                                        <img src="${list.pathAvatar}">
                                    </div>
                                </td>
                                <td>

                                    <div id="comment-${myIndex.index}" data-commentid="${myIndex.index}" class="comment comment-step1">${list.body}




                                        <c:if test="${login == list.user}">
                                            <div id="commentactions-${myIndex.index}" class="comment-actions">
                                                <div class="btn-group" role="group" aria-label="...">
                                                    <button type="button" class="btn btn-primary btn-sm"><i
                                                            class="fa fa-edit"></i>
                                                        Reply
                                                    </button>
                                                    <button type="button" class="btn btn-default btn-sm"><i
                                                            class="fa fa-pencil"></i> Edit
                                                    </button>
                                                    <button type="button" class="btn btn-danger btn-sm"><i
                                                            class="fa fa-trash"></i>Delete
                                                    </button>

                                                </div>
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


            <p><textarea style="width:100%;" name="body" id="body" rows="10" cols="full"
                         placeholder="Type your message here.." name="text" form="send"></textarea></p>
            <form id="send" method="POST"
                  action="/addComment?name=<c:out value="${desc.name}"></c:out>&id=<c:out value="${desc.id}"></c:out>&table=Description">
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
