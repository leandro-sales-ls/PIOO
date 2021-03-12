function onEditAdvertiser(id)
{
	if(id)
	{
		executarCommand("/com.pos.projeto/Controller?command=EditAdvertiser&id=" + id);
	}
	else
	{
		executarCommand("/com.pos.projeto/Controller?command=EditAdvertiser");
	}
}

function onDeleteAdvertiser(id){
	if(confirm("Deseja deletar o advertiser?"))
	{
		executarCommand("/com.pos.projeto/Controller?command=&id=" + id);
	}
}