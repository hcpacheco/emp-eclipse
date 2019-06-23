package emp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;

public class ConfigurarTornozeleiraUI {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ConfigurarTornozeleiraUI window = new ConfigurarTornozeleiraUI();
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
		shell.setSize(423, 350);
		shell.setText("SWT Application");
		
		Label lblDrones = new Label(shell, SWT.NONE);
		lblDrones.setText("Tornozeleiras");
		lblDrones.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblDrones.setBounds(183, 10, 92, 15);
		
		Spinner spinner = new Spinner(shell, SWT.BORDER);
		spinner.setBounds(343, 9, 47, 22);
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("ID :");
		label.setBounds(311, 12, 26, 15);
		
		Label lblZonaDePatrulha = new Label(shell, SWT.NONE);
		lblZonaDePatrulha.setText("Condi\u00E7\u00E3o:");
		lblZonaDePatrulha.setBounds(43, 84, 99, 15);
		
		Label lblNomeDaZona_1 = new Label(shell, SWT.NONE);
		lblNomeDaZona_1.setText("Nome do detento:");
		lblNomeDaZona_1.setBounds(43, 151, 99, 15);
		
		Button btnRadioButton = new Button(shell, SWT.RADIO);
		btnRadioButton.setBounds(185, 83, 90, 16);
		btnRadioButton.setText("Ativar");
		
		Button btnRadioButton_1 = new Button(shell, SWT.RADIO);
		btnRadioButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnRadioButton_1.setBounds(281, 83, 90, 16);
		btnRadioButton_1.setText("Desativar");
		
		Button btnSalvar = new Button(shell, SWT.NONE);
		btnSalvar.setBounds(183, 259, 75, 25);
		btnSalvar.setText("Salvar");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(183, 151, 168, 21);
		
		Label lblCpfDoDetento = new Label(shell, SWT.NONE);
		lblCpfDoDetento.setText("CPF do detento:");
		lblCpfDoDetento.setBounds(43, 182, 99, 15);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(183, 176, 168, 21);
		
		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(0, 38, 414, 2);

	}

}
