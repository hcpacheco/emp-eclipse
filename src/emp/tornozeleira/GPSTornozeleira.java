package emp.tornozeleira;

public class GPSTornozeleira {
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
	public GPSTornozeleira(double posx, double posy) {
		super();
		this.setPosx(posx);
		this.setPosy(posy);
	}
	
}
