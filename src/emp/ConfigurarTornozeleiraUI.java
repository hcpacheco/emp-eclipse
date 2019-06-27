package emp;

import java.text.SimpleDateFormat;
import java.util.Date;

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

import emp.controle.ControleEmpSingleton;
import emp.persistencia.Detento;
import emp.persistencia.Sexo;
import emp.tornozeleira.StatusTornozeleira;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ConfigurarTornozeleiraUI {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Button btnRadioButton;
	private Button btnRadioButton_1;
	private Spinner spinner;
//	private EmpUI emp;

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
		
		spinner = new Spinner(shell, SWT.BORDER);
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
		
		btnRadioButton = new Button(shell, SWT.RADIO);
		btnRadioButton.setBounds(185, 83, 90, 16);
		btnRadioButton.setText("Ativar");
		
		btnRadioButton_1 = new Button(shell, SWT.RADIO);
		btnRadioButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnRadioButton_1.setBounds(281, 83, 90, 16);
		btnRadioButton_1.setText("Desativar");
		
		Button btnSalvar = new Button(shell, SWT.NONE);
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				StatusTornozeleira s = StatusTornozeleira.IDLE;
				
				if(btnRadioButton.getSelection()) {
					s = StatusTornozeleira.ACTIVE;
				}
				
				String nomeDetento = text.getText();
				String cpfDetento = text_1.getText();
				int idTornozeleira = spinner.getSelection();
				
//				System.out.println(s);
//				System.out.println(nomeDetento);
//				System.out.println(cpfDetento);
//				System.out.println(Integer.toString(idTornozeleira));
				
				//data de nascimento de novo detento
				// Data de nascimento
				Date data1 = new Date();
				// Converte string para date
				SimpleDateFormat dateformat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
				String strdate = "05-10-1980 20:15:00";

				try {
					data1 = dateformat.parse(strdate);
				} catch (java.text.ParseException e1) {
					e1.printStackTrace();
				}

				System.out.println("aqui");
				//criar novo detento
				//!!!!
//				Date d = new Date();
				//(String nome, Date d, Sexo s, String cpf, int atividadeCardiaca)
				Detento novoDetento = new Detento(nomeDetento, data1, Sexo.INDEFINIDO, cpfDetento);
				
				//Enviar detento e fazer verificacao pra saber se ja existe em business
				ControleEmpSingleton.getInstance().configurarTornozeleira(idTornozeleira, s, novoDetento, cpfDetento);
				
			}
		});
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
