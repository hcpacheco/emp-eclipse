package emp.tornozeleira;

public class TornozeleiraFacade {
	private GPSTornozeleira gps;
	private NotificacaoTornozeleira notificacao;
	private ControleChoque choque;

	public TornozeleiraFacade() {
		super();
		this.setGps(new GPSTornozeleira(0.0, 0.0));
		this.setChoque(new ControleChoque(100, 50));
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

}
