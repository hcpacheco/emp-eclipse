package emp.tornozeleira;

import java.util.List;

import emp.Mensagem;
import emp.controle.Notificacao;

public class NotificacaoTornozeleira implements Mensagem {
	private int id;
	private Notificacao controle;
	private TornozeleiraFacade tornozeleira;

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

	@Override
	public boolean enviaMsg(int idDst, String msg) {
		if (this.controle.getId() == idDst) {
			controle.recebeMsg(msg);
			return true;
		}
		return false;

	}

	@Override
	public List<String> recebeMsg(String m) {
		this.rx.add(m);
		return this.getRx();
	}

	public int getId() {
		return id;
	}

	public NotificacaoTornozeleira(Notificacao controle, int id) {
		super();
		this.setId(id);
		this.controle = controle;
		this.tornozeleira = new TornozeleiraFacade();
		this.setRx(null);
	}
}
