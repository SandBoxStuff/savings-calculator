import java.util.*;

public class savingsCalculator {

	static double compondedInterestRate, monthlyInterest, savingsExtraPerMonth;
	static String input, userName;
	static Scanner keyboard = new Scanner(System.in);
	static int monthlyPayments, yearsToCalculate, x;
	static double savingsAccount;

	public static void main(String[] args) {

		sayWelcome();
		while (true) {
			askUserQuestions();
			toCalculate();
			requestToContinue();
		}

	}

	private static void askUserQuestions() {
		System.out.println("Hello! What is your name?");
		input = keyboard.nextLine();
		userName = input;
		System.out.println(userName + ", welcome!");
		System.out.println("How much do you currently have in your savings account?");
		savingsAccount = Integer.parseInt(keyboard.nextLine());
		System.out.println("What will be your monthly payments into your account?");
		monthlyPayments = Integer.parseInt(keyboard.nextLine());
		System.out.println("What is your annually compounded interest rate?");
		compondedInterestRate = Double.parseDouble(keyboard.nextLine());
		System.out.println("How many years would you like to calculate?");
		yearsToCalculate = Integer.parseInt(keyboard.nextLine());

	}

	private static boolean requestToContinue() {
		while (true) {
			System.out.print("Would you like to calculate another savings?");
			String yesOrNo = keyboard.nextLine();
			if (yesOrNo.equalsIgnoreCase("Yes") || yesOrNo.equalsIgnoreCase("Y")) {
				return true;
			} else if (yesOrNo.equalsIgnoreCase("No") || yesOrNo.equalsIgnoreCase("N")) {
				return false;
			} else {
				System.out.println("Invalid option (" + yesOrNo + "), please use Yes/Y or No/N.");
			}
		}
	}

	private static void sayWelcome() {
		System.out.println("Welcome!");
	}

	private static void toCalculate() {
		double monthlyInterest = (compondedInterestRate / 100) / 12;
		double savingsExtraPerMonth = (savingsAccount * monthlyInterest) + monthlyPayments;
		// System.out.println(savingsExtraPerMonth);
		// System.out.println(monthlyInterest);
		while (x < yearsToCalculate) {
			x++;
			savingsAccount = (savingsAccount + savingsExtraPerMonth);
			double roundOff = Math.round(savingsAccount * 100.00) / 100.00;
			System.out.println("Year " + x + "): " + roundOff);

		}

	}

}
