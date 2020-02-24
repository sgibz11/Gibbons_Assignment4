package gibbons_problem2;

public class SavingsAccount {
	
	//Variable to store annual interest rate
		static private double annualInterestRate;
		private double savingBalance;
		
		//Constructor method
		public SavingsAccount()
		{
			this.savingBalance=0;
		}
		//Constructor method
		public SavingsAccount(double savingBalance)
		{
			this.savingBalance=savingBalance;
		}
		//Get saving balance
		public double getSavingBalance()
		{
			return this.savingBalance;
		}
		public double[] getMonthsSavingBalance(int total_months)
		{
				double[]monthly_month=new double[total_months];
			double monthly;
			for(int i=0;i<total_months;i++)
			{
				monthly=(double)(this.savingBalance*annualInterestRate/12);
				this.savingBalance+=monthly;
				monthly_month[i]=this.savingBalance;
			}
			return monthly_month;
		}
		//Modify interest rate by setting annual interest rate to a new value
		public static void modifyInterestRate(double newInterestRate)
		{
			annualInterestRate=newInterestRate;
		}
		//Method to calculate monthly interest
		public void calculateMonthlyInterest()
		{
			double monthly;
			monthly=(double)(this.savingBalance*annualInterestRate/12);
			this.savingBalance+=monthly;
		}
}
