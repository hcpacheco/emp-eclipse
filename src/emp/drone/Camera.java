package emp.drone;

import java.util.List;

import emp.persistencia.ObjetoPerigoso;
import emp.persistencia.Pessoa;

public class Camera {

	public String reconhecerFoto(String nome, List<Pessoa> pessoas) {
		PessoaReconhecida pessoa = new PessoaReconhecida();
		return pessoa.getCpf();
	}

	public String reconhecerObjeto() {
		ObjetoReconhecido reconhecido = new ObjetoReconhecido();
		
		String tipoObjeto = defineTipoObjeto(reconhecido);

		return tipoObjeto;
	}

	public String defineTipoObjeto(ObjetoReconhecido reconhecido) {
		
		ObjetoPerigoso obj = new ObjetoPerigoso(reconhecido.getFormato(), reconhecido.getTamanho(), reconhecido.getMaterial());
		obj.define();
		
		return obj.getTipo();
	}
}