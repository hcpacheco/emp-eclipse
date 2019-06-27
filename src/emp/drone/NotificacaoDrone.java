package emp.drone;

import java.util.ArrayList;
import java.util.List;

import emp.Mensagem;
import emp.controle.Notificacao;
import emp.persistencia.ZonaDeAtividade;

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
		String duracao = Integer.toString(drone.getDuracao());
		String mensagem = zona.concat(";").concat(status).concat(";").concat(carga).concat(";").concat(posx).concat(";").concat(posy).concat(";").concat(duracao);
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
	
	public void setZona(ZonaDeAtividade z) {
		this.drone.setZona(z);
	}

	public void configuraDrone(int idDrone, StatusDrone s, ZonaDeAtividade zona, int duracao) {
		if(this.drone.getStatus_() == StatusDrone.IDLE) {
			this.drone.setStatus(s);
			this.drone.setZona(zona);
			this.drone.setPatrulha(new Patrulha(zona.getLatitudes(), zona.getLongitudes(), duracao));
		}
		
	}

	public void alteraEstado(int idDrone) {
		if(this.drone.getStatus_() != StatusDrone.IDLE) {
			this.drone.alteraEstado();
		}
	}

	

}