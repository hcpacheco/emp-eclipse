package emp.drone;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PessoaReconhecida {
	private String cpf;
	
	PessoaReconhecida(){
		super();
		
		List<String> pessoas = Arrays.asList("8260", "9922", "0101", "1010", "1234", "2345", "0012", "1111", "2222", "3333", "1230", "XXXX");
		
		Random rand = new Random();
		
		String cpf = pessoas.get(rand.nextInt(pessoas.size()));
		
		this.setCpf(cpf);

	}

	private void setCpf(String cpf) {
		this.cpf = cpf;
		
	}

	public String getCpf() {
		return cpf;
	}

}
