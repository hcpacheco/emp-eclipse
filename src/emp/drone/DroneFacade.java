package emp.drone;

import java.util.List;

import emp.persistencia.Pessoa;

public class DroneFacade {
	private int notificacao;
	private double posx;
	private double posy;
	private StatusDrone status;
	private boolean disponivel;
	private List<Pessoa> detectados;
	private BateriaDrone bateria;

	public List<Pessoa> statusPatrulha() {
		return detectados;

	}

	public boolean checarPatrulha() {
		return disponivel;

	}

}
