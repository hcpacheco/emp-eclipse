package emp;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import emp.controle.ControleEmpSingleton;

import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Menu;

public class LoginUI {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Button btnNewButton;
	private Label lblBemVindoa;
	private boolean tentativa;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoginUI window = new LoginUI();
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
		shell.setSize(450, 300);
		shell.setText("EMP Controle");
		shell.setLayout(null);

		Label lblEcossistemaDeMonitoramento = new Label(shell, SWT.NONE);
		lblEcossistemaDeMonitoramento.setBounds(73, 45, 283, 20);
		lblEcossistemaDeMonitoramento.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		lblEcossistemaDeMonitoramento.setText("Ecossistema de Monitoramento Policial");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(37, 113, 57, 15);
		lblNewLabel.setText("Usu\u00E1rio :");

		text = new Text(shell, SWT.BORDER);
		text.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				lblBemVindoa.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				lblBemVindoa.setText("Bem vindo(a)!");
			}
		});
		text.setBounds(118, 110, 220, 21);

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(37, 159, 49, 15);
		lblNewLabel_1.setText("Senha :");

		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				lblBemVindoa.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				lblBemVindoa.setText("Bem vindo(a)!");
			}
		});
		text_1.addKeyListener(new KeyAdapter() {
		});
		text_1.setBounds(118, 156, 220, 21);

		btnNewButton = new Button(shell, SWT.NONE);

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String name = text.getText();
				String pw = text_1.getText();
				System.out.println(name);
				System.out.println(pw);
				if (ControleEmpSingleton.getInstance().validarSenha(name, pw)) {
					shell.close();

					EmpUI window = new EmpUI();
					window.open();
				} else {
					lblBemVindoa.setText("Login ou senha inválido. Por favor, tente novamente.");
					lblBemVindoa.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
				}

			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.close();
			}
		});
		btnNewButton.setBounds(174, 205, 75, 25);
		btnNewButton.setText("Logar");
		
		lblBemVindoa = new Label(shell, SWT.BORDER | SWT.WRAP);
		lblBemVindoa.setText("Bem vindo(a)!");
		lblBemVindoa.setAlignment(SWT.CENTER);
		lblBemVindoa.setBounds(10, 71, 414, 25);

	}
}
