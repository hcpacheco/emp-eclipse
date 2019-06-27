package emp.tornozeleira;

import java.util.Random;

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
	public GPSTornozeleira() {
		super();
		Double x = getPos();
		Double y = getPos();
		this.setPosx(x);
		this.setPosy(y);
	}
	
	public Double getPos() {
		double randomDouble = Math.random();
		Random randomGenerator = new Random();
		double random = randomGenerator.nextInt(10) + randomDouble;
		return random;
		
	}
	public void setPosProibida() {
		setPosx(getPos());
		setPosy(getPos());
	}
	
}
