
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;


//This is a nice project since I am interested in finance & a nice revision of my previous java knowledge


public class futureMoneyCalculator {

	public static void main(String[] args) {

		Scanner user = new Scanner(System.in);

		String answer = "y";
		System.out.println("Welcome to Compound interest calculator!");
		while (!(answer.equals("n"))) {
			// ask for the initial amount
			System.out.print("The initial investment :: ");
			double initialInvestmentAmount = user.nextDouble();

			// ask for return interest rate
			System.out.print("Enter the estimated interest rate (percentage) :: ");
			double rateOfReturn = (user.nextInt() * 0.01);

			// Ask for length of year they are planning to save
			System.out.print("How many year(s) are you planning to save :: ");
			int years = user.nextInt();

			// Ask for the compound frequency
			System.out.print(
					"Times per year that interest will be compounded "
					+ "(1.Annually, 2.Semiannually, 3.Monthly, and 4.Daily) :: ");
			int frequency = user.nextInt();

			BigDecimal futureValue = compoundInterestCalculator(rateOfReturn, initialInvestmentAmount, years,
					frequency);

			//Print out the amount after compound interest
			System.out.println("In "+years+", you will have "+futureValue);

			
			System.out.print("Do you want to start again (y/n) :: ");
			answer = user.next();
			
			//ask for input until user enter valid input
			while(!(answer.equalsIgnoreCase("y")|| answer.equalsIgnoreCase("n")))
			{
				System.out.print("Enter a valid answer :: ");
				answer = user.next();
			}
		}
		
		System.out.println("Thank you. Have a great day!");

		user.close();
	}

	/*
	 * Calculate how much money will grow in a specific year using compound interest
	 * 
	 * @param interest rate, initial amount, years, frequency
	 * 
	 * @return the amount after compound interest
	 */
	public static BigDecimal compoundInterestCalculator(double rOfR, double investmentAmount, int year, int frequency) {

		// Change how frequent the money should compound based on user input
		int fq;

		// 1.Annually, 2.Semiannually, 3.Monthly,and 4.Daily

		switch (frequency) {
		case 4:
			fq = 365;
			break;
		case 2:
			fq = 2;
			break;
		case 3:
			fq = 12;
			break;
		default:
			fq = 1;
			break;

		}

		// Estimate future value
		double fV = (investmentAmount * (Math.pow((1 + (rOfR / fq)), (year * fq))));

		// Round up the decimal
		BigDecimal bigDeci = new BigDecimal(fV);
		BigDecimal fVRounded = bigDeci.setScale(2, RoundingMode.HALF_UP);

		return (fVRounded);
	}

}
