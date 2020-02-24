package gibbons_problem2;

public class SavingsAccountTest
{
	
	public SavingsAccountTest() 
	{
	}
	public static void main(String[] args) 
	{
		SavingsAccount saver1, saver2;
		saver1= new SavingsAccount(2000.0);
		saver2= new SavingsAccount(3000.0);
		int total= 0;
		SavingsAccount.modifyInterestRate(0.04);
		int total_month= 12;
		//Show complete balance till 12 months
		double[] balance_month=saver1.getMonthsSavingBalance(total_month);
		//This function will calculate till which month you want
		System.out.println("*****\n");
		for(int i=0;i<total_month;i++)
		{
			System.out.println("\n Month "+(i+1)+":\n Saver 1 balance= "+balance_month[i]+ "with rate of 0.04");
		}
		System.out.println("*****\n");
		balance_month=saver2.getMonthsSavingBalance(12);
		//This function will calculate till which month you want
		for(int i=0;i<total_month;i++)
		{
			System.out.println("\n Month "+(i+1)+":\n Saver 2 balance= "+balance_month[i]+" with rate of 0.04");
		}
		System.out.println("*****\n");
		SavingsAccount.modifyInterestRate(0.05);
		balance_month= saver1.getMonthsSavingBalance(12);
		//This function will calculate till which month you want
		for(int i=0;i<total_month;i++)
		{
			System.out.println("\n Month "+(i+1)+":\n Saver 1 balance= "+balance_month[i]+"with rate of 0.05");	
		}
		System.out.println("*****\n");
		balance_month= saver2.getMonthsSavingBalance(12);
		//This function will calculate till which month you want
		for(int i=0;i<total_month;i++)
		{
			System.out.println("\n Month "+(i+1)+ "\n Saver 2 balance= "+balance_month[i]+"with rate of 0.05");
		}
		System.out.println("*****\n");
	}

}