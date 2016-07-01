import Framework.Settings;

public class Main {

	public static void main (String[] args) throws InstantiationException, IllegalAccessException {
		
		Settings Settings = new Settings();
		Settings.setMutationRate(0.5);
		Settings.setPopulationSize(7);
		Settings.setNumberOfSurvivalInGeneration(4);
		
		GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(Settings);
		geneticAlgorithm.initilizeAlgorithm();
		
	}

}
