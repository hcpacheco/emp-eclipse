package emp.drone;

public class BateriaDrone {
	  private int carga;
	  private boolean alertaRecarga;
	  private int status;
	  private int NecessitaRecarga = 1;
	  private int DroneBomStatus = 2;
	  private int DroneCarregando = 3;
	  private int DroneCarregado = 4;
	  
	  public void setCarga(int carga) {
		  this.carga = carga;
	  }
	  
	  public int getCarga (int carga) {
		  return carga;
	  }
	  
	  public void verificaCarga(int carga) {
		  if (carga <= 20) 
		  {
			  status = NecessitaRecarga;  //Necessita de Recarga
		  	  solicitaRecarga(carga);
		  }
		  else
		  		status = DroneBomStatus ; // Drone com boa bateria
	  	}

	  public void solicitaRecarga(int carga) {
		  
		  status = DroneCarregando;
		  carga = 100;
			  
	  }

	  public int finalizaRecarga(int carga) {
		  
		  if(carga == 100)
		  status = DroneCarregado;
		  
		  return carga;
		  
	  }
}

