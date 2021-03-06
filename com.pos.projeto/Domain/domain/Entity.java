package domain;

import java.util.UUID;

import fluent.Validation;

public abstract class Entity extends Validation {

	private UUID id;
	

	private boolean novoRegistro;
	public Entity() {
		super();
		this.setId(UUID.randomUUID());
		this.novoRegistro = true;
		
	}

	private void setId(UUID valor) {
		this.novoRegistro = false;
		this.id = valor;
	}

	public void setId(String valor)
	{
		this.novoRegistro = false;
		this.id = UUID.fromString(valor);	
	}

	public String getId()
	{
		return id.toString();
	}
	
	public boolean isNovoRegistro() {
		return novoRegistro;
	}
}
