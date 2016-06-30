package GALibary;

public class Settings{
	
	private int PopulationSize;
	private double MutationRate;
	private Class DNAClass;
	
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
	public Class getDNAClass() {
		return DNAClass;
	}
	public void setDNAClass(String ClassName) {
		try {
			DNAClass = Class.forName(ClassName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
