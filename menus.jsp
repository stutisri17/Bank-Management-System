<html>
<body>

<%
	String loginid = request.getParameter("loginid");
%>
	You are Welcome <%=loginid%>, In student Bank

<form action=menu method=post>
<table align=center>
<tr><td><input type=submit value="Create Account" name=createaccount> </td></tr>
<tr><td><input type=submit value="Deposit Amount" name=depositamount> </td></tr>
<tr><td><input type=submit value="Withdrawl Amount" name=withdrawlamount> </td></tr>
<tr><td><input type=submit value="Mini Statement" name=ministatement> </td></tr>
<tr><td><input type=submit value="Member List" name=memberlist> </td></tr>
</table>
<input type=hidden value=<%=loginid%> name=loginid>
</form>
</body>
</html>

