import java.util.*;

public class Main{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		String casinoName = "Triple C";
		int initialMoney = 100;

		String[] games = {"$5 Slots", "$10 Slots", "$20 Slots", "Craps", "Roulette"};
		Casino casino = new Casino(casinoName, initialMoney);
		playAtTheCasino(input, initialMoney, casino, games);

		input.close();
	}

	public static void playAtTheCasino(Scanner input, int initialMoney, Casino casino, String[] games){

		Slots slots = new Slots();
		Craps craps = new Craps();
		Roulette roulette = new Roulette();

		int money = initialMoney;
		int choice = 1;

		while(money > 0 && choice != 0){
			casino.listGames(games);
			casino.displayMoney(money);
			choice = casino.getGame(input);
			money = playGame(input, choice, money, slots, craps, roulette);
		}
		casino.goodBye(money);
	}

	public static int playGame(Scanner input, int choice, int money, Slots slots, Craps craps, Roulette roulette){
		boolean result = true;
		int multiplier = 0;
		switch(choice){
			case 0: break;
			case 1: slots.setSlotBet(5);
				slots.spinSlots();
				slots.displayMachine();
				multiplier = slots.determineSlots();
				money = slots.determineMultiplierPrize(money, multiplier);
				break;
			case 2: slots.setSlotBet(10);
				slots.spinSlots();
				slots.displayMachine();
				multiplier = slots.determineSlots();
				money = slots.determineMultiplierPrize(money, multiplier);
				break;
			case 3: slots.setSlotBet(20);
				slots.spinSlots();
				slots.displayMachine();
				multiplier = slots.determineSlots();
				money = slots.determineMultiplierPrize(money, multiplier);
				break;
			case 4: craps.setMaxBet(25);
				craps.getBet(input, money);
				result = craps.playCraps();
				money = craps.determinePrize(money, result);
				break;
			case 5: roulette.setMaxBet(100);
				roulette.getBet(input, money);
				roulette.getPlayerChoice(input);
				roulette.playRoulette();
				multiplier = roulette.determineRouletteMultiplier();
				money = roulette.determineMultiplierPrize(money, multiplier);
				break;
			default: System.out.println("Please just choose from the provided list");
				break;
		}
		return money;
	}
}
