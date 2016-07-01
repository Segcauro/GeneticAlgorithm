
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

import org.jfree.ui.RefineryUtilities;

import Framework.Settings;

public class GeneticAlgorithm {
	
	private DynamicPlot demo;
	private Settings Settings;
	private int Genertation = 0;
	
	// Create the sorted set
    NavigableSet<DNAMathFunction> PopulationSet = new TreeSet(); 
	
	public GeneticAlgorithm (Settings settings){
		Settings = settings;
	}
	
	public void startAlgorithm() throws InstantiationException, IllegalAccessException{
		startPlotting();
		initialPopulation();	
		
		for(int i = 1; i <= 50; i++){
			
			DNAMathFunction o = PopulationSet.pollLast();
			demo.plot(Genertation, o.getFitness());
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
			PopulationSet.add(individuum);
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
