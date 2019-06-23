package emp.drone;

import java.util.List;

import emp.Mensagem;
import emp.controle.Notificacao;

public class NotificacaoDrone implements Mensagem {
	private int id;
	private Notificacao controle;
	private DroneFacade drone;

	private List<String> rx;

	public void setRx(List<String> rx) {
		this.rx = rx;
	}

	public List<String> getRx() {
		return rx;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int getCargaDrone() {
		return drone.getCarga();
	}
	
	public NotificacaoDrone(Notificacao controle, int id) {
		super();
		this.setId(id);
		this.controle = controle;
		this.drone = new DroneFacade();
		this.setRx(null);
	}

	@Override
	public boolean enviaMsg(int idDst, List<String> msg) {
		if (this.controle.getId() == idDst) {
			this.controle.recebeMsg(msg);
			return true;
		}
		return false;
	}

	@Override
	public void recebeMsg(List<String> msg) {
		this.setRx(msg);
	}

}