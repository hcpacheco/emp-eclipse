package emp;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.ProgressBar;

public class DroneUI {

	protected Shell shell;
	private Text text;

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
		shell.setSize(420, 330);
		shell.setText("Drone");

		Label lblDroneSimulador = new Label(shell, SWT.NONE);
		lblDroneSimulador.setText("Simulador de Drone");
		lblDroneSimulador.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblDroneSimulador.setBounds(140, 11, 129, 15);

		Button btnNewButton = new Button(shell, SWT.NONE);
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

		Button btnRadioButton = new Button(shell, SWT.RADIO);
		btnRadioButton.setBounds(159, 84, 71, 16);
		btnRadioButton.setText("Suspeito");

		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(0, 162, 414, 2);

		Spinner spinner = new Spinner(shell, SWT.BORDER);
		spinner.setBounds(331, 10, 47, 22);

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(300, 13, 26, 15);
		lblNewLabel.setText("ID :");

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(84, 185, 136, 15);
		lblNewLabel_1.setText("Zona Atual : XXXXXXX");

		Label lblPosioXxxxxx = new Label(shell, SWT.NONE);
		lblPosioXxxxxx.setText("Posi\u00E7\u00E3o Atual : XXX.XXX , XXX.XXX");
		lblPosioXxxxxx.setBounds(84, 208, 206, 15);

		Label lblStatusAtualXxxxx = new Label(shell, SWT.NONE);
		lblStatusAtualXxxxx.setText("Status : XXXXX");
		lblStatusAtualXxxxx.setBounds(84, 229, 251, 15);

		Label lblNvelDeBateria = new Label(shell, SWT.NONE);
		lblNvelDeBateria.setText("Carga da bateria : XX%");
		lblNvelDeBateria.setBounds(84, 250, 193, 15);

	}
}
