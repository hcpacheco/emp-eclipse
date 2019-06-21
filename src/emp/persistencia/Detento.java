package emp.persistencia;

import java.util.Date;
import java.util.List;

public class Detento extends Pessoa
{
	private List<Float> posicoes;
	private int atividadeCardiaca;

	public List<Float> getPosicoes() {
		return posicoes;
	}
	public void setPosicoes(List<Float> posicoes) {
		this.posicoes = posicoes;
	}
	public int getAtividadeCardiaca() {
		return atividadeCardiaca;
	}
	public void setAtividadeCardiaca(int atividadeCardiaca) {
		this.atividadeCardiaca = atividadeCardiaca;
	}
	
	public Detento(String nome, Date d, Sexo s, String cpf,List<Float> posicoes, int atividadeCardiaca) {
		super();
		this.setPosicoes(posicoes);
		this.setAtividadeCardiaca(atividadeCardiaca);
	}

}
