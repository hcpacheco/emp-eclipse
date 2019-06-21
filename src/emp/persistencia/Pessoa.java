package emp.persistencia;

import java.util.Date;

import emp.persistencia.Sexo;

public class Pessoa {
	private String nome;
	private Date dtnascimento;
	private Sexo sexo;
	private String cpf;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Sexo getSexo() 
	{
		return this.sexo;
	}

	public void setSexo(Sexo sexo) 
	{
		this.sexo = sexo;
	}

	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		//checa se primeiro caracter nao eh letra
		if(!(Character.isLetter(nome.charAt(0))))
		{
			System.out.println("Exceção ao setar nome");
		}
		else
		{
			this.nome = nome;	
		}
	}
	
	public Date getDtnascimento() 
	{
		return dtnascimento;
	}
	
	public void setDtnascimento(Date dtnascimento)
	{
		Date today = new Date();
		//checa se data de nascimento eh uma data posterior ao dia atual
		if(today.after(dtnascimento))
		{
			this.dtnascimento = dtnascimento;			
		}
		else
		{
			System.out.println("Exceção ao setar data de nascimento");
		}
	}
	
	//construtor default
	public Pessoa() 
	{
		this.nome = "NOME INDEFINIDO";
		this.sexo = Sexo.INDEFINIDO;
		this.dtnascimento = new Date();
		this.cpf = "XXXX";
	}
	
	//construtor alternativo
	public Pessoa(String n, Date d, Sexo s, String c)
	{
		this.setNome(n);
		this.setDtnascimento(d);
		this.setSexo(s);
		this.setCpf(c);
	}
}
