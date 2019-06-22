package emp;

import java.util.List;

public interface Mensagem {
	public void enviaMsg(int idComunicador,List<String> msg);
	public List<String> recebeMsg(String m);
}
