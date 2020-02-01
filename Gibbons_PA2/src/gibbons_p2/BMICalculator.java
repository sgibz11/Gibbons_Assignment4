package gibbons_p2;

import java.util.Scanner;

public class BMICalculator {
	//Class variables
	static final String METRIC = "METRIC";
	static final String IMPERIAL = "IMPERIAL";

	//Scanner to read user data
	static Scanner in= new Scanner(System.in);
	
	//Instance variables
	private double weight;
	private double height;
	private double bmi;
	private String unitType;
	
	//This method returns the weight of the user
	public double getWeight() {
		return weight;
	}
	
	//This method sets the weight of the user
	private void setWeight(double weight) {
		this.weight = weight;
	}
	
	//This method returns the height of the user
	public double getHeight() {
		return height;
	}
	
	//This method sets the height of the user
	private void setHeight(double height) {
		this.height = height;
	}
	
	//This method gets the user data (weight, height & unit type)
	public void readUserData() {
		//Get unit type from user
		readUnitType();
		//Get weight & height from user
		readMeasurementData();
	}
	
	//This method gets the unit type from the user
	private void readUnitType() {
		System.out.print("Please enter the Unit Type ["+IMPERIAL+" or "+METRIC+"]:");
		String unit = in.nextLine().trim().toUpperCase();
		
		//Check if unit is valid
		if(unit.equals(IMPERIAL)|| unit.equals(METRIC)) {
			//Set unit type
			this.unitType= unit;
		}else {
			//Display error
			System.out.print("Please enter a valid value.\n");
			
			//Ask user again
			readUnitType();
		}
	}
	
	//This method gets the weight & height values from the user
	private void readMeasurementData() {
		//Use appropriate method based on unit Type
		if (unitType.equals(IMPERIAL))
			readImperialData();
		else
			readMetricData();	
	}
	
	//This method gets the measurement in metric values from the user
	private void readMetricData() {
		//Get weight in kilograms
		System.out.print("\nPlease enter your weight in kilograms: ");
		setWeight(in.nextDouble());
		
		//Check if weight is negative
		if(getWeight()<0.0)
			System.exit(1);
		
		//Get height in meters
		System.out.print("Please enter your height in meters: ");
		setHeight(in.nextDouble());
		
		//Check if weight is negative
		if(getHeight()<0.0)
			System.exit(1);
	}
	
	//This method gets the measurement in imperial values from the user
	private void readImperialData() {
		//Get weight in pounds
		System.out.print("\nPlease enter your weight in pounds: ");
		setWeight(in.nextDouble());
		
		//Check if weight is negative
		if(getWeight()<0.0)
			System.exit(1);
		
		//Get height in inches 
		System.out.print("Please enter your height in inches: ");
		setHeight(in.nextDouble());
		
		//Check if height is negative
		if(getHeight()<0.0)
			System.exit(1);
	}
	
	//This method calculates & sets the BMI of the user
	public void calculateBmi() {
		//BMI formula
		bmi= weight/(height*height);
		
		//if unit Type is Imperial multiply bmi by 703
		if(unitType.equals(IMPERIAL))
			bmi=703*bmi;
	}
	
	//This method returns the BMI of the user
	public double getBmi() {
		return bmi;
	}
	
	//This method displays the BMI
	public void displayBmi() {
		System.out.print("\n**********");
		//Display BMI
		System.out.printf("\nBMI: %.1f", getBmi());
		
		//Display BMI category
		System.out.print("\nYou are " +getBMIcategory());
		
		//Display all BMI categories
		System.out.print("\n*******");
		System.out.print("\n\nBMI Categories: ");
		System.out.print("\nUnderwight = <18.5");
		System.out.print("\nNormal Weight = 18.5-24.9");
		System.out.print("\nOverweight = 25-29.9");
		System.out.print("\nObesity = BMI of 30 or greater");
		System.out.print("\n*******");
	}
	
	//This method finds & returns the BMI category based on the bmi
	public String getBMIcategory() {
		//Find the BMI category
		if(bmi<18.5)
			return "Underweight";
		else if (bmi<=24.9)
			return "Normal weight";
		else if (bmi<=29.9)
			return "Overweight";
		else
			return "Obese";
	}
	
	public static void main(String[]args) {
		BMICalculator app = new BMICalculator();
		app.readUserData();
		app.calculateBmi();
		app.displayBmi();
	}
}
	