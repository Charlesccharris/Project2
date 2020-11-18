import java.util.*;

public class Casino{

	private int startMoney;

	Casino(String name, int money){
		this.startMoney = money;
		System.out.println("Welcome to the " + name + " casino, we hope you have a good time.");
		System.out.println("You have an initial " + money + " dollars to bet with, don't spend it all in one place.");
	}

	public void listGames(String[] games){
		System.out.println("We offer the following games:");
		int j = 1;
		for(int i = 0; i < games.length; i++){
			System.out.println("(" + j + ")" + games[i]);
			j++;
		}
		System.out.println("(0)Exit");
	}

	public int getGame(Scanner input){
		System.out.print("What would you like to play: ");
		int gameChoice = input.nextInt();
		return gameChoice;
	}

	public void displayMoney(int money){
		System.out.println("You have " + money + " dollars");
	}

	public void goodBye(int money){
		if(money > startMoney){
			System.out.print("Good job, you beat the house.");
		}
		else if(money == startMoney){
			System.out.print("You broke even.");
		}
		else if(money < startMoney && money > 0){
			System.out.print("Looks like you lost some money, better luck next time.");
		}
		else{
			System.out.print("You went bust, better luck next time.");
		}
		System.out.println(" We hope to see you again soon!");
	}
}
