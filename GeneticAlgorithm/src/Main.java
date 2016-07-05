import Framework.Settings;

public class Main {

	public static void main (String[] args) throws InstantiationException, IllegalAccessException {
		
		Settings Settings = new Settings();
		Settings.setMutationRate(0.03);
		Settings.setPopulationSize(50);
		Settings.setNumberOfSurvivalInGeneration(5);
		
		GeneticAlgorithm<DNAMathFunction> geneticAlgorithm = new GeneticAlgorithm(Settings, DNAMathFunction.class);
		geneticAlgorithm.initilizeAlgorithm();
		
	}
}
