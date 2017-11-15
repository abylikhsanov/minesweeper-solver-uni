import java.util.*;

class Part2 {
	public static void main(String[] args) {
		int[][] board=new int[][]{
					{0,0,0,2,-1},
					{0,0,0,2,-1},
					{1,2,1,2,1},
					{-1,3,-1,2,0},
					{1,3,-1,2,0}
					};
		//This Part allows users to select difficulty level and test case presented to the agent
		System.out.println("Welcome to The game... This is Part 2 of the game");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the difficulty level \n1. Easy \n2. Medium \n3. Difficult");
		int choice =sc.nextInt();
		int boardChoice;
		switch(choice)
		{
			case 1:
				System.out.println("Great!! Now Enter the test case you want to present to the agent for play");
				System.out.println("Press 1 for this game board");
				board=new int[][]{
					{0,0,0,2,-1},
					{0,0,0,2,-1},
					{1,2,1,2,1},
					{-1,3,-1,2,0},
					{1,3,-1,2,0}
				};
				printBoard(board);
				System.out.println("Press 2 for this game board");
				board=new int[][]{
					{0,0,1,-1,-1},
					{0,0,1,2,1},
					{1,2,1,1,0},
					{-1,2,-1,2,1},
					{1,2,2,-1,1}
				};
				printBoard(board);
				System.out.println("Press 3 for this game board");
				board=new int[][]{
					{0,0,1,2,2},
					{0,1,3,-1,-1},
					{0,2,-1,-1,3},
					{0,2,-1,3,1},
					{0,1,1,1,0}
				};
				printBoard(board);
				System.out.println("Press 4 for this game board");
				board=new int[][]{
					{0,0,0,0,0},
					{1,2,1,1,0},
					{-1,2,-1,1,0},
					{3,5,3,2,0},
					{-1,-1,-1,1,0}
				};
				printBoard(board);
				System.out.println("Press 5 for this game board");
				board=new int[][]{
					{0,0,0,1,-1},
					{1,1,1,1,1},
					{2,-1,2,0,0},
					{3,-1,3,1,0},
					{-1,3,-1,1,0}
				};
				printBoard(board);
				System.out.println("Enter Your choice");
				boardChoice=sc.nextInt();
				switch(boardChoice)
				{
					case 1:
						board=new int[][]{
						{0,0,0,2,-1},
						{0,0,0,2,-1},
						{1,2,1,2,1},
						{-1,3,-1,2,0},
						{1,3,-1,2,0}
						};
						System.out.println("You have selected following test case for agent");
						printBoard(board);
					break;
					case 2:
						board=new int[][]{
						{0,0,1,-1,-1},
						{0,0,1,2,1},
						{1,2,1,1,0},
						{-1,2,-1,2,1},
						{1,2,2,-1,1}
						};
						System.out.println("You have selected following test case for agent");
						printBoard(board);
					break;
					case 3:
						board=new int[][]{
						{0,0,1,2,2},
						{0,1,3,-1,-1},
						{0,2,-1,-1,3},
						{0,2,-1,3,1},
						{0,1,1,1,0}
						};
						System.out.println("You have selected following test case for agent");
						printBoard(board);
					break;
					case 4:
						board=new int[][]{
						{0,0,0,0,0},
						{1,2,1,1,0},
						{-1,2,-1,1,0},
						{3,5,3,2,0},
						{-1,-1,-1,1,0}
						};
						System.out.println("You have selected following test case for agent");
						printBoard(board);
					break;
					case 5:
						board=new int[][]{
						{0,0,0,1,-1},
						{1,1,1,1,1},
						{2,-1,2,0,0},
						{3,-1,3,1,0},
						{-1,3,-1,1,0}
						};
						System.out.println("You have selected following test case for agent");
						printBoard(board);
					break;
					default:
						System.out.println("You have not entered the correct choice system will proceed with default choice 1");
						board=new int[][]{
						{0,0,0,2,-1},
						{0,0,0,2,-1},
						{1,2,1,2,1},
						{-1,3,-1,2,0},
						{1,3,-1,2,0}
						};
						System.out.println("You have selected following test case for agent");
						printBoard(board);
						break;
				}
				break;
			case 2:
				System.out.println("Great!! Now Enter the test case you want to present to the agent for play");
				System.out.println("Press 1 for this game board");
				board=new int[][]{
					{0,0,0,1,1,1,0,1,-1},
					{0,0,1,2,-1,1,0,1,1},
					{0,0,2,-1,3,1,0,1,1},
					{0,0,2,-1,2,0,0,1,-1},
					{1,1,1,1,1,0,0,2,2},
					{-1,2,1,1,0,0,0,1,-1},
					{1,2,-1,1,0,0,0,1,1},
					{1,2,1,1,0,0,1,1,1},
					{-1,1,0,0,0,0,1,-1,1},
				};
				printBoard(board);
				System.out.println("Press 2 for this game board");
				board=new int[][]{
					{0,0,0,0,0,0,1,1,1},
					{0,0,0,0,1,1,3,-1,2},
					{0,0,0,0,2,-1,6,-1,4},
					{0,0,0,0,2,-1,-1,-1,-1},
					{0,0,0,0,1,3,-1,5,3},
					{0,0,0,0,0,1,2,-1,1},
					{0,0,0,0,0,0,1,1,1},
					{0,0,0,0,1,1,1,0,0},
					{0,0,0,0,1,-1,1,0,0},
				};
				printBoard(board);
				System.out.println("Press 3 for this game board");
				board=new int[][]{
					{0,0,1,-1,1,1,-1,2,1},
					{1,1,1,1,1,1,2,-1,1},
					{-1,1,0,0,0,1,2,2,1},
					{2,2,1,1,1,2,-1,1,0},
					{1,-1,1,1,-1,2,1,1,0},
					{1,1,1,1,1,1,0,1,1},
					{0,0,0,0,0,1,1,2,-1},
					{0,0,0,0,0,1,-1,3,2},
					{0,0,0,0,0,1,1,2,-1},
				};
				printBoard(board);
				System.out.println("Press 4 for this game board");
				board=new int[][]{
					{0,0,0,0,0,0,1,-1,1},
					{0,1,2,2,1,0,1,1,1},
					{0,1,-1,-1,1,0,0,0,0},
					{0,1,2,2,1,0,0,0,0},
					{0,0,1,1,1,0,1,1,1},
					{0,0,1,-1,2,1,2,-1,2},
					{0,0,0,0,0,1,1,2,-1},
					{0,0,0,0,0,1,-1,3,2},
					{0,0,0,0,0,1,1,2,-1},
				};
				printBoard(board);
				System.out.println("Enter Your choice");
				boardChoice=sc.nextInt();
				switch(boardChoice)
				{
					case 1:
						board=new int[][]{
						{0,0,0,1,1,1,0,1,-1},
						{0,0,1,2,-1,1,0,1,1},
						{0,0,2,-1,3,1,0,1,1},
						{0,0,2,-1,2,0,0,1,-1},
						{1,1,1,1,1,0,0,2,2},
						{-1,2,1,1,0,0,0,1,-1},
						{1,2,-1,1,0,0,0,1,1},
						{1,2,1,1,0,0,1,1,1},
						{-1,1,0,0,0,0,1,-1,1},
						};
						System.out.println("You have selected following test case for agent");
						printBoard(board);
					break;
					case 2:
						board=new int[][]{
						{0,0,0,0,0,0,1,1,1},
						{0,0,0,0,1,1,3,-1,2},
						{0,0,0,0,2,-1,6,-1,4},
						{0,0,0,0,2,-1,-1,-1,-1},
						{0,0,0,0,1,3,-1,5,3},
						{0,0,0,0,0,1,2,-1,1},
						{0,0,0,0,0,0,1,1,1},
						{0,0,0,0,1,1,1,0,0},
						{0,0,0,0,1,-1,1,0,0},
						};
						System.out.println("You have selected following test case for agent");
						printBoard(board);
					break;
					case 3:
						board=new int[][]{
						{0,0,1,-1,1,1,-1,2,1},
						{1,1,1,1,1,1,2,-1,1},
						{-1,1,0,0,0,1,2,2,1},
						{2,2,1,1,1,2,-1,1,0},
						{1,-1,1,1,-1,2,1,1,0},
						{1,1,1,1,1,1,0,1,1},
						{0,0,0,0,0,1,1,2,-1},
						{0,0,0,0,0,1,-1,3,2},
						{0,0,0,0,0,1,1,2,-1},
						};
						System.out.println("You have selected following test case for agent");
						printBoard(board);
					break;
					case 4:
						board=new int[][]{
						{0,0,0,0,0,0,1,-1,1},
						{0,1,2,2,1,0,1,1,1},
						{0,1,-1,-1,1,0,0,0,0},
						{0,1,2,2,1,0,0,0,0},
						{0,0,1,1,1,0,1,1,1},
						{0,0,1,-1,2,1,2,-1,2},
						{0,0,0,0,0,1,1,2,-1},
						{0,0,0,0,0,1,-1,3,2},
						{0,0,0,0,0,1,1,2,-1},
						};
						System.out.println("You have selected following test case for agent");
						printBoard(board);
					break;
					
					default:
						System.out.println("You have not entered the correct choice system will proceed with default choice 1");
						board=new int[][]{
						{0,0,0,1,1,1,0,1,-1},
						{0,0,1,2,-1,1,0,1,1},
						{0,0,2,-1,3,1,0,1,1},
						{0,0,2,-1,2,0,0,1,-1},
						{1,1,1,1,1,0,0,2,2},
						{-1,2,1,1,0,0,0,1,-1},
						{1,2,-1,1,0,0,0,1,1},
						{1,2,1,1,0,0,1,1,1},
						{-1,1,0,0,0,0,1,-1,1},
						};
						System.out.println("You have selected following test case for agent");
						printBoard(board);
						break;
				}
				break;
			case 3:
				System.out.println("Great!! Now Enter the test case you want to present to the agent for play");
				System.out.println("Press 1 for this game board");
				board=new int[][]{
					{0,0,0,0,2,-1,4,-1,2,-1},
					{2,2,1,0,2,-1,-1,4,3,2},
					{-1,-1,1,0,1,3,-1,3,-1,1},
					{-1,3,1,0,0,1,2,3,2,1},
					{2,2,2,1,1,0,1,-1,1,0},
					{1,-1,3,-1,4,3,3,2,1,0},
					{1,1,3,-1,-1,-1,-1,1,0,0},
					{0,1,2,4,-1,4,2,1,0,0},
					{0,1,-1,3,2,1,0,0,0,0},
					{0,1,2,-1,1,0,0,0,0,0},
				};
				printBoard(board);
				System.out.println("Press 2 for this game board");
				board=new int[][]{
					{0,0,2,-1,2,0,0,0,1,1},
					{0,1,3,-1,2,0,0,0,2,-1},
					{0,2,-1,3,1,0,0,0,2,-1},
					{2,4,-1,2,0,0,0,0,1,1},
					{-1,-1,3,2,1,0,0,0,0,0},
					{-1,4,3,-1,3,2,2,2,1,1},
					{-1,3,2,-1,3,-1,-1,3,-1,1},
					{-1,2,1,2,3,4,-1,3,1,1},
					{1,1,1,3,-1,3,1,1,0,0},
					{0,0,1,-1,-1,2,0,0,0,0},
				};
				printBoard(board);
				System.out.println("Press 3 for this game board");
				board=new int[][]{
					{0,0,0,0,1,3,-1,2,0,0},
					{1,1,1,0,1,-1,-1,3,2,2},
					{1,-1,1,0,1,2,2,2,-1,-1},
					{1,1,1,0,0,1,1,2,3,-1},
					{1,1,0,0,0,1,-1,1,2,2},
					{-1,2,0,0,0,1,1,1,1,-1},
					{-1,4,1,0,0,0,0,1,2,2},
					{-1,-1,3,2,2,2,1,2,-1,1},
					{-1,-1,3,-1,-1,2,-1,2,1,2},
					{-1,3,2,2,2,2,1,1,0,0},
				};
				printBoard(board);				
				System.out.println("Enter Your choice");
				boardChoice=sc.nextInt();
				switch(boardChoice)
				{
					case 1:
						board=new int[][]{
						{0,0,0,0,2,-1,4,-1,2,-1},
						{2,2,1,0,2,-1,-1,4,3,2},
						{-1,-1,1,0,1,3,-1,3,-1,1},
						{-1,3,1,0,0,1,2,3,2,1},
						{2,2,2,1,1,0,1,-1,1,0},
						{1,-1,3,-1,4,3,3,2,1,0},
						{1,1,3,-1,-1,-1,-1,1,0,0},
						{0,1,2,4,-1,4,2,1,0,0},
						{0,1,-1,3,2,1,0,0,0,0},
						{0,1,2,-1,1,0,0,0,0,0},
						};
						System.out.println("You have selected following test case for agent");
						printBoard(board);
					break;
					case 2:
						board=new int[][]{
						{0,0,2,-1,2,0,0,0,1,1},
						{0,1,3,-1,2,0,0,0,2,-1},
						{0,2,-1,3,1,0,0,0,2,-1},
						{2,4,-1,2,0,0,0,0,1,1},
						{-1,-1,3,2,1,0,0,0,0,0},
						{-1,4,3,-1,3,2,2,2,1,1},
						{-1,3,2,-1,3,-1,-1,3,-1,1},
						{-1,2,1,2,3,4,-1,3,1,1},
						{1,1,1,3,-1,3,1,1,0,0},
						{0,0,1,-1,-1,2,0,0,0,0},
						};
						System.out.println("You have selected following test case for agent");
						printBoard(board);
					break;
					case 3:
						board=new int[][]{
						{0,0,0,0,1,3,-1,2,0,0},
						{1,1,1,0,1,-1,-1,3,2,2},
						{1,-1,1,0,1,2,2,2,-1,-1},
						{1,1,1,0,0,1,1,2,3,-1},
						{1,1,0,0,0,1,-1,1,2,2},
						{-1,2,0,0,0,1,1,1,1,-1},
						{-1,4,1,0,0,0,0,1,2,2},
						{-1,-1,3,2,2,2,1,2,-1,1},
						{-1,-1,3,-1,-1,2,-1,2,1,2},
						{-1,3,2,2,2,2,1,1,0,0},
						};
						System.out.println("You have selected following test case for agent");
						printBoard(board);
					break;					
					default:
						System.out.println("You have not entered the correct choice system will proceed with default choice 1");
						board=new int[][]{
						{0,0,0,0,2,-1,4,-1,2,-1},
						{2,2,1,0,2,-1,-1,4,3,2},
						{-1,-1,1,0,1,3,-1,3,-1,1},
						{-1,3,1,0,0,1,2,3,2,1},
						{2,2,2,1,1,0,1,-1,1,0},
						{1,-1,3,-1,4,3,3,2,1,0},
						{1,1,3,-1,-1,-1,-1,1,0,0},
						{0,1,2,4,-1,4,2,1,0,0},
						{0,1,-1,3,2,1,0,0,0,0},
						{0,1,2,-1,1,0,0,0,0,0},
						};
						System.out.println("You have selected following test case for agent");
						printBoard(board);
						break;
				}
				break;
			default:
				System.out.println("Sorry Wrong Choice. Run the program again with correct choice!!");
				System.exit(0);
				break;
				
		}
		
		// Game Agent trigger from this point...
		
		ProbabilitySolver r = new ProbabilitySolver(new GameBoard(board));
		boolean won = r.start();
		System.out.println("game " + (won ? "won" : "lost"));
		}
	
	static void printBoard(int board[][])
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[0].length;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
}


