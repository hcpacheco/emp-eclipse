package emp.drone;

import java.util.List;

import emp.persistencia.Pessoa;
import emp.persistencia.ZonaDePatrulha;

public class Patrulha {
	
	private int identificador;
	private float[] area;
	private int duracaoPatrulha;
	private List<Pessoa> detectados;
	
	public List<Pessoa> getPatrulha ()            // Precisa ser arrumado
	{                                             // List detectados não foi feito correto
		return detectados;
	}
	
	public void setPatrulha(float[] area, int duracao, int identificador)
	{
		this.area = area;
		this.duracaoPatrulha = duracao;
		this.identificador = identificador;
	}
	
	public boolean cancelarPatrulha()
	{
		return true;
	}
	
    public boolean iniciarPatrulha()
    {
    	return true;
    }
	
}
