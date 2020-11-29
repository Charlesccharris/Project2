import java.util.*;
public class Roulette extends Betting{

	private int rouletteRoll;
	private int colorNumber;
	private int oddOrEven;
	private int rows;
	private int highOrLow;

	private int playerChoice;

	private int playerNumber;
	private int playerColor;
	private int playerOddOrEven;
	private int playerRows;
	private int playerHighOrLow;

	public void getPlayerChoice(Scanner input){
		System.out.print("(0) Number\n" + "(1) Red or Black\n" +
				"(2) Odd or Even\n" + "(3) Rows\n" +
				"(4) High or Low\n" +
				"Enter what you want to bet on: ");
		this.playerChoice = input.nextInt();
		System.out.println();
		switch(playerChoice){
		case 0:
			System.out.print("Enter number you want to bet on (1-36): ");
			this.playerNumber = input.nextInt();
			break;
		case 1:
			System.out.print("(1) Red\n" + "(2) Black\n" + "Enter what you want to bet on: ");
			this.playerColor = input.nextInt();
			break;
		case 2:
			System.out.print("(1) Odd\n" + "(2) Even\n" + "Enter what you want to bet on: ");
			this.playerOddOrEven = input.nextInt();
			break;
		case 3:
			System.out.print("(1) 1 - 12\n" + "(2) 13 - 24\n" + "(3) 25 - 36\n" + "Enter what you want to bet one: ");
			this.playerRows = input.nextInt();
			break;
		case 4:
			System.out.print("(1) 1 - 18\n" + "(2) 19 - 36\n" + "Enter what you want to bet on: ");
			this.playerHighOrLow = input.nextInt();
			break;
		default:
			System.out.println("That's not an option");
		}
	}

	public void playRoulette(){
		this.rouletteRoll = (int)(Math.random() * 37);
		getColor();
		getRows();
		getHighOrLow();
		getOddOrEven();
	}

	public void getColor(){
		String color;
		switch(rouletteRoll){
		case 1: case 3: case 5:	case 7:	case 9:	case 12: case 14:
		case 16: case 18: case 19: case 21: case 23: case 25: case 27:
		case 30: case 32: case 34: case 36:
			color = "Red";
			this.colorNumber = 1;
			break;
		case 2: case 4: case 6: case 8: case 10: case 11: case 13:
		case 15: case 17: case 20: case 22: case 24: case 26: case 28:
		case 29: case 31: case 33: case 35:
			color = "Black";
			this.colorNumber = 2;
			break;
		default:
			color = "Green";
			this.colorNumber = 0;
			break;
		}
		System.out.println("The roll was " + rouletteRoll +
				" and the color was " + color);
	}

	public void getRows(){
		switch(rouletteRoll){
		case 1: case 2: case 3: case 4: case 5: case 6:
		case 7: case 8: case 9: case 10: case 11: case 12:
			this.rows = 1;
	 		break;
		case 13: case 14: case 15: case 16: case 17: case 18:
		case 19: case 20: case 21: case 22: case 23: case 24:
			this.rows = 2;
			break;
		case 25: case 26: case 27: case 28: case 29: case 30:
		case 31: case 32: case 33: case 34: case 35: case 36:
			this.rows = 3;
			break;
		default:
			this.rows = 0;
			break;
		}
	}

	public void getHighOrLow(){
		switch(rouletteRoll){
		case 1: case 2: case 3: case 4: case 5: case 6:
		case 7: case 8: case 9: case 10: case 11: case 12:
		case 13: case 14: case 15: case 16: case 17: case 18:
			this.highOrLow = 1;
			break;
		case 19: case 20: case 21: case 22: case 23: case 24:
		case 25: case 26: case 27: case 28: case 29: case 30:
		case 31: case 32: case 33: case 34: case 35: case 36:
			this.highOrLow = 2;
			break;
		default:
			this.highOrLow =0;
			break;
		}
	}

	public void getOddOrEven(){
		switch(rouletteRoll){
		case 1: case 3: case 5: case 7: case 9: case 11: case 13:
		case 15: case 17: case 19: case 21: case 23: case 25:
		case 27: case 29: case 31: case 33: case 35:
			this.oddOrEven = 1;
			break;
		case 2: case 4: case 6: case 8: case 10: case 12: case 14:
		case 16: case 18: case 20: case 22: case 24: case 26:
		case 28: case 30: case 32: case 34: case 36:
			this.oddOrEven = 2;
			break;
		default:
			this.oddOrEven = 0;
			break;
		}
	}

	public int determineRouletteMultiplier(){
		int multiplier = 0;

		switch(playerChoice){
		case 0:
			if(rouletteRoll == playerNumber){
				System.out.println("You guessed the right number");
				multiplier = 36;
			}
			else{
				System.out.println("You didn't guess the right number");
				multiplier = 0;
			}
			break;
		case 1:
			if(colorNumber == playerColor){
				System.out.println("You guessed the right color");
				multiplier = 2;
			}
			else{
				System.out.println("You didn't guess the right color");
				multiplier = 0;
			}
			break;
		case 2:
			if(oddOrEven == playerOddOrEven){
				System.out.println("You guessed right");
				multiplier = 2;
			}
			else{
				System.out.println("You guessed wrong");
				multiplier = 0;
			}
			break;
		case 3:
			if(rows == playerRows){
				System.out.println("You guessed right");
				multiplier = 3;
			}
			else{
				System.out.println("You guessed wrong");
				multiplier = 0;
			}
			break;
		case 4:
			if(highOrLow == playerHighOrLow){
				System.out.println("You guessed right");
				multiplier = 2;
			}
			else{
				System.out.println("You guessed wrong");
				multiplier = 0;
			}
		}
		return multiplier;
	}
}
