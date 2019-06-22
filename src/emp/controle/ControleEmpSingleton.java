package emp.controle;

import java.util.List;

import emp.persistencia.DAOEmp;
import emp.persistencia.ZonaDePatrulha;

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
	
	public String teste() {
		return "oi";
	}

}
