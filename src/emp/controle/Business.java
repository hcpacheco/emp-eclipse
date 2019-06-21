package emp.controle;

import java.util.List;

import emp.persistencia.ZonaDePatrulha;

public class Business {

	private Notificacao notificacao; // = new Notificacao();
	private List<ZonaDePatrulha> zonas; // = new ZonaDePatrulha();

	public Business(List<ZonaDePatrulha> z) {
		super();
		this.notificacao = new Notificacao();
		this.setZonas(z);
	}

	public void setZonas(List<ZonaDePatrulha> zonas) {
		this.zonas = zonas;
	}

	public void newZonaDePatulha(List<Float> latitudes, List<Float> longitudes) {
		int tamanhoLatitude = latitudes.size();
		int tamanhoLongitude = longitudes.size();

		// checa poligono formado por quatro pontos
		if (tamanhoLatitude == 4 && tamanhoLongitude == 4) {
			ZonaDePatrulha novaZona = new ZonaDePatrulha(latitudes, longitudes);
			this.zonas.add(novaZona);
		}
	}

	public void enviaParaDrone() {

	}

	public void enviaParaTornozeleira() {

	}

	public boolean validar(String usuario, String senha) {
		return true;
	}

}
