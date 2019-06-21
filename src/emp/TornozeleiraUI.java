package emp;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Button;

public class TornozeleiraUI {

	protected Shell shell;

	/**
	 * Launch the application.
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
		shell.setSize(420, 360);
		shell.setText("Tornozeleira");
		
		Label lblSimuladorDeTornozeleira = new Label(shell, SWT.NONE);
		lblSimuladorDeTornozeleira.setText("Simulador de Tornozeleira");
		lblSimuladorDeTornozeleira.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblSimuladorDeTornozeleira.setBounds(96, 13, 173, 15);
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("ID :");
		label.setBounds(315, 13, 26, 15);
		
		Spinner spinner = new Spinner(shell, SWT.BORDER);
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
		
		Label lblNomeDoDetento = new Label(shell, SWT.NONE);
		lblNomeDoDetento.setText("Nome do Detento: XXXXXXXXXX");
		lblNomeDoDetento.setBounds(96, 229, 206, 15);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setText("Posi\u00E7\u00E3o Atual : XXX.XXX , XXX.XXX");
		label_4.setBounds(96, 250, 206, 15);
		
		Label lblAtividadeCardacaXxx = new Label(shell, SWT.NONE);
		lblAtividadeCardacaXxx.setText("Atividade card\u00EDaca: XXX bpm");
		lblAtividadeCardacaXxx.setBounds(96, 271, 206, 15);
		
		Label lblCargaDaBateria = new Label(shell, SWT.NONE);
		lblCargaDaBateria.setText("Carga da bateria: XX%");
		lblCargaDaBateria.setBounds(96, 292, 206, 15);
		
		Label lblChoqueDesativado = new Label(shell, SWT.BORDER | SWT.WRAP);
		lblChoqueDesativado.setText("Choque desativado (0V)");
		lblChoqueDesativado.setAlignment(SWT.CENTER);
		lblChoqueDesativado.setBounds(0, 185, 414, 25);

	}

}
