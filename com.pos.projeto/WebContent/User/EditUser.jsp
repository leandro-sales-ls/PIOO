<%@ page import="domain.User"%>

<%
	User user = (User) request.getAttribute("user");
%>

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">Cadatrar User</div>
	<form id="UsuarioFormulario">
		<input type="hidden" name="id" value="<%=user.getId()%>" /> <input
			type="hidden" name="isnew" value="<%=user.isNovoRegistro()%>" />
		<div class="form-group">
			<label class="control-label required">Nome <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="nome"
				value="<%=user.getNome()%>" required />
		</div>

		<div class="form-group">
			<label class="control-label required">Login <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="login"
				value="<%=user.getLogin()%>" required />
		</div>
		
		<div class="form-group">
			<label class="control-label required">Senha <abbr
				title="required">*</abbr>
			</label> <input type="password" class="form-control" name="senha"
				 required />
		</div>

		<button class="btn btn-primary" type="button"
			onclick="onSaveUser()">Salvar</button>
		<button class="btn btn-primary" type="button"
			onclick="<%= request.getSession().getAttribute("userLogado") == null ? "onVoltarLogin()" : "onVoltarUsuario()" %>">Voltar</button>
	</form>
</div>

<script type="text/javascript">
	<jsp:include page="/User/EditUser.js" />
</script>