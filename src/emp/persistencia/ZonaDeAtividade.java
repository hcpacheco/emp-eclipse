package emp.persistencia;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeAtividade {
	private String nome;
	private List<Double> latitudes;//= new ArrayList();
	private List<Double> longitudes;// = new ArrayList();
	
	public List<Double> getLatitudes() {
		return latitudes;
	}
	
	public List<Double> getLongitudes() {
		return longitudes;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public ZonaDeAtividade(String nome,List<Double> latitudes, List<Double> longitudes) {
		super();
		this.latitudes = latitudes;
		this.longitudes = longitudes;
		this.nome = nome;
	}

	public ZonaDeAtividade(List<Double> latitudes, List<Double> longitudes) {
		super();
		this.latitudes = latitudes;
		this.longitudes = longitudes;
	}
	
	public ZonaDeAtividade() {
		super();
		this.latitudes = null;
		this.longitudes = null;
		this.nome = "";
	}
	
	public String latToString() {
		String m = "";
		for (int i = 0; i < latitudes.size(); i++) {
			m.concat(Double.toString(latitudes.get(i)).concat(","));
		}
		return m;
	}
	
	public String longToString() {
		String m = "";
		for (int i = 0; i < longitudes.size(); i++) {
			m.concat(Double.toString(longitudes.get(i)).concat(","));
		}
		return m;
	}

}
