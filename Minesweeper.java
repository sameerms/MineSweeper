import java.util.Scanner;

public class Minesweeper {

	private static MineField field;
	private static Ranking rank;	
	private static Scanner in;  // modified code in variable was never closed.Continuous in while loop
	public static void main(String[] args) {
		rank=new Ranking();
		mainMessage();
		while(gameCountinue());
		System.out.println("\nThank you for playing :) Have a nice day!");
	}	
	private static boolean gameCountinue() {
		field = new MineField();
		int result = 0;
		while (true) {

			field.show();
			System.out.print("\nPlease enter your move(row col): ");
			in = new Scanner(System.in); // modified in variable -initiated in method
			String input = in.nextLine();

			if (!cmd(input, result)){
				return false;
			}
			else if (field.legalMoveString(input)) {
				result++;
				if (result == 35) {
					System.out.println("Congratulations you WON the game!");
					
						rank.recordName(result);
						
							return true;
						}
				}
// removed the dead code which is commented and removed the excess off semicolons which are not required.
			else if (field.getBoom()) {
				System.out.println("\nBooooooooooooooooooooooooooooom!You stepped on a mine!You survived " + result + " turns");
				rank.recordName(result);
				return true;
			}

		}


		}
private static boolean cmd(String in, int result){ // implemeted new cmd method to simplify the while loop in gameContinue() method
	if (in.equals("top")) {
		rank.show();
	
	}
	else if (in.equals("restart")) {
		rank.recordName(result);
		return true;
	}
	else if (in.equals("exit")) {
		rank.recordName(result);
		return false;
	}
	return true;
}
	
	private static void mainMessage(){
		System.out.println("Welcome to Minesweeper!");
		System.out.println("To play just input some coordinates and try not to step ont mine :)");
		System.out.println("Usefull commands:");
		System.out.println("restart- Starts a new game.");
		System.out.println("exit- Quits the game.");
		System.out.println("top- Reveals the top scoreboard.");
		System.out.println("Have Fun !");
	}
}
