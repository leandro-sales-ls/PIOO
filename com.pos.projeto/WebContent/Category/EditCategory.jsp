<%@ page import="domain.Category"%>

<%
	Category category = (Category) request.getAttribute("category");
%>

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">Cadatrar Category</div>
	<form id="CategoriaFormulario">
		<input type="hidden" name="id" value="<%=category.getId()%>" /> <input
			type="hidden" name="isnew" value="<%=category.isNovoRegistro()%>" />
		<div class="form-group">
			<label class="control-label required">Nome <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="nome"
				value="<%=category.getNome()%>" required />
		</div>
		<button class="btn btn-primary" type="button"
			onclick="onSaveCategory()">Salvar</button>
		<button class="btn btn-primary" type="button"
			onclick="onVoltarCategoria()">Voltar</button>

	</form>
</div>

<script type="text/javascript">
	<jsp:include page="/Category/EditCategory.js" />
</script>