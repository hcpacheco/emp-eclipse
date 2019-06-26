package emp.controle;

import java.util.ArrayList;
import java.util.List;

import emp.drone.StatusDrone;
import emp.persistencia.Detento;
import emp.persistencia.Policial;
import emp.persistencia.ZonaDeAtividade;

public class Business {

	private Notificacao notificacao;
	private List<ZonaDeAtividade> zonas;
	private List<Policial> usuarios;
	private List<Detento> detentos;

	public Business() {
		super();
		this.notificacao = new Notificacao();
		this.setZonas(null);
		this.setUsuarios(null);
		this.setDetentos(null);
	}

	public void setUsuarios(List<Policial> usuarios) {
		this.usuarios = usuarios;
	}

	public void setZonas(List<ZonaDeAtividade> zonas) {
		this.zonas = zonas;
	}
	
	public void setDetentos(List<Detento> detentos) {
		this.detentos = detentos;
	}

	public void newZonaDePatulha(List<Double> latitudes, List<Double> longitudes) {
		int tamanhoLatitude = latitudes.size();
		int tamanhoLongitude = longitudes.size();

		// checa poligono formado por quatro pontos
		if (tamanhoLatitude == 4 && tamanhoLongitude == 4) {
			ZonaDeAtividade novaZona = new ZonaDeAtividade(latitudes, longitudes);
			this.zonas.add(novaZona);
		}
	}

	public ZonaDeAtividade getZonaPeloNome(String nome) {
		for(int i = 0; i < zonas.size(); i++) {
			if(zonas.get(i).getNome().equals(nome)) {
				return zonas.get(i);
			}
		}
		return null;
	}
	
	public Detento getDetentoPeloCpf(String cpf) {
		
		for(int i = 0; i < detentos.size(); i++) {
			if(detentos.get(i).getCpf().equals(cpf)) {
				return detentos.get(i);
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
	
	public String getTornozeleira(int id) {
		return this.notificacao.getTornozeleira(id);
	}

	public void criaNovaTornozeleira() {
		this.notificacao.criaNovaTornozeleira();
	}

	public void setZonaDrone(String nome, int idDrone) {
		ZonaDeAtividade z = getZonaPeloNome(nome);
		this.notificacao.enviaZona(idDrone,z);
	}
	
	public void setDetentoTornozeleira(String cpf, int idTornozeleira) {
		Detento d = getDetentoPeloCpf(cpf);
		this.notificacao.setDetentoTornozeleira(d, idTornozeleira);
	}

	public void configuraDrone(int idDrone, StatusDrone s, String nomeZona, int duracao) {
		ZonaDeAtividade z = getZonaPeloNome(nomeZona);
		this.notificacao.setConfiguracaoDrone(idDrone, s, z, duracao);
		
	}
	
	

}
