package emp.persistencia;

import java.util.Date;
import java.util.List;

public class Civil extends Pessoa
{
	private List<Double> posicoes;
	private boolean suspeito;
	private boolean conhecido;
	
	public List<Double> getPosicoes() 
	{
		return posicoes;
	}
	
	public void setPosicoes(List<Double> posicoes) 
	{
		this.posicoes = posicoes;
	}
	
	public boolean isSuspeito() 
	{
		return suspeito;
	}
	
	public void setSuspeito(boolean suspeito) 
	{
		this.suspeito = suspeito;
	}
	
	public boolean isConhecido() 
	{
		return conhecido;
	}
	
	public void setConhecido(boolean conhecido) 
	{
		this.conhecido = conhecido;
	}

	public Civil(String nome, Date d, Sexo s, String cpf, List<Double> posicoes, boolean suspeito) {
		
		super(nome,d,s,cpf);
		this.setPosicoes(posicoes);
		this.setSuspeito(suspeito);
		this.setConhecido(true);
	}

	public Civil(List<Double> posicoes, boolean suspeito) {
		super();
		this.setPosicoes(posicoes);
		this.setSuspeito(suspeito);
		this.setConhecido(false);
	}
	

}
