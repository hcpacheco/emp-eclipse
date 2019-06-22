package emp.controle;

import java.util.Arrays;
import java.util.List;

import emp.Mensagem;
import emp.drone.NotificacaoDrone;
import emp.tornozeleira.NotificacaoTornozeleira;

public class Notificacao implements Mensagem {
	private int id;
	List<Integer> idsDrones;
	List<Integer> idsTornozeleiras;	
	List<NotificacaoDrone> drones;
	List<NotificacaoTornozeleira> tornozeleiras;
	
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
			//envia mensagem para drone
			for (int i = 0; i < drones.size(); i++) {
				if (drones.get(i).getId() == idDst) {
					drones.get(i).recebeMsg(msg);
					return true;
				}
			}
		} else {
			//envia mensagem para tornozeleira
			for (int i = 0; i < tornozeleiras.size(); i++) {
				if (tornozeleiras.get(i).getId() == idDst) {
					tornozeleiras.get(i).recebeMsg(msg);
					return true;
				}
			}

		}

		return false;

	}

	private boolean isDrone(int id) {
		// TODO Auto-generated method stub
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
		this.setRx(null);
	}

}
