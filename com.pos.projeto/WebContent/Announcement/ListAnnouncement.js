function onEditAnnouncement(id)
{
	if(id)
	{
		executarCommand("/com.pos.projeto/Controller?command=EditAnnouncement&id=" + id);
	}
	else
	{
		executarCommand("/com.pos.projeto/Controller?command=EditAnnouncement");
	}
}


function onDeleteAnnouncement(id){
	if(confirm("Deseja deletar o announcement?"))
	{
		executarCommand("/com.pos.projeto/Controller?command=DeleteAnnouncement&id=" + id);
	}
}