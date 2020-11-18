import java.util.*;

public class Betting{

	private int maxBet;
	private int currentBet;

	public void setMaxBet(int maximumBet){
		this.maxBet = maximumBet;
		System.out.println("\nThe max bet is " + maximumBet + " dollars");
	}

	public void getBet(Scanner input, int totalMoney){
		int bet;
		System.out.print("Enter bet amount: ");
		bet = input.nextInt();

		if(bet > maxBet){
			System.out.println("Sorry, the max bet amount is " + maxBet + " so that's how much you can bet this round.");
			bet = maxBet;
		}

		if(bet > totalMoney){
			System.out.println("You don't have that much money to bet, so you will bet the rest of your money");
			bet = totalMoney;
		}
		this.currentBet = bet;
	}

	public int determinePrize(int money, boolean outcome){
		if(outcome){
			money += currentBet;
		}
		else{
			money -= currentBet;
		}
		return money;
	}
}
