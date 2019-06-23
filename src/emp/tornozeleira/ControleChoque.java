package emp.tornozeleira;

public class ControleChoque {
	private int atividadeCardiaca;
	private int potenciaChoque;
	private boolean atividadeSuspeita;

	public int getAtividadeCardiaca() {
		return atividadeCardiaca;
	}

	public void setAtividadeCardiaca(int atividadeCardiaca) {
		this.atividadeCardiaca = atividadeCardiaca;
	}

	public int getPotenciaChoque() {
		return potenciaChoque;
	}

	public void setPotenciaChoque(int potenciaChoque) {
		this.potenciaChoque = potenciaChoque;
	}

	public ControleChoque(int atividadeCardiaca, int potenciaChoque) {
		super();
		this.setAtividadeCardiaca(atividadeCardiaca);
		this.setPotenciaChoque(potenciaChoque);
	}

}
