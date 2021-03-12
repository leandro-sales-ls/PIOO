<%@ page import="domain.Advertiser"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<%
	Advertiser advertiser = (Advertiser) request.getAttribute("advertiser");
%>

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">Cadatrar Advertiser</div>

	<form id="AnuncianteFormulario">

		<input type="hidden" name="id" value="<%=advertiser.getId()%>" /> <input
			type="hidden" name="isnew" value="<%=advertiser.isNovoRegistro()%>" />
		<div class="form-group">
			<label class="control-label required">Nome <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="nome"
				value="<%=advertiser.getNome()%>" required />
		</div>

		<div class="form-group">
			<label class="control-label required">Documento <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="documento"
				value="<%=advertiser.getDocumento()%>" required />
		</div>

		<div class="form-group">
			<label class="control-label required">Endere�o <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="endereco"
				value="<%=advertiser.getEndereco()%>" required />
		</div>

		<div class="form-group">
			<label class="control-label required">Telefone <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="telefone"
				value="<%=advertiser.getTelefone()%>" required />
		</div>

		<div class="form-group">
			<label class="control-label required">Cidade <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="cidade"
				value="<%=advertiser.getCidade()%>" required />
		</div>

		<button class="btn btn-primary" type="button"
			onclick="onSaveAdvertiser()">Salvar</button>
		<button class="btn btn-primary" type="button"
			onclick="onVoltarAnunciante()">Voltar</button>

	</form>
</div>
<script type="text/javascript">
	<jsp:include page="/Anunciantes/EditAdvertiser.js" />
</script>