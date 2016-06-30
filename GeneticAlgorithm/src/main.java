import GALibary.Settings;

public class main {

	public static void main (String[] args) throws InstantiationException, IllegalAccessException {
		
		Settings Settings = new Settings();
		Settings.setMutationRate(0.02);
		Settings.setPopulationSize(50);
		Settings.setDNAClass("DNAMathFunction");
		
		GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(Settings);
		geneticAlgorithm.startAlgorithm();
		
	}

}
