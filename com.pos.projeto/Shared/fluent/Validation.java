package fluent;

import java.util.ArrayList;
import java.util.Date;

public abstract class Validation {
	private ArrayList<String> mensagens;
	
	public Validation() {
		this.mensagens = new ArrayList<String>();
	}
	
	public void deveSerVazio(Object obj, String mensagem)
	{
		if(obj != null)
		{
			this.mensagens.add(mensagem);
			return;
		}		
	}
	
	public void deveSerVazio(String obj, String mensagem)
	{
		if(!obj.isEmpty())
		{
			this.adicionarMensagem(mensagem);
		}
	}
	
	public void notEmpty(Object obj, String mensagem)
	{
		if(obj == null)
		{
			this.mensagens.add(mensagem);
			return;
		}
	}
	
	public void notEmpty(String obj, String mensagem)
	{
		if(obj.isEmpty())
		{
			this.adicionarMensagem(mensagem);
		}
	}
	
	
	public void deveSerMaiorQue(int valor, int compare, String mensagem)
	{
		if(compare > valor)
		{
			this.adicionarMensagem(mensagem);
		}
	}
	
	public void deveSerMaiorQue(Date valor, Date compare, String mensagem)
	{
		if(compare.before(valor))
		{
			this.adicionarMensagem(mensagem);
		}
	
	}
	
	public void deveSerMenorQue(int valor, int compare, String mensagem)
	{
		if(compare < valor)
		{
			this.adicionarMensagem(mensagem);
		}
	}
	
	public void deveSerMenorQue(Date valor, Date compare, String mensagem)
	{
		if(compare.after(valor))
		{
			this.adicionarMensagem(mensagem);
		}
	
	}
	
	public void deveSerIgual(String valor, String compare, String mensagem)
	{
		if(!valor.equals(compare))
		{
			this.adicionarMensagem(mensagem);
		}
	}
	
	public void naoDeveSerIgual(String valor, String compare, String mensagem)
	{
		if(valor.equals(compare))
		{
			this.adicionarMensagem(mensagem);
		}
	}

	public boolean EValido()
	{
		return this.mensagens.isEmpty();
	}
	
	public boolean EInvalido()
	{
		return !this.mensagens.isEmpty();
	}
	
	public void adicionarMensagem(String mensagem)
	{
		this.mensagens.add(mensagem);
	}
	
	public void addMessage(ArrayList mensagens)
	{
		this.mensagens.addAll(mensagens);
	}
	
	public ArrayList<String> obterMensagens() {
	
		return this.mensagens;
	}
	
	
}
