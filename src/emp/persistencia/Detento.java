package emp.persistencia;

import java.util.Date;
import java.util.List;

public class Detento extends Pessoa
{
	private List<Double> posicoes;
	private int atividadeCardiaca;

	public List<Double> getPosicoes() {
		return posicoes;
	}
	public void setPosicoes(List<Double> posicoes) {
		this.posicoes = posicoes;
	}
	public int getAtividadeCardiaca() {
		return atividadeCardiaca;
	}
	public void setAtividadeCardiaca(int atividadeCardiaca) {
		this.atividadeCardiaca = atividadeCardiaca;
	}
	
	public Detento(){
	super();
	this.setPosicoes(null);
	this.setAtividadeCardiaca(0);
	}
	
	public Detento(String nome, Date d, Sexo s, String cpf,List<Double> posicoes, int atividadeCardiaca) {
		super(nome, d, s, cpf);
		this.setPosicoes(posicoes);
		this.setAtividadeCardiaca(atividadeCardiaca);
		
	}
	
	public Detento(String nome, Date d, Sexo s, String cpf) {
		super(nome, d, s, cpf);
		this.setPosicoes(null);
		//sorteia atividade cardiaca
		int random = (int) (Math.random() * 30 + 1);
		int atividadeCardiaca = (50 + random);
		this.setAtividadeCardiaca(atividadeCardiaca);
		
	}

}
