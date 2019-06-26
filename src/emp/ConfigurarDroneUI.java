package emp;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import emp.controle.ControleEmpSingleton;
import emp.drone.StatusDrone;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ConfigurarDroneUI {

	protected Shell shell;
	private Button btnRadioButton;
	private Button btnRadioButton_1;
	private List list;
	private Spinner spinner;
	private Spinner spinner_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ConfigurarDroneUI window = new ConfigurarDroneUI();
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
		shell.setSize(424, 350);
		shell.setText("SWT Application");
		
		Label lblDrones = new Label(shell, SWT.NONE);
		lblDrones.setText("Drones");
		lblDrones.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblDrones.setBounds(183, 10, 66, 15);
		
		spinner = new Spinner(shell, SWT.BORDER);
		spinner.setBounds(340, 9, 47, 22);
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("ID :");
		label.setBounds(306, 12, 26, 15);
		
		Label lblZonaDePatrulha = new Label(shell, SWT.NONE);
		lblZonaDePatrulha.setText("Status:");
		lblZonaDePatrulha.setBounds(43, 84, 99, 15);
		
		Label lblNomeDaZona_1 = new Label(shell, SWT.NONE);
		lblNomeDaZona_1.setText("Zona de Patrulha:");
		lblNomeDaZona_1.setBounds(43, 127, 99, 15);
		
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
		
		list = new List(shell, SWT.BORDER);
		list.setItems(new String[] {"Centro", "Agronomia", "Ipanema", "Navegantes"});
		list.setBounds(183, 123, 161, 64);
		
		Label lblDurao = new Label(shell, SWT.NONE);
		lblDurao.setText("Dura\u00E7\u00E3o (horas):");
		lblDurao.setBounds(43, 210, 99, 15);
		
		spinner_1 = new Spinner(shell, SWT.BORDER);
		spinner_1.setBounds(183, 207, 47, 22);
		
		Button btnSalvar = new Button(shell, SWT.NONE);
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				StatusDrone s = StatusDrone.IDLE;
				
				if(btnRadioButton.getSelection()) {
					s = StatusDrone.PATRULHANDO;
				}
				
				String nomeZona = list.getItem(list.getSelectionIndex());
				list.getItem(0);
				list.getItems();
				
				int duracao = spinner_1.getSelection();
				
				int idDrone = spinner.getSelection();
				
				System.out.println(s);
				System.out.println(nomeZona);
				System.out.println(duracao);
				ControleEmpSingleton.getInstance().configurarDrone(idDrone, s, nomeZona, duracao);

				
				
			}
		});
		btnSalvar.setBounds(167, 280, 75, 25);
		btnSalvar.setText("Salvar");
		
		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(0, 47, 414, 2);

	}
}
