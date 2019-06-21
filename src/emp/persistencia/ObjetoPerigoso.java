package emp.persistencia;

public class ObjetoPerigoso 
{
	private String tipo;
	private int tamanhoAproximadoCm;
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getTamanhoAproximado() {
		return tamanhoAproximadoCm;
	}
	public void setTamanhoAproximado(int tamanhoAproximado) {
		this.tamanhoAproximadoCm = tamanhoAproximado;
	}
	
	public ObjetoPerigoso(String nome, int tamanho) {
		super();
		this.setTipo(nome);
		this.setTamanhoAproximado(tamanho);
	}
	
	

}
