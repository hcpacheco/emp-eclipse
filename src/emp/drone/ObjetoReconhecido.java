package emp.drone;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ObjetoReconhecido {
	private String material;
	private int tamanhocm;
	private String formato;
	
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getTamanho() {
		return tamanhocm;
	}
	public void setTamanho(int tamanho) {
		this.tamanhocm = tamanho;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	
	public ObjetoReconhecido() {
		super();
		
		List<String> materiaisConhecidos = Arrays.asList("metal", "plástico", "cerâmico");
		List<Integer> tamanhosConhecidos = Arrays.asList(10, 15, 20, 25, 30, 35, 40, 35, 50, 100, 200);
		List<String> formatosConhecidos = Arrays.asList("elipsoidal", "cuboide", "torus", "conico");
		
		Random rand = new Random();
		
		String material = materiaisConhecidos.get(rand.nextInt(materiaisConhecidos.size()));
		int tamanhocm = tamanhosConhecidos.get(rand.nextInt(tamanhosConhecidos.size()));
		String formato = formatosConhecidos.get(rand.nextInt(formatosConhecidos.size()));
		
		this.setMaterial(material);
		this.setTamanho(tamanhocm);
		this.setFormato(formato);
	}
	
	

}
