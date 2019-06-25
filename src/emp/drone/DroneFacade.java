package emp.drone;

import java.util.List;

import emp.controle.Notificacao;
import emp.persistencia.Pessoa;
import emp.persistencia.ZonaDeAtividade;

public class DroneFacade {
	private StatusDrone status;
	private boolean disponivel;
	private BateriaDrone bateria;
	private Patrulha patrulha;
	private GPS gps;
	private ZonaDeAtividade zona;

	public DroneFacade() {
		super();
		this.setGps(new GPS(0.0, 0.0));
		this.setStatus(StatusDrone.IDLE);
		this.setDisponivel(true);
		this.setBateria(new BateriaDrone());
		this.setPatrulha(new Patrulha(null,null, 0));
		this.setZona(new ZonaDeAtividade());
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

	public String getStatus() {
		return status.name();
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
	
	public int getCarga() {
		return this.bateria.getCarga();
	}
	
	public double getPosx() {
		return this.gps.getPosx();
	}
	
	public double getPosy() {
		return this.gps.getPosy();
	}

	public void setZona(ZonaDeAtividade z) {
		this.zona = z;
	}
	
	public String getZona() {
		return this.zona.getNome();
	}
}
