package emp.estacaocarregamento;

import java.util.concurrent.TimeUnit;

public class EstacaoCarregamento {
	private boolean disponivel;
	
	
	public boolean carregaDrone(int carga){
		//carrega bateria de drone ao passo de 20%bateria/segundo
		
		
		if(carga == 100)
		{
			return true;
		}
		
		//aguarda 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		//incrementa carga de bateria
		carga = min(carga + 20, 100);
		
		if(carga == 100)
		{
			return true;
		}
		else
		{
			return carregaDrone(carga);
		}
	}


	private int min(int a, int b) {
		if (a<b) return a;
		if (b<a) return b;
		return a;
	}

}
