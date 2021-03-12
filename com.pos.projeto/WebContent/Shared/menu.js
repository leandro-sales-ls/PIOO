function executarCommand(url){
	$("#com-pos-pioo-div-principal").load(url);
}

function executarCommandBody(url, dados)
{
	$.ajax({
		type: "POST",
		url: url,
		data: dados
	}).then(function(resultado){

		$("#com-pos-pioo-div-principal").html(resultado);
	});
}

$(document).ready(function(){
	$(".com-pos-pioo-menu-homes").on("click",  function(){ 
		$("#com-pos-pioo-div-principal").html("uma tela de boas vindas qualquer!");
	});

	$(".com-pos-pioo-menu-categorys").on("click", function(){
		executarCommand("/com.pos.projeto/Controller?command=ListarCategoria");
	});
	$(".com-pos-pioo-menu-advertisers").on("click", function(){ 
		executarCommand("/com.pos.projeto/Controller?command=ListAdvertiser"); 
	});
	$(".com-pos-pioo-menu-announcements").on("click",  function(){ 
		executarCommand("/com.pos.projeto/Controller?command=ListAnnouncement");
	});

	$(".com-pos-pioo-menu-users").on("click",  function(){ 
		executarCommand("/com.pos.projeto/Controller?command=ListUser");
	});

	$(".com-pos-pioo-menu-login").on("click",  function(){ 
		executarCommand("/com.pos.projeto/Controller?command=LoginUser");
	});

	$(".com-pos-pioo-menu-home").on("click", function(){
		executarCommand("/com.pos.projeto/Controller?command=ShowAnnouncement");
	});

	$(".com-pos-pioo-menu-logout").on("click", function(){
		$("body").load("/com.pos.projeto/Controller?command=LogoutUsuario");
	});
});

