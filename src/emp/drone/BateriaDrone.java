package emp.drone;

import java.util.concurrent.TimeUnit;

import emp.estacaocarregamento.EstacaoCarregamento;

public class BateriaDrone {
	  private int carga;
	  private boolean alertaRecarga;
	  private StatusBateria status;
	  
	  public void setCarga(int carga) {
		  this.carga = carga;
	  }
	  
	  public int getCarga (int carga) {
		  return carga;
	  }
	  
	  public void verificaCarga(int carga) {
		  if (this.carga <= 20) 
		  {
			  this.setStatus(StatusBateria.EMERGENCIA);;  //Necessita de Recarga
		  }
		  else
		  {
			  this.setStatus(StatusBateria.SUFICIENTE); // Drone com boa bateria
		  }
		  		
	  	}

	  public boolean solicitaRecarga(int carga, EstacaoCarregamento e) {
		  
		  this.setStatus(StatusBateria.CARREGANDO);
		  
		  boolean r = e.carregaDrone(this.carga);
		  
		  if(r)
		  {
			  //carregamento concluido
			  this.setStatus(StatusBateria.CARREGADO);
			  return true;
		  }
		  else
		  {
			  //erro ao carregar bateria
			  this.setStatus(StatusBateria.EMERGENCIA);
			  return false;
		  }   
	  }

	  public StatusBateria getStatus() {
		return status;
	}

	public void setStatus(StatusBateria status) {
		this.status = status;
	}


}

