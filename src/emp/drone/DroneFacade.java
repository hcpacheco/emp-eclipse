package emp.drone;

import java.util.List;

import emp.controle.Notificacao;
import emp.persistencia.Pessoa;

public class DroneFacade {
	private StatusDrone status;
	private boolean disponivel;
	private BateriaDrone bateria;
	private Patrulha patrulha;
	private GPS gps;

	public DroneFacade() {
		super();
		this.setGps(new GPS(0.0, 0.0));
		this.setStatus(StatusDrone.IDLE);
		this.setDisponivel(true);
		this.setBateria(new BateriaDrone());
		this.setPatrulha(new Patrulha(null, 0));
	}

	public GPS getGps() {
		return gps;
	}

	public void setGps(GPS gps) {
		this.gps = gps;
	}

	public Patrulha getPatrulha() {
		return patrulha;
	}

	public void setPatrulha(Patrulha patrulha) {
		this.patrulha = patrulha;
	}

	public StatusDrone getStatus() {
		return status;
	}

	public void setStatus(StatusDrone status) {
		this.status = status;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public BateriaDrone getBateria() {
		return bateria;
	}

	public void setBateria(BateriaDrone bateria) {
		this.bateria = bateria;
	}

	public List<Pessoa> statusPatrulha() {
		return this.getPatrulha().getDetectados();

	}

	public boolean checarPatrulha() {
		return disponivel;

	}

}
