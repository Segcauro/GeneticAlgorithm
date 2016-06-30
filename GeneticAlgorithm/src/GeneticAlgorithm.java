import GALibary.Settings;

public class GeneticAlgorithm {
	
	private Settings Settings;
	private DNAMathFunction[] Population = new DNAMathFunction[50];
	
	public GeneticAlgorithm (Settings settings){
		Settings = settings;
	}
	
	public void startAlgorithm() throws InstantiationException, IllegalAccessException{
		initialPopulation();
	}
	
	private void initialPopulation(){
		
		for(int i = 0; i < 50; i++){
			DNAMathFunction individuum = new DNAMathFunction();
			individuum.setDNARandom();
			Population[i] = individuum;
		}
		
		for(int i = 0; i < Population.length; i++){
			Population[i].printDNA();
			System.out.print(" --> ");
			System.out.println(Population[i].getFitness());
		}
	}
	
	private DNAMathFunction selectFittest(){
	
		DNAMathFunction[] Fittest = new DNAMathFunction[10];
		
		
		return null;
		
	}
	
}
