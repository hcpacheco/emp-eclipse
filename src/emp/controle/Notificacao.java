package emp.controle;

import java.util.Arrays;
import java.util.List;

import emp.Mensagem;
import emp.drone.DroneFacade;
import emp.drone.NotificacaoDrone;
import emp.tornozeleira.NotificacaoTornozeleira;
import emp.tornozeleira.TornozeleiraFacade;

public class Notificacao implements Mensagem {
	private int id;
	List<Integer> idsDrones;
	List<Integer> idsTornozeleiras;
	List<NotificacaoDrone> dronesI;
	List<NotificacaoTornozeleira> tornozeleirasI;

	private List<String> rx;

	public void setRx(List<String> rx) {
		this.rx = rx;
	}

	public List<String> getRx() {
		return rx;
	}

	@Override
	public boolean enviaMsg(int idDst, String msg) {

		if (isDrone(idDst)) {
			// envia mensagem para drone
			for (int i = 0; i < dronesI.size(); i++) {
				if (dronesI.get(i).getId() == idDst) {
					dronesI.get(i).recebeMsg(msg);
					return true;
				}
			}
		} else {
			// envia mensagem para tornozeleira
			for (int i = 0; i < tornozeleirasI.size(); i++) {
				if (tornozeleirasI.get(i).getId() == idDst) {
					tornozeleirasI.get(i).recebeMsg(msg);
					return true;
				}
			}

		}

		return false;

	}

	public List<NotificacaoDrone> getDrones() {
		return dronesI;
	}

	public void setDrones(List<NotificacaoDrone> drones) {
		this.dronesI = drones;
	}

	public void setId(int id) {
		this.id = id;
	}

	private boolean isDrone(int id) {
		return Arrays.asList(idsDrones).contains(id);
	}

	public int getId() {
		return id;
	}

	@Override
	public List<String> recebeMsg(String m) {
		this.rx.add(m);
		return this.getRx();
	}

	public Notificacao() {
		super();
		this.setId(-1);
		this.setRx(null);
	}

	public int criaNovaTornozeleira() {
		TornozeleiraFacade t = new TornozeleiraFacade();
		NotificacaoTornozeleira n = new NotificacaoTornozeleira(this, t, this.tornozeleirasI.size());
		this.tornozeleirasI.add(n);
		return n.getId();
	}

	public int criaNovoDrone() {
		DroneFacade d = new DroneFacade();
		NotificacaoDrone n = new NotificacaoDrone(this, d, this.dronesI.size());
		this.dronesI.add(n);
		return n.getId();

	}
	
	
}
