package emp.controle;

import emp.persistencia.DAOEmp;

public class ControleEmpSingleton {
	private Business b;
	private DAOEmp d;

	// Instancia singleton de ControleEmp
	private static final ControleEmpSingleton instance = new ControleEmpSingleton();

	// Construtor privado Singleton
	private ControleEmpSingleton() {
		// INICIALIZACAO DE BUSINESS
		// (Notificacao n, List<ZonaDePatrulha> z)
		this.b = new Business();
	}

	public void setDAO(DAOEmp d) {
		this.d = d;
		this.b.setZonas(d.getZonas());
		this.b.setUsuarios(d.getUsuarios());
	}

	public static ControleEmpSingleton getInstance() {
		return instance;
	}

	public boolean validarSenha(String usuario, String senha) {
		return b.validar(usuario, senha);
	}

	public DAOEmp getD() {
		return d;
	}

	public void setD(DAOEmp d) {
		this.d = d;
	}
	
	public void criaNovoDrone() {
		this.b.criaNovoDrone();
	}
	
	public void criaNovaTornozeleira() {
		this.b.criaNovaTornozeleira();
	}
	
	public String getDrone(int id) {
		return this.b.getDrone(id);
	}
	
	public void setZona(String nome, int idDrone) {
		this.b.setZona(nome, idDrone);
	}

}
