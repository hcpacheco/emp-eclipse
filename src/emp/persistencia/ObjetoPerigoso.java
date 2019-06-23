package emp.persistencia;

public class ObjetoPerigoso {
	private String tipo;
	private int tamanhoAproximadoCm;
	private String formato;
	private String material;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getTamanhoAproximado() {
		return tamanhoAproximadoCm;
	}

	public String getFormato() {
		return formato;
	}

	public String getMaterial() {
		return material;
	}

	public void setTamanhoAproximado(int tamanhoAproximado) {
		this.tamanhoAproximadoCm = tamanhoAproximado;
	}

	private void setMaterial(String material) {
		this.material = material;
	}

	private void setFormato(String formato) {
		this.formato = formato;
	}

	public ObjetoPerigoso(String formato, int tamanho, String material) {
		super();
		this.setTipo("Desconhecido");
		this.setFormato(formato);
		this.setTamanhoAproximado(tamanho);
		this.setMaterial(material);
	}

	public void define() {
		if (this.getMaterial().equals("metal") && this.getFormato().equals("elipsoidal")
				&& ((this.getTamanhoAproximado() >= 5) && (this.getTamanhoAproximado() <= 15))) {
			this.setTipo("Faca");
		} else if (this.getMaterial().equals("metal") && this.getFormato().equals("cuboide")
				&& ((this.getTamanhoAproximado() >= 20) && (this.getTamanhoAproximado() <= 40))) {
			this.setTipo("Pistola");
		} else if (this.getMaterial().equals("metal") && this.getFormato().equals("torus")
				&& ((this.getTamanhoAproximado() >= 40) && (this.getTamanhoAproximado() <= 100))) {
			this.setTipo("Machado");
		} else if (this.getMaterial().equals("metal") && this.getFormato().equals("torus")
				&& (this.getTamanhoAproximado() < 40)) {
			this.setTipo("Celular");
		} else if (this.getMaterial().equals("plástico") && this.getFormato().equals("conico")
				&& ((this.getTamanhoAproximado() >= 20) && (this.getTamanhoAproximado() <= 40))) {
			this.setTipo("Garrafa");
		} else if (this.getMaterial().equals("cerâmico") && (this.getTamanhoAproximado() <= 100)) {
			this.setTipo("Vaso");
		}
	}

}
