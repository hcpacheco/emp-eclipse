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
