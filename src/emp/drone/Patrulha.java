package emp.drone;

import java.util.List;

import emp.persistencia.Pessoa;
import emp.persistencia.ZonaDeAtividade;

public class Patrulha {
	private int identificador;
	private List<Double> limitesx;
	private List<Double> limitesy;
	private int duracao;
	private List<Pessoa> detectados;
	
	public List<Pessoa> getDetectados(){
		return detectados;
	}
	
	public Patrulha(List<Double> limitesx, List<Double> limitesy, int duracao) {
		this.setArea(limitesx, limitesy);
		this.setDuracao(duracao);
	}
	
	public void setId(int identificador) {
		this.identificador = identificador;
		
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
		
	}

	private void setArea(List<Double> x, List<Double> y) {
		this.limitesx = x;
		this.limitesy = y;
		
	}

	public int getDuracao() {
		return duracao;
	}

	public boolean cancelarPatrulha() {
		return true;
	}
	
	public boolean iniciarPatrulha() {
		return true;
	}

	public void atualizaPosicao() {
		
	}	
}
