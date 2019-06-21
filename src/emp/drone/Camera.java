<<<<<<< HEAD
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
}
=======
package emp.drone;

import java.util.List;

import emp.persistencia.Civil;
import emp.persistencia.Detento;

public class Camera {
	
	private boolean FaceReconhecida;
	
	public boolean reconhecerFace (List<Civil> civis, List<Detento> detentos, String nomeParaReconhecer)

	{
		for(int i=0; i <= civis.size();i++)
			if(civis.get(i).getNome() == nomeParaReconhecer)
				FaceReconhecida = true;
			else
				FaceReconhecida = false;
		
		for (int j=0; j <= detentos.size();j++)
			if(detentos.get(j).getNome() == nomeParaReconhecer)
				FaceReconhecida = true;
			else
				FaceReconhecida = false;
		
		return FaceReconhecida;
		
	}
}
>>>>>>> 839b334702f0f41e1f198be3367a59c7638d643a
