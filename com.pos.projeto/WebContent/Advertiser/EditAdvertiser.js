function onVoltarAnuncio(){
	navegarPrincipal("/com.pos.projeto/Controller?command=ListAdvertiser");
}

function onSaveAdvertiser(){
	var valores = $('#AnuncianteFormulario').serialize();
	var command = "/com.pos.projeto/Controller?command=SaveAdvertiser&" + valores;
	executarCommand(command);
}