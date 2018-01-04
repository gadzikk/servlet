/**
 * Created by gadzik on 04.01.18.
 */

function paggingOnHtml(currentPage, level, last) {
    $("#pagination").html("");
    var prev = Number(currentPage) - Number(1);
    var doubleprev = Number(currentPage) - Number(2);
    var next = Number(currentPage) + Number(1);
    var doubleNext = Number(currentPage) + Number(2);

    if (last > 3) {
        if (currentPage == 1) {
            $("#pagination").append("<div>1</div>" +
                "<div>" + next + "</div>" +
                "<div>" + doubleNext + "</div>" +
                "... " + "<div>" + last + "</div>");
            return;
        }
        var aboveOnTheBeginning = Math.abs(Number(currentPage) - Number(1)) > level;
        var aboveOnTheEnd = Math.abs(Number(currentPage) - Number(last)) > level;
        var prevIsOne = prev == 1;
        var nextIsLast = next == last;

        if (currentPage == last) {
            $("#pagination").append("<div>1</div>" +
                "... " +
                "<div>" + doubleprev + "</div>" +
                "<div>" + prev + "</div>" +
                "<div>" + last + "</div>");
        }
        else {
            if (aboveOnTheBeginning && aboveOnTheEnd) {
                $("#pagination").append("<div>1</div>" +
                    "... " +
                    "<div>" + prev + "</div>" +
                    "<div>" + currentPage + "</div>" +
                    "<div>" + next + "</div>" +
                    "... " +
                    "<div>" + last + "</div>");
            }
            else if (aboveOnTheBeginning && !aboveOnTheEnd) {
                if (nextIsLast) {
                    $("#pagination").append("<div>1</div>" +
                        "... " +
                        "<div>" + prev + "</div>" +
                        "<div>" + currentPage + "</div>" +
                        "<div>" + last + "</div>");
                }
                else {
                    $("#pagination").append("<div>1</div>" +
                        "... " +
                        "<div>" + prev + "</div>" +
                        "<div>" + currentPage + "</div>" +
                        "<div>" + next + "</div>" +
                        "<div>" + last + "</div>");
                }
            }
            else if (!aboveOnTheBeginning && aboveOnTheEnd) {
                if (prevIsOne) {
                    $("#pagination").append("<div>1</div>" +
                        "<div>" + currentPage + "</div>" +
                        "<div>" + next + "</div>" +
                        "... " +
                        "<div>" + last + "</div>");
                }
                else {
                    $("#pagination").append("<div>1</div>" +
                        "<div>" + prev + "</div>" +
                        "<div>" + currentPage + "</div>" +
                        "<div>" + next + "</div>" +
                        "... " +
                        "<div>" + last + "</div>");
                }
            }
            else {
                for (var i = 1; i <= last; i++) {
                    $("#pagination").append("<div>" + i + "</div>");
                }
            }
        }
    }
    else {
        for (var i = 1; i <= last; i++) {
            $("#pagination").append("<div>" + i + "</div>");
        }
    }
}

function orderingHelper(htmlOrdering) {
    if ($("#lastClicked").html() == htmlOrdering) {
        if ($("#ordering").val() == "asc") {
            $("#ordering").val("desc");
        }
        else if ($("#ordering").val() == "desc") {
            $("#ordering").val("asc");
        }
    }
    else {
        $("#ordering").val("asc");
    }
    $("#lastClicked").html(htmlOrdering);
}