package emp.drone;

import java.util.ArrayList;
import java.util.List;

import emp.Mensagem;
import emp.controle.Notificacao;
import emp.persistencia.ZonaDePatrulha;

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

	public void getDrone() {
		String zona = drone.getZona();
		String carga = Integer.toString(drone.getCarga());
		String status = drone.getStatus();
		String posx = Double.toString(drone.getPosx());
		String posy = Double.toString(drone.getPosy());
		String mensagem = zona.concat(";").concat(status).concat(";").concat(carga).concat(";").concat(posx).concat(";").concat(posy);
		System.out.println(mensagem);
//		return drone.getCarga();
		List<String> tx = new ArrayList<>();
		tx.add("drone");
		tx.add(mensagem);
		this.enviaMsg(-1, tx);
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
	
	public void setZona(ZonaDePatrulha z) {
		this.drone.setZona(z);
	}
	

}