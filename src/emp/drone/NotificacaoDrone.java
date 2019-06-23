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

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public NotificacaoDrone(Notificacao controle, DroneFacade drone, int id) {
		super();
		this.setId(id);
		this.controle = controle;
		this.drone = drone;
		this.setRx(null);
	}

	public List<String> getRx() {
		return rx;
	}

	@Override
	public boolean enviaMsg(int idDst, String msg) {
		if (this.controle.getId() == idDst) {
			this.controle.recebeMsg(msg);
			return true;
		}
		return false;
	}

	@Override
	public List<String> recebeMsg(String m) {
		this.rx.add(m);
		return this.getRx();
	}

}