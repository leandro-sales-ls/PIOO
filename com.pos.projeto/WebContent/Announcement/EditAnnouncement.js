function onVoltarAnuncio(){
	executarCommand("/com.pos.projeto/Controller?command=ListAnnouncement");
}

function onSaveAnnouncement(){
	var valores = $('#AnuncioFormulario').serialize();
	var command = "/com.pos.projeto/Controller?command=SaveAnnouncement&" + valores;
	executarCommand(command);
}