
import org.jfree.ui.RefineryUtilities;

import Framework.Settings;

public class GeneticAlgorithm {
	
	private DynamicPlot demo;
	private Settings Settings;
	private int Genertation = 0;
	private DNAMathFunction[] Population = new DNAMathFunction[50];
	
	public GeneticAlgorithm (Settings settings){
		Settings = settings;
	}
	
	public void startAlgorithm() throws InstantiationException, IllegalAccessException{
		startPlotting();
		for(int i = 0; i < 1000; i++){
			initialPopulation();
			printPopulation();
			demo.plot(Genertation);
			Genertation += 1;
		}
	}
	
	private void startPlotting(){
        demo = new DynamicPlot("Dynamic Data Demo");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
	}
	
	private void initialPopulation(){
		for(int i = 0; i < 50; i++){
			DNAMathFunction individuum = new DNAMathFunction();
			individuum.setRandomDNA();
			Population[i] = individuum;
		}
	}
	//Helpermethode for Developer Testing
	private void printPopulation(){
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
	
	private void crossOver(){
		
	}
	private void mutatePopulation(){
		
	}
}
