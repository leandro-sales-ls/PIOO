package domain;

import java.util.Date;

public class Announcement extends Entity {
	private Date dataCriacao;
	private Date dataValidade;
	private Category category;
	private Advertiser advertiser;
	
	protected Announcement()
	{
		super();
	}
	
	public Announcement(Category category, Advertiser advertiser, Date dataValidade) {
		super();
		
		super.addMessage(category.obterMensagens());
		super.addMessage(advertiser.obterMensagens());		
		super.deveSerMaiorQue(dataValidade, new Date(), "Data de validade deve ser maior do que a data atual");
		
		this.setDataCriacao(new Date());
		this.category = category;
		this.advertiser = advertiser;
		this.dataValidade = dataValidade;	
		
	}


	public Date getDataCriacao() {
		return dataCriacao;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public Category getCategoria() {
		return category;
	}

	public Advertiser getAnunciante() {
		return advertiser;
	}
	
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}
