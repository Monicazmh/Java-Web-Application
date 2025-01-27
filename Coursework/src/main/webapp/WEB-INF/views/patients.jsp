<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Patients Information</title>
</head>
<body>
<h2>Patients Information</h2>
<table border="1">
  <tr>
    <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>SSN</th>
    <th>Birthdate</th>
    <!-- Add more headers as needed -->
  </tr>
  <%-- Iterate over patientsList attribute --%>
  <%
    List<Map<String, String>> patientsList = (List<Map<String, String>>) request.getAttribute("patientsList");
    for (Map<String, String> patient : patientsList) {
  %>
  <tr>
    <%-- Display patient data --%>
    <td><%= patient.get("ID") %></td>
    <td><%= patient.get("FIRST") %></td>
    <td><%= patient.get("LAST") %></td>
    <td><%= patient.get("SSN") %></td>
    <td><%= patient.get("BIRTHDATE") %></td>
    <!-- Add more data as needed -->
  </tr>
  <%
    }
  %>
</table>
</body>
</html>

