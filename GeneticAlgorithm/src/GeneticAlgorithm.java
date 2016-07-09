import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;
import org.jfree.ui.RefineryUtilities;

import Framework.DeepCopy;
import Framework.IDNA;
import Framework.Settings;

public class GeneticAlgorithm <DNAClassType extends IDNA> {
	
	private DynamicPlot demo;
	private int Generation = 0;
	private double MutationRate;
	private int NumberOfSurvivalInGeneration;
	private int PopulationSize;
	private Class<DNAClassType> DNAClass;
    private NavigableSet<DNAClassType> PopulationSet = new TreeSet(); 
    private NavigableSet<DNAClassType> FittestOfPopulationSet = new TreeSet(); 
    
	public GeneticAlgorithm (Settings Settings, Class<DNAClassType> ic_Class){
		this.DNAClass = ic_Class;
		this.MutationRate = Settings.getMutationRate();
		this.PopulationSize = Settings.getPopulationSize();
		this.NumberOfSurvivalInGeneration = Settings.getNumberOfSurvivalInGeneration();
	}
	
	public void initilizeAlgorithm() throws InstantiationException, IllegalAccessException{
		DNAClassType test = newIndividuum();
		test.setRandomDNA();
		test.printDNA();
		startPlotting();
		initialPopulation();	
		startAlgorithm();
	}
	private void startAlgorithm(){
		while(true)
		{
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
	private DNAClassType newIndividuum() throws InstantiationException, IllegalAccessException{
		return DNAClass.newInstance();
		
	}
	private void initialPopulation() throws InstantiationException, IllegalAccessException{
		for(int i = 0; i < PopulationSize; i++)
		{
			DNAClassType individuum = newIndividuum();
			individuum.setRandomDNA();
			PopulationSet.add(individuum);
		}
	}

	private void selectFittest(){
		for(int i = 0; i < NumberOfSurvivalInGeneration; i++)
		{
			FittestOfPopulationSet.add(PopulationSet.last());
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
		//Set in einen Array überführt.
		NavigableSet<DNAClassType> TemporaryPopulationSet = new TreeSet();
		TemporaryPopulationSet.addAll(PopulationSet);
		DNAClassType[] ArryWithFittest = (DNAClassType[]) Array.newInstance(DNAClass, PopulationSet.size());
		for(int i = 0; i < PopulationSet.size(); i++)
		{
			ArryWithFittest[i] = TemporaryPopulationSet.pollFirst();
		}
		
		//Die Besten Individuen sind nun im Array
		//Nach Zufall werden die leeren 45 Generationplätze mit Fitten besetzt.
		while(PopulationSet.size() < PopulationSize)
		{
			int index1 = random.nextInt(max - min + 1) + min;
			int index2;
			//verhindert dass ein Individum mit sich selbst gekreuzt wird.
			do{
				index2 = random.nextInt(max - min + 1) + min;
			}while(index1 == index2);
			
			//zwei zuf�llige Individuen werden ausgew�hlt und zu einem neuen rekombiniert
			DNAClassType newIndividuum = combineIndividuen((DNAClassType) DeepCopy.copy(ArryWithFittest[index1]), (DNAClassType) DeepCopy.copy(ArryWithFittest[index2]));
			PopulationSet.add(mutateIndividuum(newIndividuum));
		}
	}
	
	//Recombination
	private DNAClassType combineIndividuen(DNAClassType dnaClassType, DNAClassType dnaClassType2)
	{
		for(int i = 0; i < dnaClassType.getDNALength(); i++)
		{
			if(Math.random() < 0.5)
			{
				dnaClassType.setAllele(i, dnaClassType2.getAllele(i));
			}
		}
		return dnaClassType;
	}

	private DNAClassType mutateIndividuum(DNAClassType Individuum)
	{
		Random willValueMutate = new Random();
		int min = 1;
		int max = 100;
		int mutationTreshold = (int) (MutationRate * 100);
				
		for(int i = 0; i < Individuum.getDNALength(); i++)
		{
			if((willValueMutate.nextInt(max - min + 1) + min) <= mutationTreshold)
			{
				Individuum.setRandomAllel(i);
			}
		}
		return Individuum;
	}
}
