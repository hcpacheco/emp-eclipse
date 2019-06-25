package emp.drone;

import java.util.List;

import emp.persistencia.Pessoa;
import emp.persistencia.ZonaDePatrulha;

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
	
	private void setId(int identificador) {
		this.identificador = identificador;
		
	}

	private void setDuracao(int duracao) {
		this.duracao = duracao;
		
	}

	private void setArea(List<Double> x, List<Double> y) {
		this.limitesx = x;
		this.limitesy = y;
		
	}

	public boolean cancelarPatrulha() {
		return true;
	}
	
	public boolean iniciarPatrulha() {
		return true;
	}	
}
