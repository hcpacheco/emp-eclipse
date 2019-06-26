package emp.simulacao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.widgets.Display;

import emp.LoginUI;
import emp.controle.ControleEmpSingleton;
import emp.persistencia.Civil;
import emp.persistencia.DAOEmp;
import emp.persistencia.Detento;
import emp.persistencia.ObjetoPerigoso;
import emp.persistencia.Policial;
import emp.persistencia.Sexo;
import emp.persistencia.ZonaDeAtividade;

public class SimulacaoControle{

	public static void main(String[] args) {
		// inicializacao de 'Banco de Dados'

		// ArraList e posicoes
		List<Double> posicoes = new ArrayList<Double>();
		posicoes.add(new Double(10.2));
		posicoes.add(new Double(1.1));
		posicoes.add(new Double(3.3));

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
		Detento detento3 = new Detento("Leonardo", data1, Sexo.MASCULINO, "8765", posicoes, -1);

		// OBJETOS PERIGOSOS
		// (String nome, int tamanho, String material)
		ObjetoPerigoso objeto1 = new ObjetoPerigoso("Faca", 17, "elipsoidal");
		ObjetoPerigoso objeto2 = new ObjetoPerigoso("Pistola", 21, "cuboide");
		ObjetoPerigoso objeto3 = new ObjetoPerigoso("Machado", 50, "torus");

		//ZONAS DE PATRULHA
		List<Double> latitudes1 = new ArrayList<Double>();
		latitudes1.add(new Double(10.2));
		latitudes1.add(new Double(1.1));
		latitudes1.add(new Double(3.3));
		latitudes1.add(new Double(4.25));
		
		List<Double> latitudes2 = new ArrayList<Double>();
		latitudes2.add(new Double(1.4));
		latitudes2.add(new Double(9.4));
		latitudes2.add(new Double(3.1));
		latitudes2.add(new Double(6.7));
		
		List<Double> longitudes1 = new ArrayList<Double>();
		longitudes1.add(new Double(10.2));
		longitudes1.add(new Double(1.1));
		longitudes1.add(new Double(3.3));
		longitudes1.add(new Double(4.25));
		
		List<Double> longitudes2 = new ArrayList<Double>();
		longitudes2.add(new Double(0.3));
		longitudes2.add(new Double(2.5));
		longitudes2.add(new Double(8.8));
		longitudes2.add(new Double(5.3));
		
		ZonaDeAtividade zona1 = new ZonaDeAtividade("Centro", latitudes1, longitudes1);
		ZonaDeAtividade zona2 = new ZonaDeAtividade("Agronomia", latitudes2,longitudes2);
		ZonaDeAtividade zona3 = new ZonaDeAtividade("Ipanema", latitudes1,longitudes2);
		ZonaDeAtividade zona4 = new ZonaDeAtividade("Navegantes", latitudes2,longitudes1);
		
		List<ZonaDeAtividade> listaz = new ArrayList<ZonaDeAtividade>();
		listaz.add(zona1);
		listaz.add(zona2);
		listaz.add(zona3);
		listaz.add(zona4);
		
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
		listad.add(detento3);

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
		
		ControleEmpSingleton.getInstance().criaNovoDrone();
		ControleEmpSingleton.getInstance().criaNovoDrone();
		ControleEmpSingleton.getInstance().criaNovoDrone();
		ControleEmpSingleton.getInstance().criaNovoDrone();
		ControleEmpSingleton.getInstance().criaNovoDrone();
		ControleEmpSingleton.getInstance().criaNovoDrone();
		
		ControleEmpSingleton.getInstance().setZonaDrone("Agronomia", 0);
		ControleEmpSingleton.getInstance().setZonaDrone("Centro", 1);
		ControleEmpSingleton.getInstance().setZonaDrone("Ipanema", 2);
		ControleEmpSingleton.getInstance().setZonaDrone("Agronomia", 3);
		ControleEmpSingleton.getInstance().setZonaDrone("Navegantes", 4);
		ControleEmpSingleton.getInstance().setZonaDrone("Centro", 5);
		
		ControleEmpSingleton.getInstance().criaNovaTornozeleira();
		ControleEmpSingleton.getInstance().criaNovaTornozeleira();
		ControleEmpSingleton.getInstance().criaNovaTornozeleira();
		
		ControleEmpSingleton.getInstance().setDetentoTornozeleira("0101", 0);
		ControleEmpSingleton.getInstance().setDetentoTornozeleira("1010", 1);
		ControleEmpSingleton.getInstance().setDetentoTornozeleira("8765", 2);

		
		ControleEmpSingleton.getInstance().getTornozeleira(0);
		ControleEmpSingleton.getInstance().getTornozeleira(1);
		ControleEmpSingleton.getInstance().getTornozeleira(2);

//		System.out.println(ControleEmpSingleton.getInstance().getDrone(0));
//		System.out.println(ControleEmpSingleton.getInstance().getDrone(1));
//		System.out.println(ControleEmpSingleton.getInstance().getDrone(2));

		
		LoginUI window = new LoginUI();
		window.open();
		
	} 

}
