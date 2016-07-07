import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;
import org.jfree.ui.RefineryUtilities;

import Framework.DeepCopy;
import Framework.Settings;

public class GeneticAlgorithm {
	
	private DynamicPlot demo;
	private int Generation = 0;
	private double MutationRate;
	private int NumberOfSurvivalInGeneration;
	private int PopulationSize;
    private NavigableSet<DNAMathFunction> PopulationSet = new TreeSet(); 
    private NavigableSet<DNAMathFunction> FittestOfPopulationSet = new TreeSet(); 
    
	public GeneticAlgorithm (Settings Settings){
		MutationRate = Settings.getMutationRate();
		PopulationSize = Settings.getPopulationSize();
		NumberOfSurvivalInGeneration = Settings.getNumberOfSurvivalInGeneration();
	}
	
	public void initilizeAlgorithm() throws InstantiationException, IllegalAccessException{
		startPlotting();
		initialPopulation();	
		startAlgorithm();
		
	}
	private void startAlgorithm(){
		while(true){
			selectFittest();
			demo.plot(Generation, FittestOfPopulationSet.last().getFitness());
			Generation += 1;
			emptyOldPopulation();
			createNewPopulation();
		}
	}
	
	private void startPlotting(){
        demo = new DynamicPlot("Dynamic Data Demo");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
	}
	
	private void initialPopulation(){
		for(int i = 0; i < PopulationSize; i++){
			DNAMathFunction individuum = new DNAMathFunction();
			individuum.setRandomDNA();
			PopulationSet.add(individuum);
		}
	}

	private void selectFittest(){
		for(int i = 0; i < NumberOfSurvivalInGeneration; i++){
			FittestOfPopulationSet.add(PopulationSet.pollLast());
		}
	}
	private void emptyOldPopulation(){
		
		PopulationSet.clear();
		
	}
	
	private void createNewPopulation(){
		fillInFittestOfPreviousGeneration();
		fillPopulationWithNewIndividuen();
	}
	
	private void fillInFittestOfPreviousGeneration(){
		
		PopulationSet.addAll(FittestOfPopulationSet);	
		FittestOfPopulationSet.clear();
	}
	
	private void fillPopulationWithNewIndividuen(){
		Random random = new Random();
		int min = 0;
		int max = (PopulationSet.size() - 1 );
		//Da ein Zugriff auf einen Index in dem Set nicht erlaubt ist, wird 
		//Set in einen Array Ã¼berfÃ¼hrt.
		NavigableSet<DNAMathFunction> TemporaryPopulationSet = new TreeSet();
		TemporaryPopulationSet.addAll(PopulationSet);
		DNAMathFunction[] ArryWithFittest = new DNAMathFunction[PopulationSet.size()];
		for(int i = 0; i < PopulationSet.size(); i++){
			ArryWithFittest[i] = TemporaryPopulationSet.pollFirst();
		}
		
		//Die Besten Individuen sind nun im Array
		//Nach Zufall werden die leeren 45 GenerationplÃ¤tze mit Fitten besetzt.
		while(PopulationSet.size() < PopulationSize){
			int index1 = random.nextInt(max - min + 1) + min;
			int index2;
			//verhindert dass ein Individum mit sich selbst gekreuzt wird.
			do{
				index2 = random.nextInt(max - min + 1) + min;
			}while(index1 == index2);
			
			//zwei zufällige Individuen werden ausgewählt und zu einem neuen rekombiniert
			DNAMathFunction newIndividuum = combineIndividuen((DNAMathFunction) DeepCopy.copy(ArryWithFittest[index1]), (DNAMathFunction) DeepCopy.copy(ArryWithFittest[index2]));
			PopulationSet.add(mutateIndividuum(newIndividuum));
		}
	}
	
	//Rekombination
	private DNAMathFunction combineIndividuen(DNAMathFunction Individuum1, DNAMathFunction Individuum2)
	{
		for(int i = 0; i < Individuum1.getDNALength(); i++)
		{
			if(Math.random() < 0.5)
			{
				Individuum1.setAllele(i, Individuum2.getAllele(i));
			}
		}
		return Individuum1;
	}

	private DNAMathFunction mutateIndividuum(DNAMathFunction Individuum){
		Random willValueMutate = new Random();
		int min = 1;
		int max = 100;
		int mutationTreshold = (int) (MutationRate * 100);
				
		for(int i = 0; i < Individuum.getDNALength(); i++){
			if((willValueMutate.nextInt(max - min + 1) + min) <= mutationTreshold){
				Individuum.setRandomAllel(i);
			}
		}
		return Individuum;
	}
}
