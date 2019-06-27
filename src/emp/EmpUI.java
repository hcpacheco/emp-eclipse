package emp;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import emp.controle.ControleEmpSingleton;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class EmpUI {

	protected Shell shell;
	private Label label_5;
	private Label label_2;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			EmpUI window = new EmpUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(430, 430);
		shell.setText("EMP Controle");
		
		Label label = new Label(shell, SWT.CENTER);
		label.setAlignment(SWT.CENTER);
		label.setText("Drones");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		label.setBounds(171, 72, 58, 15);
		
		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(0, 72, 414, 2);
		
		label_2 = new Label(shell, SWT.BORDER | SWT.WRAP);
		label_2.setText("Notifica\u00E7\u00E3o: Suspeito identificado (Zona central)");
		label_2.setAlignment(SWT.CENTER);
		label_2.setBounds(10, 101, 394, 25);
		
		Button btnConfigurarDrone = new Button(shell, SWT.NONE);
		btnConfigurarDrone.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ConfigurarDroneUI window = new ConfigurarDroneUI();
				window.open();
			}
		});
		btnConfigurarDrone.setText("Configurar Drones");
		btnConfigurarDrone.setBounds(10, 140, 133, 25);
		
		Button btnVerificarPatrulhas = new Button(shell, SWT.NONE);
		btnVerificarPatrulhas.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnVerificarPatrulhas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				DroneUI window = new DroneUI();
				window.open();
			}
		});

		btnVerificarPatrulhas.setText("Verificar Drones");
		btnVerificarPatrulhas.setBounds(271, 140, 133, 25);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("Tornozeleiras");
		label_3.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		label_3.setBounds(160, 218, 99, 15);
		
		Label label_4 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_4.setBounds(0, 218, 414, 2);
		
		label_5 = new Label(shell, SWT.BORDER | SWT.WRAP);
		label_5.setText("Notifica\u00E7\u00E3o: Tornozeleira 0187 detectou atividade at\u00EDpica (Jo\u00E3o da Silva)");
		label_5.setAlignment(SWT.CENTER);
		label_5.setBounds(10, 247, 394, 25);
		
		Button btnConfigurarTornozeleira = new Button(shell, SWT.NONE);
		btnConfigurarTornozeleira.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				ConfigurarTornozeleiraUI window = new ConfigurarTornozeleiraUI();
				window.open();
			}
		});
		btnConfigurarTornozeleira.setText("Configurar Tornozeleira");
		btnConfigurarTornozeleira.setBounds(10, 291, 133, 25);
		
		Button button_5 = new Button(shell, SWT.NONE);
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				TornozeleiraUI window = new TornozeleiraUI();
				window.open();
			}
		});
		button_5.setText("Verificar Tornozeleiras");
		button_5.setBounds(271, 291, 133, 25);
		
		Label lblEcossistemaDeMonitoramento = new Label(shell, SWT.SHADOW_IN | SWT.CENTER);
		lblEcossistemaDeMonitoramento.setText("Ecossistema de Monitoramento Policial");
		lblEcossistemaDeMonitoramento.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblEcossistemaDeMonitoramento.setAlignment(SWT.CENTER);
		lblEcossistemaDeMonitoramento.setBounds(78, 12, 252, 15);

	}

	public void printNotificacaoDrone(int idDrone, String nome, boolean suspeito) {
		String mensagem = ControleEmpSingleton.getInstance().getDrone(idDrone);
		String[] mensagemArray = mensagem.split(";", -1);
		String zona = mensagemArray[0];
		String status = mensagemArray[1];
		String carga = mensagemArray[2];
		String posx = mensagemArray[3];
		String posy = mensagemArray[4];
		String duracao = mensagemArray[5];
		if(suspeito) {
			label_2.setText("Alerta: ".concat(nome).concat(" identificado(a)").concat(" na Zona ").concat(zona));
			label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		}
		else {
			label_2.setText("Civil: ".concat(nome).concat(" identificado(a)").concat(" na Zona ").concat(zona));
		}
	}

	public void printNotificacaoTornozeleira(int idTornozeleira, String nome, boolean remocao) {
		String mensagem = ControleEmpSingleton.getInstance().getTornozeleira(idTornozeleira);
		String[] mensagemArray = mensagem.split(";", -1);
		String det = mensagemArray[0];
		String carga = mensagemArray[1];
		String posx = mensagemArray[2];
		String posy = mensagemArray[3];
		String bpm = mensagemArray[4];
		String potencia = mensagemArray[5];
		
		if(remocao) {
			label_5.setText("Notifica\u00E7\u00E3o: Tornozeleira ".concat(Integer.toString(idTornozeleira)).concat(" detectou tentativa de remocao (").concat(nome).concat(")"));

		}
		else {
			label_5.setText("Notifica\u00E7\u00E3o: Tornozeleira 0187 detectou atividade at\u00EDpica (Jo\u00E3o da Silva)");

		}

	}
}
