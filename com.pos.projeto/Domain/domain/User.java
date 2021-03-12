package domain;

public class User extends Entity {

	private String nome;
	private String login;
	private String senha;

	public User(String login, String senha)
	{
		super();
		
	
		notEmpty(login, "Login deve ser informado");
		notEmpty(senha, "Senha deve ser informado");
		
		
		this.login = login;
		this.senha = senha;	
	}

	public User(String nome, String login, String senha)
	{

		super();
		
		notEmpty(nome, "Nome deve ser informado");
		notEmpty(login, "Login deve ser informado");
		notEmpty(senha, "Senha deve ser informado");
		
		this.nome = nome;		
		this.login = login;
		this.senha = senha;

	}

	public void setSenha(String senha, String senhaCompare)
	{
		
		deveSerIgual(senha, senhaCompare, "Senhas n�o coicidem");
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		
		return senha;
	}
}
