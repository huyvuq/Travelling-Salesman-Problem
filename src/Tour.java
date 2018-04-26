import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tour {
	private List<City> tour = new ArrayList<>();
	
	public Tour(List<City> cityList) {
		for(City city: cityList) {
			this.tour.add(city);
		}
	}
	public List<City> getTour(){
		return this.tour;
	}
	
	public String toString() {
		return "";
	}
	
	public int getDistance() {
		int distance = City.calculateDistance(this.tour.get(this.tour.size() - 1), this.tour.get(0));
		for (int i = 0; i < this.tour.size() - 2; i++) {
			distance += City.calculateDistance(tour.get(i), tour.get(i+1));
		}
		return distance;
	}
	
	public void randomlySwapTwoCities() {
		Random generator = new Random(); 
		int index1 = generator.nextInt(tour.size());
		int index2 = generator.nextInt(tour.size());
		
		while (index1 == index2) {index2 = generator.nextInt(tour.size());}
		
		City city2 = tour.get(index2);
		tour.set(index2, tour.get(index1));
		tour.set(index1, city2);
	}
}
