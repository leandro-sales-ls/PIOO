<%@ page import="domain.Category"%>
<%@ page import="domain.Advertiser"%>
<%@ page import="domain.Announcement"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<%
	Announcement announcement = (Announcement) request.getAttribute("announcement");
	List<Category> categorys = (ArrayList<Category>) request.getAttribute("categorys");
	List<Advertiser> advertisers = (ArrayList<Advertiser>) request.getAttribute("advertisers");
%>

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">Cadatrar Announcement</div>
	<form id="AnuncioFormulario">
		<input type="hidden" name="id" value="<%=announcement.getId()%>"> <input
			type="hidden" name="isnew" value="<%=announcement.isNovoRegistro()%>" />
		<div class="form-group">

			<label class="control-label required">Category <abbr
				title="required">*</abbr>
			</label> <select name="categoryId" require>
				<%
					for (Category item : categorys) {
				%>
				<option value="<%=item.getId()%>"
					<%=!announcement.isNovoRegistro() && announcement.getCategoria().getId() == item.getId() ? "selected" : ""%>><%=item.getNome()%></option>
				<%
					}
				%>
			</select>
		</div>
		<div class="form-group">
			<label class="control-label required">Advertiser <abbr
				title="required">*</abbr>
			</label> <select name="advertiserId" require>
				<%
					for (Advertiser item : advertisers) {
				%>
				<option value="<%=item.getId()%>"
					<%=!announcement.isNovoRegistro() && announcement.getAnunciante().getId() == item.getId() ? "selected" : ""%>><%=item.getNome()%></option>
				<%
					}
				%>
			</select>
		</div>
		<div class="form-group">
			<label class="control-label required">Validade <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="dataValidade"
				value="<%=announcement.getDataValidade().toString()%>" required />
		</div>
		<button class="btn btn-primary" type="button"
			onclick="onSaveAnnouncement()">Salvar</button>
		<button class="btn btn-primary" type="button"
			onclick="onVoltarAnuncio()">Voltar</button>
	</form>
</div>

<script type="text/javascript">
	<jsp:include page="/Anuncios/EditAnnouncement.js" />
</script>