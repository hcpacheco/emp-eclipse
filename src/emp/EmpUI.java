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

public class EmpUI {

	protected Shell shell;

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
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("Drones");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		label.setBounds(178, 10, 58, 15);
		
		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(0, 31, 414, 2);
		
		Label label_2 = new Label(shell, SWT.BORDER | SWT.WRAP);
		label_2.setText("Notifica\u00E7\u00E3o: Suspeito identificado (Zona central)");
		label_2.setAlignment(SWT.CENTER);
		label_2.setBounds(10, 39, 394, 25);
		
		Button button = new Button(shell, SWT.NONE);
		button.setText("Enviar Drone");
		button.setBounds(10, 85, 133, 25);
		
		Button button_1 = new Button(shell, SWT.NONE);
//		button_1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseDown(MouseEvent e) {
//			}
//		});

		button_1.setText("Verificar Drones");
		button_1.setBounds(271, 85, 133, 25);
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.setText("Configurar Patrulha");
		button_2.setBounds(10, 142, 133, 25);
		
		Button button_3 = new Button(shell, SWT.NONE);
		button_3.setText("Verificar Patrulhas");
		button_3.setBounds(271, 142, 133, 25);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("Tornozeleiras");
		label_3.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		label_3.setBounds(160, 218, 99, 15);
		
		Label label_4 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_4.setBounds(0, 239, 414, 2);
		
		Label label_5 = new Label(shell, SWT.BORDER | SWT.WRAP);
		label_5.setText("Notifica\u00E7\u00E3o: Tornozeleira 0187 detectou atividade at\u00EDpica (Jo\u00E3o da Silva)");
		label_5.setAlignment(SWT.CENTER);
		label_5.setBounds(10, 247, 394, 25);
		
		Button button_4 = new Button(shell, SWT.NONE);
		button_4.setText("Configurar Detentos");
		button_4.setBounds(10, 291, 133, 25);
		
		Button button_5 = new Button(shell, SWT.NONE);
		button_5.setText("Verificar Tornozeleiras");
		button_5.setBounds(271, 291, 133, 25);

	}

}
