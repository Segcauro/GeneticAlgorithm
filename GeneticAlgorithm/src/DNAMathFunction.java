import java.util.Random;

import Framework.IDNA;

public class DNAMathFunction implements IDNA{

	private String[] DNA = new String[5];
	private int DNALength = 5;
	private String[] DNAValues = {"0", "1", "2","3","4","5","6","7","8","9","10",""};
	
	public void printDNA(){
		for(int i = 0; i < DNA.length; i++){
			System.out.print(DNA[i]);
		}
	}
	
	public double getFitness() {
		int a = Integer.parseInt(DNA[0]);
		int b = Integer.parseInt(DNA[1]);
		int c = Integer.parseInt(DNA[2]);
		int d = Integer.parseInt(DNA[3]);
		int e = Integer.parseInt(DNA[4]);
		
		int fitness = (-10*a^5) + (22*b^4)+ (100*c^3) - (11*d^2) + (200*e) - (1200);
		
		return fitness;
	}

	public void setRandomDNA() {
		Random random = new Random();
		int min = 0;
		int max = 10;
		
		for(int i = 0; i < DNALength; i++){
			String Value = DNAValues[random.nextInt(max - min + 1) + min];
			DNA[i] = Value;
		}
		
	}
	public void setDNA(String[] dna) {
		DNA = dna;
	}

}
