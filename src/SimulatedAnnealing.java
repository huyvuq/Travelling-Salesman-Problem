
public class SimulatedAnnealing {	
	
	public static void findBestTour(String fileName) {
		double temperature = 100000;
		double coolingRate = 0.003;
		
        Tour currentSolution = new Tour(new Tour(DataProvider.retrieveCitiesFromFile(fileName)).getTour());
        
		System.out.println("Distance before optimization: " + currentSolution.getDistance());
		
		Tour best = new Tour(currentSolution.getTour());
		
		while (temperature > 1) {
			Tour newSolution = new Tour(currentSolution.getTour());
			newSolution.randomlySwapTwoCities();
			
			double currentDistance = currentSolution.getDistance();
			double neighbourDistance = newSolution.getDistance();
			
			if (acceptanceProbaility(currentDistance, neighbourDistance, temperature) > Math.random())
				currentSolution = new Tour(newSolution.getTour());
			
			if (currentSolution.getDistance() < best.getDistance())
				best = new Tour(currentSolution.getTour());
			temperature *= 1 - coolingRate;
		}
		
		System.out.println("Distance after optimization: " + best.getDistance());

	}
	
	private static double acceptanceProbaility(double currentBest, double neighbor, double temperature) {
		if (currentBest < neighbor)
			return 1;
		
		return Math.exp((currentBest-neighbor)/temperature);
	}
}
