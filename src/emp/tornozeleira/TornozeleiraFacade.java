package emp.tornozeleira;

import emp.persistencia.Detento;
import emp.persistencia.ZonaDeAtividade;

public class TornozeleiraFacade {
	private GPSTornozeleira gps;
	private NotificacaoTornozeleira notificacao;
	private ControleChoque choque;
	private ZonaDeAtividade zona;
	private Detento	detento;
	private int carga;
	private StatusTornozeleira status;

	public TornozeleiraFacade() {
		super();
		this.setGps(new GPSTornozeleira(0.0, 0.0));
		this.setChoque(new ControleChoque(100, 50));
		this.setZona(new ZonaDeAtividade());
		this.setDetento(new Detento());
		this.setStatus(StatusTornozeleira.IDLE);
		
		int random = (int) (Math.random() * 40 + 1);
		this.setCarga(50 + random);
	}
	
	public void setCarga(int carga) {
		this.carga = carga;
	}

	public Detento getDetento() {
		return detento;
	}

	public void setDetento(Detento detento) {
		this.detento = detento;
	}

	public GPSTornozeleira getGps() {
		return gps;
	}

	public void setGps(GPSTornozeleira gps) {
		this.gps = gps;
	}

	public NotificacaoTornozeleira getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(NotificacaoTornozeleira notificacao) {
		this.notificacao = notificacao;
	}

	public ControleChoque getChoque() {
		return choque;
	}

	public void setChoque(ControleChoque choque) {
		this.choque = choque;
	}

	public ZonaDeAtividade getZona() {
		return zona;
	}

	public void setZona(ZonaDeAtividade zona) {
		this.zona = zona;
	}

	public StatusTornozeleira getStatus() {
		return this.status;
	}
	
	public void setStatus(StatusTornozeleira s) {
		this.status = s;
	}
	
	public int getCarga() {
		return this.carga;
	}
}
