import Framework.Settings;

public class Main {

	public static void main (String[] args) throws InstantiationException, IllegalAccessException {
		
		Settings Settings = new Settings();
		Settings.setMutationRate(0.02);
		Settings.setPopulationSize(50);
		
		GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(Settings);
		geneticAlgorithm.startAlgorithm();
		
	}

}
