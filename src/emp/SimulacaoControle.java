package emp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import emp.controle.ControleEmpSingleton;
import emp.persistencia.Civil;
import emp.persistencia.DAOEmp;
import emp.persistencia.Detento;
import emp.persistencia.ObjetoPerigoso;
import emp.persistencia.Policial;
import emp.persistencia.Sexo;
import emp.persistencia.ZonaDePatrulha;

public class SimulacaoControle {

	public static void main(String[] args) {
		// inicializacao de 'Banco de Dados'

		// ArraList e posicoes
		List<Float> posicoes = new ArrayList<Float>();
		posicoes.add(new Float(10.2));
		posicoes.add(new Float(1.1));
		posicoes.add(new Float(3.3));

		// Data de nascimento
		Date data1 = new Date();
		Date data2 = new Date();
		// Converte string para date
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String strdate = "02-04-2000 21:35:00";

		try {
			data1 = dateformat.parse(strdate);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String strdate2 = "10-08-1988 11:10:00";
		try {
			data2 = dateformat2.parse(strdate2);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// CIVIS
		// (String nome, Date d, Sexo s, String cpf, List<Float> posicoes, boolean
		// suspeito)
		// (List<Float> posicoes, boolean suspeito)
		Civil civil1 = new Civil("Maria", data1, Sexo.FEMININO, "1234", posicoes, false);
		Civil civil2 = new Civil("Joao", data2, Sexo.MASCULINO, "2345", posicoes, false);
		Civil civil3 = new Civil(posicoes, false);
		Civil civil4 = new Civil(posicoes, true);
		Civil civil5 = new Civil(posicoes, true);
		Civil civil6 = new Civil("Aline", data2, Sexo.FEMININO, "0012", posicoes, false);

		// POLICIAIS
		// (String nome, Date d, Sexo s, String cpf, String usuario, String senha, int
		// permissao)
		Policial policial1 = new Policial("Alberto", data1, Sexo.MASCULINO, "8260", "alberto", "senha", 0);
		Policial policial2 = new Policial("Elena", data2, Sexo.FEMININO, "9922", "elena", "policial", 1);

		// DETENTOS
		// (String nome, Date d, Sexo s, String cpf,List<Float> posicoes, int
		// atividadeCardiaca)
		Detento detento1 = new Detento("Juliana", data2, Sexo.FEMININO, "0101", posicoes, -1);
		Detento detento2 = new Detento("Zé", data1, Sexo.MASCULINO, "1010", posicoes, -1);

		// OBJETOS PERIGOSOS
		// (String nome, int tamanho)
		ObjetoPerigoso objeto1 = new ObjetoPerigoso("Faca", 17);
		ObjetoPerigoso objeto2 = new ObjetoPerigoso("Pistola", 21);
		ObjetoPerigoso objeto3 = new ObjetoPerigoso("Machado", 50);

		//ZONAS DE PATRULHA
		List<Float> latitudes1 = new ArrayList<Float>();
		latitudes1.add(new Float(10.2));
		latitudes1.add(new Float(1.1));
		latitudes1.add(new Float(3.3));
		latitudes1.add(new Float(4.25));
		
		List<Float> latitudes2 = new ArrayList<Float>();
		latitudes2.add(new Float(1.4));
		latitudes2.add(new Float(9.4));
		latitudes2.add(new Float(3.1));
		latitudes2.add(new Float(6.7));
		
		List<Float> longitudes1 = new ArrayList<Float>();
		longitudes1.add(new Float(10.2));
		longitudes1.add(new Float(1.1));
		longitudes1.add(new Float(3.3));
		longitudes1.add(new Float(4.25));
		
		List<Float> longitudes2 = new ArrayList<Float>();
		longitudes2.add(new Float(0.3));
		longitudes2.add(new Float(2.5));
		longitudes2.add(new Float(8.8));
		longitudes2.add(new Float(5.3));
		
		ZonaDePatrulha zona1 = new ZonaDePatrulha("Centro", latitudes1, longitudes1);
		ZonaDePatrulha zona2 = new ZonaDePatrulha("Agronomia", latitudes2,longitudes2);
		
		List<ZonaDePatrulha> listaz = new ArrayList<ZonaDePatrulha>();
		listaz.add(zona1);
		listaz.add(zona2);
		
		// Inicialização de listas de dados usados no objeto DAOEmp
		List<Civil> listac = new ArrayList<Civil>();
		listac.add(civil1);
		listac.add(civil2);
		listac.add(civil3);
		listac.add(civil4);
		listac.add(civil5);
		listac.add(civil6);

		List<Policial> listap = new ArrayList<Policial>();
		listap.add(policial1);
		listap.add(policial2);

		List<Detento> listad = new ArrayList<Detento>();
		listad.add(detento1);
		listad.add(detento2);

		List<ObjetoPerigoso> listao = new ArrayList<ObjetoPerigoso>();
		listao.add(objeto1);
		listao.add(objeto2);
		listao.add(objeto3);

		// Inicialização de banco de dados para simulação
		// (List<Policial> usuarios, List<Civil> civis, List<Detento> detentos,
		// List<ObjetoPerigoso> objetos)
		DAOEmp d = new DAOEmp(listap, listac, listad, listao, listaz);
		
		//Inicialização de ControleEmpSingleton db
		ControleEmpSingleton.getInstance().setDAO(d);
		
		LoginUI window = new LoginUI();
		window.open();
		
		
		}

}
