function onVoltarCategoria(){
	executarCommand("/com.pos.projeto/Controller?command=ListarCategoria");
}

function onSaveCategory(){
	var valores = $('#CategoriaFormulario').serialize();
	var command = "/com.pos.projeto/Controller?command=SaveCategory&" + valores;
	executarCommand(command);
}