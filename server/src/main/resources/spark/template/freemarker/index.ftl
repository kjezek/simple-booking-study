<html>

<head>
    <title>Booking Case-study</title>
    <script src="/jquery.js"></script>

    <style media="screen" type="text/css">
        body {
            margin: 0; padding: 0;
        }
        #header {
            width: 100%; height: 64px; background-color: Maroon;
            color: white;
            padding-left: 100px;
            font-size: 30px;
            font-family: Arial;
        }
        #main {
            margin: auto; width: 60%;
        }
        .inner-row {
            height: 30px;
            display: inline-block;
            width: 79%;
            vertical-align: top;
        }
        .inner-row .name {
            font-size: 25px; font-family: Arial;
            display: inline-block;
            width: 85%;
        }
        .inner-row .book {
            display: inline-block; background-color: maroon;
            padding: 5px;
            color: orange;
            font-family: Arial; font-weight: bold; font-size: 15px;
            cursor: pointer;
            text-align: right;
        }
        .rating {
            color: maroon; font-weight: bold;  font-size: 11px;
            height: 20px;
        }
        #title {
            position: relative; top: 25px;
        }
        #menu {
            height: 45px;
        }

        .rooms {
            width: 100%; text-align: right;
            font-family: Arial; color: green;
            font-size: 12px;
        }
        .rooms .price {
            padding-left: 20px; font-weight: bold;
        }

        .row {
            border-top: dotted maroon 1px;
            padding: 5px;
        }
    </style>

</head>

<body>

<div id="header">
    <div id="title">
        <span style="font-style: italic; margin: 0; padding: 0; color: orange; ">My</span>
        <span style="margin: 0; padding: 0">Booking</span>
    <#--<span>.</span>-->
    <#--<span style="color: orange; margin: 0; padding: 0;">CZ</span>-->
    </div>
</div>

<div id="menu">

</div>

<div id="main">
<#list hotels as hotel>

    <div class="row">
        <img src="${hotel.url}">
        <div class="inner-row">
            <div class="name">${hotel.name}</div>
            <div class="book">Book Now</div>
            <div rating_id="${hotel.ratingId}" class="rating">
                0%
            </div>
            <div hotel_id="${hotel.id}" class="rooms"></div>
        </div>
    </div>
</#list>
</div>


<script>

    $( document ).ready(function() {

        $(".rooms").each(function() {

            var hotelId = $(this).attr("hotel_id");
            $.get("/rooms/" + hotelId, function(data) {

                var roomElement = null;
                var html = "";
                var json = $.parseJSON(data);
                $(json).each(function(i, item) {
                    roomElement = $("div[class=rooms][hotel_id=" + item.hotelId  + "]");
                    html += "<span class=type>" + item.room + "</span>"
                            + "<span class=price>" + item.price + "€</span> <br>"
                });
                $(roomElement).html(html)

            });
        });

        $.get( "/rating", function( data ) {

            var ratings = $.parseJSON(data);

            $(".rating").each(function() {
                var key = $(this).attr('rating_id');
                var value = ratings[key];
                $(this).text(value + "%");
            });
        });
    });

</script>

</body>

</html>