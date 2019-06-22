package emp;

import java.util.List;

public interface Mensagem {
	public boolean enviaMsg(int idDst,String msg);
	public List<String> recebeMsg(String m);
}
