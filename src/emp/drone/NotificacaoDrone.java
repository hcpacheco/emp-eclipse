package emp.drone;

import java.util.List;

import emp.Mensagem;
import emp.controle.Notificacao;

public class NotificacaoDrone implements Mensagem{
	private int id;
	private Notificacao controle;
	
    private boolean notificacaoDrone;
    private String tipoNotificacao;
	private String material;
	private float tamanho;
	private String formato;
	
	private List<String> rx;

	public void setRx(List<String> rx) {
		this.rx = rx;
	}

	public List<String> getRx() {
		return rx;
	}

	@Override
	public boolean enviaMsg(int idDst, String msg) {
		if(this.controle.getId() == idDst)
		{
			this.controle.recebeMsg(msg);
			return true;
		}		
		return false;
	}

	@Override
	public List<String> recebeMsg(String m) {
		this.rx.add(m);
		return this.getRx();
	}
	
	public int getId() {
		return id;
	}
    
   

}