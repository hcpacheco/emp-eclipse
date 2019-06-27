package emp.controle;

import emp.drone.StatusDrone;
import emp.persistencia.DAOEmp;
import emp.persistencia.Detento;
import emp.tornozeleira.StatusTornozeleira;

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
		this.b.setDetentos(d.getDetentos());
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
	
	public void criaNovoDrone() {
		this.b.criaNovoDrone();
	}
	
	public void criaNovaTornozeleira() {
		this.b.criaNovaTornozeleira();
	}
	
	public String getDrone(int id) {
		return this.b.getDrone(id);
	}
	
	public void alteraEstadoDrone(int id) {
		this.b.alteraEstadoDrone(id);
	}
	
	public String getTornozeleira(int id) {
		return this.b.getTornozeleira(id);
	}
	
	public void setZonaDrone(String nome, int idDrone) {
		this.b.setZonaDrone(nome, idDrone);
	}

	public void setDetentoTornozeleira(String cpf, int idTornozeleira) {
		this.b.setDetentoTornozeleira(cpf, idTornozeleira);
	}
	
	public void configurarDrone(int idDrone, StatusDrone s, String nomeZona, int duracao) {
		this.b.configuraDrone(idDrone,s,nomeZona,duracao);
	}

	public void configurarTornozeleira(int idTornozeleira, StatusTornozeleira s, Detento d, String cpfDetento) {
		this.b.configuraTornozeleira(idTornozeleira, s, d, cpfDetento);
		
	}

	public void setPosicaoProibidaTornozeleira(int idTornozeleira) {
		this.b.setPosicaoProibidaTornozeleira(idTornozeleira);		
	}
	
}
