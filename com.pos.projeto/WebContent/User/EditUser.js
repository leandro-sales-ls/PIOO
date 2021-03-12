function onVoltarUsuario(){
	executarCommand("/com.pos.projeto/Controller?command=ListUser");
}

function onVoltarLogin(){
	executarCommand("/com.pos.projeto/Controller?command=LoginUser");
}

function onSaveUser(){
	var valores = $('#UsuarioFormulario').serialize();
	var command = "/com.pos.projeto/Controller?command=SaveUser&" + valores;
	executarCommand(command);
}

