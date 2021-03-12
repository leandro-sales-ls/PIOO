<%@ page import="domain.Announcement"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<%
	ArrayList<Announcement> announcements = (ArrayList<Announcement>) request.getAttribute("announcements");
%>
<div class="row">
	<%
		for (Announcement item : announcements) {
	%>
	<div class="col-2">
		<h3><%=item.getCategoria().getNome()%></h3>
		<div>
			<%=item.getCategoria().getNome()%>
		</div>
	</div>
	<%
		}
	%>
</div>