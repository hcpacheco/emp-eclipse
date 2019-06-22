package emp.drone;

import java.util.List;

import emp.persistencia.Pessoa;

public class Camera {
	
	

    
    public String reconhecerFoto(String nome, List<Pessoa> pessoas) {
    	PessoaReconhecida pessoa = new PessoaReconhecida();
		return pessoa.getCpf();
    }
   
    public ObjetoReconhecido reconhecerObjeto() {
    	ObjetoReconhecido o = new ObjetoReconhecido();
    	return o;
    }
}