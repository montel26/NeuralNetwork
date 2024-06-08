import java.util.Random;

public class Neuron {
//	Random random = new Random();
//	private Double oldBias = random.nextDouble(-1, 1), bias= random.nextDouble(-1,-1);
//	private Double oldweight1 = random.nextDouble(-1, 1), weight1 = random.nextDouble(-1,-1);
//	private Double oldweight2 = random.nextDouble(-1, 1), weight2= random.nextDouble(-1,-1);
//	
	private Random random = new Random(); // Initialize the random number generator

	// Initialize biases and weights
	private Double oldBias = -1.0 + 2.0 * random.nextDouble(); 
	private Double bias = -1.0 + 2.0 * random.nextDouble();
	private Double oldweight1 = -1.0 + 2.0 * random.nextDouble(); 
	private Double weight1 = -1.0 + 2.0 * random.nextDouble();
	private Double oldweight2 = -1.0 + 2.0 * random.nextDouble(); 
	private Double weight2 = -1.0 + 2.0 * random.nextDouble();

	public String toString() {
		return String.format("oldBias: %.15f | bias: %.15f | oldWeight1: %.15f | weight: %.15f | oldWeight2: %.15f | weight2: %.15f", this.oldBias, this.bias,this.oldweight1,this.weight1,this.oldweight2,this.weight2);
		
	}
	
	public void mutate(Double learnFactor) {
		
		int propertyToChange = random.nextInt(0,3);
		Double changeFactor = (learnFactor == null) ? random.nextDouble(-1,1): (learnFactor * random.nextDouble(-1,1));
		
		if (propertyToChange == 0) {
			this.bias += changeFactor;
		}else if (propertyToChange == 1) {
			this.weight1 += changeFactor;
		}else {
			this.weight2 += changeFactor;
		};
	}
	
	public void forget() {
		bias = oldBias;
		weight1 = oldweight1;
		weight2 = oldweight2;
		
	}
	
	public void remember() {
		oldBias = bias;
		oldweight1 = weight1;
		oldweight2 = weight2;
	}
	
	public double compute(double input1,double input2) {
		double preActivation = (this.weight1 * input1) + (this.oldweight2 * input2) + this.bias;
		double output = HelperClass.sigmoid(preActivation);
		return output;
	}
	
}
