import java.util.List;
import java.util.Random;

import Framework.IDNA;

public class DNAMathFunction implements IDNA, Comparable, java.io.Serializable{

	private String[] DNA = new String[26];
	private int DNALength = DNA.length;
	private String[] DNAValues = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	private int numberOfDNAValues = DNAValues.length - 1;
	
	public void printDNA(){
		for(int i = 0; i < DNA.length; i++){
			System.out.print(DNA[i]);
			System.out.print("	");
		}
	}
	
	public double getFitness() {
		int fitness = 0;
		for(int i = 0; i < DNALength; i++)
		{
			if(DNA[i] == DNAValues[i])
			{
				fitness++;
			}
		}

		return fitness;
	}

	public void setRandomDNA() {
		Random random = new Random();
		
		for(int i = 0; i < numberOfDNAValues; i++)
		{
			Random index = new Random();
			int min = 0;
			int max = numberOfDNAValues;
			
			DNA[i] = DNAValues[index.nextInt(max - min + 1) + min];
		}
		
		int min = 1;
		int max = numberOfDNAValues;
		
		for(int i = 0; i < DNALength; i++){
			String Value = DNAValues[random.nextInt(max - min + 1) + min];
			DNA[i] = Value;
		}	
	}
	public void setRandomAllel(int Index){
		Random random = new Random();
		int min = 0;
		int max = numberOfDNAValues;
		
		DNA[Index] = DNAValues[random.nextInt(max - min + 1) + min];
	}
	
	public void setDNA(String[] dna) {
		DNA = dna;
	}
	
	public void setAllele(int Index, String Value){
		DNA[Index] = Value;
	}
	
	public String[] getDNA(){
		return DNA;
	}
	public String getAllele(int Index){
		return DNA[Index];
	}

	@Override
	public int compareTo(Object o) {

		DNAMathFunction object = (DNAMathFunction) o;
		
		if(object.getFitness() < this.getFitness()){
			return 1;
		}else if (object.getFitness() > this.getFitness()){
			return -1;
		}else {
			return 0;
		}	
	}
	public int getDNALength(){
		return DNALength;
	}
}
