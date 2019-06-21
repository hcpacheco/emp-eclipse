package emp.drone;

import java.util.List;

import emp.persistencia.Pessoa;

public class Patrulha {
	private int identificador;
	private float area[];
	private int duracaoPatrulha;
	private List<Pessoa> detectados;
	
	public List<Pessoa> getPtarulha(){
		return detectados;
	}
	
	public void setPatrula(float area[], int duracao, int identificador) {
		this.identificador = identificador;
		this.area = area;
		this.duracaoPatrulha = duracao; 
	}
	
	public boolean cancelarPatrulha() {
		return true;
	}
	
	public boolean iniciarPatrulha() {
		return true;
	}	
}
