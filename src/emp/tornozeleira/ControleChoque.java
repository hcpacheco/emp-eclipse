package emp.tornozeleira;

import java.util.Random;

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

	public ControleChoque() {
		super();
		Random randomGenerator = new Random();
		int atividadeCardiaca = randomGenerator.nextInt(50) + 50;
		this.setAtividadeCardiaca(atividadeCardiaca);
		
		Random randomGenerator2 = new Random();
		int potenciaChoque = randomGenerator2.nextInt(30) + 20;		
		this.setPotenciaChoque(potenciaChoque);
	}

}
