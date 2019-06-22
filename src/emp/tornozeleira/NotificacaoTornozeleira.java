package emp.tornozeleira;

import java.util.List;

import emp.Mensagem;

public class NotificacaoTornozeleira implements Mensagem{

	private List<String> rx;

	public void setRx(List<String> rx) {
		this.rx = rx;
	}

	public List<String> getRx() {
		return rx;
	}

	@Override
	public void enviaMsg(int idComunicador, List<String> msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> recebeMsg(String m) {
		this.rx.add(m);
		return this.getRx();
	}

}
