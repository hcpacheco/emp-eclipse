package emp.drone;

import java.util.List;
import java.util.Random;

import emp.controle.Notificacao;
import emp.persistencia.Pessoa;
import emp.persistencia.ZonaDeAtividade;

public class DroneFacade {
	private StatusDrone status;
	private boolean disponivel;
	private BateriaDrone bateria;
	private Patrulha patrulha;
	private GPS gps;
	private ZonaDeAtividade zona;

	public DroneFacade() {
		super();
		this.setGps(new GPS(0.0, 0.0));
		this.setStatus(StatusDrone.IDLE);
		this.setDisponivel(true);
		this.setBateria(new BateriaDrone());
		this.setPatrulha(new Patrulha(null, null, 0));
		this.zona = new ZonaDeAtividade();
	}

	public GPS getGps() {
		return gps;
	}

	public void setGps(GPS gps) {
		this.gps = gps;
	}

	public Patrulha getPatrulha() {
		return patrulha;
	}

	public void setPatrulha(Patrulha patrulha) {
		this.patrulha = patrulha;
	}

	public String getStatus() {
		return status.name();
	}

	public StatusDrone getStatus_() {
		return status;
	}

	public void setStatus(StatusDrone status) {
		this.status = status;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public BateriaDrone getBateria() {
		return bateria;
	}

	public void setBateria(BateriaDrone bateria) {
		this.bateria = bateria;
	}

	public List<Pessoa> statusPatrulha() {
		return this.getPatrulha().getDetectados();

	}

	public boolean checarPatrulha() {
		return disponivel;
	}

	public int getCarga() {
		return this.bateria.getCarga();
	}

	public double getPosx() {
		return this.gps.getPosx();
	}

	public double getPosy() {
		return this.gps.getPosy();
	}

	public void setZona(ZonaDeAtividade z) {
		this.zona = z;
		
		//inicializa posicao de patrulha
		
		Double x = z.getLatitudes().get(0);
		Double y = z.getLongitudes().get(1);
		this.getGps().setPosx(x);
		this.getGps().setPosy(y);
	}

	public String getZona() {
		return this.zona.getNome();
	}

	public int getDuracao() {
		return this.getPatrulha().getDuracao();
	}

	public void alteraEstado() {
		if (this.getStatus_() == StatusDrone.PATRULHANDO && this.getDuracao() > 0 && this.getCarga() > 0) {
			int carga = this.getCarga();
			Random randomGenerator =  new Random();
			int randomInt = randomGenerator.nextInt(40) + 1;
			if (carga > randomInt) {
				int novaCarga = carga - randomInt;
				this.getBateria().setCarga(novaCarga);
				
				setNovaPosicao();
				
			} else {
				this.getBateria().setCarga(0);
				this.setStatus(StatusDrone.CARREGANDO);
						
			}
//			this.getBateria().setCarga(novaCarga);
			
			int d = this.getPatrulha().getDuracao();
			this.getPatrulha().setDuracao(d-1);

		} else if (this.getDuracao() >= 0 && this.getStatus_() == StatusDrone.CARREGANDO) {
			int carga = this.getCarga();
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(20) + 1;
			if (carga + randomInt > 100) {
				this.getBateria().setCarga(100);
				if (this.getDuracao() > 0) {
					this.setStatus(StatusDrone.PATRULHANDO);
					int d = this.getPatrulha().getDuracao();
					this.getPatrulha().setDuracao(d-1);
				} else {
					this.setStatus(StatusDrone.IDLE);
				}
			} else {
				this.getBateria().setCarga(carga + randomInt);
			}
			

		} 
		else if(this.getDuracao() == 0 && this.getStatus_() == StatusDrone.PATRULHANDO)
		{
			this.setStatus(StatusDrone.IDLE);
			this.voltaParaHQ();
		}

	}
	
	public void setDuracao(int d) {
		this.getPatrulha().setDuracao(d);
	}
	
	public void setNovaPosicao() {
		this.getGps().atualizaPosicao();
	}
	
	public void voltaParaHQ() {
		this.getGps().retornaHQ();
	}
}
