<%@ page import="domain.Advertiser"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">Lista de categorys</div>
	<div>
		<button class="btn btn-primary" type="button"
			onclick="onEditAdvertiser()">Nova Advertiser</button>
	</div>
	<!-- Table -->
	<table class="table">
		<tr>
			<th></th>
			<th>Nome</th>
			<th>Documento</th>
			<th>Telefone</th>
		</tr>
		<%
			List<Advertiser> advertisers = (List<Advertiser>) request.getAttribute("advertisers");
			for (Advertiser item : advertisers) {
		%>
		<tr>
			<td>
				<button type="button" class="btn btn-info btn-sm"
					onclick="onEditAdvertiser('<%=item.getId()%>')">
					<span class="fa fa-pencil"> </span>
				</button>
				<button type="button" class="btn btn-danger btn-sm"
					onclick="onExluirAnunciante('<%=item.getId()%>')">
					<span class="fa fa-trash-o"></span>
				</button>
			</td>
			<td><%=item.getNome()%></td>
			<td><%=item.getDocumento()%></td>
			<td><%=item.getTelefone()%></td>
		</tr>
		<%
			}
		%>
	</table>
</div>

<script type="text/javascript">
	<jsp:include page="/Anunciantes/ListAdvertiser.js" />
</script>
