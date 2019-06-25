package emp.controle;

import java.util.ArrayList;
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

	public void newZonaDePatulha(List<Double> latitudes, List<Double> longitudes) {
		int tamanhoLatitude = latitudes.size();
		int tamanhoLongitude = longitudes.size();

		// checa poligono formado por quatro pontos
		if (tamanhoLatitude == 4 && tamanhoLongitude == 4) {
			ZonaDePatrulha novaZona = new ZonaDePatrulha(latitudes, longitudes);
			this.zonas.add(novaZona);
		}
	}

	public ZonaDePatrulha getZonaPeloNome(String nome) {
		for(int i = 0; i < zonas.size(); i++) {
			if(zonas.get(i).getNome().equals(nome)) {
				return zonas.get(i);
			}
		}
		return null;
	}

	public void enviaMsg(int idDst, List<String> msg) {
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

	public void criaNovoDrone() {
		this.notificacao.criaNovoDrone();
	}

	public String getDrone(int id) {
		return this.notificacao.getDrone(id);
	}

	public void criaNovaTornozeleira() {
		this.notificacao.criaNovaTornozeleira();
	}

	public void setZona(String nome, int idDrone) {
		ZonaDePatrulha z = getZonaPeloNome(nome);
//		System.out.println(nome);
//		System.out.println("aqui");
//		System.out.println(z.getNome());
		this.notificacao.enviaZona(idDrone,z);
	}

}
