package Framework;

public class Settings{
	
	private int PopulationSize;
	private double MutationRate;
	private int NumberOfSurvivalInGeneration;
	
	public int getPopulationSize() {
		return PopulationSize;
	}
	public void setPopulationSize(int populationSize) {
		PopulationSize = populationSize;
	}
	public double getMutationRate() {
		return MutationRate;
	}
	public void setMutationRate(double mutationRate) {
		MutationRate = mutationRate;
	}
	public int getNumberOfSurvivalInGeneration() {
		return NumberOfSurvivalInGeneration;
	}
	public void setNumberOfSurvivalInGeneration(int numberOfSurvivalInGeneration) {
		NumberOfSurvivalInGeneration = numberOfSurvivalInGeneration;
	}
}
