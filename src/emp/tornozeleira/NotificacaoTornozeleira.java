package emp.tornozeleira;

import java.util.ArrayList;
import java.util.List;

import emp.Mensagem;
import emp.controle.Notificacao;
import emp.persistencia.Detento;

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
	public boolean enviaMsg(int idDst, List<String> msg) {
		if (this.controle.getId() == idDst) {
			controle.recebeMsg(msg);
			return true;
		}
		return false;

	}

	@Override
	public void recebeMsg(List<String> msg) {
		this.setRx(msg);
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
	
	public void getTornozeleira() {
		String det = tornozeleira.getDetento().getNome();
		String carga = Integer.toString(tornozeleira.getCarga());
		String posx = Double.toString(tornozeleira.getGps().getPosx());
		String posy = Double.toString(tornozeleira.getGps().getPosy());
		String bpm = Integer.toString(tornozeleira.getChoque().getAtividadeCardiaca());
		String potencia = Integer.toString(tornozeleira.getChoque().getPotenciaChoque());
		
		String mensagem = det.concat(";").concat(carga).concat(";").concat(posx).concat(";").concat(posy).concat(";").concat(bpm).concat(";").concat(potencia);
		List<String> tx = new ArrayList<>();
		tx.add("tornozeleira");
		tx.add(mensagem);
		this.enviaMsg(-1, tx);
//		System.out.println(mensagem);
	}
	
	public void setDetento(Detento d) {
		this.tornozeleira.setDetento(d);
	}

	public void configuraTornozeleira(StatusTornozeleira s, Detento d) {
		if(this.tornozeleira.getStatus() == StatusTornozeleira.IDLE) {
			this.tornozeleira.setStatus(s);
			this.tornozeleira.setDetento(d);
		}
		
	}
}
