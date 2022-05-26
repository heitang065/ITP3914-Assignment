//	Programmer:	Tang Chun Hei
//	Language:	Java
//	To Compile:	javac FourInLine.java
//	To Run:		java FourInLine

//	Module:		IT114105 - Software Engineering
//	Created:	28 Oct 2020
//	Modified:	28 Nov 2020
//-----------------------------------------------------------------
import java.util.Scanner;

public class FourInLine{
	public static Scanner kb = new Scanner(System.in);
	public static void main(String[]args){
		
		int [][] table = new int [6][7];	//create table
		
		int player = 1;	//initialize to player 1
		int cnt =0;		//count of turn
		boolean winner = false;
		
		//turn start
		while (winner == false && cnt < 42){
			cnt++;
			printTable(table);
			playerMove(player, table);
			winner = isWin(player, table);
			
			//switch player
			if (cnt%2 == 1)
				player = 2;
			else
				player = 1;
		}
		printTable(table);
		
		if (winner){
			if (player == 1)
				System.out.println("Player 2 win this game!");
			else
				System.out.println("Player 1 win this game!");
		}else
			System.out.println("Draw!!");
	}
	//create table format
	public static void printTable(int[][] table){
		for (int i=0; i<table.length ;i++){
			System.out.print(5-i+" |");
			for (int j=0; j<table[i].length ;j++){
				System.out.printf("%2d", table[i][j]);
			}
			System.out.println();
		}
		System.out.println("  +--------------");
		System.out.println("    0 1 2 3 4 5 6");
		System.out.println();
	}
	
	public static void playerMove(int player, int[][] table){
		int input;
		while (true){
			//ask for input
			System.out.print("Player "+player+" type a column (0-6) or 9 to quit current game: ");
			input = kb.nextInt();
			
			//quit game
			if (input == 9){
				System.out.print("Bye Bye!");
				System.exit(0);
			}
			//check valid input & column not full
			else if (input < 0 || input >= table[0].length)
				System.out.println("Range of column should be 0 to 6!");
			else if (table[0][input] != 0)
				System.out.println("Column "+input+" is full!");
			//insert player's disc
			else{
				for (int i=table.length-1; i>=0 ;i--){
					if (table[i][input] == 0){
						table[i][input] = player;
						break;
					}
				}break;
			}
		}
	}
	
	public static boolean isWin(int player, int[][] table){
		//check horizontal
		for (int i=0; i<table.length; i++)
			for (int j=0; j<table[i].length-3; j++){
				if (table[i][j] == player &&
					table[i][j+1] == player &&
					table[i][j+2] == player &&
					table[i][j+3] == player)
					return true;
			}
			
		//check vertical
		for (int i=0; i<table.length-3; i++)
			for (int j=0; j<table[i].length; j++){
				if (table[i][j] == player &&
					table[i+1][j] == player &&
					table[i+2][j] == player &&
					table[i+3][j] == player)
					return true;
			}
					
		//check upward diagonal
		for (int i=3; i<table.length; i++)
			for (int j=0; j<table[i].length-3; j++){
				if (table[i][j] == player &&
					table[i-1][j+1] == player &&
					table[i-2][j+2] == player &&
					table[i-3][j+3] == player)
					return true;
			}
					
		//check downward diagonal
		for (int i=0; i<table.length-3; i++)
			for (int j=0; j<table[i].length-3; j++){
				if (table[i][j] == player &&
					table[i+1][j+1] == player &&
					table[i+2][j+2] == player &&
					table[i+3][j+3] == player)
					return true;
			}
		return false;
	}
}