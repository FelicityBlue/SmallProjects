
//import packages
import java.util.Random;
import java.util.Scanner;

public class CoinFlipSimulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);

		System.out.print("Do you want to flip a coin :: ");
		String choice = input.next();
		
		//As long as the user doesn't choose not to play
		while (!(choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no"))) 
		{
			
			//if the user choose to play
			if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) 
			{
				System.out.println("It is a " + coinFlip()+".");
			}
			//if the user input invalid respond
			else 
			{
				System.out.println("Enter a valid choice.");
			}
			//ask again
			System.out.print("Do you want to flip a coin :: ");
			choice = input.next();
		}
		//if the user choose not to play
		System.out.println("Thank you. Have a great day!");

		input.close();

	}

	/*
	 * flipping coin simulator
	 * 
	 * @return boolean value based on if it is 0 or 1
	 */
	public static String coinFlip() {
		Random rand = new Random();

		int num = rand.nextInt(2);
		if (num == 1) {
			return "head";
		} else {
			return "tail";
		}

	}

}
