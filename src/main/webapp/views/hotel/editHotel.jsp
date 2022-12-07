<%@ page import="java.util.List" %>
<%@ page import="models.Hotel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EDIT APARTMENT</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

    <%
        Hotel hotel = (Hotel) request.getAttribute("apartment");
    %>

    <div class="w3-container w3-padding">
        <div class="w3-card-4">
            <div class="w3-container w3-center w3-green">
                <h2>Edit Customer</h2>
            </div>
            <form method="post" action="/editApartment" class="w3-selection w3-light-grey w3-padding">
                <label>Room Name:
                    <input type="text" value=${getApartmentName}  name="apartmentName"
                           class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
                </label>
                <label>Room Count:
                    <input type="text" value=${getRoomCount} name="roomCount"
                           class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
                </label>
                <label>Room Price:
                    <input type="text" value=${getRoomPrice} name="roomPrice"
                           class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
                </label>
                <label>isBooked:
                    <input type="text" value=${getIsBooked} name="isBooked"
                           class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
                </label>
                <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
            </form>
        </div>
    </div>

    <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
        <button class="w3-btn w3-round-large" onclick="location.href='/listApartment'">Back to main</button>
    </div>

</body>
</html>

