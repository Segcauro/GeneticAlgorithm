import java.util.Random;

import Framework.IDNA;

public class DNAMathFunction implements IDNA, Comparable, java.io.Serializable{

	private String[] DNA = new String[11];
	private int DNALength = 11;
	private String[] DNAValues = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
	private int numberOfDNAValues = DNAValues.length - 1;
	
	public void printDNA(){
		for(int i = 0; i < DNA.length; i++){
			System.out.print(DNA[i]);
			System.out.print("	");
		}
	}
	
	public double getFitness() {
		int a = Integer.parseInt(DNA[0]);
		int b = Integer.parseInt(DNA[1]);
		int c = Integer.parseInt(DNA[2]);
		int d = Integer.parseInt(DNA[3]);
		int e = Integer.parseInt(DNA[4]);
		int f = Integer.parseInt(DNA[5]);
		int g = Integer.parseInt(DNA[6]);
		int h = Integer.parseInt(DNA[7]);
		int i = Integer.parseInt(DNA[8]);
		int j = Integer.parseInt(DNA[9]);
		int k = Integer.parseInt(DNA[10]);
		
		//int value1 = (c * (a-7) + 9) *  (f+3)+i*4 - (j-5);
		//int value1 = (int)( Math.pow((a-2), 2) + Math.pow((b-3),2) - 1);
		int value1 = 2;
		int fitness = (int)( Math.pow((a-4), 2) + Math.pow((b-2),2) - 4);
		//int value2 = (4* (b-d)+e)* (6+g)+1*h - (8-k);
		//int value2 = a+b+c+d+e+f+g+h+i+j+k;
		//(x-2)^2+(y-3)^2-1 = (x-4)^2+(y-2)^2-4
		
		return fitness * Math.cos(a - d) * Math.sin(b - k) * Math.sin(j - g);
	}

	public void setRandomDNA() {
		Random random = new Random();
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
		
		String newValue = DNAValues[random.nextInt(max - min + 1) + min];
		DNA[Index] = newValue;
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
