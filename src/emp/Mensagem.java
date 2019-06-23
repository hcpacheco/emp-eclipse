package emp;

import java.util.List;

public interface Mensagem {
	public boolean enviaMsg(int idDst, List<String> msg);

	public void recebeMsg( List<String> m);
}
