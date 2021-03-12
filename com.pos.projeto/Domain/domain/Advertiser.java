
package domain;

import java.util.Date;

public class Advertiser extends Entity {

	private String nome;
	private String documento;
	private String endereco;
	private String cidade;
	private String telefone;
	


	private Date dataCriacao;
	
	protected Advertiser()
	{
		super();
	}
	
	public Advertiser(String nome, String documento, String endereco, String cidade, String telefone)
	{
		super();
	
		super.notEmpty(nome, "Nome deve ser informado");
		super.notEmpty(documento, "Documento deve ser informado");
		super.notEmpty(endereco, "Endereço deve ser informado");
		super.notEmpty(cidade, "Cidade deve ser informada");
		super.notEmpty(telefone, "Telefone deve ser informado");
		
		this.nome = nome;
		this.documento = documento;
		this.endereco = endereco;
		this.cidade = cidade;
		this.telefone = telefone;	
		this.setDataCriacao(new Date());
	}
	
	public String getNome() {
		return nome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public String getTelefone() {
		return telefone;
	}
	

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
}
