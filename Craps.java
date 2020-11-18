public class Craps extends Betting{

	public boolean playCraps(){
		boolean result = true;
                int diceOne = diceRolls();
                int diceTwo = diceRolls();

		int total = diceOne + diceTwo;

		System.out.println(diceOne + " " + diceTwo);

		switch(total){
		case 2: case 3: case 12:
			System.out.println("Craps! You lost!");
			result = false;
			break;
		case 7: case 11:
			System.out.println("Natural! You won!");
			result = true;
			break;
		default:
			System.out.println("Point established, point is: " + total);
			result = rollAgain(total);
			break;
		}
		return result;
	}

	public static int diceRolls(){

		int roll =(int)(Math.random()*6+1);
		return roll;
	}

	public static boolean rollAgain(int total){
		boolean result = true;

                int rollOne = diceRolls();
		int rollTwo = diceRolls();

		boolean keepRolling = true;

                int subTotal = rollOne + rollTwo;

		while(keepRolling){

			if(subTotal == 7){
				System.out.println(rollOne + " and " + rollTwo + " is " + subTotal + " You lose");
				keepRolling = false;
				result = false;
			}
			else if(subTotal == total){
                                System.out.println(rollOne + " and " + rollTwo + " is " + subTotal + " You win");
				keepRolling = false;
				result = true;
			}
			else{
				System.out.println("Roll again");
		                rollOne = diceRolls();
				rollTwo = diceRolls();
		  		subTotal = rollOne + rollTwo;
       				System.out.println(rollOne + " and " + rollTwo + " is " + subTotal);
			}
		}
		return result;
	}
}
