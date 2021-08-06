import java.security.SecureRandom;

public class Craps
{
	private static final SecureRandom randomNumbers = new SecureRandom();
	private enum Status { CONTINUE, WON, LOST };
	private static final int SNAKE_EYES = 2;
	private static final int TREY= 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int  BOX_CARS = 12;
	private static int playerWinsFirstTime = 0;
	private	static int casinoWinsFirstTime = 0;
	private	static int playerWinsSubsequently = 0;
	private	static int casionoWinsSubsequently = 0;
	private static int playerMoney = 0;
	private static int casinoMoney = 0;
	private static int bet = 0;
	
	public static void main(String args[])
	{
		int myPoint = 0;
		Status gameStatus;
		
		
		for(int i=0; i<1000; i++)
		{
			bet = 100 + randomNumbers.nextInt(200);
			int sumOfDice = rollDice();
			switch(sumOfDice)
			{
				case SEVEN:
				case YO_LEVEN:
					gameStatus = Status.WON;
					playerWinsFirstTime++;
					playerMoney = playerMoney + bet;
					casinoMoney = casinoMoney - bet;
					break;
					
					
				case SNAKE_EYES:
				case TREY:
				case BOX_CARS:
					gameStatus=Status.LOST;
					casinoWinsFirstTime++;
					casinoMoney = casinoMoney + bet;
					playerMoney = playerMoney - bet;
					break;
					
					
				default:
					gameStatus = Status.CONTINUE;
					myPoint = sumOfDice;
					break;
			}
			
			while(gameStatus == Status.CONTINUE)
			{
				sumOfDice = rollDice();
					if(sumOfDice == myPoint)
					{
						gameStatus = Status.WON;
						playerWinsSubsequently++;
						playerMoney = playerMoney + bet;
						casinoMoney = casinoMoney - bet;
					}
				else 
					if(sumOfDice == SEVEN)
					{
						gameStatus = Status.LOST;
						casionoWinsSubsequently++;
						casinoMoney = casinoMoney + bet;
						playerMoney = playerMoney - bet;
					}
			}
			
		}
		wins();
	}
	
		public static int rollDice()
		{
			int die1 = 1 + randomNumbers.nextInt(6);
			int die2 = 1 + randomNumbers.nextInt(6);
			
			int sum = die1 + die2;			
			return sum;
		}
		public static void wins()
		{
			System.out.printf("\n\n\n\nplayerWinsFirstTime  %d\ncasinoWinsFirstTime  %d\nplayerWinsSubsequently  %d\ncasionoWinsSubsequently  %d\nCASINO MONEY WON %d\n PLAYER MONEY WON %d\n\n\n\n\n",playerWinsFirstTime,casinoWinsFirstTime,playerWinsSubsequently,casionoWinsSubsequently,casinoMoney,playerMoney);
		}
	}		
		
			