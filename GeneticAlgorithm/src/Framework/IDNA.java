package Framework;

public interface IDNA {
	
	public void setDNA(double[] DNAValues);
	public void setRandomDNA();
	public void setRandomAllel(int Index);
	public void setAllele(int Index, double Value);
	public double getFitness();
	public double[] getDNA();
	public double getAllele(int Index);
	public int getDNALength();
	public int compareTo(Object o);
	public void printDNA();
}
