
public class City {
	private double xPos, yPos;

	//Constructor
	public City(double x, double y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public static int calculateDistance(City city1, City city2) {
		return  (int)Math.round( Math.sqrt((city1.xPos-city2.xPos)*(city1.xPos-city2.xPos)
										+ (city1.yPos-city2.yPos)*(city1.yPos-city2.yPos)) );
	}
	
	public double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}

	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}
	
	public String toString() {
		return "X " + this.xPos + ". Y:" + this.yPos;
	}
}
