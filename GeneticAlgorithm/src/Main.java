import Framework.Settings;

public class Main {

	public static void main (String[] args) throws InstantiationException, IllegalAccessException {
		
		Settings Settings = new Settings();
		Settings.setMutationRate(0.01);
		Settings.setPopulationSize(50);
		Settings.setNumberOfSurvivalInGeneration(5);
		
		GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(Settings);
		geneticAlgorithm.initilizeAlgorithm();
		
	}

}
