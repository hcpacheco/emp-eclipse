package emp.persistencia;

import java.util.ArrayList;
import java.util.List;

public class ZonaDePatrulha {
	private String nome;
	private List<Float> latitudes;//= new ArrayList();
	private List<Float> longitudes;// = new ArrayList();
	
	public List getLatitudes() {
		return latitudes;
	}
	
	public List getLongitudes() {
		return longitudes;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public ZonaDePatrulha(String nome,List latitudes, List longitudes) {
		super();
		this.latitudes = latitudes;
		this.longitudes = longitudes;
		this.nome = nome;
	}

	public ZonaDePatrulha(List<Float> latitudes, List<Float> longitudes) {
		super();
		this.latitudes = latitudes;
		this.longitudes = longitudes;
	}
	
	
	
	

}
