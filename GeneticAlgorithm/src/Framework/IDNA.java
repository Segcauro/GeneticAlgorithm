package Framework;

public interface IDNA {
	
	public void setDNA(String[] DNAValues);
	public void setRandomDNA();
	public void setRandomAllel(int Index);
	public void setAllele(int Index, String Value);
	public double getFitness();
	public String[] getDNA();
	public String getAllele(int Index);
	public int getDNALength();
	public int compareTo(Object o);
	public void printDNA();
}
