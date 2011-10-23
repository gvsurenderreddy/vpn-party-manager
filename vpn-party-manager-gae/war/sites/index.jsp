<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.LinkedList"%>
<%@page import="vpm.gae.server.Server"%>
<!doctype html>
<html>
<head>
<title>VPN-Party-Manager</title>
</head>
<body>
	<h1>Current Running Server</h1>
	<br />
	<table id="servertable">
		<tr>
			<th>Server Name</th>
			<td>Ip</td>
			<td>Port</td>
		</tr>
		<%
		    List<Server> server = Server.getServer();
		    for (Server s : server) {
		%>
		<tr>
			<th><%=s.getName()%></th>
			<td><%=s.getIp()%></td>
			<td><%=s.getPort()%></td>
		</tr>
		<%
		    }
		%>
	</table>
</body>
</html>