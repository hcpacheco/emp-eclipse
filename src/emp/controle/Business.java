package emp.controle;

import java.util.List;

import emp.persistencia.Policial;
import emp.persistencia.ZonaDePatrulha;

public class Business {

	private Notificacao notificacao;
	private List<ZonaDePatrulha> zonas;
	private List<Policial> usuarios;

	public Business() {
		super();
		this.notificacao = new Notificacao();
		this.setZonas(null);
		this.setUsuarios(null);
	}

	public void setUsuarios(List<Policial> usuarios) {
		this.usuarios = usuarios;
	}

	public void setZonas(List<ZonaDePatrulha> zonas) {
		this.zonas = zonas;
	}

	public void newZonaDePatulha(List<Float> latitudes, List<Float> longitudes) {
		int tamanhoLatitude = latitudes.size();
		int tamanhoLongitude = longitudes.size();

		// checa poligono formado por quatro pontos
		if (tamanhoLatitude == 4 && tamanhoLongitude == 4) {
			ZonaDePatrulha novaZona = new ZonaDePatrulha(latitudes, longitudes);
			this.zonas.add(novaZona);
		}
	}

	public void enviaMsg(int idDst, String msg) {
		notificacao.enviaMsg(idDst, msg);
	}

	public boolean validar(String usuario, String senha) {
		
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getUsuario().equals(usuario)) {
				if (usuarios.get(i).getSenha().equals(senha)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

}
