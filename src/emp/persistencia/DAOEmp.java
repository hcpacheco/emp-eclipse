package emp.persistencia;

import java.util.List;

public class DAOEmp {
	private List<Policial> usuarios;
	private List<Civil> civis;
	private List<Detento> detentos;
	private List<ObjetoPerigoso> objetos;
	private List<ZonaDeAtividade> zonas;

	public List<ZonaDeAtividade> getZonas() {
		return zonas;
	}

	public void setZonas(List<ZonaDeAtividade> zonas) {
		this.zonas = zonas;
	}

	public void setUsuarios(List<Policial> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Policial> getUsuarios() {
		return usuarios;
	}

	public Policial getPolicial(String cpf) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getCpf().equals(cpf)) {
				return usuarios.get(i);
			}
		}
		return null;
	}

	public Detento getDetento(String cpf) {
		for (int i = 0; i < detentos.size(); i++) {
			if (detentos.get(i).getCpf().equals(cpf)) {
				return detentos.get(i);
			}
		}
		return null;
	}

	public Civil getCivil(String cpf) {
		for (int i = 0; i < civis.size(); i++) {
			if (civis.get(i).getCpf().equals(cpf)) {
				return civis.get(i);
			}
		}
		return null;
	}

	public List<Civil> getCivis() {
		return civis;
	}

	public void setCivis(List<Civil> civis) {
		this.civis = civis;
	}

	public List<Detento> getDetentos() {
		return detentos;
	}

	public void setDetentos(List<Detento> detentos) {
		this.detentos = detentos;
	}

	public List<ObjetoPerigoso> getObjetos() {
		return objetos;
	}

	public void setObjetos(List<ObjetoPerigoso> objetos) {
		this.objetos = objetos;
	}

	public DAOEmp(List<Policial> usuarios, List<Civil> civis, List<Detento> detentos, List<ObjetoPerigoso> objetos,
			List<ZonaDeAtividade> zonas) {
		super();
		this.setUsuarios(usuarios);
		this.setCivis(civis);
		this.setDetentos(detentos);
		this.setObjetos(objetos);
		this.setZonas(zonas);
	}

}
