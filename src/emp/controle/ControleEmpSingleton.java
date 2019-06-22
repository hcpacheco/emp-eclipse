package emp.controle;

import java.util.List;

import emp.persistencia.DAOEmp;
import emp.persistencia.ZonaDePatrulha;

public class ControleEmpSingleton {
	private Business b;// = new Business();
	private DAOEmp d;// = new DAOEmp()

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
	}

	public static ControleEmpSingleton getInstance() {
		return instance;
	}

	public boolean validarSenha(String usuario, String senha) {
		boolean correto = b.validar(usuario, senha);
		if (correto) {
			return true;
		} else {
			return false;
		}
	}

}
