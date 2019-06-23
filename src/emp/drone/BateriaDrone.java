package emp.drone;

import java.util.concurrent.TimeUnit;

import emp.estacaocarregamento.EstacaoCarregamento;

public class BateriaDrone {
	private int carga;
	private boolean alertaRecarga;
	private StatusBateria status;

	public BateriaDrone() {
		super();
		int random = (int) (Math.random() * 20 + 1);
		this.setCarga(75 + random);
		this.alertaRecarga = false;
		this.setStatus(StatusBateria.CARREGADO);
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	public int getCarga() {
		return this.carga;
	}

	public void verificaCarga(int carga) {
		if (this.getCarga() <= 20) {
			this.setStatus(StatusBateria.EMERGENCIA);
		} else if (this.getCarga() <= 60) {
			this.setStatus(StatusBateria.SUFICIENTE);
		} else {
			this.setStatus(StatusBateria.CARREGADO);
		}
	}

	public boolean solicitaRecarga(EstacaoCarregamento e) {

		this.setStatus(StatusBateria.CARREGANDO);

		boolean r = e.carregaDrone(this.carga);

		if (r) {
			// carregamento concluido
			this.setStatus(StatusBateria.CARREGADO);
			return true;
		} else {
			// erro ao carregar bateria
			this.setStatus(StatusBateria.EMERGENCIA);
			return false;
		}
	}

	public StatusBateria getStatus() {
		return status;
	}

	public void setStatus(StatusBateria status) {
		this.status = status;
	}

}
