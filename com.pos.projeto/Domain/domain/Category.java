package domain;

public class Category extends Entity {

	private String nome;
	
	
	public Category(String nome)
	{
		super();
		super.notEmpty(nome, "Nome da category deve ser informado!");
		this.nome = nome;		
	}
	
	public String getNome() {
		return this.nome;
	}
	
	
	
}
