<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 12.12.2021
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="models.Hotel" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Hotels</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <meta name="viewport" content="width=device-width"/>
    <link type="text/css" rel="stylesheet" href="/css/main.css"/>
</head>

<div>
    <h3>List of free rooms</h3>
    <table>
        <tr class="header">
            <td><p>Id</p></td>
            <td><p>Name</p></td>
            <td><p>Amount of rooms</p></td>
            <td><p>Price</p></td>
            <td></td>
        </tr>
        <%
            HttpSession session1 = request.getSession();
            String role = (String) session.getAttribute("session_role");
            out.println("Authorized client" + request.getAttribute("session") + " Role " + role);
            List<Hotel> apartments = (List<Hotel>) request.getAttribute("apartments");

            if (apartments != null && !apartments.isEmpty()) {

                for (Hotel s : apartments) {
                    if (s.getIsBooked() == 0 && !role.equals("Administrator")) {
                        out.println("<tr>");
                        out.println("<td><p>" + s.getId() + "</p></td>");
                        out.println("<td><p>" + s.getApartmentName() + "</p></td>");
                        out.println("<td><p>" + s.getRoomCount() + "</p></td>");
                        out.println("<td><p>" + s.getRoomPrice() + "</p></td>");
                        out.println("<td><p>");

                        out.println("<form action=\"/bookApartment\" method=\"POST\">");
                        out.println("<div>");
                        out.println("<input type = \"hidden\" value=\"" + s.getId() + "\" name=\"id\">");
                        out.println("<input type = \"hidden\" value=\"" + request.getAttribute("session") + "\" name=\"session\">");
                        out.println("</div>");
                        out.println("<div>");
                        out.println("<button>Book Apartment</button>");
                        out.println("</div>");
                        out.println("</form>");
                        out.println("</p></td>");
                        out.println("</tr>");
                    }

                    if (role.equals("Administrator")) {
                        out.println("<tr>");
                        out.println("<td><p>" + s.getId() + "</p></td>");
                        out.println("<td><p>" + s.getApartmentName() + "</p></td>");
                        out.println("<td><p>" + s.getRoomCount() + "</p></td>");
                        out.println("<td><p>" + s.getRoomPrice() + "</p></td>");
                        out.println("<td><p>");

                        out.println("<td><p><a href=" + "'/editApartment?id=   " + s.getId() + " ' >Редактировать</a></p></td>");
                        out.println("</p></td>");
                        out.println("</tr>");
                    }
                }
            }
        %>
        <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
            <%
                if (request.getAttribute("apartment") != null) {
                    Hotel apartment = (Hotel) request.getAttribute("apartment");

                    if (apartment != null) {
                        out.println("Booked hotel" + apartment.getApartmentName());
                    }
                }
            %>
        </div>
    </table>
</div>
<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/closeSession'">Close Session</button>
    <button class="w3-btn w3-round-large" onclick="location.href='/listApartment'">Back to main</button>
</div>
</body>
</html>
