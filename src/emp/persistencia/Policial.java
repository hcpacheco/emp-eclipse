package emp.persistencia;

import java.util.Date;

public class Policial extends Pessoa {
	private String usuario;
	private String senha;
	private int permissao;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getPermissao() {
		return permissao;
	}

	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}

	public Policial(String nome, Date d, Sexo s, String cpf, String usuario, String senha, int permissao) {
		super(nome, d, s, cpf);
		this.setUsuario(usuario);
		this.setSenha(senha);
		this.setPermissao(permissao);
	}

}
