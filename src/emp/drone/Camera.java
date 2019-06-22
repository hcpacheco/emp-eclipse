package emp.drone;

import java.util.List;

import emp.persistencia.Pessoa;

public class Camera {
	
	

    
    public String reconhecerFoto(String nome, List<Pessoa> pessoas) {
    	PessoaReconhecida pessoa = new PessoaReconhecida();
		return pessoa.getCpf();
		
//		for(int i = 0; i <= pessoas.size(); i++) {
//    		if(pessoas.get(i).getNome() == pessoa.getNome()) {
//    			return true;			
//    		}		
//		}
		
    }
   
    public ObjetoReconhecido reconhecerObjeto() {
    	ObjetoReconhecido o = new ObjetoReconhecido();
    	return o;
    }
}