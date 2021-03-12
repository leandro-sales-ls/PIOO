

function onEditUser(id)
{
	if(id)
	{
		executarCommand("/com.pos.projeto/Controller?command=EditUser&id=" + id);
	}
	else
	{
		executarCommand("/com.pos.projeto/Controller?command=EditUser");
	}
}



function onExluirUsuario(id){
	if(confirm("Deseja deletar o user?"))
	{
		executarCommand("/com.pos.projeto/Controller?command=DeleteUser&id=" + id);
	}
}