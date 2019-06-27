package emp.drone;

public class GPS {
	private double posx;
	private double posy;
	public double getPosx() {
		return posx;
	}
	public void setPosx(double posx) {
		this.posx = posx;
	}
	public double getPosy() {
		return posy;
	}
	public void setPosy(double posy) {
		this.posy = posy;
	}
	public GPS(double posx, double posy) {
		super();
		this.setPosx(posx);
		this.setPosy(posy);
	}
	
	public void atualizaPosicao() {
		Double x = this.getPosx();
		Double y = this.getPosy();
		double randomDouble = Math.random();
		double randomDouble2 = Math.random();

		x += randomDouble;
		setPosx(x);

		y += randomDouble2;
		setPosy(y);

		
	}
	public void retornaHQ() {
		this.setPosx(0.0);
		this.setPosy(0.0);
	}
	
	
}
