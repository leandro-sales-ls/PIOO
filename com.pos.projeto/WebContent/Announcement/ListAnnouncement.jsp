<%@ page import="domain.Announcement"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">Lista de an�ncio</div>
	<div>
		<button class="btn btn-primary" type="button"
			onclick="onEditAnnouncement()">Novo An�ncio</button>
	</div>
	<!-- Table -->
	<table class="table">
		<tr>
			<th></th>
			<th>Category</th>
			<th>Announcement</th>
			<th>Validade</th>

		</tr>
		<%
			List<Announcement> announcements = (List<Announcement>) request.getAttribute("announcements");
			for (Announcement item : announcements) {
		%>
		<tr>
			<td>
				<button type="button" class="btn btn-info btn-sm"
					onclick="onEditAnnouncement('<%=item.getId()%>')">
					<span class="fa fa-pencil"></span>
				</button>
				<button type="button" class="btn btn-danger btn-sm"
					onclick="onDeleteAnnouncement('<%=item.getId()%>')">
					<span class="fa fa-trash-o"></span>
				</button>
			</td>
			<td><%=item.getCategoria().getNome()%></td>
			<td><%=item.getAnunciante().getNome()%></td>
		</tr>
		<%
			}
		%>
	</table>
</div>


<script type="text/javascript">
	<jsp:include page="/Anuncios/ListAnnouncement.js" />
</script>
