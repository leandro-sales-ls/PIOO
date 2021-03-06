<%@ page import="domain.User"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">Lista de usu�rios</div>
	<div>
		<button class="btn btn-primary" type="button"
			onclick="onEditUser()">Novo User</button>
	</div>
	<!-- Table -->
	<table class="table">
		<tr>
			<th></th>
			<th>Nome</th>
			<th>Login</th>
		</tr>
		<%
			List<User> users = (List<User>) request.getAttribute("users");
			for (User item : users) {
		%>
		<tr>
			<td>
				<button type="button" class="btn btn-info btn-sm"
					onclick="onEditUser('<%=item.getId()%>')">
					<span class="fa fa-pencil"> </span>
				</button>
				<button type="button" class="btn btn-danger btn-sm"
					onclick="onExluirUsuario('<%=item.getId()%>')">
					<span class="fa fa-trash-o"></span>
				</button>
			</td>
			<td><%=item.getNome()%></td>
			<td><%=item.getLogin()%></td>
		</tr>
		<%
			}
		%>
	</table>
</div>

<script type="text/javascript">
	<jsp:include page="/User/ListUser.js" />
</script>
