function onLoginUser(){
	var valores = $('#LoginFormulario').serialize();
	var command = "/com.pos.projeto/Controller?command=LoginUser&" + valores;
	$("body").load(command);
}

function onCadastrarUsuario(){
	executarCommand("/com.pos.projeto/Controller?command=EditUser");
}
