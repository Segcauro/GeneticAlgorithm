import java.util.Random;

import Framework.IDNA;

public class DNAMathFunction implements IDNA, Comparable, java.io.Serializable{

	private double[] DNA = new double[1];
	private int DNALength = DNA.length;
	private double[] DNAValues = new double[1];
	private int numberOfDNAValues = DNAValues.length - 1;
	
	public void printDNA(){
		for(int i = 0; i < DNA.length; i++){
			System.out.print(DNA[i]);
			System.out.print("	");
		}
	}
	
	public double getFitness() {
		double x = DNAValues[0];
		return Math.pow(x, 4) * (-3.4) + Math.pow(x, 3) * 6.8 + Math.pow(x, 2) * (-1.2) + x * 3.1 - 27;
	}

	public void setRandomDNA() {
		
		for(int i = 0; i < DNALength; i++){
			setRandomAllel(i);
		}	
	}
	
	public void setRandomAllel(int Index){
		double random = Math.random() ;
		//int min = 0;
		//int max = numberOfDNAValues;
		
		//double newValue = DNAValues[random.nextInt(max - min + 1) + min];
		DNA[Index] = random;
	}
	
	public void setDNA(double[] dna) {
		DNA = dna;
	}
	
	public void setAllele(int Index, double Value){
		DNA[Index] = Value;
	}
	
	public double[] getDNA(){
		return DNA;
	}
	public double getAllele(int Index){
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
