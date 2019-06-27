package emp;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ibm.icu.math.BigDecimal;

import emp.controle.ControleEmpSingleton;
import emp.simulacao.SimulacaoControle;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.widgets.FormToolkit;

import java.math.RoundingMode;
import java.util.concurrent.TimeUnit;

import javax.swing.JTable;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class DroneUI {

	protected Shell shell;
	private Text text;
	private Label lblNewLabel_1;
	private Label lblPosioXxxxxx;
	private Label lblStatusAtualXxxxx;
	private Label lblNvelDeBateria;
	private EmpUI emp;
	private Label lblDuracaoPatrulha;
	private Button btnRadioButton;
	private Spinner spinner;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		try {
			DroneUI window = new DroneUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		this.emp = emp;
		Display display = Display.getDefault();
		createContents(0);
		shell.open();
		shell.layout(true);
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents(int idDrone) {
		shell = new Shell();
		shell.addShellListener(new ShellAdapter() {
		});
		
//		System.out.println(idDrone);
		String mensagem = ControleEmpSingleton.getInstance().getDrone((idDrone));
		String[] mensagemArray = mensagem.split(";", -1);
		String zona = mensagemArray[0];
		String status = mensagemArray[1];
		String carga = mensagemArray[2];
		String posx = mensagemArray[3];
		String posy = mensagemArray[4];
		String duracao = mensagemArray[5];
		
		shell.setSize(420, 400);
		shell.setText("Drone");
		shell.setLayout(null);

		Label lblDroneSimulador = new Label(shell, SWT.NONE);
		lblDroneSimulador.setText("Simulador de Drone");
		lblDroneSimulador.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblDroneSimulador.setBounds(140, 11, 129, 15);

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String nome = text.getText();
				boolean suspeito = btnRadioButton.getSelection();
				int idDrone = spinner.getSelection();
				
				SimulacaoControle.printNotificacaoDrone(idDrone, nome, suspeito);
			}
		});
		btnNewButton.setBounds(124, 121, 153, 25);
		btnNewButton.setText("Detectar");

		Label label = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(0, 49, 414, 2);

		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(0, 202, 414, -24);

		text = new Text(shell, SWT.BORDER);
		text.setBounds(84, 57, 232, 21);

		Label lblNome = new Label(shell, SWT.NONE);
		lblNome.setBounds(23, 60, 55, 15);
		lblNome.setText("Nome :");

		btnRadioButton = new Button(shell, SWT.RADIO);
		btnRadioButton.setBounds(159, 84, 71, 16);
		btnRadioButton.setText("Suspeito");

		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(0, 162, 414, 2);

		spinner = new Spinner(shell, SWT.BORDER);
		spinner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
//				createContents(spinner.getSelection());
				String mensagem = ControleEmpSingleton.getInstance().getDrone(spinner.getSelection());
				String[] mensagemArray = mensagem.split(";", -1);
				String zona = mensagemArray[0];
				String status = mensagemArray[1];
				String carga = mensagemArray[2];
				String posx = mensagemArray[3];
				String posy = mensagemArray[4];
				String duracao = mensagemArray[5];
				printDrone(zona, posx, posy, status, carga, duracao);
				
//				System.out.println("teste");
//				lblPosioXxxxxx.setText("o");
				
//				lblNewLabel_1.setText("oi");
//				lblNewLabel_1.getParent().layout();
//				createContents(spinner.getSelection());
			}
		});
		
		spinner.setMaximum(5);
		spinner.setBounds(331, 10, 47, 22);

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(300, 13, 26, 15);
		lblNewLabel.setText("ID :");

		lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(84, 185, 136, 15);
		lblNewLabel_1.setText("Zona Atual : XXXXXXX");

		lblPosioXxxxxx = new Label(shell, SWT.NONE);
		lblPosioXxxxxx.setText("Posi\u00E7\u00E3o Atual : XXX.XXX , XXX.XXX");
		lblPosioXxxxxx.setBounds(84, 208, 206, 15);

		lblStatusAtualXxxxx = new Label(shell, SWT.NONE);
		lblStatusAtualXxxxx.setText("Status : XXXXX");
		lblStatusAtualXxxxx.setBounds(84, 229, 251, 15);

		lblNvelDeBateria = new Label(shell, SWT.NONE);
		lblNvelDeBateria.setText("Carga da bateria : XX%");
		lblNvelDeBateria.setBounds(84, 250, 193, 15);
		
		Button btnSimular = new Button(shell, SWT.NONE);
		btnSimular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String mensagem = ControleEmpSingleton.getInstance().getDrone(spinner.getSelection());
				String[] mensagemArray = mensagem.split(";", -1);
				String zona = mensagemArray[0];
				String status = mensagemArray[1];
				String carga = mensagemArray[2];
				String posx = mensagemArray[3];
				String posy = mensagemArray[4];
				String duracao = mensagemArray[5];
				
				int d = Integer.parseInt(duracao);
				
				simulaEstadoDrone(d);

				
				
			}
		});
		btnSimular.setText("Simular");
		btnSimular.setBounds(124, 326, 153, 25);
		
		lblDuracaoPatrulha = new Label(shell, SWT.NONE);
		lblDuracaoPatrulha.setText("Tempo restante: Xh");
		lblDuracaoPatrulha.setBounds(84, 271, 193, 15);
		
		printDrone(zona, posx, posy, status, carga, duracao);



	}
	
	
	public void printDrone(String zona, String posx, String posy, String status, String carga, String duracao ) {

		posx = truncaXY(posx);
		posy = truncaXY(posy);
		lblNewLabel_1.setText("Zona Atual : ".concat(zona));
		lblPosioXxxxxx.setText("Posi\u00E7\u00E3o Atual : ".concat(posx).concat(" , ").concat(posy));
		lblStatusAtualXxxxx.setText("Status : ".concat(status));
		lblNvelDeBateria.setText("Carga da bateria : ".concat(carga).concat("%"));
		lblDuracaoPatrulha.setText("Tempo restante: ".concat(duracao).concat("h"));
	}
	
	public void simulaEstadoDrone(int d) {
		int it = d;
		String status = "";
		while (!(status.equals("IDLE")))
		{
			//wait
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			ControleEmpSingleton.getInstance().alteraEstadoDrone(spinner.getSelection());
			String mensagem = ControleEmpSingleton.getInstance().getDrone(spinner.getSelection());
			String[] mensagemArray = mensagem.split(";", -1);
			String zona = mensagemArray[0];
			status = mensagemArray[1];
			String carga = mensagemArray[2];
			String posx = mensagemArray[3];
			String posy = mensagemArray[4];
			String duracao = mensagemArray[5];
			printDrone(zona, posx, posy, status, carga, duracao);
			
			it = Integer.parseInt(duracao);
		}
		
	}
	
	public String truncaXY(String pos) {
		if (pos.length() > 4)
		{
		    pos = pos.substring(0, 4);
		}
		return pos;
	}
	
	
}
