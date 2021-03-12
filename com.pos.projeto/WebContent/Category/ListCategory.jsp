<%@ page import="domain.Category"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">Lista de categorys</div>
	<div>
		<button class="btn btn-primary" type="button"
			onclick="onEditCategory()">Nova Category</button>
	</div>
	<!-- Table -->
	<table class="table">
		<tr>
			<th></th>
			<th>Nome</th>
		</tr>
		<%
			List<Category> categorys = (List<Category>) request.getAttribute("categorys");
			for (Category item : categorys) {
		%>
		<tr>
			<td>
				<button type="button" class="btn btn-info btn-sm"
					onclick="onEditCategory('<%=item.getId()%>')">
					<span class="fa fa-pencil"> </span>
				</button>
				<button type="button" class="btn btn-danger btn-sm"
					onclick="onExluirCategoria('<%=item.getId()%>')">
					<span class="fa fa-trash-o"></span>
				</button>
			</td>
			<td><%=item.getNome()%></td>
		</tr>
		<%
			}
		%>
	</table>
</div>

<script type="text/javascript">
	<jsp:include page="/Category/ListarCategoria.js" />
</script>
