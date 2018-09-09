import java.util.Arrays;
import java.util.Scanner;

public class AuditableBanking 
{
	public int[] newTransactions;
	public int[][] allTransactions;
	public int allTransactionsCount;
	
	public AuditableBanking(int[] newtransactions, int[][] alltransactions, int alltransactionscount)
	{
		newTransactions = newtransactions;
		allTransactions = alltransactions;
		allTransactionsCount = alltransactionscount;
	}
	
	
	public static int submitTransactions(int[] newTransactions, int[][] allTransactions,
	    int allTransactionsCount) {
		if(allTransactionsCount == allTransactions.length)
		{
			return allTransactionsCount;
		}
		allTransactions[allTransactionsCount] = newTransactions;
		allTransactionsCount++;
		return allTransactionsCount;
	}
	
	public static int processCommand(String command, int[][] allTransactions, int allTransactionsCount) 
	{
		
		int[]  input = Arrays.stream(command.trim().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		if(input[0] == 0)
		{
			/*
			 * Binary Amount Transaction
			 */
			System.out.println(allTransactionsCount);
			allTransactionsCount = submitTransactions(input, allTransactions, allTransactionsCount);
		}
		else if(input[0] == 1)
		{
			/*
			 * Integer Amount Transaction
			 */
			allTransactionsCount = submitTransactions(input, allTransactions, allTransactionsCount);
			
		}
		else if(input[0] == 2 && input.length == 5)
		{
			/*
			 * Quick Withdraw Transaction
			 */
			allTransactionsCount = submitTransactions(input, allTransactions, allTransactionsCount);
		}
		else
		{
			System.out.println("Didn't Work");
			return allTransactionsCount;
		}
		System.out.println(allTransactionsCount);
		return allTransactionsCount;
	}
	public static int calculateCurrentBalance(int[][] allTransactions, int allTransactionsCount) 
	{
		int balance = 0;
		for (int r=0; r<allTransactions.length; r++)
		{
				if(allTransactions[r][0] == 0)
				{
					/*
					 * Binary Amount Transaction
					 */
					System.out.println("its binary");
					for(int i = 1; i < allTransactions[r].length; i++)
					{
						if(allTransactions[r][i] == 1)
						{
							balance++;
							System.out.println(balance);
						}
						else
						{
							balance--;
							System.out.println(balance);
						}
					}
					System.out.println("After Binary balance: " + balance);
				}
				else if(allTransactions[r][0] == 1)
				{
					/*
					 * Integer Amount Transaction
					 */
					System.out.println("its Integer");
					for(int i = 1; i < allTransactions[r].length; i++)
					{
						balance += allTransactions[r][i];
					}
					System.out.println("After Integer balance: " + balance);
				}
				else if(allTransactions[r][0] == 2 && allTransactions[r].length == 5)
				{
					/*
					 * Quick Withdraw Transaction
					 */
					System.out.println("its quick withdraw");
					balance -= 20 * allTransactions[r][1];
					balance -= 40 * allTransactions[r][2];
					balance -= 80 * allTransactions[r][3];
					balance -= 100 * allTransactions[r][4];
					System.out.println("After withdrawl balance: " + balance);
				}
			
		}
		return balance;
	}
	
	public static void main(String args[])
	{
		
	}
}
