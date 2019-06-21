package emp.drone;

import java.util.List;

import emp.persistencia.Pessoa;

public class Camera {
	private boolean faceReconhecida;
    
    public boolean reconhecerFoto(String nome, List<Pessoa> pessoas) {
		for(int i = 0; i <= pessoas.size(); i++) {
    		if(pessoas.get(i).getNome() == nome) {
    			faceReconhecida = true;			
    		}
    		else 
    			faceReconhecida = false;	
		}
		return faceReconhecida;
    }
    
    public boolean DetectaObjetoPerigoso()
    {
    	
    }
    
}
