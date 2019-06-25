package emp.controle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import emp.Mensagem;
import emp.drone.DroneFacade;
import emp.drone.NotificacaoDrone;
import emp.persistencia.ZonaDePatrulha;
import emp.tornozeleira.NotificacaoTornozeleira;
import emp.tornozeleira.TornozeleiraFacade;

public class Notificacao implements Mensagem {
	private int id;
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
	public boolean enviaMsg(int idDst, List<String> msg) {
		if (msg.get(0).equals("drone")) {
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

	public String getDrone(int id) {
		for (int i = 0; i < dronesI.size(); i++) {
			if (dronesI.get(i).getId() == id) {
				dronesI.get(i).getDrone();
				List<String> mensagem = this.getRx();

				// verifica se mensagem vem do drone
				if (mensagem.get(0).equals("drone")) {
					return mensagem.get(1);
				}
			}
		}
		return null;
	}

	public void setDrones(List<NotificacaoDrone> drones) {
		this.dronesI = drones;
	}

	public void setTornozeleiras(List<NotificacaoTornozeleira> tornozeleiras) {
		this.tornozeleirasI = tornozeleiras;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public void recebeMsg(List<String> msg) {
		this.setRx(msg);
	}

	public Notificacao() {
		super();
		this.setId(-1);
		this.setRx(null);
		this.setDrones(new ArrayList<NotificacaoDrone>());
		this.setTornozeleiras(new ArrayList<NotificacaoTornozeleira>());
	}

	public void criaNovaTornozeleira() {
		NotificacaoTornozeleira n = new NotificacaoTornozeleira(this, this.tornozeleirasI.size());
		this.tornozeleirasI.add(n);
	}

	public void criaNovoDrone() {
		NotificacaoDrone n = new NotificacaoDrone(this, this.dronesI.size());
		this.dronesI.add(n);

	}

//	public void enviaZona(int idDrone, ZonaDePatrulha z) {
//		List<String> mensagem = new ArrayList<String>();
//		mensagem.set(0, "drone");
//		
//		String header = "1,";
//		String boundaries = z.latToString().concat(z.longToString());
//		mensagem.set(1, header.concat(boundaries));
//		
//		enviaMsg(idDrone,mensagem);
//	}
	public void enviaZona(int idDrone, ZonaDePatrulha z) {
//		List<String> mensagem = new ArrayList<String>();
//		mensagem.set(0, "drone");
//		mensagem.set(1, )
		for (int i = 0; i < dronesI.size(); i++) {
			if (dronesI.get(i).getId() == idDrone) {
				dronesI.get(i).setZona(z);
			}
		}
	}

}
