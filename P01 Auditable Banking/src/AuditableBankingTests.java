public class AuditableBankingTests 
{
		public static boolean testProcessCommand() 
		{
			int[] newTransactions = {0,1, 0, 0, 1, 1, 1, 0, 1};
			int[][] allTransactions = {{2,4},{5,6},{},{},{}};
			int allTransactionsCount = 2;
			AuditableBanking ab = new AuditableBanking(newTransactions, allTransactions, allTransactionsCount);
			allTransactionsCount = ab.processCommand("0 1 0 0 1 1 1 0 1", allTransactions, allTransactionsCount);
			if(allTransactionsCount != 2)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public static boolean testCalculateCurrentBalance() 
		{
			int[] newTransactions = {0,1, 0, 0, 1, 1, 1, 0, 1};
			int[][] allTransactions = {{1,-10,+100},{0,1, 0, 0, 1, 1, 1, 0, 1},{2,2,1,0,0}};
			int allTransactionsCount = 3;
			AuditableBanking ab = new AuditableBanking(newTransactions, allTransactions, allTransactionsCount);
			int balance = ab.calculateCurrentBalance(allTransactions, allTransactionsCount);
			System.out.println(balance);
			if(balance == 12) {
				return true;
			}else{
				return false;
			}
		}

		public static void main(String args[])
		{
			/**if(testProcessCommand()) 
			{
				System.out.println("The test works");
			}
			else
			{
				System.out.println("Didnt Work");
			}
			**/
			if(testCalculateCurrentBalance()) 
			{
				System.out.println("The test works");
			}
			else
			{
				System.out.println("Didnt Work");
			}
		}
}
