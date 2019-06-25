package emp;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import emp.controle.ControleEmpSingleton;

import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class TornozeleiraUI {

	protected Shell shell;

	private Label lblNomeDoDetento;
	private Label label_4;
	private Label lblAtividadeCardacaXxx;
	private Label lblCargaDaBateria;
	private Label lblChoqueDesativado;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TornozeleiraUI window = new TornozeleiraUI();
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
		createContents(0);
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
	protected void createContents(int idTornozeleira) {
		shell = new Shell();
		shell.setSize(420, 360);
		shell.setText("Tornozeleira");

		String mensagem = ControleEmpSingleton.getInstance().getTornozeleira(idTornozeleira);
		String[] mensagemArray = mensagem.split(";", -1);
		String det = mensagemArray[0];
		String carga = mensagemArray[1];
		String posx = mensagemArray[2];
		String posy = mensagemArray[3];
		String bpm = mensagemArray[4];
		String potencia = mensagemArray[5];
		
		Label lblSimuladorDeTornozeleira = new Label(shell, SWT.NONE);
		lblSimuladorDeTornozeleira.setText("Simulador de Tornozeleira");
		lblSimuladorDeTornozeleira.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblSimuladorDeTornozeleira.setBounds(96, 13, 173, 15);

		Label label = new Label(shell, SWT.NONE);
		label.setText("ID :");
		label.setBounds(315, 13, 26, 15);

		Spinner spinner = new Spinner(shell, SWT.BORDER);
		spinner.setMaximum(2);
		spinner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String mensagem = ControleEmpSingleton.getInstance().getTornozeleira(spinner.getSelection());
				String[] mensagemArray = mensagem.split(";", -1);
				String det = mensagemArray[0];
				String carga = mensagemArray[1];
				String posx = mensagemArray[2];
				String posy = mensagemArray[3];
				String bpm = mensagemArray[4];
				String potencia = mensagemArray[5];
				printTornozeleira(det, carga, posx, posy, bpm, potencia);
				
			}
		});
		spinner.setBounds(347, 10, 47, 22);

		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(0, 43, 414, 2);

		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(0, 168, 414, 2);

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(96, 71, 198, 25);
		btnNewButton.setText("Detectar tentativa de remo\u00E7\u00E3o");

		Button btnDetectarPosioProibida = new Button(shell, SWT.NONE);
		btnDetectarPosioProibida.setText("Detectar posi\u00E7\u00E3o proibida");
		btnDetectarPosioProibida.setBounds(96, 115, 198, 25);

		lblNomeDoDetento = new Label(shell, SWT.NONE);
		lblNomeDoDetento.setText("Nome do Detento: XXXXXXXXXX");
		lblNomeDoDetento.setBounds(96, 229, 206, 15);

		label_4 = new Label(shell, SWT.NONE);
		label_4.setText("Posi\u00E7\u00E3o Atual : XXX.XXX , XXX.XXX");
		label_4.setBounds(96, 250, 206, 15);

		lblAtividadeCardacaXxx = new Label(shell, SWT.NONE);
		lblAtividadeCardacaXxx.setText("Atividade card\u00EDaca: XXX bpm");
		lblAtividadeCardacaXxx.setBounds(96, 271, 206, 15);

		lblCargaDaBateria = new Label(shell, SWT.NONE);
		lblCargaDaBateria.setText("Carga da bateria: XX%");
		lblCargaDaBateria.setBounds(96, 292, 206, 15);

		lblChoqueDesativado = new Label(shell, SWT.BORDER | SWT.WRAP);
		lblChoqueDesativado.setText("Choque desativado (0V)");
		lblChoqueDesativado.setAlignment(SWT.CENTER);
		lblChoqueDesativado.setBounds(0, 185, 414, 25);

		printTornozeleira(det, carga, posx, posy, bpm, potencia);

	}

	public void printTornozeleira(String nome, String carga, String posx, String posy, String bpm, String potencia) {
		lblNomeDoDetento.setText("Nome do Detento : ".concat(nome));
		label_4.setText("Posi\u00E7\u00E3o Atual : ".concat(posx).concat(" , ").concat(posy));
		lblAtividadeCardacaXxx.setText("Atividade card\\u00EDaca : ".concat(bpm).concat(" bpm"));
		lblCargaDaBateria.setText("Carga da bateria : ".concat(carga).concat("%"));
		lblChoqueDesativado.setText("Choque desativado (".concat(potencia).concat("V)"));

	}

}
