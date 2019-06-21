package emp.drone;

import emp.controle.string;

public class NotificacaoDrone {
    private boolean notificacaoDrone;
    private String tipoNotificacao;
	private String material;
	private float tamanho;
	private String formato;
	

    public boolean enviarNotificacao(int d) 
    {
		return notificacaoDrone;
    }
    
    public void SuspeitaObjetoPerigoso(String material,Float tamanho, String formato){
    	this.material = material;
    	this.tamanho = tamanho;
    	this.formato = formato;
    	
    }
    
   

}