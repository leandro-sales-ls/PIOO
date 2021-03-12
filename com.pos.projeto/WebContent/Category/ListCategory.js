$(document).ready(function(){
});

function onEditCategory(id)
{
	if(id)
	{
		executarCommand("/com.pos.projeto/Controller?command=EditCategory&id=" + id);
	}
	else
	{
		executarCommand("/com.pos.projeto/Controller?command=EditCategory");
	}
}



function onExluirCategoria(id){
	if(confirm("Deseja deletar o category?"))
	{
		executarCommand("/com.pos.projeto/Controller?command=DeleteCategory&id=" + id);
	}
}