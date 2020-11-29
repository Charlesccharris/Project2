public class Slots extends Betting{

	private String[] outComes = {" Seven  ", "  Bar   ",
				" Lemon  ", " Cherry ",
				"  Bell  ", " Orange "};

	private int slotOne;
	private int slotTwo;
	private int slotThree;

	public void spinSlots(){
		int spinOne = (int)(Math.random() * 6);
		int spinTwo = (int)(Math.random() * 6);
		int spinThree = (int)(Math.random() * 6);

		this.slotOne = spinOne;
		this.slotTwo = spinTwo;
		this.slotThree = spinThree;
	}

	public void displayMachine(){
		System.out.println("----------------------------\n" +
				"|" + outComes[slotOne] + "|" + outComes[slotTwo] +
				"|" + outComes[slotThree] + "|\n" +
				"----------------------------");
	}

	public int determineSlots(){
		int multiplier = 0;

		if(slotOne == slotTwo && slotTwo != slotThree){
			System.out.println("You got a minor Prize");
			multiplier = getWinForTwo(slotTwo);
		}
		else if(slotTwo == slotThree && slotOne != slotTwo){
			System.out.println("You got a minor Prize");
			multiplier = getWinForTwo(slotTwo);
		}
		else if(slotOne == slotTwo && slotTwo == slotThree){
			System.out.println("You got a major Prize");
			multiplier = getWinForThree(slotTwo);
		}
		else{
			System.out.println("You didn't win anything");
			multiplier = 0;
		}
		return multiplier;
	}

	public int getWinForTwo(int choice){
		int multiplier = 0;
		switch(choice){
		case 0: multiplier = 5;
		break;
		case 1: case 2: multiplier = 4;
		break;
		case 3:	case 4: multiplier = 3;
		break;
		case 5: multiplier = 2;
		break;
		}
		return multiplier;
	}

	public int getWinForThree(int choice){
		int multiplier = 0;
		switch(choice){
		case 0:	multiplier = 15;
		break;
		case 1: case 2: multiplier = 10;
		break;
		case 3: case 4: multiplier = 8;
		break;
		case 5: multiplier = 4;
		break;
		}
		return multiplier;
	}
}
