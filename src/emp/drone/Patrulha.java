package emp.drone;

import java.util.List;

import emp.persistencia.Pessoa;
import emp.persistencia.ZonaDePatrulha;

public class Patrulha {
	private int identificador;
	private List<Float> area;
	private int duracao;
	private List<Pessoa> detectados;
	
	public List<Pessoa> getDetectados(){
		return detectados;
	}
	
	public Patrulha(List<Float> area, int duracao) {
		this.setAreaInicial(area);
		this.setDuracao(duracao);
	}
	
	private void setId(int identPatrulha) {
		this.identificador = identificador;
		
	}

	private void setDuracao(int duracao) {
		this.duracao = duracao;
		
	}

	private void setAreaInicial(List<Float> areaInicial) {
		this.area = areaInicial;
		
	}

	public boolean cancelarPatrulha() {
		return true;
	}
	
	public boolean iniciarPatrulha() {
		return true;
	}	
}
